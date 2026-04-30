package pemlanModul3Bab8;

interface Colorable {
    void howToColor();
}

interface Comparable {
    void compareTo(Object obj);
}

public class Rectangle implements Colorable, Comparable {
    private String warna;
    private int kategori;

    public Rectangle() {
    }

    public Rectangle(String warna) {
        this.warna = warna;
    }

    @Override
    public void howToColor() {
        if (this.warna == null) {
            System.out.println("tidak ada warna, warna bangun kotak masih polos");
        } else {
            System.out.println("bangun kotak sudah diwarnai dengan warna " + this.warna);
        }
    }

    @Override
    public void compareTo(Object obj) {
        this.kategori = (int) obj;
        if (this.kategori == 0) {
            System.out.println("ukuran cat yang cocok untuk bangun kotak dengan kategori " + this.kategori + " yaitu 2.5L");
        } else {
            System.out.println("ukuran cat yang cocok untuk bangun kotak dengan kategori " + this.kategori + " yaitu 6.5L");
        }
    }

    public static void main(String[] args) {
        Rectangle kotak1 = new Rectangle("merah");
        Rectangle kotak2 = new Rectangle();
        Rectangle kotak3 = new Rectangle();

        kotak1.howToColor();
        kotak2.howToColor();
        kotak3.compareTo(4);
    }
}