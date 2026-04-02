package Semester_2.TugasBab13_11;

// File: Octagon.java
public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
    private double side;

    // Constructor tanpa argumen
    public Octagon() {
        this.side = 0;
    }

    // Constructor dengan argumen
    public Octagon(double side) {
        this.side = side;
    }

    // Getter untuk sisi
    public double getSide() {
        return side;
    }

    // Setter untuk sisi
    public void setSide(double side) {
        this.side = side;
    }

    // Implementasi method getArea() dari GeometricObject
    @Override
    public double getArea() {
        return (2 + 4 / Math.sqrt(2)) * side * side;
    }

    // Implementasi method getPerimeter() dari GeometricObject
    @Override
    public double getPerimeter() {
        return 8 * side;
    }

    // Implementasi method compareTo() dari interface Comparable
    @Override
    public int compareTo(Octagon o) {
        if (this.getArea() > o.getArea()) {
            return 1;
        } else if (this.getArea() < o.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    // Implementasi method clone() dari interface Cloneable
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}