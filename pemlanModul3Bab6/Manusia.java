package Semester_2.pemlanModul3Bab6;

public class Manusia {
    private String nama;
    private String nik;
    private Boolean jenisKelamin; //true = laki-laki, false = perempuan
    private Boolean menikah; //true = sudah menikah, false = belum menikah
    
    public Manusia(String nama, String nik, Boolean jenisKelamin, Boolean menikah){
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.nik = nik;
        this.menikah = menikah;
    }

    public void setNama(String nama) { this.nama = nama;}
    public String getNama() { return nama; }
    public void setJenisKelamin(Boolean jenisKelamin) { this.jenisKelamin = jenisKelamin;}
    public Boolean isJenisKelamin() { return jenisKelamin; }
    public void setNik(String nik) { this.nik = nik;}
    public String getNik() { return nik; }
    public void setMenikah(Boolean menikah) { this.menikah = menikah;}
    public Boolean isMenikah() { return menikah; }

    public double getTunjangan(){
        if (menikah) {
            return jenisKelamin ? 25.0 : 20.0;
        } else {
            return 15.0;
        }
    }

    public double getPendapatan(){
        return getTunjangan();
    }

    public String toString(){
        String jk = jenisKelamin ? "Laki-laki" : "Perempuan";
        return String.format("Nama          : %s\nNIK           : %s\nJenis Kelamin : %s\nPendapatan    : $%.1f", nama, nik, jk, getPendapatan());
    }
}