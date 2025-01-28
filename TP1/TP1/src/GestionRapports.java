import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class GestionRapports {
    private Vente vente;
    private Stock stock;

    public GestionRapports(Vente vente, Stock stock) {
        this.vente = vente;
        this.stock = stock;
    }

    public void genererRapportVentes() {
        System.out.println("===== Rapport des ventes =====");
        for (Map.Entry<Produit, Integer> entry : vente.getVentesParProduit().entrySet()) {
            Produit produit = entry.getKey();
            int quantiteVendue = entry.getValue();
            System.out.println(produit.getNom() + " - Quantité vendue : " + quantiteVendue);
        }
    }

    public void genererRapportProduitsPlusVendus(int nombreProduits) {
        System.out.println("===== Rapport des " + nombreProduits + " produits les plus vendus =====");
        ArrayList<Produit> produitsTries = vente.getProduitsVendus().stream()
                .sorted(Comparator.comparingInt(prod -> -vente.getVentesParProduit().getOrDefault(prod, 0)))
                .limit(nombreProduits)
                .collect(Collectors.toCollection(ArrayList::new));

        for (Produit produit : produitsTries) {
            int quantiteVendue = vente.getVentesParProduit().getOrDefault(produit, 0);
            System.out.println(produit.getNom() + " - Quantité vendue : " + quantiteVendue);
        }
    }

    public void genererRapportProduitsRuptureStock() {
        System.out.println("===== Rapport des produits en rupture de stock =====");
        for (Produit produit : stock.getProduits()) {
            if (produit.getQte() == 0) {
                System.out.println(produit.getNom() + " est en rupture de stock.");
            }
            else {
            	System.out.println("Aucun Produit n'est en rupturede stock");
            }
        }
    }
}
