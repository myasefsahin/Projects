import java.util.Scanner;
public class Islem {
    Kisi kisi1 = new Kisi("kullanıcıadi",sifre,bakiye);
    Kisi kisi2 = new Kisi("kullanıiciadi",sifre,bakiye);
    Kisi kisi3 = new Kisi("kullaniciadi",sifre,bakiye);



    String tempKAdi;
    int tempSifre;

    public Islem() {
        giris();
    }

    public void giris() {
        Scanner in = new Scanner(System.in);
        System.out.print("Lütfen k adi giriniz:");
        tempKAdi = in.nextLine();

        if (tempKAdi.equals(kisi1.getK_adi())) {
            System.out.print("Şifre giriniz:");
            tempSifre = in.nextInt();
            while (!(tempSifre == kisi1.getSifre())) {
                System.err.println("HATALI ŞİFRE TEKRAR GİRİNİZ:");
                tempSifre = in.nextInt();
            }
            System.out.println("HOŞ GELDİNİZ " + kisi1.getK_adi());
            System.out.println("----------------------");
            System.out.println("Yapmak istediğiniz işlemi seçiniz.");
            System.out.println("'Y' para yatırma");
            System.out.println("'C' para çekme");
            System.out.println("'G' bakiye gösterme");
            System.out.println("'Q' çıkış yapma");
            islemFonk(kisi1);
        }
        if (tempKAdi.equals(kisi2.getK_adi())){
            System.out.print("Şifre giriniz:");
            tempSifre = in.nextInt();
            while (!(tempSifre == kisi2.getSifre())) {
                System.err.println("HATALI ŞİFRE TEKRAR GİRİNİZ:");
                tempSifre = in.nextInt();
            }
            System.out.println("HOŞ GELDİNİZ " + kisi2.getK_adi());
            System.out.println("----------------------");
            System.out.println("Yapmak istediğiniz işlemi seçiniz.");
            System.out.println("'Y' para yatırma");
            System.out.println("'C' para çekme");
            System.out.println("'G' bakiye gösterme");
            System.out.println("'Q' çıkış yapma");
            islemFonk(kisi2);

        }
        if (tempKAdi.equals(kisi3.getK_adi())){
            System.out.print("Şifre giriniz:");
            tempSifre = in.nextInt();
            while (!(tempSifre == kisi3.getSifre())) {
                System.err.println("HATALI ŞİFRE TEKRAR GİRİNİZ:");
                tempSifre = in.nextInt();
            }
            System.out.println("HOŞ GELDİNİZ " + kisi3.getK_adi());
            System.out.println("----------------------");
            System.out.println("Yapmak istediğiniz işlemi seçiniz.");
            System.out.println("'Y' para yatırma");
            System.out.println("'C' para çekme");
            System.out.println("'G' bakiye gösterme");
            System.out.println("'Q' çıkış yapma");
            islemFonk(kisi3);

        }




    }

    private void islemFonk(Kisi k) {
        System.out.println(k.getK_adi());
        Scanner in = new Scanner(System.in);
        String islem;
        islem = in.next();
        switch (islem) {
            case "Y":
                while (true){
                    System.out.print("Yatırmak istediğiniz miktarı giriniz:");
                    int tempMiktar= in.nextInt();
                    k.setPara(k.getPara() + tempMiktar);
                    System.out.print("Para eklemek istermisiniz ? e,h");
                    String tempIslem=in.next();
                    if (tempIslem.equals("h")){
                        break;
                    }

                }
                islemFonk(k);
                break;
            case "C":
                break;
            case "G":
                System.out.println("Bakiyeniz = "+ k.getPara());
                islemFonk(k);
                break;
            case "Q":
                System.out.println("ÇIKIŞ YAPILIYOR .............");
                break;
            default:
                System.out.println("Hatalı işlem seçimi ");

                islemFonk(k);
                break;
        }
    }
}
