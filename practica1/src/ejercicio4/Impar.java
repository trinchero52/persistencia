package ejercicio4;

public class Impar implements Runnable{

	private static int i = 0;
	private static int total = 10;
	
	@Override
	public void run() {
		while(i <= total) {
			if(i % 2 == 1) {
				System.out.println(Thread.currentThread().getName() + "Valor:" + i++);
				i++;
			} else {
				i++;
			}
        }
    }
}
