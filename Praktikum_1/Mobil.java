package Semester_2.Praktikum_1;

public class Mobil {
    private String noPlat;
    private String warna;
    private String manufaktur;
    private double kecepatan;
    private double waktu;

    public void setNoPlat(String s) {
        noPlat = s;
    }

    public void setWarna(String s) {
        warna = s;
    }

    public void setManufaktur(String s) {
        manufaktur = s;
    }

    public void setKecepatan( double i) {
        kecepatan = rubahKecepatan(i);
    }

    public void setWaktu(double d) {
        waktu = rubahSekon(d);
    }
    
    private double rubahSekon(double d) {
        return 3600 * d;
    }

    private double rubahKecepatan(double i) {
        return i / 3.6;
    }

    public double hitungJarak() {
        return kecepatan * waktu;
    }

    public void displayMessage () {
        System.out.println("Mobil anda adalah bermerek "+manufaktur);
        System.out.println("Mempunyai nomor plat "+noPlat);
        System.out.println("serta memiliki warna "+warna);
        System.out.println("dan mampu menempuh kecepatan "+kecepatan+ " m/s");
        System.out.println("dengan waktu tempu "+waktu+" detik");
    }
}
