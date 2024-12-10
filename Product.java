import java.util.*;

class Product {
    private String name;
    private int price;
    private int multiPriceQuantity;
    private int multiPrice;

    public Product(String name, int price, int multiPriceQuantity, int multiPrice) {
        this.name = name;
        this.price = price;
        this.multiPriceQuantity = multiPriceQuantity;
        this.multiPrice = multiPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMultiPriceQuantity() {
        return multiPriceQuantity;
    }

    public void setMultiPriceQuantity(int multiPriceQuantity) {
        this.multiPriceQuantity = multiPriceQuantity;
    }

    public int getMultiPrice() {
        return multiPrice;
    }

    public void setMultiPrice(int multiPrice) {
        this.multiPrice = multiPrice;
    }
}