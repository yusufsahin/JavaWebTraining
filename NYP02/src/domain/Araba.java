package domain;


///Java da sadece 1 sınıftan extend edebilirsiniz ,biden çok implementasyon yapabilirsiniz
public class Araba extends Arac implements SurusKontrol,LastikKontrol {
    private  int hiz;

    public Araba(String marka, String model, String renk, int hiz) {
        super(marka, model, renk);
        this.hiz = hiz;
    }
    public void  hizlan(int hizArtisi)
    {
        this.hiz+=hizArtisi;
    }

    public void yavasla(int hizAzaltma)
    {
        this.hiz-=hizAzaltma;
    }

    public void dur()
    {
        this.hiz=0;
    }

    public void  bilgileriGoster()
    {
        System.out.println("Marka : " +this.getMarka());
        System.out.println("Model : " +this.getModel() );
        System.out.println("Renk : " +this.getRenk() );

        System.out.println("Hız : " +hiz );
    }

    @Override
    public void YorgunlukAlgi() {
        System.out.println("Yorgunluk Aldı Kontrol Ediliyor...");
    }

    @Override
    public void LastikHavaBasinci() {
        System.out.println("Lastik Hava Basıncı Kontrol Ediliyor...");
    }
}
