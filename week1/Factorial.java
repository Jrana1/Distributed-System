import java.math.BigInteger;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(BigInteger.valueOf(20)));
    }
    private  static BigInteger factorial(BigInteger n ){
        if(n==BigInteger.ZERO) return BigInteger.ONE;
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
}
