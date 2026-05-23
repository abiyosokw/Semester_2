import java.util.*;

// Kelas representasi data Pemain
class Pemain {
    String tim;
    int tinggi;
    int berat;

    public Pemain(String tim, int tinggi, int berat) {
        this.tim = tim;
        this.tinggi = tinggi;
        this.berat = berat;
    }

    @Override
    public String toString() {
        return "Pemain " + tim + " [Tinggi: " + tinggi + " cm, Berat: " + berat + " kg]";
    }
}

// Comparator untuk Tinggi Badan (Ascending/Menaik)
class SortByTinggiAsc implements Comparator<Pemain> {
    public int compare(Pemain a, Pemain b) {
        return a.tinggi - b.tinggi;
    }
}

// Comparator untuk Tinggi Badan (Descending/Menurun)
class SortByTinggiDesc implements Comparator<Pemain> {
    public int compare(Pemain a, Pemain b) {
        return Collections.reverseOrder(new SortByTinggiAsc()).compare(a, b);
    }
}

// Comparator untuk Berat Badan (Ascending/Menaik)
class SortByBeratAsc implements Comparator<Pemain> {
    public int compare(Pemain a, Pemain b) {
        return a.berat - b.berat;
    }
}

// Comparator untuk Berat Badan (Descending/Menurun)
class SortByBeratDesc implements Comparator<Pemain> {
    public int compare(Pemain a, Pemain b) {
        return Collections.reverseOrder(new SortByBeratAsc()).compare(a, b);
    }
}

