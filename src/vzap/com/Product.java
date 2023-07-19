package vzap.com;

public class Product {
    private int productID;
    private double prodPrice;
    private String prodDescription;

    public Product(int productID, double prodPrice, String prodDescription) {
        this.productID = productID;
        this.prodPrice = prodPrice;
        this.prodDescription = prodDescription;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    @Override
    public String toString() {
        return "Product [productID=" + productID + ", prodPrice=" + prodPrice + ", prodDescription=" + prodDescription
                + "]";
    }
}
