package Semester_2.pemlanKuis1.medium;

import java.util.HashMap;
import java.util.Scanner;

abstract class Vehicle {
    protected String kode;
    protected String nama;
    protected int harga;
    protected boolean tersedia;

    public Vehicle(String kode, String nama, int harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.tersedia = true; 
    }

    public abstract String getTipe();
    public abstract int getPotonganPromo();

    public String getStatus() {
        return tersedia ? "TERSEDIA" : "DISEWA";
    }

    public void rent(int hari, boolean isPromo) {
        int total = this.harga * hari;
        
        if (isPromo) {
            total -= getPotonganPromo();
        }
        
        total = Math.max(0, total);
        
        this.tersedia = false;
        System.out.println("Total sewa " + this.kode + ": " + total);
    }

    public void returnVehicle() {
        this.tersedia = true;
        System.out.println(this.kode + " berhasil dikembalikan");
    }

    public void detail() {
        System.out.println(this.kode + " | " + getTipe() + " | " + this.nama + " | harga: " + this.harga + " | status: " + getStatus());
    }
}

class Car extends Vehicle {
    public Car(String kode, String nama, int harga) {
        super(kode, nama, harga);
    }

    @Override
    public String getTipe() {
        return "CAR";
    }

    @Override
    public int getPotonganPromo() {
        return 20000; 
    }
}

class Bike extends Vehicle {
    public Bike(String kode, String nama, int harga) {
        super(kode, nama, harga); 
    }

    @Override
    public String getTipe() {
        return "BIKE";
    }

    @Override
    public int getPotonganPromo() {
        return 10000; 
    }
}

public class siswa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine(); 

        HashMap<String, Vehicle> vehicles = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String command = parts[0];

            switch (command) {
                case "ADD":
                    String tipe = parts[1];
                    String kode = parts[2];
                    String nama = parts[3];
                    int harga = Integer.parseInt(parts[4]);

                    if (vehicles.containsKey(kode)) {
                        System.out.println("Kendaraan sudah terdaftar");
                    } else {
                        if (tipe.equals("CAR")) {
                            vehicles.put(kode, new Car(kode, nama, harga));
                        } else if (tipe.equals("BIKE")) {
                            vehicles.put(kode, new Bike(kode, nama, harga));
                        }
                        System.out.println(tipe + " " + kode + " berhasil ditambahkan");
                    }
                    break;

                case "RENT":
                    String kodeRent = parts[1];
                    int hari = Integer.parseInt(parts[2]);
                    boolean isPromo = (parts.length > 3 && parts[3].equals("PROMO"));

                    if (!vehicles.containsKey(kodeRent)) {
                        System.out.println("Kendaraan tidak ditemukan");
                    } else {
                        Vehicle v = vehicles.get(kodeRent);
                        if (!v.tersedia) {
                            System.out.println("Kendaraan sedang disewa");
                        } else {
                            v.rent(hari, isPromo);
                        }
                    }
                    break;

                case "RETURN":
                    String kodeReturn = parts[1];
                    
                    if (!vehicles.containsKey(kodeReturn)) {
                        System.out.println("Kendaraan tidak ditemukan");
                    } else {
                        Vehicle v = vehicles.get(kodeReturn);
                        if (v.tersedia) {
                            System.out.println("Kendaraan belum disewa");
                        } else {
                            v.returnVehicle();
                        }
                    }
                    break;

                case "DETAIL":
                    String kodeDetail = parts[1];
                    
                    if (!vehicles.containsKey(kodeDetail)) {
                        System.out.println("Kendaraan tidak ditemukan");
                    } else {
                        vehicles.get(kodeDetail).detail();
                    }
                    break;

                case "COUNT":
                    System.out.println("Total kendaraan: " + vehicles.size());
                    break;
            }
        }
        scanner.close();
    }
}