public class ManajemenTimFutsal {
    public static void main(String[] args) {
        // 2a. Implementasi ArrayList untuk Tim A dan Tim B
        ArrayList<Pemain> timA = new ArrayList<>();
        ArrayList<Pemain> timB = new ArrayList<>();

        // Memasukkan data Tim A
        timA.add(new Pemain("A", 168, 50));
        timA.add(new Pemain("A", 170, 60));
        timA.add(new Pemain("A", 165, 56));
        timA.add(new Pemain("A", 168, 55));
        timA.add(new Pemain("A", 168, 60));
        timA.add(new Pemain("A", 170, 70));
        timA.add(new Pemain("A", 169, 66));
        timA.add(new Pemain("A", 165, 56));
        timA.add(new Pemain("A", 168, 72));
        timA.add(new Pemain("A", 169, 56));

        // Memasukkan data Tim B
        timB.add(new Pemain("B", 170, 66));
        timB.add(new Pemain("B", 167, 60));
        timB.add(new Pemain("B", 165, 59));
        timB.add(new Pemain("B", 166, 58));
        timB.add(new Pemain("B", 172, 58));
        timB.add(new Pemain("B", 175, 71));
        timB.add(new Pemain("B", 172, 68));
        timB.add(new Pemain("B", 171, 68));
        timB.add(new Pemain("B", 171, 65));
        timB.add(new Pemain("B", 166, 60));

        System.out.println("=== JAWABAN TUGAS 1 ===");
        
        // 1a. Urutkan berdasarkan Tinggi Badan (Ascending & Descending)
        System.out.println("\n-- Tim A Diurutkan Berdasarkan Tinggi (Ascending) --");
        Collections.sort(timA, new SortByTinggiAsc());
        for (Pemain p : timA) System.out.println(p);

        System.out.println("\n-- Tim A Diurutkan Berdasarkan Tinggi (Descending) --");
        Collections.sort(timA, new SortByTinggiDesc());
        for (Pemain p : timA) System.out.println(p);

        // 1b. Urutkan berdasarkan Berat Badan (Ascending & Descending)
        System.out.println("\n-- Tim B Diurutkan Berdasarkan Berat (Ascending) --");
        Collections.sort(timB, new SortByBeratAsc());
        for (Pemain p : timB) System.out.println(p);

        System.out.println("\n-- Tim B Diurutkan Berdasarkan Berat (Descending) --");
        Collections.sort(timB, new SortByBeratDesc());
        for (Pemain p : timB) System.out.println(p);

        Pemain maxTinggiA = Collections.max(timA, new SortByTinggiAsc());
        Pemain minTinggiA = Collections.min(timA, new SortByTinggiAsc());
        Pemain maxBeratA = Collections.max(timA, new SortByBeratAsc());
        Pemain minBeratA = Collections.min(timA, new SortByBeratAsc());
        System.out.println("\n-- Statistik Tim A --");
        System.out.println("Max Tinggi : " + maxTinggiA.tinggi + " cm\t | Min Tinggi : " + minTinggiA.tinggi + " cm");
        System.out.println("Max Berat  : " + maxBeratA.berat + " kg\t | Min Berat  : " + minBeratA.berat + " kg");

        Pemain maxTinggiB = Collections.max(timB, new SortByTinggiAsc());
        Pemain minTinggiB = Collections.min(timB, new SortByTinggiAsc());
        Pemain maxBeratB = Collections.max(timB, new SortByBeratAsc());
        Pemain minBeratB = Collections.min(timB, new SortByBeratAsc());
        System.out.println("\n-- Statistik Tim B --");
        System.out.println("Max Tinggi : " + maxTinggiB.tinggi + " cm\t | Min Tinggi : " + minTinggiB.tinggi + " cm");
        System.out.println("Max Berat  : " + maxBeratB.berat + " kg\t | Min Berat  : " + minBeratB.berat + " kg");

        // 1d. Copy seluruh anggota Tim B ke Tim C dan tampilkan buktinya
        // List tujuan (timC) harus setidaknya sepanjang List sumber (timB) [cite: 95]
        ArrayList<Pemain> timC = new ArrayList<>(Arrays.asList(new Pemain[timB.size()]));
        Collections.copy(timC, timB);
        
        System.out.println("\n-- Hasil Copy Tim B ke Tim C (Bukti) --");
        for (Pemain p : timC) {
            System.out.println(p); // Ini akan mencetak isi timC yang seharusnya sama persis dengan timB
        }

        System.out.println("\n=== JAWABAN TUGAS 2 ===");

        // Ekstraksi atribut ke ArrayList integer murni untuk mempermudah method pencarian Collection
        ArrayList<Integer> tinggiTimA = new ArrayList<>();
        ArrayList<Integer> beratTimA = new ArrayList<>();
        for (Pemain p : timA) { tinggiTimA.add(p.tinggi); beratTimA.add(p.berat); }

        ArrayList<Integer> tinggiTimB = new ArrayList<>();
        ArrayList<Integer> beratTimB = new ArrayList<>();
        for (Pemain p : timB) { tinggiTimB.add(p.tinggi); beratTimB.add(p.berat); }

        // 2b. Jumlah pemain Tim B dengan tinggi 168 cm dan 160 cm
        int countTinggiB168 = Collections.frequency(tinggiTimB, 168);
        int countTinggiB160 = Collections.frequency(tinggiTimB, 160);
        System.out.println("\nJumlah pemain Tim B dengan tinggi 168 cm: " + countTinggiB168);
        System.out.println("Jumlah pemain Tim B dengan tinggi 160 cm: " + countTinggiB160);

        // 2c. Jumlah pemain Tim A dengan berat 56 kg dan 53 kg
        int countBeratA56 = Collections.frequency(beratTimA, 56);
        int countBeratA53 = Collections.frequency(beratTimA, 53);
        System.out.println("\nJumlah pemain Tim A dengan berat 56 kg: " + countBeratA56);
        System.out.println("Jumlah pemain Tim A dengan berat 53 kg: " + countBeratA53);

        // 2d. Apakah pemain Tim A ada yang memiliki tinggi/berat sama dengan Tim B?
        boolean tinggiSama = !Collections.disjoint(tinggiTimA, tinggiTimB);
        boolean beratSama = !Collections.disjoint(beratTimA, beratTimB);
        
        System.out.println("\nApakah ada kesamaan Tinggi Badan antara Tim A dan Tim B? " + (tinggiSama ? "Ya, ada." : "Tidak ada."));
        System.out.println("Apakah ada kesamaan Berat Badan antara Tim A dan Tim B? " + (beratSama ? "Ya, ada." : "Tidak ada."));
    }
}