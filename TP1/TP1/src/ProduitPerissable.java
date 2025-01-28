import java.time.LocalDate;


public class ProduitPerissable extends Produit {
    private LocalDate dateExp;

    public ProduitPerissable(String n,  double p, int q, LocalDate localDate) {
        super(n, p, q);
        dateExp = localDate;
    }
    
    public LocalDate getDateExp() {
		return dateExp;
	}
	
	public void setDateExp(LocalDate dateExp) {
		this.dateExp = dateExp;
	}
	//toString
	public String toString() {
		return "Produit périssable:"+"\n"+
				super.toString()
				+"Date d'expiration (AAAA-MM-JJ) :"+dateExp+"\n";
	}
}