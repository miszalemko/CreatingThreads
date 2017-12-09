package watki.Synchronization;

//4. Na podstawie zadania 3
//        Utwórz w klasie SynchronizacjaMonitora pole statyczne typu int o nazwie wartoscWspoldzielona
//        Zmodyfikuj metode run w ten sposob ze zakomentujesz blok synchronized.
//        Kolejno, wypiszesz na ekran id watku oraz wartosc pola wartoscWspoldzielona.
//        Nastepnie uspisz watek na 3 sekundy.
//        Wygenerujesz losowa liczbe z przedzialu od 0 do 100
//        Wypiszez na ekran id watku oraz wygenerowana liczbe.
//        Nastepnie zwiekszysz wartoscWspoldzielona o wygenerowana liczbe.
//        Wypiszesz na ekran id watku oraz wartosc zmiennej wspoldzielonej.
//        Czy wyniki zmienia sie jezeli przywrocisz synchronizacje?

import java.util.Random;

public class MonitorSynchronizationWithValue {

    private static String monitor = " ";
    private static int wartoscWspoldzielona = 10;

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (monitor) {
                        try {
                            System.out.println("ThreadId " + Thread.currentThread().getId() + " wartoscWspoldzielona " + wartoscWspoldzielona);
                            Thread.sleep(3000);
                            int losowanaliczba = random.nextInt(100);
                            System.out.println("ThreadId " + Thread.currentThread().getId() + " losowanaliczba " + losowanaliczba);
                            wartoscWspoldzielona += losowanaliczba;
                            System.out.println("ThreadId " + Thread.currentThread().getId() + " wartoscWspoldzielona " + wartoscWspoldzielona);
                            wartoscWspoldzielona = 10;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }).start();
        }
    }
}
