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

	/* Construtor da Classe Filósofo */
	public Filosofo(int id, Mesa m){
		this.id = id;
		this.m = m;
	}

	/* filósofo come */
	public void comer(){
		try {
			Thread.sleep(1000);
			System.out.println("Filósofo "+id+" está comendo.");
		} catch (InterruptedException e){
			System.out.println("Erro: Filósofo "+id+" não conseguiu comer"!);
		}
	}

	/* filósofo pensa */
	public void pensar(){
		try {
			Thread.sleep(1000);
			System.out.println("Filósofo "+id+" está pensando.");
		} catch (InterruptedException e){
			System.out.println("Erro: Filósofo "+id+" não conseguiu pensar"!);
		}
	}

	/* filósofo fica faminto */
	public void estaFaminto(){

	}

	/* executa thread de filósofo */
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
