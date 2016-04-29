package Exercicio01;

/* A classe Arena tem como responsablidade armazenar os dois Treinadores
 * que estão em batalha, assim como os pokemons que cada um está usando.
 * Os métodos dessa classe fornecem meios de saber qual treinador ou 
 * qual pokemon está na arena no presente momento.
 * Cada Treinador possui turnos para realizar ações. Quando o treinador
 * está no seu turno, ele está ativo. Caso contrário ele está inativo.
 * O campo vencedor permanece null até algum dos treinadores ser declarado 
 * o vencedor da batalha.
 */

public class Arena {
	private Treinador treinador01;
	private Treinador treinador02;
	private Pokemon pokemon01;
	private Pokemon pokemon02;
	private Treinador vencedor;
	
	public Arena (Treinador treinador01, Treinador treinador02, Pokemon pokemon01, Pokemon pokemon02) {
		this.treinador01 = treinador01;
		this.treinador02 = treinador02;
		this.pokemon01 = pokemon01;
		this.pokemon02 = pokemon02;
	}
	
	//Retorna o Pokemon ativo que está na arena.
	public Pokemon getPokemon (int turno) {
		if (turno == 1) {
			return pokemon01;
		}
		else {
			return pokemon02;
		}
	}
	//Altera o Pokemon ativo na arena por um novo Pokemon.
	public void alteraPokemon(Pokemon novo, int turno) {
		if (turno == 1) {
			pokemon01 = novo;
		}
		else {
			pokemon02 = novo;
		}
	}
	//Retorna o Treinador ativo na arena.
	public Treinador getTreinador (int turno) {
		if (turno == 1) {
			return treinador01;
		}
		else {
			return treinador02;
		}
	}
	//Retorna o Treinador inativo na arena.
	public Treinador getTreinadorInat (int turno) {
		if (turno == 1) {
			return treinador02;
		}
		else {
			return treinador01;
		}
	}
	//Retorna o Pokemon inativo na arena.
	public Pokemon getPokemonInat (int turno) {
		if (turno == 1) {
			return pokemon02;
		}
		else {
			return pokemon01;
		}
	}
	//Torna um treinador o vencedor da batalha.
	public void venceu (Treinador vencedor) {
		this.vencedor = vencedor;
	}
	//Retorna o treinador vencedor, caso exista algum.
	public Treinador getVencedor() {
		return vencedor;
	}
}
