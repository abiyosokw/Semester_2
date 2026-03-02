package Semester_2.Praktikum_1;
import java.util.Scanner;

public class MainMobil { 
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Mobil m3 = new Mobil();
        System.out.println("Masukkan kecepatan mobil :");
        int kecepatan = sc.nextInt();
        sc.nextLine();
        m3.setKecepatan(kecepatan);
        System.out.println("Masukkan manufaktur mobil :");
        String manufaktur = sc.nextLine();
        m3.setManufaktur(manufaktur);
        System.out.println("Masukkan nomor Plat mobil :");
        String noPlat = sc.nextLine();
        m3.setNoPlat(noPlat);
        System.out.println("Masukkan warna mobil :");
        String warna = sc.nextLine();
        m3.setWarna(warna);
        System.out.println("Masukkan waktu tempuh mobil (dalam jam) :");
        double waktu = sc.nextDouble();
        m3.setWaktu(waktu);
        m3.displayMessage();
        
        sc.close();
        
        /* 
        //instan objek bernama m1
        Mobil m1 = new Mobil();
        m1.setKecepatan(50);
        m1.setManufaktur("Toyota");
        m1.setNoPlat("AB 1231 UA");
        m1.setWarna("Merah");
        m1.displayMessage();
        System.out.println("================");

        //instan objek baru bernama m2
        Mobil m2 = new Mobil();
        m2.setKecepatan(100);
        m2.setManufaktur("Mitsubishi");
        m2.setNoPlat("N 1134 AG");
        m2.setWarna("Pink");
        m2.displayMessage();
        System.out.println("================");

        //merubah warna dari objek m1
        System.out.println("mobil pada objek m1 di rubah menjadi warna hijau");
        m1.setWarna("Hijau");
        //menampilkan hasil perubahan
        m1.displayMessage();
        */

    }
}