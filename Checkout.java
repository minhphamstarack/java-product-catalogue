import java.util.*;
public class Checkout {
    private final Map<String, Product> productCatalog = new HashMap<>();
    private final Map<String, Integer> cart = new HashMap<>();

    public void addProduct(Product product) {
        productCatalog.put(product.getName(), product);
    }

    public void scan(String productName) {
        if(!productCatalog.containsKey(productName)) {
            System.out.println("Product not found!");
            return;
        }
        cart.put(productName, cart.getOrDefault(productName, 0) + 1);
    }

    public int getTotal() {
        int totalPrice = 0;
        for(Map.Entry<String, Integer> entry : cart.entrySet()) {
            String productName = entry.getKey();
            int quantity = entry.getValue();
            Product product = productCatalog.get(productName);

            if (product.getMultiPriceQuantity() > 0 && quantity >= product.getMultiPriceQuantity()) {
                int multiPriceCount = quantity / product.getMultiPriceQuantity();
                int remainder = quantity % product.getMultiPriceQuantity();
                totalPrice += multiPriceCount * product.getMultiPrice() + remainder * product.getPrice();
            } else {
                totalPrice += quantity * product.getPrice();
            }
        }

        return totalPrice;
    }

    public void printReceipt() {
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String productName = entry.getKey();
            int quantity = entry.getValue();
            Product product = productCatalog.get(productName);
            int price = product.getPrice();

            if (product.getMultiPriceQuantity() > 0 && quantity >= product.getMultiPriceQuantity()) {
                System.out.println(productName + " x" + quantity + " - " + getTotal() + " cents (multi-price applied)");
            } else {
                System.out.println(productName + " x" + quantity + " - " + (quantity * price) + " cents");
            }

            System.out.println("Total Price: " + getTotal() + " cents");
        }
    }

}
