package watki.UsuwanieZeZbioru;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
Napisz program kt�ry r�wnocze�nie wypisuje na ekran losowy element z nast�puj�cych zbior�w
Q, W, E, R, T, Y
1, 2, 3, 4, 5, 6
^, &, *, (, #
Wypisanie elementu usuwa go ze zbioru
Program ko�czy dzia�anie gdy wszystkie elementy zostan� wypisane

W jaki inny spos�b mozna przekazac referencje zbioru do watku?
W jaki inny sposob mozna zainicjalizowac zbiory?
Jak wyeliminowac zmienne i bloki statyczne?
 * @author ml
 *
 */
public class UsuwamZeZbiorow {
	//Instancja zbioru 1
	private static Set<String> zbior1 = new HashSet<>();
	private static Set<Integer> zbior2 = new HashSet<>();
	private static Set<Character> zbior3 = new HashSet<>();
	//Wypelnienie zbioru danymi
	static {
		zbior1.add("Q");
		zbior1.add("W");
		zbior1.add("E");
		zbior1.add("R");
		zbior1.add("T");
		zbior1.add("Y");
		zbior2.add(1);
		zbior2.add(2);
		zbior2.add(3);
		zbior2.add(4);
		zbior2.add(5);
		zbior2.add(6);
		zbior3.add('^');
		zbior3.add('&');
		zbior3.add('*');
		zbior3.add('(');
		zbior3.add('#');
	}

	public static void main(String[] args) {
		//Watek dla zbioru1
		Thread watekZbioruStringow = new Thread(new Runnable(){
			@Override
			public void run() {
				//Pobieramy iterator
				Iterator<String> iterator1 = zbior1.iterator();
				//Dopoki iterator moze zwrocic element
				while(iterator1.hasNext()){
					//Pobierz i wypisz element
					System.out.println(iterator1.next());
					//Usun element
					iterator1.remove();
				}
			}
		});
		//Watek dla zbioru2
		Thread watekZbioruIntegerow = new Thread(() -> {
            //Pobieramy iterator
            Iterator<Integer> iterator2 = zbior2.iterator();
            //Dopoki iterator moze zwrocic element
            while(iterator2.hasNext()){
                //Pobierz i wypisz element
                System.out.println(iterator2.next());
                //Usun element
                iterator2.remove();
            }
        });
		//Watek dla zbioru3
		Thread watekZbioruCharakterow = new Thread(() -> {
			//pobieramy iterator
			Iterator<Character> iterator3 = zbior3.iterator();
			//Dopoki iterator moze zwrocic element
			while (iterator3.hasNext()) {
				//Pobierz i wypisz element
				System.out.println(iterator3.next());
				//Usun element
				iterator3.remove();
			}
		});
		//Wystartuj watek
		watekZbioruStringow.start();
		watekZbioruIntegerow.start();
		watekZbioruCharakterow.start();

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(zbior1.isEmpty());
		System.out.println(zbior2.isEmpty());
		System.out.println(zbior3.isEmpty());
	}
}
