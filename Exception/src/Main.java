public class Main {
    public static void main(String[] args) {

        try {
            int result = divede(10, 5);
            System.out.println(result);
        }catch (ArithmeticException e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("---Finally block executed---");
        }

    }

    public static int divede(int devident,int divisor)
    {
        return  devident/divisor;
    }
}