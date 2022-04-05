package ejercicio4;

public class Par extends Thread{
	
	public Par(String name) {
		super(name);
	}
	
	private static int i = 0;
	private static int total = 10;
	
	@Override
	public void run() {
		while(i <= total) {
			if(i % 2 == 0) {
				System.out.println(Thread.currentThread().getName() + "" + "Valor:" + i++);
				i++;
			} else {
				i++;
			}
        }
    }
}
