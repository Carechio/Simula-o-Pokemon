package Exercicio01;

/*A classe Treinador armazena o nome do treinador, 
 * o numero de pokemon ainda disponiveis para a
 * batalha assim como todos os seus pokemon (max 6). 
 * A classe tambem fornece metodos para fornecer o 
 * nome do treinador e um de seus pokemon em especifico.
 */
public class Treinador {
	private String nome;
	private Pokemon[] pokemon = new Pokemon[6];
	private int numPok;
	public Treinador (String nome, Pokemon[] pokemon) {
		this.nome = nome;
		numPok = 0;
		for(int i = 0; i < 6; i++) {
			this.pokemon[i] = pokemon[i];
			if (pokemon[i] != null) numPok ++;
		}
	}
	//Retorna o nome do Treinador.
	public String getNome() {
		return nome;
	}
	//Retorna o pokemon de numero n de um certo treinador
	//caso exista ou o proximo pokemon nao nulo caso contrario.
	public Pokemon getPokemon (int num) {
		if (pokemon[num-1] != null) return pokemon[(num-1)];
		else {
			for (int i = 0; pokemon[(num + i)] == null; i++) {
				if (pokemon[(num + i)] != null) return pokemon[(num + i)];
				if (num + i == 6) break;
			}
			for (int j = 0; pokemon[j] == null; j++) {
				if (pokemon[j] != null) return pokemon[j];
			}
		}
		return null;
	}
	//Retorna o numero de pokemons ainda aptos para a batalha.
	public int getNumPok() {
		return numPok;
	}
	//Diminui em um o numero de pokemon aptos a batalha.
	public void perdePok() {
		numPok--;
	}
	public Pokemon getNextPokemon() {
		for (int i = 0; i < pokemon.length; i++) {
			if (pokemon[i].getHP() != 0) return pokemon[i];
		}
		return null;
	}
}
