package TugasBab12_1;

public class WithoutException {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Exercise12_01 operand1 operator operand2");
            System.exit(1);
        }

        // Periksa operand pertama
        if (!isNumeric(args[0])) {
            System.out.println("Wrong Input: " + args[0]);
            System.exit(2);
        }

        // Periksa operand kedua
        if (!isNumeric(args[2])) {
            System.out.println("Wrong Input: " + args[2]);
            System.exit(3);
        }

        int o1 = Integer.parseInt(args[0]);
        int o2 = Integer.parseInt(args[2]);
        int result = 0;

        switch (args[1].charAt(0)) {
            case '+': result = o1 + o2; break;
            case '-': result = o1 - o2; break;
            case '.': result = o1 * o2; break;
            case '/': result = o1 / o2; break;
        }

        System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + result);
    }

    /** Method bantuan untuk mengecek apakah string adalah angka */
    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}