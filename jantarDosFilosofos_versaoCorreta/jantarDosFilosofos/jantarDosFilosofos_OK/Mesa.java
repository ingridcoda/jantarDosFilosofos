package jantarDosFilosofos_OK;

import java.util.concurrent.Semaphore;

public class Mesa {
	private int estado[];
	private Semaphore mutex;
	private Semaphore semaforos[];	
    private final int pensando = 0;
    private final int faminto = 1;
    private final int comendo = 2;
	private int esquerda;
	private int direita;
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
		testar(filosofo);
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
		testar(esquerda);
		testar(direita);
		mutex.release();
	}
	
	/* Testa possibilidade de filosofo comer */
	public void testar(int filosofo){
		this.esquerda = (filosofo + totalFilosofos - 1) % totalFilosofos;
		this.direita = (filosofo + 1) % totalFilosofos;
		if(estado[filosofo] == faminto && estado[esquerda] != comendo && estado[direita] != comendo){
			estado[filosofo] = comendo;
			semaforos[filosofo].release();
		}
	}
}
