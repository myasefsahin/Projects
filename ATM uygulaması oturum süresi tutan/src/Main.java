public class Main {
    public static void main(String[] args) throws InterruptedException {

        Login.giris();


    }
}
class thread extends Thread{
    static int saniye;
    static int dakika;
    static int saat;
    public thread(){
        super();

    }
    public void run(){
        while (true){
            try {
                saniye++;
                sleep(1000);
                if(saniye==60){
                    dakika++;
                    saniye=0;
                }
                if(dakika==60){
                    dakika=0;
                    saat++;
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
