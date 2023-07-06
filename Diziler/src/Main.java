import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] sayilar= new int[5];
        sayilar[0]=1;
        sayilar[1]=2;
        sayilar[2]=3;
        sayilar[3]=4;
        sayilar[4]=5;
        System.out.println(sayilar[4]);

        String[] renkler={"Mavi","Beyaz","Siyah"};
        System.out.println("Dizinin birinci elemanı: " + renkler[0]);
        System.out.println("Dizinin ikinci elemanı: " + renkler[1]);
        System.out.println("Dizinin üçüncü elemanı: " + renkler[2]);

        int sayilarBoyut=sayilar.length;
        System.out.println(sayilarBoyut);

        int renklerBoyut=renkler.length;
        System.out.println(renklerBoyut);
        sayilar[4]=6;
        renkler[2]="Sarı";
        System.out.println(sayilar[4]);

        System.out.println(renkler[2]);

        System.out.println("sayilar 'i 2 ile çarp");
        for (int i=0;i<sayilar.length;i++)
        {
            sayilar[i]=sayilar[i]*2;
            System.out.println(sayilar[i]);
        }

        System.out.println("Güncellenmiş renkler");

        for (String renk:renkler) {
            System.out.println(renk);
        }

        List<Integer> sayilar2= new ArrayList<>();

        sayilar2.add(1);
        sayilar2.add(2);
        sayilar2.add(3);
        sayilar2.add(4);
        sayilar2.add(5);
        //Out of bounds
       // sayilar[6]=7;
        sayilar2.add(7);
        sayilar2.add(8);

        for (int k:sayilar2) {
            System.out.println(k);
        }

        List<String> renkler2= new ArrayList<>();

        renkler2.add("Mavi");
        renkler2.add("Beyaz");
        renkler2.add("Siyah");
        renkler2.add("Sarı");

        int size=renkler2.size();
        System.out.println("Renkler2 Size : "+size);

        for(String r:renkler2)
        {
            System.out.println(r);
        }

    }
}