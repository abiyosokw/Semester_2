package UAP;
import java.util.ArrayList;

public class GoDriveRentalSystem {
    private ArrayList<Kendaraan> daftarKendaraan;

    public GoDriveRentalSystem() {
        this.daftarKendaraan = new ArrayList<>();
    }

    public void tambahKendaraan(Kendaraan k) {
        daftarKendaraan.add(k);
        System.out.println("[INFO] Kendaraan berhasil ditambahkan: " + k.getNamaKendaraan() + " (" + k.getKodeKendaraan() + ")");
    }

    public void tambahKendaraanAwal(Kendaraan k) {
        daftarKendaraan.add(k);
    }

    public void tampilkanDaftarKendaraan() {
        System.out.println("====== DAFTAR ARMADA GODRIVE ======");
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Belum ada kendaraan di dalam sistem.");
            return;
        }
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            Kendaraan k = daftarKendaraan.get(i);
            String jenis = (k instanceof Mobil) ? "[MOBIL]" : "[MOTOR]";
            System.out.print((i + 1) + ". " + jenis + " ");
            k.tampilInfo();
        }
    }

    public Kendaraan cariKendaraan(String kode) {
        for (Kendaraan k : daftarKendaraan) {
            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        return null;
    }

    public void sewaKendaraan(String kode, int lamaSewa) throws KendaraanTidakTersediaException {
        Kendaraan k = cariKendaraan(kode);
        if (k == null || !k.isTersedia()) {
            throw new KendaraanTidakTersediaException("Kendaraan dengan kode " + kode + " gagal disewa. Alasan: Kendaraan sedang disewa atau tidak ditemukan!");
        }
        k.setTersedia(false);
    }

    public void kembalikanKendaraan(String kode) {
        Kendaraan k = cariKendaraan(kode);
        if (k != null && !k.isTersedia()) {
            k.setTersedia(true);
            System.out.println("[INFO] Kendaraan " + k.getNamaKendaraan() + " (" + k.getKodeKendaraan() + ") berhasil dikembalikan. Status: Tersedia.");
        } else if (k != null && k.isTersedia()) {
            System.out.println("[INFO] Kendaraan dengan kode " + kode + " sudah berada dalam status Tersedia.");
        } else {
            System.out.println("[ERROR] Kendaraan dengan kode " + kode + " tidak ditemukan dalam sistem.");
        }
    }
}