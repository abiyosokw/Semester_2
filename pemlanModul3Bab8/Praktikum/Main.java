package pemlanModul3Bab8.Praktikum;

// File: Main.java
public class Main {
    public static void main(String[] args) {
        // Contoh data belanja
        Invoice[] listBelanja = {
            new Invoice("Sabun", 2, 5000),
            new Invoice("Beras 5kg", 1, 75000)
        };

        // Instansiasi Employee
        Employee emp = new Employee(101, "Budi", 5000000, listBelanja);
        
        // Tampilkan hasil secara polimorfis
        emp.tampilkanInfo();
    }
}