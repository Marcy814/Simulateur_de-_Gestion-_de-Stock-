public class Commande {
    // Attributs
    private Produit p;
    private int qte;

    // Constructeur
    public Commande(Produit p, int qte) {
        this.p = p; 
        this.qte = qte;
    }

    // Getters
    public Produit getProduit() {
        return this.p; // Retourne l'attribut p, pas la méthode getProduit()
    }

    public String getNomCommande(Commande c) {
        return c.getProduit().getNom(); // Utilisation de la méthode getProduit() pour obtenir le produit associé à la commande
    }

    public int getQuantite() {
        return qte;
    }
}
