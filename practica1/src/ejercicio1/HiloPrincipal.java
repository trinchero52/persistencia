package ejercicio1;

public class HiloPrincipal {
	
	public static void main(String[] args) {
		  
		Thread t = Thread.currentThread();
	      String name = t.getName();
	      System.out.println("name=" + name); 
	}
	
}
