package pemlanModulBab10;

import java.io.File;

public class HapusDirektori {
    public static void main(String[] args) {
        File folder = new File("test_folder");

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File f : files) {
                    f.delete();
                }
            }
            if (folder.delete()) {
                System.out.println("Direktori berhasil dihapus");
            }
        } else {
            System.out.println("Folder tidak ditemukan di: " + folder.getAbsolutePath());
        }
    }
}