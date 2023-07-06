import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter the dividend");
        int dividend= scanner.nextInt();
        System.out.println("Enter the divisor");
        int divisor= scanner.nextInt();
        try {
            int result=divide(dividend,divisor);
            System.out.println("Result : " +result);
        }
        catch (ArithmeticException e)
        {
            System.out.println("An error occured : "+e.getMessage());
        }
    }
    public static  int divide(int dividend,int divisor) throws ArithmeticException{
        if(divisor==0)
        {
            throw  new ArithmeticException("Divisor connot be zero");
        }
        return dividend/divisor;
    }
}