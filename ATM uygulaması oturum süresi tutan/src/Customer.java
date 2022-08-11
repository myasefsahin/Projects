public class Customer {
    private final String customername;
    private final String customerno ;
    private final String password;
    private int  money;
    public Customer(String customername,String customerno,String password,int money){
        this.customername=customername;
        this.customerno=customerno;
        this.password=password;
        this.setMoney(money);

    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCustomername() {
        return customername;
    }

    public String getCustomerno() {
        return customerno;
    }

    public String getPassword() {
        return password;
    }
}
