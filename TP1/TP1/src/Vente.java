import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Vente {
    private ArrayList<Produit> produitsVendus;
    private Map<Produit, Integer> ventesParProduit;

    public Vente() {
        produitsVendus = new ArrayList<>();
        ventesParProduit = new HashMap<>();
    }

    public void enregistrerVente(Produit produit, int quantiteVendue) {
        // Mettre à jour le stock après la vente
        int nouvelleQuantite = produit.getQte() - quantiteVendue;
        if (nouvelleQuantite >= 0) {
            produit.setQte(nouvelleQuantite); // Mettre à jour la quantité disponible
            produitsVendus.add(produit); // Ajouter le produit vendu à la liste
            ventesParProduit.put(produit, quantiteVendue); // Enregistrer la quantité vendue par produit
            System.out.println("Vente enregistrée pour " + quantiteVendue + " " + produit.getNom());
        } else {
            System.out.println("Quantité insuffisante en stock pour " + produit.getNom());
        }
    }

    public ArrayList<Produit> getProduitsVendus() {
        return produitsVendus;
    }

    public Map<Produit, Integer> getVentesParProduit() {
        return ventesParProduit;
    }
}
