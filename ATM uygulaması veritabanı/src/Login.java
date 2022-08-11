import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
    Scanner giris = new Scanner(System.in);
    Connection connection = null;
    DbHelper helper = new DbHelper();
    Statement statement;
    ResultSet resultset;
    static int bakiye;
    static String musterinum;
    static String isim;


    public void girisyap() throws SQLException {
        Menu menu = new Menu();
        while (true) {
            System.out.println("Lütfen müşteri numaranızı giriniz ");
            String musterino = giris.next();
            System.out.println("Lütfen Şifrenizi giriniz");
            String sifre = giris.next();
            connection = helper.getConnection();
            statement = connection.createStatement();
            String girissorgu = "SELECT count(no) as giris from databasename.tablename where musterino ='" + musterino + "' and sifre = '" + sifre + "'";
            resultset = statement.executeQuery(girissorgu);
            resultset.next();

            if (resultset.getInt("giris") == 1) {
                System.out.println("Giriş Başarılı");
                connection = helper.getConnection();
                statement = connection.createStatement();
                String giris = "SELECT Adsoyad as adsoyad from databasename.tablename  where musterino ='" + musterino + "' and sifre = '" + sifre + "'";
                resultset = statement.executeQuery(giris);
                resultset.next();


                if (resultset.getString("adsoyad").equals("Ahmet Aslan")) {
                    isim = resultset.getString("adsoyad");
                    System.out.println("Hoşgeldiniz " + isim);
                    String bakiyegetir = "SELECT bakiye as bakiyegetir from databasename.tablename where musterino = '" + musterino + "' and sifre = '" + sifre + "'";
                    resultset = statement.executeQuery(bakiyegetir);
                    resultset.next();
                    bakiye = resultset.getInt("bakiyegetir");
                    String musterinogetir = "select musterino as musterino from databasename.tablename  where Adsoyad = '" + isim + "'";
                    resultset = statement.executeQuery(musterinogetir);
                    resultset.next();
                    musterinum = resultset.getString("musterino");
                    menu.menu();

                    break;


                } else if (resultset.getString("adsoyad").equals("Mehmet Demir")) {
                    isim = resultset.getString("adsoyad");
                    System.out.println("Hoşgeldiniz " + isim);
                    String bakiyegetir = "SELECT bakiye as bakiyegetir from tablename where musterino = '" + musterino + "' and sifre = '" + sifre + "'";
                    statement = connection.createStatement();
                    resultset = statement.executeQuery(bakiyegetir);
                    resultset.next();
                    bakiye = resultset.getInt("bakiyegetir");
                    String musterinogetir = "select musterino as musterino from databasename.tablename  where Adsoyad = '" + isim + "'";
                    resultset = statement.executeQuery(musterinogetir);
                    resultset.next();
                    musterinum = resultset.getString("musterino");
                    menu.menu();

                    break;


                } else if (resultset.getString("adsoyad").equals("Arzu Yılmaz")) {
                    isim = resultset.getString("adsoyad");
                    System.out.println("Hoşgeldiniz " + isim);
                    String bakiyegetir = "SELECT bakiye as bakiyegetir from tablename where musterino = '" + musterino + "' and sifre = '" + sifre + "'";
                    statement = connection.createStatement();
                    resultset = statement.executeQuery(bakiyegetir);
                    resultset.next();
                    bakiye = resultset.getInt("bakiyegetir");
                    String musterinogetir = "select musterino as musterino from databasename.tablename  where Adsoyad = '" + isim + "'";
                    resultset = statement.executeQuery(musterinogetir);
                    resultset.next();
                    musterinum = resultset.getString("musterino");
                    menu.menu();

                    break;
                }

            } else if (resultset.getInt("giris") == 0) {
                System.out.println("Hatalı Giriş Yaptınız Lütfen Tekrar deneyiniz");
            }
        }
    }
}



