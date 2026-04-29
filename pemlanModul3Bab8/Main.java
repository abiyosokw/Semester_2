package pemlanModul3Bab8;

interface Colorable {
    public void howToColor();
}  

interface Comparable {
    public void compareTo(Object obj);
}

class Rectangle implements Colorable, Comparable { // class rectanggle
    private String warna;
    private int kategori;

    public Rectangle() {
    }

    public Rectangle(String warna) {
        this.warna = warna;
    }

    public void howToColor() {
        if(this.warna == null){
        System.out.println("tidak ada warna, warna bangun kotak masih polos");
        } else {
        System.out.println("bangun kotak sudah diwarnai dengan warna "+this.warna);
        }
    }

    public void compareTo(Object obj) {
        if (obj instanceof Integer) {
            this.kategori = (Integer) obj;
            if (this.kategori == 0) {
                System.out.println("ukuran cat yang cocok untuk bangun kotak dengan ukuran kategori " + this.kategori + " yaitu 2.5L");
            } else {
                System.out.println("ukuran cat yang cocok untuk bangun kotak dengan ukuran kategori " + this.kategori + " yaitu 6.5L");
            }
        }
    }

    public class Main {
        public static void main(String[] args) {
            Rectangle kotak1 = new Rectangle("merah");
            Rectangle kotak2= new Rectangle();
            Rectangle kotak3 = new Rectangle();
            kotak1.howToColor();
            kotak2.howToColor();
            kotak3.compareTo(4);
        }
    }
}