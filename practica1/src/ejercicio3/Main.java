package ejercicio3;
public class Main {

	public static void main(String[] args) {
		Thread t1 = new Hilo("hilo1", 4);
		Thread t2 = new Hilo("hilo2", 3);
		Thread t3 = new Hilo("hilo3", 1);
		Thread t4 = new Hilo("hilo4", 2);
		Thread t5 = new Hilo("hilo5", 3);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
