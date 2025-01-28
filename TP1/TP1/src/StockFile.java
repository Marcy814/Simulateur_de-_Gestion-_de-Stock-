import java.util.ArrayDeque;
import java.util.Queue;

public class StockFile extends Stock {
    private Queue<Produit> fileStock;

    public StockFile() {
        fileStock = new ArrayDeque<>();
    }

    @Override
    public void ajouterProduit(Produit produit) {
        fileStock.add(produit);
    }
    
    
    
}
