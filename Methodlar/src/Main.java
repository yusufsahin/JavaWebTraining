public class Main {
    public static void main(String[] args) {
        String isim="John Doe";
        System.out.println("Hello world! , "+isim);

        System.out.println("Selamla Methodu - void ve parametresiz");
        selamla();

        System.out.println("Selamla Methodu - void ve parametreli");
        selamla("Jane Doe");


        System.out.println("Dönüş değerli Method");
        String mesaj= selam();
        System.out.println(mesaj);

        System.out.println(selam("Frank Doe"));

        System.out.println(Topla(5,3));

        System.out.println(Carp(2,7));
    }
    public static void  selamla()
    {
        System.out.println("Hello World!");
    }
    public static void  selamla(String isim)
    {
        System.out.println("Hello World! , "+isim);
    }

    public static String selam()
    {
        return "Hello World! - return";
    }

    public  static String selam(String isim)
    {
        String msg= "Hello World! , "+isim;
        return  msg;
    }

    public  static  int Topla(int a,int b)
    {
        return  a+b;
    }
    public static int Carp(int a,int b)
    {
        return  a*b;
    }
}