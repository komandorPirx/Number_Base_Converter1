import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger m = scanner.nextBigInteger();
        BigInteger out = BigInteger.valueOf(1);
        int i = 1;
        while (out.compareTo(m) < 0) {
            out = out.multiply(BigInteger.valueOf(i));
            i++;
        }
        System.out.println(i - 1);
    }
}
