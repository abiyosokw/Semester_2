package pemlanModul3Bab6;

import java.time.LocalDate;

public class Manager extends Pekerja {
    private String departemen;

    public Manager(String nama, String nik, boolean jk, boolean menikah, double gaji, LocalDate tahunMasuk, int jumlahAnak, String departemen) {
        super(nama, nik, jk, menikah, gaji, tahunMasuk, jumlahAnak);
        this.departemen = departemen;
    }

    @Override
    public double getTunjangan() {
        // Tunjangan Manager = Tunjangan Pekerja + 10% Gaji
        return super.getTunjangan() + (0.10 * getGajiAsli());
    }

    @Override
    public String toString() {
        return super.toString() + "\nDepartemen    : " + departemen;
    }
}