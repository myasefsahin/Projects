import java.sql.*;
import java.util.Scanner;

public class calistir {

    public static void main(String[] args) throws SQLException {
        Scanner giris = new Scanner(System.in);
        Connection connection = null;
        DbHelper helper = new DbHelper();
        Statement statement ;
        ResultSet resultset;



        try {

            System.out.println("lütfen e mailinizi giriniz: ");
            String email = giris.next();
            System.out.println("lütfen şifrenizi giriniz : ");
            String password = giris.next();
            connection = helper.getConnection();
            statement = connection.createStatement();
            String emailsorgu = "Mysql String";
            resultset = statement.executeQuery(emailsorgu);
            resultset.next();
            if (resultset.getInt("giris") == 1) {
                System.out.println("Sisteme giriş başarılı");
                System.out.println("Hoşgeldiniz.. ");
            }

            while (resultset.getInt("giris") != 1) {

                Scanner giris2 = new Scanner(System.in);
                System.out.println("Hatalı giriş lütfen tekrar deneyiniz.");
                System.out.println(" ");
                System.out.println("lütfen e mailinizi giriniz: ");
                String email2 = giris2.next();
                System.out.println("lütfen şifrenizi giriniz : ");
                String password2 = giris2.next();
                emailsorgu = "Mysql String";
                resultset = statement.executeQuery(emailsorgu);
                resultset.next();


                if (resultset.getInt("giris") == 1) {

                    System.out.println("Sisteme giriş başarılı");
                    System.out.println("Hoşgeldiniz..");
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR : " + e.getMessage());
        }

        Scanner personelveri = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Kayıtları görüntülemek için  l ye basınız");
        char alinan = personelveri.next().charAt(0);
        char tus = 'l';

        while (alinan != 'l') {

            System.out.println("kayıtları görüntülemek için lütfen l tuşuna basınız ;");
            alinan = personelveri.next().charAt(0);
            if (alinan == tus) {
                break;

            }
        }

        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultset = statement.executeQuery("Tablodan çekmek istediğiniz sütunları veren Mysql Stringi");


            System.out.println("PERSONEL  BİLGİLERİ");
            while (resultset.next()) {
                System.out.println(resultset.getString("NO") + "- " + "AD : " + resultset.getString("NAME") + " ");
                System.out.println("    SOYAD : " + resultset.getString("SURNAME"));
                System.out.println("    İŞE KAYIT TARİHİ : " + resultset.getDate("DATE"));

            }

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            helper.ShowErrorMessage(exception);

        } finally {
            assert connection != null;
            connection.close();

        }
    }


}



