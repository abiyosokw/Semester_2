package pemlanModulBab10;

import java.io.File;

public class DaftarFile {
    public static void main(String[] args) {
        File folder = new File(".");
        if (folder.isDirectory()) {
            String[] daftarFile = folder.list();
            for (String nama : daftarFile) {
                System.out.println(nama);
            }
        }
    }
}