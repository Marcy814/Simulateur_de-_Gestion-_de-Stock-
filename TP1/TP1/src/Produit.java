public class Produit {
	
	//Attributs
    private String nom;
    private double prix;
    private int qte;
    
    //Constructeur
    public Produit(String n, double p, int q) {
        this.nom = n;
        this.prix = p;
        this.qte = q;
    }
    //Getters
    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }
    
    public int getQte() {
    	return qte;
    }
    
    //Setters
    public void setNom(String nNom) {
    	this.nom = nNom;
    }
    
    public void setPrix(double nPrix) {
    	this.prix = nPrix;
    }
    
    public void setQte(int nQte) {
    	this.qte = nQte;
    }
    ///to string
    public String toString() {
    	return "\nNom :"+nom+"\n"+
    			"Prix :"+prix+"\n"+
    			"Quantite :"+qte+"\n";
    }
}

