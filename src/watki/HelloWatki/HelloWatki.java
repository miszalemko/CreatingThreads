package watki.HelloWatki;
/**
 * 
Hello watki.
Napisz program ktory tworzy nastepujace watki.
Dziedziczacy po Thread.
Klase implementujaca Runnable
Anonimowa klase dziedziczaca po Thread
Anonimowa klase implementujaca runnable
Lambda
Kazdy watek w metodzie run wypisuje stringa opisujacego sposob utworzenia

 * @author ml
 *
 */
public class HelloWatki {
	
	public static void main(String[] args) {
		Thread poThread = new DziedziczePoThread();
		poThread.start();
		Thread poImpl = new Thread(new ThreadImpl());
		poImpl.start();
		Thread threadAnon = new Thread() {
			@Override
			public void run() {
				super.run();
				System.out.println("anonimowa przez dziedziczenie " + Thread.currentThread().getId());
			}
		};
		threadAnon.start();
		Thread threadimpl = new Thread(() -> System.out.println("anonimowa interface "  + Thread.currentThread().getId()));
		threadimpl.start();
	}

}

//Nie anonimowa klasa. Ma nazwe ktorej mozna uzyc z operatorem new
class DziedziczePoThread extends Thread{
	public void run(){
		System.out.println("Jestem watkiem dziedziczacym po Thread "  + Thread.currentThread().getId());
	}
}

class ThreadImpl implements Runnable {
	@Override
	public void run() {
		System.out.println("watek tworzony przez implementacje "  + Thread.currentThread().getId());
	}
}

