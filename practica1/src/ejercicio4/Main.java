package ejercicio4;

public class Main {

	public static void main(String[] args) {
		Thread hiloImpar = new Thread(new Impar(), "hiloImpar: "); 
		 Thread hiloPar = new Par("hiloPar: "); 
		 hiloImpar.start();
		 hiloPar.start();
		 
		 hiloPar.setName("Hilo par: ");
		 hiloImpar.setName("Hilo Impar: ");
		 
		 try {
				hiloImpar.join();
				hiloPar.join();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}

	}

}
