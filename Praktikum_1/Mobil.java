package Semester_2.Praktikum_1;

public class Mobil {
    private String noPlat;
    private String warna;
    private String manufaktur;
    private int kecepatan;

    public void setNoPlat(String s) {
        noPlat = s;
    }

    public void setWarna(String s) {
        warna = s;
    }

    public void setManufaktur(String s) {
        manufaktur = s;
    }

    public void setKecepatan(int i) {
        kecepatan = i;
    }

    public void displayMessage () {
        System.out.println("Mobil anda adalah bermerek "+manufaktur);
        System.out.println("Mempunyai nomor plat "+noPlat);
        System.out.println("serta memiliki warna "+warna);
        System.out.println("dan mampu menempuh kecepatan "+kecepatan);
    }
}
