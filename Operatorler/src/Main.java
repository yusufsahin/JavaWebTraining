import java.io.FilterOutputStream;

public class Main {
    public static void main(String[] args) {
        /*
        Çoklu Açıklama Satırı
        */
        //Aritmetik Opreratörler
        int a= 10;
        int b=5;
        int toplam= a+b;
        System.out.println("Toplam= "+toplam);
        int fark = a-b;
        System.out.println("Fark= "+fark);
        int carpim= a*b;
        System.out.println("Çarpım= "+carpim);
        int bolum= a/b;
        System.out.println("Bölüm= "+bolum);
        int kalan= a%b;
        System.out.println("Mod= "+kalan);
        a=a+1;
        System.out.println(a);
        b= b-1;
        System.out.println(b);

        //Atama Operatörleri
        System.out.println("Atama Operatörleri");
        int x= 5;
        System.out.println(x);
        x+=3;  //x=x+3;
        System.out.println(x);
        x-=2; //x=x-2;
        System.out.println(x);
        x*=4; //x=x*4;
        System.out.println(x);
        x/=3; // x=x/3;
        System.out.println(x);
        x%=5; //x=x%5;
        System.out.println(x);

        //Karşılaştırma Operatörleri
        System.out.println("Karşılaştırma Operatörleri");
        int k= 10;
        int l= 5;
        boolean esitMi = (k==l);
        System.out.println("Eşit mi? "+esitMi);
        boolean esitDegilMi= (k!=l);
        System.out.println("Eşit Değil mi? "+esitDegilMi);
        boolean buyukMu= (k>l);
        System.out.println("Büyük mü? "+buyukMu);
        boolean kucukMu=(k<l);
        System.out.println("Küçük mü?" + kucukMu);
        boolean buyukEsitMi= (k>=l);
        System.out.println("Büyük Eşit mi? "+buyukEsitMi);
        boolean kucukEsitMi=(k<=l);
        System.out.println("Küçük Eşit mi?" + kucukEsitMi);

        //Mantıksal Operatörler
        System.out.println("Mantıksal Operatörler");
        boolean durum1= true;
        System.out.println("durum1 : "+durum1);
        boolean durum2= false;
        System.out.println("durum2 : "+durum2);
        //VE
        boolean sonuc1= durum1 && durum2;
        System.out.println("VE kapısı(AND Gate) : " +sonuc1);
        //VEYA
        boolean sonuc2= durum1 || durum2;
        System.out.println("VEYA kapısı(OR Gate) : "+sonuc2);
        //DEĞİL
        boolean sonuc3= !sonuc2;
        System.out.println("DEĞİL kapısı(NOT Gate) :"+sonuc3);

    }
}