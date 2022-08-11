import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    İslemler i̇slemler = new İslemler();
    Login login = new Login();
    Scanner menu = new Scanner(System.in);

    public void menu() throws SQLException {
        try {


            while (true) {
                System.out.println("------------------------");
                byte secenek;
                System.out.println("1) Para çek");
                System.out.println("2) Para Yatır");
                System.out.println("3) Bakiye sorgula");
                System.out.println("4) Çıkış");
                System.out.println("------------------------");
                System.out.println("Lütfen yapmak istediğniz işlemi seçiniz");
                secenek = menu.nextByte();
                if (secenek == 1) {
                    i̇slemler.paracek();
                    break;
                } else if (secenek == 2) {
                    i̇slemler.parayatir();
                    break;
                } else if (secenek == 3) {
                    i̇slemler.bakiyesorgu();
                    break;
                } else if (secenek == 4) {
                    System.out.println("Bizi tercih ettiğiniz için teşekkür ederiz." + "\n" + "  ");
                    login.girisyap();
                    break;
                } else {
                    System.out.println("Hatalı giriş yaptınız Lütfen tekrar deneyiniz");
                }
            }
        } catch (java.util.InputMismatchException hata) {
            System.out.println("Hatalı karakter girişi");
            menu.next();
        } finally {
            menu();
        }
    }

    public void menu2() throws SQLException {
        try {

            while (true) {
                byte secenek;
                System.out.println("1) Ana menüye dön");
                System.out.println("2) Çıkış yap");
                System.out.println("İslem : ");
                secenek = menu.nextByte();
                if (secenek == 1) {
                    menu();
                    break;
                } else if (secenek == 2) {
                    System.out.println("Bizi tercih ettiğiniz için teşekkür ederiz." + "\n" + "  ");
                    login.girisyap();
                    break;
                } else {
                    System.out.println("Hatalı giriş yaptınız lütfen tekrar deneyiniz.");
                }
            }
        } catch (java.util.InputMismatchException hata) {
            System.out.println("Hatalı karakter girişi");
            menu.next();
        } finally {
            menu2();
        }
    }

}
