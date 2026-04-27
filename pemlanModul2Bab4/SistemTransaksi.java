package pemlanModul2Bab4;

import java.util.Scanner;

public class SistemTransaksi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Tampilkan header aplikasi
        System.out.println("======================================");
        System.out.println("   SISTEM TRANSAKSI SWALAYAN TINY    ");
        System.out.println("======================================");
        
        // Inisialisasi data pelanggan
        DataPelanggan dataPelanggan = new DataPelanggan();
        
        // Tampilkan daftar pelanggan
        dataPelanggan.tampilkanDaftarPelanggan2();
        
        // Pilih pelanggan
        System.out.print("\nPilih pelanggan (1-" + dataPelanggan.getJumlahPelanggan() + "): ");
        int pilihanPelanggan = input.nextInt();
        input.nextLine(); // consume newline
        
        if (pilihanPelanggan < 1 || pilihanPelanggan > dataPelanggan.getJumlahPelanggan()) {
            System.out.println("Pilihan tidak valid!");
            input.close();
            return;
        }
        
        // Dapatkan pelanggan yang dipilih
        Pelanggan pelangganAktif = dataPelanggan.getPelanggan(pilihanPelanggan - 1);
        
        // Inisialisasi menu transaksi
        MenuTransaksi menu = new MenuTransaksi(input, pelangganAktif);
        
        // Loop menu transaksi
        boolean running = true;
        while (running) {
            running = menu.prosesMenu();
        }
        
        input.close();
    }
}
