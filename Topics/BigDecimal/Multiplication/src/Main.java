import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in1Str = scanner.next();
        String in2Str = scanner.next();
        BigDecimal out = new BigDecimal(in1Str).multiply(new BigDecimal(in2Str));
        System.out.println(out);
    }
}
