/*
 * MEMBRES DU GROUPE : 
    					- Marcy Audrey DJIAHA KOUEGA
    					- Madeleina Williamyde KANA NGAPGHO
    					- Homerine Phalone KAPCHE TAPE
    					- Udjine Junior YENCHI GUIMEYA (YENU65280200)

 * 
 * 
 * DESCRIPTION DU PROGRAMME:
 * 	Programme simulant la gestion des differents types de produits (périssable et non périssable)
 * 	Le programme effectue differente tâches. Nous avons entre autre l'ajout, la modification, la suppression
 * 	de produits, et bien d'autres.
 * 
 * Un rapport ci-joint permet de montrer les fonctionnalités du programme...
 * */


import java.time.LocalDate;
import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Main {
    // Déclaration d'une variable statique de type Stock
    
    public static void main(String[] args) {
        
        List<Vente> listeVentes = new ArrayList<>();
        Queue<Commande> fileCommande = new LinkedList<>();
        Stock stock = new Stock(); // Initialisation de l'objet stock
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans le programme de gestion de stock!");

        while (true) {
            System.out.println("Que souhaitez-vous faire?");
            System.out.println("1. Ajouter un produit");
            System.out.println("2. Supprimer un produit");
            System.out.println("3. Modifier un produit");
            System.out.println("4. Rechercher un produit");
            System.out.println("5. Passer une commande");
            System.out.println("6. Générer un rapport");
            System.out.println("7. Quitter");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne

            switch (choix) {
            case 1:
                // Logique pour ajouter un produit
                ajouterProduit(stock, scanner);
                break;
            case 2:
                // Logique pour supprimer un produit
                supprimerProduit(stock, scanner);
                break;
            case 3:
                // Logique pour modifier un produit
                modifierProduit(stock, scanner);
                break;
            case 4:
                // Logique pour rechercher un produit
                rechercherProduit(stock, scanner);
                break;
            case 5:
                // Logique pour passer une commande
                passerCommande(stock, scanner, fileCommande, listeVentes);
                break;
            case 6:
                // Logique pour générer un rapport
                genererRapport(listeVentes, stock);
                break;
            case 7:
                System.out.println("Merci d'avoir utilisé notre programme. À bientôt!");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        }
    }
    ////////////////////////FIN DU MAIN//////////////////////////////
    //Ajouter
    private static void ajouterProduit(Stock stock, Scanner scanner) {
        System.out.println("Veuillez saisir le nom du produit:");
        String nomProduit = scanner.nextLine();

        System.out.println("Veuillez saisir la quantité disponible:");
        int quantiteProduit = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne

        System.out.println("Veuillez saisir le prix unitaire:");
        double prixProduit = scanner.nextDouble();
        scanner.nextLine(); // Pour consommer la nouvelle ligne

        System.out.println("Le produit est-il périssable? (Oui/Non):");
        String estPerissableStr = scanner.nextLine();
        boolean estPerissable = estPerissableStr.equalsIgnoreCase("Oui");

        LocalDate dateExpiration = null;
        if (estPerissable) {
            System.out.println("Veuillez saisir la date d'expiration (AAAA-MM-JJ):");
            String dateExpirationStr = scanner.nextLine();
            dateExpiration = LocalDate.parse(dateExpirationStr);
        }

        // Création du produit
        Produit nouveauProduit;
        if (estPerissable) {
            nouveauProduit = new ProduitPerissable(nomProduit, prixProduit, quantiteProduit, dateExpiration);
        } else {
            nouveauProduit = new ProduitNonPerissable(nomProduit, prixProduit, quantiteProduit);
        }

        // Ajout du produit au stock
        stock.ajouterProduit(nouveauProduit);

        System.out.println("Le produit a été ajouté avec succès au stock.\n");
    }
    
    //Rechercher un produit
    private static void rechercherProduit(Stock stock, Scanner scanner) {
        System.out.println("Veuillez saisir le nom du produit à rechercher:");
        String nomProduit = scanner.nextLine();

        Produit produitTrouve = stock.rechercherProduit(nomProduit);

        if (produitTrouve != null) {
            System.out.println("Produit trouvé :");
            System.out.println(produitTrouve);
        } else {
            System.out.println("Le produit spécifié n'est pas trouvé dans le stock.\n");
        }
    }

    
    
    //Supprimer
    private static void supprimerProduit(Stock stock, Scanner scanner) {
        System.out.println("Veuillez saisir le nom du produit à supprimer:");
        String nomProduit = scanner.nextLine();

        Produit produitSupprime = stock.supprimerProduit(nomProduit);

        if (produitSupprime != null) {
            System.out.println("Le produit \"" + nomProduit + "\" a été supprimé avec succès du stock.\n");
        } else {
            System.out.println("Le produit \"" + nomProduit + "\" n'a pas été trouvé dans le stock.\n");
        }
    }

    
    //Modifier
    private static void modifierProduit(Stock stock, Scanner scanner) {
        System.out.println("Veuillez saisir le nom du produit à modifier:");
        String nomProduit = scanner.nextLine();

        Produit produitAModifier = stock.rechercherProduit(nomProduit);

        if (produitAModifier != null) {
            System.out.println("Veuillez saisir les nouvelles informations pour le produit \"" + nomProduit + "\":");
            
            System.out.println("Nouvelle quantité disponible:");
            int nouvelleQuantite = scanner.nextInt();
            produitAModifier.setQte(nouvelleQuantite);
            scanner.nextLine(); // Pour consommer la nouvelle ligne
            
            System.out.println("Nouveau prix unitaire:");
            double nouveauPrix = scanner.nextDouble();
            produitAModifier.setPrix(nouveauPrix);
            scanner.nextLine(); // Pour consommer la nouvelle ligne

            System.out.println("Le produit \"" + nomProduit + "\" a été modifié avec succès.");
        } else {
            System.out.println("Le produit \"" + nomProduit + "\" n'a pas été trouvé dans le stock.");
        }
    }

    //Commander
    private static void passerCommande(Stock stock, Scanner scanner, Queue<Commande> fileCommande, List<Vente> listeVentes) {
        System.out.println("Passer une commande :");
        System.out.println("Veuillez saisir le nom du produit :");
        String nomProduit = scanner.nextLine();

        System.out.println("Veuillez saisir la quantité souhaitée :");
        int quantite = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne

        Produit produit = stock.rechercherProduit(nomProduit);
        if (produit == null) {
            System.out.println("Le produit spécifié n'a pas été trouvé dans le stock.\n");
            return;
        }

        if (quantite > produit.getQte()) {
            System.out.println("La quantité demandée est supérieure à la quantité disponible en stock.\n");
            return;
        }

        // Enregistrement de la commande
        Commande commande = new Commande(produit, quantite);
        fileCommande.offer(commande);
        //produit.setQte(produit.getQte() - quantite);
        //Enregistrement de la vente
        Vente vente = new Vente();
        vente.enregistrerVente(produit, quantite);
        listeVentes.add(vente);
        System.out.println("La commande a été ajoutée à la file d'attente.\n");
    }

    //Generer un rapport
    private static void genererRapport(List<Vente> listeVentes, Stock stock) {
        System.out.println("Rapport des ventes :");
        for (Vente vente : listeVentes) {
            System.out.println("Vente enregistrée :");
            for (Produit produit : vente.getProduitsVendus()) {
                System.out.println("- " + produit.getNom() + " : " + vente.getVentesParProduit().get(produit) + " unités");
            }
        }

        System.out.println("\nProduits les plus vendus :");
        Map<Produit, Integer> ventesParProduit = new HashMap<>();
        for (Vente vente : listeVentes) {
            for (Produit produit : vente.getProduitsVendus()) {
                int quantiteVendue = vente.getVentesParProduit().get(produit);
                ventesParProduit.put(produit, ventesParProduit.getOrDefault(produit, 0) + quantiteVendue);
            }
        }
        List<Map.Entry<Produit, Integer>> produitsTries = new ArrayList<>(ventesParProduit.entrySet());
        produitsTries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        for (int i = 0; i < Math.min(5, produitsTries.size()); i++) {
            Produit produit = produitsTries.get(i).getKey();
            int quantiteVendue = produitsTries.get(i).getValue();
            System.out.println("- " + produit.getNom() + " : " + quantiteVendue + " unités");
        }

        System.out.println("\nProduits en rupture de stock :");
        for (Produit produit : stock.getProduits()) {
            if (produit.getQte() == 0) {
                System.out.println("- " + produit.getNom() + " est en rupture de stock.");
            }
            else {
            	System.out.println("Aucun produit en rupture de stock.");
            }
        }
        
    }

}  
