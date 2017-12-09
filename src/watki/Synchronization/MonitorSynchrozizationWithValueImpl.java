package watki.Synchronization;

//5. Zmodyfikuj tak kod w zadaniu 4.
//        Utworz w klasie metodę statyczną synchronizowaną o nazwie metodaSynchronizowana.
//        Zrefaktoruj tak kod by w run nastapilo wywolanie tej metody.
//        A metodaSynchronizowana wykonala wszystkie operacji z wczesniejszej wersji run.
//        Usun blok synchronized z ciala metody.

import java.util.Random;

public class MonitorSynchrozizationWithValueImpl {

    private static int wartoscWspoldzielona = 10;
    private static Random random = new Random();

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                metodaSynchronizowana();
            }).start();
        }
    }

    public synchronized static void  metodaSynchronizowana() {
            try {
                System.out.println("ThreadId " + Thread.currentThread().getId() + " wartoscWspoldzielona " + wartoscWspoldzielona);
                Thread.sleep(3000);
                int losowanaliczba = random.nextInt(100);
                System.out.println("ThreadId " + Thread.currentThread().getId() + " losowanaliczba " + losowanaliczba);
                wartoscWspoldzielona += losowanaliczba;
                System.out.println("gównoTrick");
                System.out.println("ThreadId " + Thread.currentThread().getId() + " wartoscWspoldzielona " + wartoscWspoldzielona);
                wartoscWspoldzielona = 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}
