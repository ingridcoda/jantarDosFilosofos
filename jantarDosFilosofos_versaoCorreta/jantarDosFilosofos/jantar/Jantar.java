import java.util.concurrent.*;
import semaforos.Mesa;
import filosofos.Filosofo;

public class Jantar {
	
	public static void main(String[] args){
		
		Mesa mesa = new Mesa();
		
		Thread filosofo1 = new Filosofo(1);
		Thread filosofo2 = new Filosofo(2);
		Thread filosofo3 = new Filosofo(3);
		Thread filosofo4 = new Filosofo(4);
		Thread filosofo5 = new Filosofo(5);
		
		filosofo1.start();
		filosofo2.start();
		filosofo3.start();
		filosofo4.start();
		filosofo5.start();
		
	}
	
}