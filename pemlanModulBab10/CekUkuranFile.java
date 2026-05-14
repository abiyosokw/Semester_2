package pemlanModulBab10;

import java.io.File;

public class CekUkuranFile {
    public static void main(String[] args) {
        File file = new File("./pemlanModulBab10/test.txt");
        if (file.exists()) {
            long bytes = file.length();
            double kilobytes = bytes / 1024.0;
            double megabytes = kilobytes / 1024.0;

            if (megabytes < 1) {
                System.out.printf("Ukuran file: %.2f KB\n", kilobytes);
            } else {
                System.out.printf("Ukuran file: %.2f MB\n", megabytes);
            }
        }
    }
}