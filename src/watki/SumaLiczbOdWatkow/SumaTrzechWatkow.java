package watki.SumaLiczbOdWatkow;

public class SumaTrzechWatkow {

    int liczba1 = 0;
    int liczba2 = 0;
    int liczba3 = 0;

    public static void main(String[] args) throws InterruptedException {
        MojeRunnableImp impl1 = new MojeRunnableImp();
        Thread watek1 = new Thread(impl1);

        MojeRunnableImp impl2 = new MojeRunnableImp();
        Thread watek2 = new Thread(impl2);

        MojeRunnableImp impl3 = new MojeRunnableImp();
        Thread watek3 = new Thread(impl3);

        watek1.start();
        watek2.start();
        watek3.start();
        Thread.sleep(1000);
        if(impl1.czyWygenerowane() && impl2.czyWygenerowane() && impl3.czyWygenerowane()){
            System.out.println("Suma wygenerowanych liczb " + (impl1.podajWygenerowana() +
                    impl2.podajWygenerowana() + impl3.podajWygenerowana()));
        }
    }
}
