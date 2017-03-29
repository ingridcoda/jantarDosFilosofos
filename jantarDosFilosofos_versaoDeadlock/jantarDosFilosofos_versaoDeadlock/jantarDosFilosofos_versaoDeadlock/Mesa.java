package jantarDosFilosofos_versaoDeadlock;

import java.util.concurrent.Semaphore;

public class Mesa {
	private int estado[];
	private Semaphore mutex;
	private Semaphore semaforos[];	
	private final int pensando = 0;
	private final int faminto = 1;
	private final int comendo = 2;
	private int totalFilosofos = 5;

	/* Construtor da classe Mesa */
	public Mesa(){
		estado = new int[totalFilosofos];
		semaforos = new Semaphore[] {new Semaphore(0),new Semaphore(0),new Semaphore(0),new Semaphore(0),new Semaphore(0)};
		mutex = new Semaphore(1);
	}

	/* Filósofo tenta pegar garfo */
	public void pegarGarfo(int filosofo){
		try {
			mutex.acquire();
			System.out.println("Filósofo "+(filosofo + 1)+" pegou garfo para comer.");
		} catch (InterruptedException e){
			System.out.println("Erro: Filósofo "+(filosofo + 1)+" não conseguiu pegar garfo para comer!");
		}

		estado[filosofo] = faminto;
		comer(filosofo);
		mutex.release();
		try {
			semaforos[filosofo].acquire();
		} catch(InterruptedException e){
			e.printStackTrace();
		}


	}

	/* Filósofo larga o garfo */
	public void largarGarfo(int filosofo){
		try {
			mutex.acquire();
			System.out.println("Filósofo "+(filosofo + 1)+" largou garfo.");
		} catch (InterruptedException e){
			System.out.println("Erro: Filósofo "+(filosofo + 1)+" não conseguiu pegar garfo para comer!");
		}
		estado[filosofo] = pensando;
		mutex.release();
	}

	public void comer(int filosofo){
		estado[filosofo] = comendo;			
	}
}
