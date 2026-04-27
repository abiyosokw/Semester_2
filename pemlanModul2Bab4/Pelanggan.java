package pemlanModul2Bab4;

public class Pelanggan {
    private String nomorPelanggan;
    private String nama;
    private double saldo;
    private String pin;
    private boolean isFrozen;
    private int kesalahanPin;

    public Pelanggan(String nama, String nomorPelanggan, double saldo, String pin) {
        this.nama = nama;
        this.nomorPelanggan = nomorPelanggan;
        this.saldo = saldo;
        this.pin = pin;
        this.isFrozen = false;
        this.kesalahanPin = 0;
    }

    public String getNomorPelanggan() {
        return nomorPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public String getJenisPelanggan() {
        String duaDigitAwal = nomorPelanggan.substring(0,2);

        switch(duaDigitAwal) {
            case "38":
                return "Silver";
            case "56":
                return "Gold";
            case "74":
                return "Platinum";
            default:
                return "Unknown";
        }
    }

    private double hitungCashback(double jumlahPembelian) {
        String duaDigitAwal = nomorPelanggan.substring(0,2);
        double cashback = 0;

        switch(duaDigitAwal) {
            case "38":
                if (jumlahPembelian > 1_000_000) {
                    cashback = jumlahPembelian * 0.05;
                }
                break;
            case "56":
                if  (jumlahPembelian > 1_000_000) {
                    cashback = jumlahPembelian * 0.07;
                } else {
                    cashback = jumlahPembelian * 0.02;
                }
                
                break;
            case "74":
                if (jumlahPembelian > 1_000_000) {
                    cashback = jumlahPembelian * 0.10;
                } else {
                    cashback = jumlahPembelian * 0.05;
                }
                break;
        }

        return cashback;
    }

    public boolean autentikasi(String pin) {
        if (isFrozen) {
            System.out.println("\nAkun Anda telah diblokir!");
            return false;
        }

        if (this.pin.equals(pin)) {
            kesalahanPin = 0; // reset kesalahan PIN
            return true;
        } else {
            kesalahanPin++;
            if (kesalahanPin >= 3) {
                isFrozen = true;
                System.out.println("\nAkun Anda telah diblokir karena salah memasukkan PIN sebanyak 3 kali!");
            } else {
                System.out.println("\nPIN salah! Kesempatan tersisa: " + (3 - kesalahanPin));
            }
            return false;
        }
    }

    public boolean pembelian(double jumlahPembelian, String pin) {
        if (!autentikasi(pin)) {
            return false;
        }
        double cashback = hitungCashback(jumlahPembelian);
        double setelahTransaksi = saldo - jumlahPembelian + cashback;

        if (setelahTransaksi < 10_000) {
            System.out.println("Transaksi gagal! Saldo setelah transaksi kurang dari Rp 10.000");
            System.out.println("Saldo Anda saat ini: Rp " + String.format("%,.2f", saldo));
            return false;
        }

        saldo = setelahTransaksi;
        System.out.println("==== TRANSAKSI BERHASIL ====");
        System.out.printf("\nJumlah pembelian: Rp %,.2f", jumlahPembelian);
        System.out.printf("\nTransaksi berhasil! Cashback yang Anda dapatkan: Rp %,.2f", cashback);
        System.out.printf("\nSaldo Anda saat ini: Rp %,.2f", saldo);
        return true;
    }

    public boolean topUp(double jumlahTopUp, String pin) {
        if (!autentikasi(pin)) {
            return false;
        }
        if (jumlahTopUp <= 0) {
            System.out.println("Jumlah top up harus lebih dari 0!");
            return false;
        }
        saldo += jumlahTopUp;
        System.out.println("\n==== TOP UP BERHASIL ====");
        System.out.printf("Jumlah top up: Rp %,.2f\n", jumlahTopUp);
        System.out.printf("Saldo Anda saat ini: Rp %,.2f\n", saldo);
        return true;
    }

    public void tampilkanInfo() {
        System.out.println("\n==== INFO PELANGGAN ====");
        System.out.println("Nama: " + nama);
        System.out.println("Nomor Pelanggan: " + nomorPelanggan);
        System.out.println("Jenis Pelanggan: " + getJenisPelanggan());
        System.out.printf("Saldo: Rp %,.2f\n", saldo);
        System.out.println("Status Akun: " + (isFrozen ? "Diblokir" : "Aktif"));
    }
}
