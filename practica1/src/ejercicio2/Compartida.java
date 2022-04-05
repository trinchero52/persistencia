package ejercicio2;

public class Compartida {
	public static void imprimir() {
		System.out.println("hilo actual: " + Thread.currentThread().getName());
	}
}
