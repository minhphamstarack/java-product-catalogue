public class Main {
    public static void main(String[] args) {
        Checkout checkout = new Checkout();

        checkout.addProduct(new Product("A", 40, 3, 70));
        checkout.addProduct(new Product("B", 10, 2, 15));

        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");

        checkout.printReceipt();
    }
}