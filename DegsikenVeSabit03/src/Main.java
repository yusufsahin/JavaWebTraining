public class Main {
    public static void main(String[] args) {

        int sayi=10;
        byte b1=-128;
        byte b2=127;

        short s1=-129;
        short s2= 128;

        short s3= -32768;
        short s4= 32767;


        int i1= -2147483648;
        int i2=2147483647;

        long l1 =9223372036854775807L;
        long l2 =-9223372036854775808L;

        float f1= 67.05F;
        double d1= 56677.7888888;

        final String mesaj="Merhaba dünya!";
        String isim="John";

        final float PI_SAYISI= 3.14F;
        final double E_SAYISI= 2.17;

        //Hata verir
        //short s5= 32768;
        //Hata verir
        //byte b3= -256;
        // byte b4= 130;

        boolean isValid=false;




        System.out.println(sayi);
        System.out.println(b1);
        System.out.println(b2);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(f1);
        System.out.println(d1);

        System.out.println(mesaj);
        System.out.println(PI_SAYISI);
        System.out.println(E_SAYISI);
        //Hat verir - Sabit değeri atandıktan sonra değiştirilemez
        //PI_SAYISI=3.148;

        System.out.println(mesaj+","+isim);
        //Hata verir
        // mesaj="Merhaba";
        System.out.println(isValid);

        //Tekrar atama yapıldı
        isim="Jane";

        System.out.println(mesaj+","+isim);

        final  String mesaj_isim=mesaj+","+isim;
        System.out.println(mesaj_isim);


        //System.out.println("Hello world!");
    }
}