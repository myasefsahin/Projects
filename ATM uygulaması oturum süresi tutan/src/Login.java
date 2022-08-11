import java.util.Scanner;

public class Login {
    static Customer customer1 = new Customer("Ahmet Aslan", "123456789", "1234", 2500);
    static Customer customer2 = new Customer("Mehmet Demir", "987654321", "9876", 3500);
    static Customer customer3 = new Customer("Arzu Yılmaz", "963852741", "4567", 4500);
    static String logcustomername;
    static String logpassword;
    static int tutar;
    static Scanner giris = new Scanner(System.in);
    static thread calistir = new thread();

    public static void giris() {
        calistir=new thread();
        while (true) {
            System.out.println("----------------------");
            System.out.println("HOŞGELDİNİZ");
            System.out.println("LÜTFEN MÜŞTERİ NUMARANIZI GİRİNİZ");
            logcustomername = giris.next();
            System.out.println("LÜTFEN ŞİFRENİZİ GİRİNİZ");
            logpassword = giris.next();
            if (logcustomername.equals(customer1.getCustomerno()) && logpassword.equals(customer1.getPassword())) {
                calistir.start();
                System.out.println("Hoşgeldiniz " + customer1.getCustomername());
                Menu.menu1(customer1);
                break;
            } else if (logcustomername.equals(customer2.getCustomerno()) && logpassword.equals(customer2.getPassword())) {
                calistir.start();
                System.out.println("Hoşgeldiniz : " + customer2.getCustomername());
                Menu.menu1(customer2);
                break;
            } else if (logcustomername.equals(customer3.getCustomerno()) && logpassword.equals(customer3.getPassword())) {
                calistir.start();
                System.out.println("Hoşgeldiniz : " + customer3.getCustomername());
                Menu.menu1(customer3);
                break;
            } else {
                System.out.println("Hatalı giriş yaptınız lütfen tekrar deneyiniz ");
            }
        }
    }

    public static void paracek(Customer customer) {
        try {


            while (true) {
                System.out.println("lütfen çekmek isediğiniz tutarı giriniz :");
                tutar = giris.nextInt();
                if (tutar > customer.getMoney()) {
                    System.out.println("Yetersiz Bakiye" + "\n");
                    System.out.println("En fazla çekebileceğiniz bakiye : " + customer.getMoney());
                } else if (tutar < 0) {
                    System.out.println("Lütfen pozitif bir değer giriniz ");
                } else {
                    while (true) {
                        System.out.println("İşlemi onaylıyormusunuz : ");
                        System.out.println("E) EVET" + "\n" + "H) HAYIR");
                        char onay = giris.next().charAt(0);
                        if (onay == 'e' || onay == 'E') {
                            customer.setMoney(customer.getMoney() - tutar);
                            System.out.println("İşlem gerçekleşti");
                            Menu.menu2(customer);
                            break;
                        } else if (onay == 'h' || onay == 'H') {
                            System.out.println("işlem iptal edildi");
                            Menu.menu2(customer);
                            break;
                        } else {
                            System.out.println("Hatalı giriş yaptınız lütfen tekrar deneyiniz");
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Hatalı karakter girişi");
            giris.next();
        } finally {
            paracek(customer);
        }
    }

    public static void parayatir(Customer customer) {
        try {

            System.out.println("lütfen yatırmak isediğiniz tutarı giriniz :");
            tutar = giris.nextInt();
            if (tutar < 0) {
                System.out.println("Lütfen pozitif bir değer giriniz ");
            } else {
                while (true) {
                    System.out.println("İşlemi onaylıyormusunuz : ");
                    System.out.println("E) EVET" + "\n" + "H) HAYIR");
                    char onay = giris.next().charAt(0);
                    if (onay == 'e' || onay == 'E') {
                        customer.setMoney(customer.getMoney() + tutar);
                        System.out.println("İşlem gerçekleşti");
                        Menu.menu2(customer);
                        break;
                    } else if (onay == 'h' || onay == 'H') {
                        System.out.println("işlem iptal edildi");
                        Menu.menu2(customer);
                        break;
                    } else {
                        System.out.println("Hatalı giriş yaptınız lütfen tekrar deneyiniz");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Hatalı karakter girişi");
            giris.next();
        } finally {
            parayatir(customer);
        }
    }

    public static void Bakiyesorgu(Customer customer) {
        System.out.println("Güncel Bakiyeniz : " + customer.getMoney());
        Menu.menu2(customer);
    }
}
