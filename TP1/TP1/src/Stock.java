import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Stock {
	//Attributs
    private ArrayList<Produit> produits;
    private Deque<ProduitNonPerissable> stockPile;
    private Queue<ProduitPerissable> stockFile;
    
    //Methode du constructeur
    public Stock() {
    	produits = new ArrayList<>();
        stockPile = new ArrayDeque<>();
        stockFile = new LinkedList<>();
    }

    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    public Produit supprimerProduit(String nom) {
        for (Produit produit : produits) {
            if (produit.getNom().equals(nom)) {
                produits.remove(produit);
                return produit;
            }
        }
        return null;
    }

    public Produit rechercherProduit(String nom) {
        for (Produit produit : produits) {
            if (produit.getNom().equals(nom)) {
                return produit;
            }
        }
        return null;
    }

	public ArrayList<Produit> getProduits() {
		// TODO Auto-generated method stub
		return produits;
	}
}
