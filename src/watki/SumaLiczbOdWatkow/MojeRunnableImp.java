package watki.SumaLiczbOdWatkow;

import java.util.Random;

public class MojeRunnableImp implements MojeRunnable{

    private int wygenerowana;
    private boolean wygenerowane = false;

    @Override
    public int podajWygenerowana() {
        return wygenerowana;
    }

    @Override
    public void run() {
        Random random = new Random();
        wygenerowana = random.nextInt(100);
        System.out.println("wygenerowana " + wygenerowana);
        wygenerowane = true;
    }

    boolean czyWygenerowane(){
        return wygenerowane;
    }
}