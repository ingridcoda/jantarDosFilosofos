import java.util.concurrent.*;
import filosofos.Filosofo;

public class Mesa {
	private int estado[];
	private Semaphore mutex;
	private Semaphore s[];	
    private final int pensando = 0;
    private final int faminto = 1;
    private final int comendo = 2;
	private int esquerda;
	private int direita;
	
	/* Construtor da Classe de Semáforo Mesa */
	public Mesa(){
		estado = new int[5];
		s = new Semaphore[] {new Semaphore(0),new Semaphore(0),new Semaphore(0),new Semaphore(0),new Semaphore(0)};
		mutex = new Semaphore(1);
	}
	
	/* filósofo tenta pegar garfo */
	public void pegarGarfo(int filosofo){
		try {
			mutex.acquire();
		} catch (InterruptedException e){
			System.out.println("Erro: Filósofo "+id+" não conseguiu pegar garfo para comer!");
		}
		
		estado[filosofo] = faminto;
		testar(filosofo);
		mutex.release();
		
		try {
			s[filosofo].acquire();
		} catch(InterruptedException e){
			/////adicionar algo aqui para tratar exception!
		}
		

	}

	/* filósofo larga o garfo */
	public void largarGarfo(int filosofo){
		try {
			mutex.acquire();
		} catch (InterruptedException e){
			System.out.println("Erro: Filósofo "+id+" não conseguiu pegar garfo para comer!");
		}
	}
	
	public void testar(int filosofo){
		
	}
}
