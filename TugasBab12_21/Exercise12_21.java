import java.io.File;
import java.util.Scanner;

public class Exercise12_21  {
    public static void main(String[] args) throws Exception {
        File file = new File("SortedStrings.txt");
        Scanner input = new Scanner(file);

        if (input.hasNext()) {
            String str1 = input.next();
            boolean isSorted = true;

            while (input.hasNext()) {
                String str2 = input.next();

                if (str2.compareTo(str1) < 0) {
                    System.out.println("String di dalam file tidak berurutan.");
                    System.out.println("Dua string yang out of order: " + str1 + " dan " + str2);
                    isSorted = false;
                    break;
                }
                
                // geser perbandingan ke kata berikutnya
                str1 = str2; 
            }

            if (isSorted) {
                System.out.println("Semua string di dalam file sudah berurutan menaik.");
            }
        } else {
            System.out.println("File kosong.");
        }

        input.close();
    }
}