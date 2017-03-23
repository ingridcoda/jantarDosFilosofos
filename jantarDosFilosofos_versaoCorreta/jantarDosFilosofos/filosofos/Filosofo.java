package filosofos;
import java.util.concurrent;
import semaforos.Mesa;
import java.lang.*;

public class Filosofo extends Thread {
	int id;
	private Mesa m;
	private final int pensando = 0;
	private final int faminto = 1;
	private final int comendo = 2;

	/* Construtor da Classe Fil�sofo */
	public Filosofo(int id, Mesa m){
		this.id = id;
		this.m = m;
	}

	/* fil�sofo come */
	public void comer(){
		try {
			Thread.sleep(1000);
			System.out.println("Fil�sofo "+id+" est� comendo.");
		} catch (InterruptedException e){
			System.out.println("Erro: Fil�sofo "+id+" n�o conseguiu comer"!);
		}
	}

	/* fil�sofo pensa */
	public void pensar(){
		try {
			Thread.sleep(1000);
			System.out.println("Fil�sofo "+id+" est� pensando.");
		} catch (InterruptedException e){
			System.out.println("Erro: Fil�sofo "+id+" n�o conseguiu pensar"!);
		}
	}

	/* fil�sofo fica faminto */
	public void estaFaminto(){

	}

	/* executa thread de fil�sofo */
	public void run(){
		try {
			pensar();
			m.pegarGarfo(this.id);
			comer();
			m.largarGarfo(this.id);

		} catch(InterruptedException e){

		} finally {

		}
	}


}
