package domain;

public class Araba {

    private String marka;
    private String model;
    private String renk;
    private int hiz;

    public Araba() {
    }

    public Araba(String marka, String model, String renk, int hiz) {
        this.marka = marka;
        this.model = model;
        this.renk = renk;
        this.hiz = hiz;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public int getHiz() {
        return hiz;
    }

    public void setHiz(int hiz) {
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
        System.out.println("Marka : " +marka );
        System.out.println("Model : " +model );
        System.out.println("Renk : " +renk );
        System.out.println("Hız : " +hiz );
    }
}
