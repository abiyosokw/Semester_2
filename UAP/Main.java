package UAP;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GoDriveRentalSystem system = new GoDriveRentalSystem();

        system.tambahKendaraanAwal(new Mobil("MBL01", "Toyota Avanza", 350000, 7));
        system.tambahKendaraanAwal(new Mobil("MBL02", "Daihatsu Sigra", 300000, 7));
        system.tambahKendaraanAwal(new Mobil("MBL03", "Honda Brio", 288000, 5));
        system.tambahKendaraanAwal(new Motor("MTR01", "Honda Vario", 88000, "Matik"));
        system.tambahKendaraanAwal(new Motor("MTR02", "Yamaha NMAX", 100000, "Matik"));
        system.tambahKendaraanAwal(new Motor("MTR03", "Kawasaki KLX", 90000, "Manual"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== MENU GO DRIVE RENTAL SYSTEM ======");
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Tampilkan Daftar Armada");
            System.out.println("3. Sewa Kendaraan");
            System.out.println("4. Kembalikan Kendaraan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            int menu;
            try {
                menu = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input pilihan harus berupa angka!");
                continue;
            }

            if (menu == 1) {
                System.out.print("Masukkan jenis kendaraan (mobil/motor): ");
                String jenis = scanner.nextLine().trim();
                System.out.print("Masukkan kode kendaraan: ");
                String kode = scanner.nextLine().trim();
                System.out.print("Masukkan nama kendaraan: ");
                String nama = scanner.nextLine().trim();
                System.out.print("Masukkan harga sewa per hari: ");
                double harga = Double.parseDouble(scanner.nextLine().trim());

                if (jenis.equalsIgnoreCase("mobil")) {
                    System.out.print("Masukkan kapasitas kursi: ");
                    int kursi = Integer.parseInt(scanner.nextLine().trim());
                    system.tambahKendaraan(new Mobil(kode, nama, harga, kursi));
                } else if (jenis.equalsIgnoreCase("motor")) {
                    System.out.print("Masukkan jenis transmisi: ");
                    String transmisi = scanner.nextLine().trim();
                    system.tambahKendaraan(new Motor(kode, nama, harga, transmisi));
                } else {
                    System.out.println("[ERROR] Jenis kendaraan tidak valid!");
                }

            } else if (menu == 2) {
                system.tampilkanDaftarKendaraan();

            } else if (menu == 3) {
                System.out.print("Masukkan kode kendaraan yang ingin disewa: ");
                String kode = scanner.nextLine().trim();
                System.out.print("Masukkan durasi sewa (dalam hari): ");
                int durasi = Integer.parseInt(scanner.nextLine().trim());
                
                System.out.print("Apakah Anda Member VIP? (y/n): ");
                String vipInput = scanner.nextLine().trim();
                boolean isVip = vipInput.equalsIgnoreCase("y");

                try {
                    Kendaraan k = system.cariKendaraan(kode);
                    if (k == null || !k.isTersedia()) {
                        throw new KendaraanTidakTersediaException("Kendaraan dengan kode " + kode + " gagal disewa. Alasan: Kendaraan sedang disewa atau tidak ditemukan!");
                    }

                    double biayaDasarHarian = durasi * k.getHargaSewaPerHari();
                    double tambahanBiaya = 0;
                    String labelTambahan = "";

                    if (k instanceof Mobil) {
                        Mobil m = (Mobil) k;
                        if (m.getJumlahKursi() > 5) {
                            tambahanBiaya = 50000;
                            labelTambahan = "Tambahan Kursi (>5)  : Rp " + String.format("%,.0f", tambahanBiaya);
                        }
                    } else if (k instanceof Motor) {
                        Motor mot = (Motor) k;
                        if (mot.getJenisTransmisi().equalsIgnoreCase("Matik")) {
                            tambahanBiaya = 10000 * durasi;
                            labelTambahan = "Tambahan Asuransi (Matik): Rp " + String.format("%,.0f", tambahanBiaya);
                        }
                    }

                    double totalSebelumDiskon = biayaDasarHarian + tambahanBiaya;
                    double diskonVip = 0;
                    if (isVip) {
                        diskonVip = 0.10 * totalSebelumDiskon;
                    }

                    double diskonDurasi = 0;
                    if (durasi > 7) {
                        diskonDurasi = 0.05 * totalSebelumDiskon;
                    }

                    double totalBiayaAkhir = totalSebelumDiskon - diskonVip - diskonDurasi;

                    system.sewaKendaraan(kode, durasi);

                    System.out.println("\n===TRANSAKSI SEWA GODRIVE===");
                    System.out.println("Kendaraan Berhasil Disewa!");
                    System.out.println("Unit                 : " + k.getNamaKendaraan() + " (" + k.getKodeKendaraan() + ")");
                    System.out.println("Lama Sewa            : " + durasi + " hari");
                    System.out.println("Biaya Dasar Harian   : Rp " + String.format("%,.0f", biayaDasarHarian));
                    if (!labelTambahan.isEmpty()) {
                        System.out.println(labelTambahan);
                    }
                    if (isVip) {
                        System.out.println("Diskon Member VIP (10%): Rp " + String.format("%,.0f", diskonVip));
                    }
                    if (durasi > 7) {
                        System.out.println("Diskon Durasi >7 Hari (5%): Rp " + String.format("%,.0f", diskonDurasi));
                    }
                    System.out.println("TOTAL BIAYA AKHIR    : Rp " + String.format("%,.0f", totalBiayaAkhir));

                } catch (KendaraanTidakTersediaException e) {
                    System.err.println("Exception in thread \"main\" " + e.getClass().getName() + ": " + e.getMessage());
                    for (StackTraceElement element : e.getStackTrace()) {
                        System.err.println("\tat " + element);
                    }
                }

            } else if (menu == 4) {
                System.out.print("Masukkan kode kendaraan yang ingin dikembalikan: ");
                String kode = scanner.nextLine().trim();
                system.kembalikanKendaraan(kode);

            } else if (menu == 5) {
                System.out.println("Terima kasih telah menggunakan sistem GoDrive Rental!");
                break;
            } else {
                System.out.println("[ERROR] Pilihan menu di luar jangkauan (1-5)!");
            }
        }
        scanner.close();
    }
}