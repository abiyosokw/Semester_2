package TugasBab12_1;

public class WithException {
    public static void main(String[] args) {
        // Cek apakah argumen yang dimasukkan lengkap (operand1 operator operand2)
        if (args.length != 3) {
            System.out.println("Usage: java Exercise12_01 operand1 operator operand2");
            System.exit(1);
        }

        int result = 0;

        try {
            // Mencoba mengubah string menjadi integer
            int o1 = Integer.parseInt(args[0]);
            int o2 = Integer.parseInt(args[2]);

            // Melakukan operasi berdasarkan operator
            switch (args[1].charAt(0)) {
                case '+': result = o1 + o2; break;
                case '-': result = o1 - o2; break;
                case '.': result = o1 * o2; break;
                case '/': result = o1 / o2; break;
            }

            System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + result);

        } catch (NumberFormatException ex) {
            // Menangkap error jika input bukan angka
            // ex.getMessage() biasanya berisi string yang salah tersebut
            String inputSalah = ex.getMessage().split("\"")[1]; 
            System.out.println("Wrong Input: " + inputSalah);
        }
    }
}