package pemlanModul3Bab8.Praktikum;

// File: Employee.java
public class Employee implements Payable {
    private Integer registrationNumber;
    private String name;
    private Integer salaryPerMonth;
    private Invoice[] invoices; // Array belanjaan karyawan [cite: 234]

    public Employee(Integer registrationNumber, String name, Integer salaryPerMonth, Invoice[] invoices) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }

    @Override
    public double getPayableAmount() {
        double totalBelanja = 0;
        for (Invoice inv : invoices) {
            totalBelanja += inv.getPayableAmount();
        }
        return salaryPerMonth - totalBelanja; // Gaji bersih setelah potong hutang 
    }

    public void tampilkanInfo() {
        System.out.println("Nama Karyawan: " + name + " [" + registrationNumber + "]");
        System.out.println("Gaji Awal: Rp" + salaryPerMonth);
        System.out.println("Detail Belanja:");
        for (Invoice inv : invoices) {
            System.out.println("- " + inv.getDetail() + " = Rp" + inv.getPayableAmount());
        }
        System.out.println("Gaji Akhir (setelah potong): Rp" + getPayableAmount());
    }
}