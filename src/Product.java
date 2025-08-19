import java.util.Arrays;

public class Product {
    public static Product[] details ;
    private String productId;
    private String productName;
    private String productPrice;

    public Product() {
    }

    public Product(String productId, String productName, String productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        System.out.println(details.toString());
        return productName;
    }

    public void setProductName(String productName) {

        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + String.valueOf(productId) + '\'' +
                ", name='" + String.valueOf(productName) + '\'' +
                ", price='" + String.valueOf(productPrice) + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Product.details));
    }
}
