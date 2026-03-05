package Semester_2.Inheritance;
import java.util.Scanner;

public class MainGeometricObject {
public static void main (String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Masukkan tiga sisi segitiga: " );
        double s1 = sc.nextDouble();
        double s2 = sc.nextDouble();
        double s3 = sc.nextDouble();

    Triangle t1 = new Triangle(s1, s2, s3);

    System.out.println("Masukkan warna segitiga: " );
    String color = sc.next();
        t1.setColor(color);

    System.out.println("Apakah segitiga terisi? (true/false): " );
    boolean filled = sc.nextBoolean();
        t1.setFilled(filled);
    sc.close();

    System.out.println("--- Hasil ---");
    System.out.println(t1.toString());
    System.out.println("Luas: " + t1.getArea());
    System.out.println("Keliling: " + t1.getPerimeter());
    System.out.println("Warna: " + t1.getColor());
    System.out.println("Terisi: " + t1.isFilled());
    }
}

/*
========================================================
Bagian  |   GeometricObject (Ibu)  |   Triangle (Anak) |
========================================================
Variabel|  - color: String,        |   - side1: double |
        |  - filled: boolean       |   - side2: double |
        |                          |   - side3: double |
========================================================
Method  |   + getColor()           |   + Triangle()    |
        |   + setColor()           |   + getArea()     |
        |   + isFilled()           |   + getPerimeter()|
        |   + setFilled()          |   + toString()    |
========================================================
*/
