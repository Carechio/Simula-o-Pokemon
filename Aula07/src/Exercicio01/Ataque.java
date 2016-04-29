package Exercicio01;

//Implementacao dos ataques de cada pokemon.
abstract public class Ataque {
	private String nome;
	private int dano;
	public Ataque (String nome, int dano) {
		this.nome = nome;
		this.dano = dano;
	}
	//Retorna o dano do ataque.
	public int usaAtaque() {
		return dano;
	}
	//Retorna o nome do ataque.
	public String getNome() {
		return nome;
	}
}
