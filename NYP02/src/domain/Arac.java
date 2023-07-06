package domain;

public abstract class Arac {
    private String marka;
    private String model;
    private String renk;

    public Arac() {
    }

    public Arac(String marka, String model, String renk) {
        this.marka = marka;
        this.model = model;
        this.renk = renk;
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


}
