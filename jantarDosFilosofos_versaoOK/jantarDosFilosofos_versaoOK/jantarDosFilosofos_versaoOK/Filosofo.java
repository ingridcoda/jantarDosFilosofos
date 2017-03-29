package jantarDosFilosofos_versaoOK;
//import jantarDosFilosofos_OK.Mesa;

public class Filosofo extends Thread{
	final int id;
	private Mesa m;

	/* Construtor da Classe Fil�sofo */
	public Filosofo(int id, Mesa m){
		this.id = id;
		this.m = m;
	}

	/* Executa thread de fil�sofo */
	public void run(){
		while(true){
			System.out.println("Fil�sofo "+(id + 1)+" vai pensar.");
			pensar();
			System.out.println("Fil�sofo "+(id + 1)+" pensou.");
			System.out.println("Fil�sofo "+(id + 1)+" vai acordar.");
			System.out.println("Fil�sofo "+(id + 1)+" acordou.");
			System.out.println("Fil�sofo "+(id + 1)+" vai comer.");
			m.pegarGarfo(this.id);
			comer();
			m.largarGarfo(this.id);
			System.out.println("Fil�sofo "+(id + 1)+" comeu.");
		} 
	}
	
	/* Fil�sofo pensa */
	public void pensar(){
		try {
			Thread.sleep(1000);
			System.out.println("Fil�sofo "+(id + 1)+" est� pensando.");
		} catch (InterruptedException e){
			System.out.println("Erro: Fil�sofo "+(id + 1)+" n�o conseguiu pensar!");
		}
	}
	
	/* Fil�sofo come */
	public void comer(){
		try {
			Thread.sleep(1000);
			System.out.println("Fil�sofo "+(id + 1)+" est� comendo.");
		} catch (InterruptedException e){
			System.out.println("Erro: Fil�sofo "+(id + 1)+" n�o conseguiu comer!");
		}
	}

	
}
