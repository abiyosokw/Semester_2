import java.util.*;

abstract class Member {
    private String id;    
    private String nama;  
    private int saldo;

    public Member(String id, String nama) {
        this.id = id;
        this.nama = nama;
        this.saldo = 0;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getSaldo() {
        return saldo;
    }

    public String getInfo() {
        String tipe = this.getClass().getSimpleName().toUpperCase();
        return id + " | " + nama + " | " + tipe + " | saldo: " + saldo;
    }

    public abstract int hitungPembayaran(int hargaDasar, int sesi);

    public int buy(int totalBayar) {
        if (this.saldo >= totalBayar) {
            this.saldo -= totalBayar;
            return 1; 
        }
        return 0;
    }

    public void topUp(int jumlah) {
        this.saldo += jumlah;
    }
}

class Reguler extends Member {
    public Reguler(String id, String nama) {
        super(id, nama); 
    }

    @Override
    public int hitungPembayaran(int hargaDasar, int sesi) {
        int subtotal = hargaDasar;
        if (sesi > 5) {
            subtotal -= (int) (hargaDasar * 0.1); 
        }
        int pajak = (int) (subtotal * 0.05); 
        return subtotal + pajak;
    }
}

class VIP extends Member {
    public VIP(String id, String nama) {
        super(id, nama); 
    }

    @Override
    public int hitungPembayaran(int hargaDasar, int sesi) {
        int subtotal = hargaDasar;
        if (sesi > 5) {
            subtotal -= (int) (hargaDasar * 0.1);
        }
        subtotal -= (int) (hargaDasar * 0.15);
        
        int pajak = (int) (subtotal * 0.05); 
        int total = subtotal + pajak;
        return Math.max(0, total); 
    }
}

public class GymSystem {
    private List<Member> members = new ArrayList<>(); 

    private Member findMember(String id) {
        for (Member m : members) {
            if (m.getId().equals(id)) return m;
        }
        return null;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] p = line.split(" ");
            String command = p[0];

            switch (command) {
                case "ADD":
                    String tipe = p[1];
                    String id = p[2];
                    String nama = p[3];
                    if (findMember(id) != null) {
                        System.out.println("Member sudah terdaftar"); 
                    } else {
                        if (tipe.equals("REGULER")) members.add(new Reguler(id, nama));
                        else members.add(new VIP(id, nama));
                        System.out.println(tipe + " " + id + " berhasil ditambahkan"); 
                    }
                    break;

                case "TOPUP":
                    Member mTop = findMember(p[1]);
                    if (mTop == null) System.out.println("Member tidak ditemukan"); 
                    else {
                        mTop.topUp(Integer.parseInt(p[2]));
                        System.out.println("Saldo " + mTop.getId() + ": " + mTop.getSaldo()); 
                    }
                    break;

                case "BUY":
                    processBuy(p[1], p[2], Integer.parseInt(p[3]));
                    break;

                case "CHECK":
                    Member mCheck = findMember(p[1]);
                    if (mCheck == null) System.out.println("Member tidak ditemukan"); 
                    else System.out.println(mCheck.getInfo());
                    break;

                case "COUNT":
                    System.out.println("Total member: " + members.size());
                    break;
            }
        }
        sc.close();
    }

    private void processBuy(String id, String layanan, int sesi) {
        Member m = findMember(id);
        if (m == null) {
            System.out.println("Member tidak ditemukan"); 
            return;
        }

        int harga;
        if (layanan.equals("cardio")) harga = 20000; 
        else if (layanan.equals("yoga")) harga = 25000; 
        else if (layanan.equals("personal_training")) harga = 40000; 
        else {
            System.out.println("Layanan tidak valid"); 
            return;
        }

        int hargaDasar = harga * sesi;
        int totalBayar = m.hitungPembayaran(hargaDasar, sesi);

        if (m.getSaldo() < totalBayar) {
            System.out.println("Saldo " + m.getId() + " tidak cukup"); 
        } else {
            m.buy(totalBayar);
            System.out.println("Total bayar " + m.getId() + ": " + totalBayar);
            System.out.println("Saldo " + m.getId() + ": " + m.getSaldo());
        }
    }

    public static void main(String[] args) {
        new GymSystem().run();
    }
}