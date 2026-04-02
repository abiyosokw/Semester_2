package Semester_2.TugasBab13_11;

// File: TestOctagon.java
public class TestOctagon {
    public static void main(String[] args) {
        // Membuat objek Octagon dengan nilai sisi 5
        Octagon oct1 = new Octagon(5);

        // Menampilkan luas dan keliling
        System.out.println("Luas Octagon      : " + oct1.getArea());
        System.out.println("Keliling Octagon  : " + oct1.getPerimeter());

            // Membuat objek baru menggunakan method clone
            try {
                Octagon oct2 = (Octagon) oct1.clone();

                // Membandingkan kedua objek menggunakan method compareTo
                int hasilPerbandingan = oct1.compareTo(oct2);

                if (hasilPerbandingan == 1) {
                    System.out.println("Hasil Compare     : Octagon pertama lebih besar dari hasil clone-nya.");
                } else if (hasilPerbandingan == -1) {
                    System.out.println("Hasil Compare     : Octagon pertama lebih kecil dari hasil clone-nya.");
                } else {
                    System.out.println("Hasil Compare     : Octagon pertama SAMA (equal) dengan hasil clone-nya.");
                }
            } catch (CloneNotSupportedException e) {
                System.out.println("Error: Clone tidak didukung - " + e.getMessage());
            }
    }
}