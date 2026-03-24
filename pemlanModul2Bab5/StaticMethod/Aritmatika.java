package Semester_2.pemlanModul2Bab5.StaticMethod;

public class Aritmatika {
    public void hitungPenjumlahan(int a,int b){
        int nilai = a+b;
        System.out.println("nilai penjumlahan adalah: "+nilai);
    }
    
    public static void hitungPerkalian(int a, int b){
        int nilai = a*b;
        System.out.println("nilai perkalian adalah: "+nilai);

        Aritmatika obj = new Aritmatika();
        obj.hitungPenjumlahan(a, b); 
    }

    public static void hitungPengurangan(int a, int b){
        int nilai = a-b;
        System.out.println("nilai pengurangan adalah: "+nilai);
    }
}