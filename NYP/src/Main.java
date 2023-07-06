import domain.Araba;

public class Main {
    public static void main(String[] args) {

        Araba araba1 = new Araba();
        araba1.setMarka("Toyata");
        araba1.setModel("Coralla");
        araba1.setRenk("Beyaz");
        araba1.setHiz(100);

        System.out.println("araba1");
        System.out.println(araba1.getMarka()+" "+ araba1.getModel()+" "+araba1.getRenk()+" "+araba1.getHiz());

        Araba araba2= new Araba("BMW","320","Mavi",120);

        System.out.println("araba2");
        System.out.println(araba2.getMarka()+" "+ araba2.getModel()+" "+araba2.getRenk()+" "+araba2.getHiz());

        araba2.setHiz(110);
        System.out.println("araba2 hız değişti");
        System.out.println(araba2.getMarka()+" "+ araba2.getModel()+" "+araba2.getRenk()+" "+araba2.getHiz());

        araba2.hizlan(30);
        araba2.bilgileriGoster();

        araba2.yavasla(50);

        araba2.bilgileriGoster();

        araba2.dur();

        araba2.bilgileriGoster();

    }
}