package Semester_2.pemlanKuis1.easy;

import java.util.HashMap;
import java.util.Scanner;

abstract class Student {
    protected String nama;
    protected int saldo;

    public Student(String nama) {
        this.nama = nama;
        this.saldo = 0;
    }

    public abstract String getTipe();

    public void save(int jumlah) {
        this.saldo += jumlah;
        System.out.println("Saldo " + this.nama + ": " + this.saldo);
    }

    public abstract boolean canTake(int jumlah);

    public abstract void take(int jumlah);

    public void check() {
        System.out.println(this.nama + " | " + getTipe() + " | saldo: " + this.saldo);
    }
}

class Reguler extends Student {
    public Reguler(String nama) {
        super(nama);
    }

    @Override
    public String getTipe() {
        return "REGULER";
    }

    @Override
    public boolean canTake(int jumlah) {
        return this.saldo >= jumlah; 
    }

    @Override
    public void take(int jumlah) {
        this.saldo -= jumlah;
        System.out.println("Saldo " + this.nama + ": " + this.saldo);
    }
}

class Beasiswa extends Student {
    public Beasiswa(String nama) {
        super(nama);
    }

    @Override
    public String getTipe() {
        return "BEASISWA";
    }

    @Override
    public boolean canTake(int jumlah) {
        int jumlahDiambil = Math.max(0, jumlah - 1000); 
        return this.saldo >= jumlahDiambil;
    }

    @Override
    public void take(int jumlah) {
        int jumlahDiambil = Math.max(0, jumlah - 1000); 
        this.saldo -= jumlahDiambil;
        System.out.println("Saldo " + this.nama + ": " + this.saldo);
    }
}

// Main Class
public class tabungan{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine();
        
        HashMap<String, Student> accounts = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String command = parts[0];

            switch (command) {
                case "CREATE":
                    String tipe = parts[1];
                    String namaCreate = parts[2];
                    
                    if (accounts.containsKey(namaCreate)) {
                        System.out.println("Akun sudah terdaftar");
                    } else {
                        if (tipe.equals("REGULER")) {
                            accounts.put(namaCreate, new Reguler(namaCreate));
                        } else if (tipe.equals("BEASISWA")) {
                            accounts.put(namaCreate, new Beasiswa(namaCreate));
                        }
                        System.out.println(tipe + " " + namaCreate + " berhasil dibuat");
                    }
                    break;

                case "SAVE":
                    String namaSave = parts[1];
                    int jumlahSave = Integer.parseInt(parts[2]);
                    
                    if (!accounts.containsKey(namaSave)) {
                        System.out.println("Akun tidak ditemukan");
                    } else {
                        accounts.get(namaSave).save(jumlahSave);
                    }
                    break;

                case "TAKE":
                    String namaTake = parts[1];
                    int jumlahTake = Integer.parseInt(parts[2]);
                    
                    if (!accounts.containsKey(namaTake)) {
                        System.out.println("Akun tidak ditemukan");
                    } else {
                        Student s = accounts.get(namaTake);
                        if (!s.canTake(jumlahTake)) {
                            System.out.println("Saldo " + namaTake + " tidak cukup");
                        } else {
                            s.take(jumlahTake);
                        }
                    }
                    break;

                case "CHECK":
                    String namaCheck = parts[1];
                    if (!accounts.containsKey(namaCheck)) {
                        System.out.println("Akun tidak ditemukan");
                    } else {
                        accounts.get(namaCheck).check();
                    }
                    break;
            }
        }
        scanner.close();
    }
}