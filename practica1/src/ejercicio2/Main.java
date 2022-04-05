package ejercicio2;

public class Main {

	public static void main(String[] args) {
		Thread h1 = new Thread(new HiloUno());
		Thread h2 = new Thread(new HiloDos());
		Thread h3 = new Thread(new HiloTres());
		Thread h4 = new Thread(new HiloCuatro());
		Thread h5 = new Thread(new HiloCinco());
		
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();
	}

}
