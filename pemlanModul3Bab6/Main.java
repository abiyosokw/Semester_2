package pemlanModul3Bab6;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TEST CASE MANUSIA ===");
        System.out.println(new Manusia("Budi", "111", true, true)); // Laki-laki Menikah
        System.out.println("\n" + new Manusia("Siti", "112", false, true)); // Perempuan Menikah
        System.out.println("\n" + new Manusia("Andi", "113", true, false)); // Belum Menikah

        System.out.println("\n=== TEST CASE MAHASISWA FILKOM ===");
        // Contoh NIM: 235150601111001 (Angkatan 23, Prodi 6: PTI)
        System.out.println(new MahasiswaFILKOM("Eko", "221", true, false, "235150601111", 2.8)); // IPK < 3
        System.out.println("\n" + new MahasiswaFILKOM("Dwi", "222", false, false, "225150401111", 3.3)); // IPK 3-3.5
        System.out.println("\n" + new MahasiswaFILKOM("Tri", "223", true, false, "215150201111", 3.8)); // IPK 3.5-4

        System.out.println("\n=== TEST CASE PEKERJA ===");
        System.out.println(new Pekerja("Joko", "331", true, true, 2000, LocalDate.now().minusYears(2), 2));
        System.out.println("\n" + new Pekerja("Ani", "332", false, true, 2000, LocalDate.now().minusYears(9), 0));
        System.out.println("\n" + new Pekerja("Bambang", "333", true, true, 2000, LocalDate.now().minusYears(20), 10));

        System.out.println("\n=== TEST CASE MANAGER ===");
        System.out.println(new Manager("Suharto", "441", true, true, 7500, LocalDate.now().minusYears(15), 0, "IT"));
    }
}