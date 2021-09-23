package converter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        input();
    }

    static long convertToDecimal(long base, String nb) {
        String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        long outResult = 0L;
        for (int i = 0; i < nb.length(); i++) {
            char c = nb.toUpperCase().charAt(i);
            int d = digits.indexOf(c);
            outResult = base * outResult + d;
        }
        return outResult;
    }

    static double convertFractionalToDecimal(double base, String nb) {
        String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        double outResult = 0.0;
        for (int i = 0; i < nb.length(); i++) {
            char c = nb.toUpperCase().charAt(i);
            int d = digits.indexOf(c);
            outResult += d * Math.pow(base, -1 * (i + 1));
        }
        return outResult;
    }

    static char reVal(long num) {
        if (num >= 0 && num <= 9)
            return (char) (num + 48);
        else
            return (char) (num - 10 + 65);
    }

    static String fromFractionalDecimal(String base, double inputFrac) {
        String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder outResult = new StringBuilder().append(".");
        int wholePart = 0;
        inputFrac = inputFrac % 1;
        for (int i = 0; i <= 10; i++) {
            wholePart = (int) (inputFrac * Double.parseDouble(base));
            outResult.append(digits.charAt(wholePart));
            inputFrac = (inputFrac * Double.parseDouble(base)) - wholePart;
        }
        return outResult.toString();
    }

    static String fromDecimal(long base1, long inputNum) {
        String s = "";
        StringBuilder outResult = new StringBuilder();
        while (inputNum > 0) {
            s += reVal(inputNum % base1);
            inputNum /= base1;
        }

        outResult.append(s);
        return new String(outResult.reverse());
    }

    static void input() {
        while (true) {
            System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
            String sourceBase = scanner.next();
            if (sourceBase.equalsIgnoreCase("/exit")) break;
            String targetBase = scanner.next();
            int decimalIndx;
            String strFractionalPart = "0";
            while (true) {
                System.out.printf("Enter number in base %s to convert to base %s (To go back type /back) ",
                        sourceBase, targetBase);
                String number = scanner.next();
                if (number.equalsIgnoreCase("/back")) break;
                decimalIndx = number.indexOf('.');
                strFractionalPart = number.substring(decimalIndx + 1, number.length());
                if (decimalIndx > -1) {
                    number = number.substring(0, decimalIndx);
                    String out1 = fromDecimal(Integer.parseInt(targetBase), convertToDecimal(Long.parseLong(sourceBase), number));
                    String out2 = fromFractionalDecimal(targetBase, convertFractionalToDecimal(Double.parseDouble(sourceBase), strFractionalPart));
                    System.out.printf("Conversion result: %s%.6s\n", out1, out2);
                } else {
                    System.out.println("Conversion result: " +
                            fromDecimal(Integer.parseInt(targetBase), convertToDecimal(Long.parseLong(sourceBase), number)));
                }

            }
        }
    }
}