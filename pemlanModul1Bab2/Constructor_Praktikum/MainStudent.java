package pemlanModul1Bab2.Constructor_Praktikum;
import java.util.Scanner;

public class MainStudent {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah siswa yang ingin diinput: ");
        int jumlahSiswa = sc.nextInt();
        sc.nextLine();
        Student[] daftarSiswa = new Student[jumlahSiswa];

        for (int i = 0; i < jumlahSiswa; i++) {
            System.out.println("Masukkan data ke-"+(i+1)+":");
            System.out.print("Nama: "); String nama = sc.nextLine();
            System.out.print("Alamat: "); String alamat = sc.nextLine();
            System.out.print("Umur: "); int umur = sc.nextInt();
            System.out.print("Nilai Matematika: "); int math = sc.nextInt();
            System.out.print("Nilai Bahasa Inggris: "); int english = sc.nextInt();
            System.out.print("Nilai IPA: "); int science = sc.nextInt();
            sc.nextLine();

            daftarSiswa[i] = new Student(nama, alamat, umur);
            daftarSiswa[i].setMath(math);
            daftarSiswa[i].setEnglish(english);
            daftarSiswa[i].setScience(science);
        }

        System.out.println("\n================================");
        Student.jumlahObjek();
        System.out.println("================================");

        System.out.println("\nData Siswa:");
        for (int i = 0; i < daftarSiswa.length; i++) {
            daftarSiswa[i].displayMessage();
            System.out.println();
        }
        sc.close();
    }
}