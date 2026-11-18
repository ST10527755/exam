public class VATAndCommission {
    // Sample exam rates: change to the values stated in your question.
    private static final double VAT_RATE = 0.14;
    private static final double COMMISSION_RATE = 0.10;
    public static void main(String[] args) {
        double price = 100;
        int quantity = 3;
        // VAT is applied after multiplying price by quantity.
        double subtotal = price * quantity;
        double totalWithVat = subtotal * (1 + VAT_RATE);
        double sales = 800000;
        // Commission is a percentage of sales.
        double commission = sales * COMMISSION_RATE;
        System.out.println("Total with VAT: " + totalWithVat);
        System.out.println("Commission: " + commission);
    }
}
