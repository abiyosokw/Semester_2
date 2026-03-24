package Semester_2.pemlanModul2Bab5.StaticMethod;

public class Aritmatika {
    public void hitungPenjumlahan(int a,int b){
        int nilai = a+b;
        System.out.println("nilai penjumlahan adalah: "+nilai);
    }
    
    public static void hitungPerkalian(int a, int b){
        int nilai = a*b;
        System.out.println("nilai perkalian adalah: "+nilai);
    }

    public static void hitungPengurangan(int a, int b){
        int nilai = a-b;
        System.out.println("nilai pengurangan adalah: "+nilai);
    }

    public double hitungPembagian(String nil, String nil2){
        int a = Integer.parseInt(nil);
        int b = Integer.parseInt(nil2);
        double nilai = (double) a / b;
        return nilai;
    }
}