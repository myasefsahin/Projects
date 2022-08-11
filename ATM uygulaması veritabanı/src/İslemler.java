import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class İslemler {
    Connection connection = null;
    DbHelper helper = new DbHelper();
    Statement statement;
    int resultset;
    Scanner islemyap = new Scanner(System.in);


    public void paracek() throws SQLException {
        Menu menuler = new Menu();
        while (true) {
            try {
                char secenek;
                System.out.println("Lütfen çekmek istediğiniz tutarı giriniz :");
                float tutar = islemyap.nextFloat();
                if (tutar > Login.bakiye) {
                    System.out.println("Yetersiz Bakiye En fazla çekebileceğiniz miktar : " + Login.bakiye);
                } else if (tutar < 0) {
                    System.out.println("lütfen pozitif bir sayı giriniz");
                } else {
                    while (true) {
                        System.out.println("İşlemi onaylıyormusunuz?");
                        System.out.println("E) EVET" + "\n" + "H) HAYIR");
                        secenek = islemyap.next().charAt(0);
                        if (secenek == 'E' || secenek == 'e') {
                            Login.bakiye -= tutar;
                            uptade();
                            System.out.println("Güncel bakiyeniz = " + Login.bakiye);
                            menuler.menu2();
                            break;
                        } else if (secenek == 'H' || secenek == 'h') {
                            System.out.println("Menüye yönlendiriliyorsunuz...");
                            menuler.menu();

                            break;
                        } else {
                            System.out.println("Hatalı karakter girişi lütfen tekrar deneyiniz");
                        }
                    }
                }
            } catch (java.util.InputMismatchException hata) {
                System.out.println("hatalı karakter girişi ");
                islemyap.next();
            } finally {
                paracek();
            }
        }
    }

    public void parayatir() throws SQLException {
        Menu menuler = new Menu();
        try {
            while (true) {
                char secenek;
                System.out.println("Lütfen yatırmak istediğiniz tutarı giriniz ");
                float tutar = islemyap.nextFloat();
                if (tutar < 0) {
                    System.out.println("Lütfen pozitif bir sayı giriniz");
                } else {
                    while (true) {
                        System.out.println("İşlemi onaylıyormusunuz ?" + "\n" + "E) EVET" + "\n" + "H) HAYIR");
                        secenek = islemyap.next().charAt(0);
                        if (secenek == 'e' || secenek == 'E') {
                            Login.bakiye += tutar;
                            uptade();
                            System.out.println("Güncel bakiyeniz = " + Login.bakiye);
                            menuler.menu2();
                            break;
                        } else if (secenek == 'h' || secenek == 'H') {
                            System.out.println("Menüye yönlendiriliyorsunuz...");
                            menuler.menu();
                            break;
                        } else {
                            System.out.println("Hatalı giriş yaptınız lütfen tekrar deneyiniz.");
                        }
                    }
                }
            }
        } catch (java.util.InputMismatchException hata) {
            System.out.println("Hatalı karakter girişi");
            islemyap.next();
        } finally {
            parayatir();
        }
    }

    public void bakiyesorgu() throws SQLException {
        Menu menuler = new Menu();
        System.out.println("Güncel bakiyeniz = " + Login.bakiye);
        menuler.menu2();
    }

    public void uptade() throws SQLException {
        connection = helper.getConnection();
        statement = connection.createStatement();
        String uptade = "update tablename set bakiye = '" + Login.bakiye + "' where musterino ='" + Login.musterinum + "'";
        resultset = statement.executeUpdate(uptade);


    }
}
