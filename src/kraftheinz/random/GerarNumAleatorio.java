package kraftheinz.random;

import java.util.ArrayList;
import java.util.Random;

public class GerarNumAleatorio {

	private ArrayList<Integer> numerosGerados = new ArrayList<>();
	private Random random = new Random();

	public int gerarNumeroAleatorio() {
		int numeroAleatorio;
		do {
			numeroAleatorio = random.nextInt(1000); // Gera um número aleatório entre 0 e 99999
		} while (numerosGerados.contains(numeroAleatorio)); // Verifica se o número já foi gerado

		numerosGerados.add(numeroAleatorio); // Adiciona o número à lista de números gerados
		return numeroAleatorio;
	}
}
