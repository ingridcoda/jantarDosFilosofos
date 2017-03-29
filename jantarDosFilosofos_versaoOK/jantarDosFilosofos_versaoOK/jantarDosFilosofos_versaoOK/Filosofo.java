package jantarDosFilosofos_versaoOK;
//import jantarDosFilosofos_OK.Mesa;

public class Filosofo extends Thread{
	final int id;
	private Mesa m;

	/* Construtor da Classe Filósofo */
	public Filosofo(int id, Mesa m){
		this.id = id;
		this.m = m;
	}

	/* Executa thread de filósofo */
	public void run(){
		while(true){
			System.out.println("Filósofo "+(id + 1)+" vai pensar.");
			pensar();
			System.out.println("Filósofo "+(id + 1)+" pensou.");
			System.out.println("Filósofo "+(id + 1)+" vai acordar.");
			System.out.println("Filósofo "+(id + 1)+" acordou.");
			System.out.println("Filósofo "+(id + 1)+" vai comer.");
			m.pegarGarfo(this.id);
			comer();
			m.largarGarfo(this.id);
			System.out.println("Filósofo "+(id + 1)+" comeu.");
		} 
	}
	
	/* Filósofo pensa */
	public void pensar(){
		try {
			Thread.sleep(1000);
			System.out.println("Filósofo "+(id + 1)+" está pensando.");
		} catch (InterruptedException e){
			System.out.println("Erro: Filósofo "+(id + 1)+" não conseguiu pensar!");
		}
	}
	
	/* Filósofo come */
	public void comer(){
		try {
			Thread.sleep(1000);
			System.out.println("Filósofo "+(id + 1)+" está comendo.");
		} catch (InterruptedException e){
			System.out.println("Erro: Filósofo "+(id + 1)+" não conseguiu comer!");
		}
	}

	
}
