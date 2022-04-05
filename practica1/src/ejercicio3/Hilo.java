package ejercicio3;

public class Hilo extends Thread {

	int rep;

	public Hilo(String name, int rep) {
		super(name);
		this.rep = rep;
	}
	
	@Override
	public void run() {
		var c = rep;
		while (c != 0) {
			System.out.println(this.getName());
			c -= 1;
		}
	}
}
