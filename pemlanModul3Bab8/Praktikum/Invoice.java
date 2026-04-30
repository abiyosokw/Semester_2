package pemlanModul3Bab8.Praktikum;

// File: Invoice.java
public class Invoice implements Payable {
    private String productName;
    private Integer quantity;
    private Integer pricePerItem;

    public Invoice(String productName, Integer quantity, Integer pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    @Override
    public double getPayableAmount() {
        return quantity * pricePerItem; // Total belanja per produk [cite: 229, 232]
    }

    public String getDetail() {
        return productName + " (x" + quantity + ") - @Rp" + pricePerItem;
    }
}