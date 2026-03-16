package Semester_2.pemlanModul2Bab4;

public class DataPelanggan {
    private Pelanggan[] daftarPelanggan;

    public DataPelanggan() {
        daftarPelanggan = new Pelanggan[3];
        daftarPelanggan[0] = new Pelanggan("Andi Wijaya", "3812345678", 2000000, "1234");
        daftarPelanggan[1] = new Pelanggan("Budi Santoso", "5698765432", 5000000, "5678");
        daftarPelanggan[2] = new Pelanggan("Citra Dewi", "7411223344", 10000000, "9012");
    }

    public Pelanggan[] getDaftarPelanggan() {
        return daftarPelanggan;
    }

    public void tampilkanDaftarPelanggan2() {
        System.out.println("\nDaftar Pelanggan:");
        for (int i = 0; i < daftarPelanggan.length; i++) {
            System.out.println((i + 1) + ". " + daftarPelanggan[i].getNama() + 
                            " (" + daftarPelanggan[i].getNomorPelanggan() + ") - " +
                            daftarPelanggan[i].getJenisPelanggan());
        }
    }

    public Pelanggan getPelanggan(int index) {
        if (index >= 0 && index < daftarPelanggan.length) {
            return daftarPelanggan[index];
        }
        return null;
    }
    public int getJumlahPelanggan() {
        return daftarPelanggan.length;
    }
}
