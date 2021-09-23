import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal moneyAmount = scanner.nextBigDecimal();
        BigDecimal yearPercent = scanner.nextBigDecimal();
        int years = scanner.nextInt();
        BigDecimal finalAmount = moneyAmount.multiply(BigDecimal.ONE.
            add(yearPercent.divide(new BigDecimal("100"))).pow(years));
        System.out.println("Amount of money in the account: " + finalAmount.setScale(2, RoundingMode.CEILING));
    }
}
