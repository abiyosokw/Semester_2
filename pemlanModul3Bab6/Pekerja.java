package pemlanModul3Bab6;
import java.time.LocalDate;
import java.time.Period;

public class Pekerja extends Manusia {
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;

    public Pekerja(String nama, String nik, boolean jk, boolean menikah, double gaji, LocalDate tahunMasuk, int jumlahAnak) {
        super(nama, nik, jk, menikah);
        this.gaji = gaji;
        this.tahunMasuk = tahunMasuk;
        this.jumlahAnak = jumlahAnak;
    }

    public double getBonus() {
        int lamaBekerja = Period.between(tahunMasuk, LocalDate.now()).getYears();
        if (lamaBekerja <= 5) return 0.05 * gaji;
        if (lamaBekerja <= 10) return 0.10 * gaji;
        return 0.15 * gaji;
    }

    @Override
    public double getTunjangan() {
        return super.getTunjangan() + (jumlahAnak * 20.0);
    }

    @Override
    public double getPendapatan() {
        return gaji + getBonus() + getTunjangan();
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nTahun Masuk   : %s\nJumlah Anak   : %d\nGaji          : $%.1f", 
                tahunMasuk, jumlahAnak, gaji);
    }
    
    // Getter tambahan untuk Manager
    public double getGajiAsli() { return gaji; }
}