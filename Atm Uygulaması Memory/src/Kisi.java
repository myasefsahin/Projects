public class Kisi {
    private String k_adi;
    private int sifre;
    private int para;

    public Kisi(String k_adi, int sifre, int para) {
        this.k_adi = k_adi;
        this.sifre = sifre;
        this.setPara(para);
    }

    public int getPara() {
        return para;
    }

    public void setPara(int para) {
        this.para = para;
    }

    public String getK_adi() {
        return k_adi;
    }

    public int getSifre() {
        return sifre;
    }
}
