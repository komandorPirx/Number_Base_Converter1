import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal inBig = scanner.nextBigDecimal();
        int newScale = scanner.nextInt();

        System.out.println(inBig.setScale(newScale, RoundingMode.HALF_DOWN));
    }   
}