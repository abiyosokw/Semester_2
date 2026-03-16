package Semester_2.pemlanModul2Bab4;
import java.util.Scanner;

public class MenuTransaksi {
    private Scanner input;
    private Pelanggan pelangganAktif;

    public MenuTransaksi(Scanner input, Pelanggan pelangganAktif) {
        this.input = input;
        this.pelangganAktif = pelangganAktif;
    }

    private void tampilkanMenu() {
        System.out.println("\n======================================");
        System.out.println("           MENU TRANSAKSI            ");
        System.out.println("======================================");
        System.out.println("1. Pembelian");
        System.out.println("2. Top Up");
        System.out.println("3. Cek Saldo");
        System.out.println("4. Keluar");
        System.out.print("Pilih menu: ");
    }

    public boolean prosesMenu() {
        tampilkanMenu();
        
        int pilihan = input.nextInt();
        input.nextLine(); // consume newline
        
        if (pelangganAktif.isFrozen() && (pilihan == 1 || pilihan == 2)) {
            System.out.println("\nAkun Anda telah diblokir! Tidak dapat melakukan transaksi.");
            return true; // tetap lanjut, tidak keluar
        }
        
        switch (pilihan) {
            case 1:
                prosesPembelian();
                return true;
                
            case 2:
                prosesTopUp();
                return true;
                
            case 3:
                pelangganAktif.tampilkanInfo();
                return true;
                
            case 4:
                System.out.println("\nTerima kasih telah menggunakan Swalayan Tiny!");
                return false; // keluar dari loop
                
            default:
                System.out.println("\nPilihan tidak valid!");
                return true;
        }
    }

    private void prosesPembelian() {
        System.out.print("\nMasukkan jumlah pembelian: Rp ");
        double jumlahPembelian = input.nextDouble();
        input.nextLine(); // consume newline
        
        System.out.print("Masukkan PIN untuk konfirmasi: ");
        String pin = input.nextLine();
        
        pelangganAktif.pembelian(jumlahPembelian, pin);
    }

    private void prosesTopUp() {
        System.out.print("\nMasukkan jumlah top up: Rp ");
        double jumlahTopUp = input.nextDouble();
        input.nextLine(); // consume newline
        
        System.out.print("Masukkan PIN untuk konfirmasi: ");
        String pin = input.nextLine();
        
        pelangganAktif.topUp(jumlahTopUp, pin);
    }
}
