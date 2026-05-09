package pemlanModul3Bab8.Praktikum;

// File: Main.java
public class Main {
    public static void main(String[] args) {
        // Contoh data belanja
        Invoice[] listBelanja = {
            new Invoice("Garam", 1, 6500),
            new Invoice("Gula 1 kg", 1, 95000)
        };

        // Instansiasi Employee
        Employee emp = new Employee(202, "Joshua", 6700000, listBelanja);
        
        // Tampilkan hasil secara polimorfis
        emp.tampilkanInfo();
    }
}