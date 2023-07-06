import domain.Araba;
import domain.Motosiklet;

public class Main {
    public static void main(String[] args) {

        System.out.println("Araba 1");

        Araba araba1= new Araba("Mercedes","C190","Siyah",200);

        araba1.yavasla(90);

        araba1.bilgileriGoster();

        araba1.YorgunlukAlgi();;

        araba1.LastikHavaBasinci();

        Motosiklet motosiklet1= new Motosiklet("BMW","R60","Gece Mavisi",70);

        motosiklet1.bilgileriGoster();
        motosiklet1.hizlan(10);
        motosiklet1.bilgileriGoster();
        motosiklet1.LastikHavaBasinci();
    }
}