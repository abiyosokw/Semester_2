package Semester_2.pemlanKuis1.hard;
import java.util.Scanner;

public class moo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String nama = "";
        int berat = 0;
        String layanan = "";
        String kelas = "";

        while (true) {
            if (!sc.hasNext()) return;
            nama = sc.next();
            if (nama.matches("^[a-zA-Z]+$")) {
                break;
            } else {
                System.out.println("Mooo! Nama sapi harus pakai huruf, bukan angka atau simbol!");
            }
        }

        while (true) {
            if (!sc.hasNext()) return;
            if (sc.hasNextInt()) {
                berat = sc.nextInt();
                if (berat >= 1 && berat <= 80) {
                    break;
                } else {
                    System.out.println("Sapi astral? Masukkan berat yang valid dulu, bestie!");
                }
            } else {
                sc.next(); 
                System.out.println("Sapi astral? Masukkan berat yang valid dulu, bestie!");
            }
        }

        while (true) {
            if (!sc.hasNext()) return;
            layanan = sc.next();
            if (layanan.equals("spa") || layanan.equals("potong_kuku") || layanan.equals("grooming")) {
                break;
            } else {
                System.out.println("Pilih spa, potong_kuku, atau grooming! Sapi kamu mau dirawat apa, sih?");
            }
        }

        while (true) {
            if (!sc.hasNext()) return;
            kelas = sc.next();
            if (kelas.equals("reguler") || kelas.equals("vip")) {
                break;
            } else {
                System.out.println("Pilih reguler atau vip! Sapi kamu mau treatment sultan atau biasa aja?");
            }
        }

        double hargaPerKg = 0;
        if (layanan.equals("spa")) hargaPerKg = 8000;
        else if (layanan.equals("potong_kuku")) hargaPerKg = 6000;
        else if (layanan.equals("grooming")) hargaPerKg = 10000;

        double biayaDasar = berat * hargaPerKg;

        double diskon = 0;
        if (berat > 30) {
            diskon = biayaDasar * 0.10;
        }

        double tambahanVip = 0;
        if (kelas.equals("vip")) {
            tambahanVip = biayaDasar * 0.20;
        }

        double subtotal = biayaDasar - diskon + tambahanVip;

        double pajak = subtotal * 0.08;

        double totalBiaya = subtotal + pajak;

        boolean isSapiSpesial = nama.equals("Moo") || nama.equals("Mooo") || nama.equals("Moooo");
        if (isSapiSpesial) {
            totalBiaya = 0.0;
        }

        System.out.println("================ NOTA KLINIK SAPI ================");
        System.out.println("Nama Sapi: " + nama);
        System.out.println("Berat: " + berat + " kg");
        System.out.println("Jenis Layanan: " + layanan);
        System.out.println("Kelas: " + kelas);
        System.out.println("Biaya Dasar: Rp " + biayaDasar);
        System.out.println("Diskon: Rp " + diskon);
        System.out.println("Biaya Tambahan VIP: Rp " + tambahanVip);
        System.out.println("Subtotal: Rp " + subtotal);
        System.out.println("Pajak: Rp " + pajak);
        System.out.println("Total Biaya: Rp " + totalBiaya);
        System.out.println("==================================================");

        if (isSapiSpesial) {
            System.out.println("Terima kasih, " + nama + " ! Sapi spesial memang beda perlakuan~");
        } else {
            System.out.println("Terima kasih, " + nama + " ! Semoga sapinya makin glow up.");
        }
        
        sc.close();
    }
}