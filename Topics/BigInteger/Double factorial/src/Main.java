import java.math.BigInteger;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {
        return n < 2
                ? BigInteger.ONE
                : BigInteger.valueOf(n).multiply(calcDoubleFactorial(n - 2));
    }
}
