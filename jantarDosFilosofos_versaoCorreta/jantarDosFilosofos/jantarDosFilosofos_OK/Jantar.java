package jantarDosFilosofos_OK;

public class Jantar {
		
	/* Classe principal do programa */
	public static void main(String[] args){
		
		Mesa mesa = new Mesa();
		
		Thread filosofo1 = new Filosofo(0, mesa);
		Thread filosofo2 = new Filosofo(1, mesa);
		Thread filosofo3 = new Filosofo(2, mesa);
		Thread filosofo4 = new Filosofo(3, mesa);
		Thread filosofo5 = new Filosofo(4, mesa);
		
		filosofo1.start();
		filosofo2.start();
		filosofo3.start();
		filosofo4.start();
		filosofo5.start();
		
	}
	
}
