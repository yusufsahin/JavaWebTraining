import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> calisanListesi= new ArrayList<>();
        Person p1= new Person("John",30);
        Person p2 = new Person("Jane" ,25);
        Person p3= new Person("Frank",27);
        Person p4= new Person("Bill",33);
        Person p5= new Person("David",35);
        calisanListesi.add(p1);
        calisanListesi.add(p2);
        calisanListesi.add(p3);
        calisanListesi.add(p4);
        calisanListesi.add(p5);
        for (Person p: calisanListesi) {
            System.out.println("Name : " +p.getName()+", Age : "+p.getAge());
        }
        System.out.println("p1 Yaş güncelleme");
        p1.setAge(40);
        for (Person p: calisanListesi) {
            System.out.println("Name : " +p.getName()+", Age : "+p.getAge());
        }
    }
}