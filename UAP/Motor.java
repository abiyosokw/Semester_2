package UAP;

public class Motor extends Kendaraan {
    private String jenisTransmisi;

    public Motor(String kode, String nama, double harga, String jenisTransmisi) {
        super(kode, nama, harga);
        this.jenisTransmisi = jenisTransmisi;
    }

    public String getJenisTransmisi() { return jenisTransmisi; }
    public void setJenisTransmisi(String jenisTransmisi) { this.jenisTransmisi = jenisTransmisi; }

    @Override
    public void tampilInfo() {
        System.out.printf("Kode: %-6s | Nama: %-18s | Transmisi: %-6s | Tarif: Rp%,.0f/hari | Status: %s%n",
                getKodeKendaraan(), getNamaKendaraan(), jenisTransmisi, getHargaSewaPerHari(),
                (isTersedia() ? "Tersedia" : "Tidak Tersedia"));
    }

    @Override
    public double hitungBiayaDasar(int lamaSewa) {
        double total = lamaSewa * getHargaSewaPerHari();
        if (jenisTransmisi != null && jenisTransmisi.equalsIgnoreCase("Matik")) {
            total += 10000 * lamaSewa;
        }
        return total;
    }
}