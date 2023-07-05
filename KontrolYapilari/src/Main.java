import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Bir sayi giriniz");
        int input=scanner.nextInt();
        System.out.println("Girdiğiniz sayi : "+ input);
        //if
        if(input>0){
            System.out.println("Sayı Pozitif");
        }else
        {
            System.out.println("Sayi Negatif");
        }

        System.out.println("Hafta günü için bir sayi giriniz");
        int gun= scanner.nextInt();
        //Switch Case
        switch (gun)
        {
            case 1:
                System.out.println("Pazartesi");
                break;
            case 2:
                System.out.println("Salı");
                break;
            case 3:
                System.out.println("Çarşamba");
                break;
            case 4:
                System.out.println("Perşembe");
                break;
            case 5:
                System.out.println("Cuma");
                break;
            case 6:
                System.out.println("Cumartesi");
                break;
            case 7:
                System.out.println("Pazar");
                break;
            default:
                System.out.println("Geçersiz Gün");
        }
        System.out.println("2 'de 20 kadar 2 er 2 er saydıralım");
        for (int i=0;i<=20;i+=2){
            System.out.println("i = "+i);
        }

        System.out.println("While Döngüsü için bir sayı giriniz");

        int sayi= scanner.nextInt();

        while (sayi<=5)
        {
            System.out.println("Sayı : "+sayi);
            sayi++;
        }

        System.out.println("Do - While döngüsü için bie sayı giriniz");

        int sayi2= scanner.nextInt();
        do {
            System.out.println("Sayı : "+sayi2);
            sayi2++;

            System.out.println(sayi2);
        }while (sayi2<5);
    }
}