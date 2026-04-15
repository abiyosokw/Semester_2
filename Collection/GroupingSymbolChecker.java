package Semester_2.Collection;

import java.util.*;
import java.io.*;

public class GroupingSymbolChecker {
    public static void main(String[] args) {
        // 1. Cek apakah argumen nama file sudah dimasukkan di command line
        if (args.length != 1) {
            System.out.println("Usage: java GroupingSymbolChecker sourceCodeFile.java");
            System.exit(1);
        }

        File file = new File(args[0]);
        
        // 2. Cek apakah file tersebut benar-benar ada
        if (!file.exists()) {
            System.out.println("File " + args[0] + " tidak ditemukan.");
            System.exit(2);
        }

        try (Scanner input = new Scanner(file)) {
            Stack<Character> stack = new Stack<>();

            while (input.hasNext()) {
                String line = input.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);

                    // Jika simbol buka, masukkan ke stack
                    if (ch == '(' || ch == '{' || ch == '[') {
                        stack.push(ch);
                    } 
                    // Jika simbol tutup, lakukan pengecekan
                    else if (ch == ')' || ch == '}' || ch == ']') {
                        if (stack.isEmpty()) {
                            System.out.println("Salah: Ada simbol tutup tanpa simbol buka.");
                            return;
                        }
                        
                        if (!isPaired(stack.pop(), ch)) {
                            System.out.println("Salah: Simbol tidak cocok atau tumpang tindih.");
                            return;
                        }
                    }
                }
            }

            // Cek apakah masih ada sisa di stack (simbol buka yang tidak ditutup)
            if (stack.isEmpty()) {
                System.out.println("Selamat! Semua simbol pengelompokan sudah benar.");
            } else {
                System.out.println("Salah: Ada simbol buka yang tidak ditutup.");
            }

        } catch (IOException ex) {
            System.out.println("Terjadi kesalahan saat membaca file.");
        }
    }

    // Helper method untuk mengecek kecocokan pasangan
    private static boolean isPaired(char open, char close) {
        if (open == '(' && close == ')') return true;
        if (open == '{' && close == '}') return true;
        if (open == '[' && close == ']') return true;
        return false;
    }
}
