package pemlanModul3Bab8.Data;
import java.util.Scanner;


class Manusia implements MakhlukHidup, Identitas {
    private String nama;
    private int umur;

    // Konstruktor dengan parameter nama dan umur (Soal 6)
    public Manusia(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    @Override
    public void makan() { System.out.println(nama + " makan pakai sendok garpu"); }
    @Override
    public void berjalan() { System.out.println(nama + " jalan pakai dua kaki"); }
    @Override
    public void bersuara() { System.out.println("Suaranya merdu"); }
    @Override
    public void tampilkanNama() { System.out.println("Nama saya: " + this.nama); }
    @Override
    public void tampilkanUmur() { System.out.println("Umur saya: " + this.umur); }
}

public class Main {
    public static void main(String[] args) {
        //(Soal 6) Membuat objek Manusia dengan nama "Agus" dan umur 20, lalu menampilkan nama dan umurnya
        Manusia me = new Manusia("Agus", 20);
        me.tampilkanNama();
        me.tampilkanUmur();

        // (Soal 7) Membuat objek Manusia dengan inputan nama dan umur
        Scanner input = new Scanner(System.in);
    
        System.out.print("Masukkan Nama: ");
        String n = input.nextLine();
        System.out.print("Masukkan Umur: ");
        int u = input.nextInt();
        
        Manusia orang = new Manusia(n, u);
        orang.tampilkanNama();
        orang.tampilkanUmur();
        orang.makan();

        input.close();

        // (Soal 8) Membuat objek Hewan dan memanggil method makan, bersuara, dan berjalan
        Hewan kucing = new Hewan();
    
        System.out.println("--- Aksi Hewan ---");
        kucing.makan();    // Memanggil method makan
        kucing.bersuara(); // Memanggil method bersuara
        kucing.berjalan(); // Memanggil method berjalan
    }
}