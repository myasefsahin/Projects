import java.util.Scanner;

public class Menu {

    static Scanner menusecim = new Scanner(System.in);

    public static void menu1(Customer customer)  {
        while (true) {

            System.out.println("-------MENU---------");
            System.out.println("lütfen yapmak istediğiniz işlemi seçiniz");
            System.out.println("1) Para çekme");
            System.out.println("2) Para yatırma");
            System.out.println("3) Bakiye sorgula");
            System.out.println("4) Çıkış");
            byte secenek = menusecim.nextByte();
            if (secenek == 1) {
                Login.paracek(customer);
                break;
            } else if (secenek == 2) {
                Login.parayatir(customer);
                break;
            } else if (secenek == 3) {
                Login.Bakiyesorgu(customer);
                break;
            } else if (secenek == 4) {
                System.out.println("Çıkış yapılıyor..." + "\n" + "Bizi tercih ettiğiniz için teşekkür ederiz");
                System.out.println("Oturum süreniz ="+thread.saat+" saat "+thread.dakika+" dakika "+thread.saniye+" saniye");
                thread.saniye=0;
                Login.calistir.stop();
                Login.giris();

            } else {
                System.out.println("Hatalı karakter girişi lütfen tekrar deneyiniz");

            }
        }
    }

    public static void menu2(Customer customer)  {
        while (true) {
            System.out.println("1) Ana menüye dön");
            System.out.println("2) Çıkış");
            System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz");
            byte secim = menusecim.nextByte();
            if (secim == 1) {
                System.out.println("Menüye Yönlendiriliyorsunuz...");
                menu1(customer);
                break;
            } else if (secim == 2) {
                System.out.println("Çıkış yapılıyor..." + "\n" + "Bizi tercih ettiğiniz için teşekkür ederiz");
                System.out.println("Oturum süreniz ="+thread.saat+" saat "+thread.dakika+" dakika "+thread.saniye+" saniye");
                thread.saniye=0;
                Login.calistir.stop();
                Login.giris();

                break;
            } else {
                System.out.println("Hatalı karakter girişi lütfen tekrar deneyiniz");
            }
        }
    }
}
