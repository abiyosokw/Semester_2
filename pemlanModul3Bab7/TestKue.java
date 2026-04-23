abstract class Kue {
    private String nama;
    private double harga; 

    public Kue(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public abstract double hitungHarga();

    @Override
    public String toString() {
        return "Nama kue: " + nama + ", Harga: Rp " + hitungHarga();
    }
}

class KuePesanan extends Kue {
    private double berat;

    public KuePesanan(String nama, double harga, double berat) {
        super(nama, harga);
        this.berat = berat;
    }

    public double getBerat() {
        return berat;
    }

    @Override
    public double hitungHarga() {
        return getHarga() * berat;
    }

    @Override
    public String toString() {
        return "Nama kue: " + getNama() + ", Harga: Rp " + hitungHarga() + ", Harga satuan: Rp " + getHarga() + ", Berat: " + berat + " kg";
    }
}

class KueJadi extends Kue {
    private double jumlah;

    public KueJadi(String nama, double harga, double jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }

    public double getJumlah() {
        return jumlah;
    }

    @Override
    public double hitungHarga() {
        return getHarga() * jumlah * 2;
    }

    @Override
    public String toString() {
        return "Nama kue: " + getNama() + ", Harga: Rp " + hitungHarga() + ", Harga satuan: Rp " + getHarga() + ", Jumlah: " + jumlah;
    }
}

public class TestKue {
    public static void main(String[] args) {

        Kue[] daftarKue = new Kue[20];

        daftarKue[0] = new KuePesanan("Lumpur", 3000, 1.2);
        daftarKue[1] = new KuePesanan("Brownies", 9000, 1.3);
        daftarKue[2] = new KuePesanan("Lukchup", 4000, 1.1);
        daftarKue[3] = new KuePesanan("Klepon", 1500, 1.2);
        daftarKue[4] = new KuePesanan("Bika Ambon", 5500, 1.3);
        daftarKue[5] = new KuePesanan("Serabi", 4000, 2.0);
        daftarKue[6] = new KuePesanan("Mochi", 3500, 1.2);
        daftarKue[7] = new KuePesanan("Lapis Legit", 600000, 3.0);
        daftarKue[8] = new KuePesanan("Putu Ayu", 7200, 2.3);
        daftarKue[9] = new KuePesanan("Cheese Cake", 40000, 2.1);

        daftarKue[10] = new KueJadi("Donat", 2500, 10);
        daftarKue[11] = new KueJadi("Bolu Kukus", 2000, 8);
        daftarKue[12] = new KueJadi("Nastar", 5000, 8);
        daftarKue[13] = new KueJadi("Putri Salju", 5000, 5);
        daftarKue[14] = new KueJadi("Kue Sus", 3500, 6);
        daftarKue[15] = new KueJadi("Lemper", 2000, 12);
        daftarKue[16] = new KueJadi("Onde-onde", 2500, 11);
        daftarKue[17] = new KueJadi("Roti Bakar", 5500, 4);
        daftarKue[18] = new KueJadi("Pancong", 3000, 10);
        daftarKue[19] = new KueJadi("Pisang Molen", 3700, 7);

        double totalHargaSemua = 0;
        double totalHargaPesanan = 0;
        double totalBeratPesanan = 0;
        double totalHargaJadi = 0;
        double totalJumlahJadi = 0;
        
        Kue kueTermahal = daftarKue[0];

        System.out.println("===== DAFTAR KUE : =====");
        
        System.out.println("KUE PESANAN:");
        for (Kue kue : daftarKue) {
            if (kue instanceof KuePesanan) {
                System.out.println(kue.toString());
                
                totalHargaPesanan += kue.hitungHarga();
                
                totalBeratPesanan += ((KuePesanan) kue).getBerat();
            }
        }

        System.out.println("\nKUE JADI:");
        for (Kue kue : daftarKue) {
            if (kue instanceof KueJadi) {
                System.out.println(kue.toString());
                
                totalHargaJadi += kue.hitungHarga();
                
                totalJumlahJadi += ((KueJadi) kue).getJumlah();
            }
        }

        for (Kue kue : daftarKue) {
            totalHargaSemua += kue.hitungHarga(); 

            if (kue.hitungHarga() > kueTermahal.hitungHarga()) {
                kueTermahal = kue;
            }
        }

        System.out.println("\n===== Informasi Semua Kue =====");
        System.out.println("Total Harga Semua Kue: Rp " + totalHargaSemua);
        System.out.println("Total Harga Kue Pesanan: Rp " + totalHargaPesanan);
        System.out.println("Total Berat Kue Pesanan: " + totalBeratPesanan + " kg");
        System.out.println("Total Harga Kue Jadi: Rp " + totalHargaJadi);
        System.out.println("Total Jumlah Kue Jadi: " + totalJumlahJadi);
        
        System.out.println("Kue dengan Harga Termahal: " + kueTermahal.toString());
    }
}