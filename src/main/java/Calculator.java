import java.util.Scanner;

public class Calculator {
    public int sub(int a, int b) {
        return a - b;
    }
    public  int sum(int a,int b){
        return a+b;
    }
    public int mul(int a,int b){
        return a*b;
    }
    public double div(int a, int b){
        return a/b;
    }
    public static boolean isPrimeNumber(double n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
