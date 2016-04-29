package Exercicio01;

/* A classe Pokemon armaena nome, HP atual, HP máximo e tipo do pokemon. Metodos para manipular HP,
 * fornecer nome ou tipo e os ataques do pokemon.
 */
abstract public class Pokemon {
	private String  nome;
	private int HP;
	private int maxHP;
	private Type tipo;
	private int catchRate;
	private Ataque atk1 = null;
	private Ataque atk2 = null;
	private Ataque atk3 = null;
	private Ataque atk4 = null;
	public Pokemon (String nome, int HP, String tipo, int catchRate, Ataque atk1) {
		this.nome = nome;
		this.HP = HP;
		maxHP = HP;
		this.tipo = new Type(tipo);
		this.atk1 = atk1;
		this.catchRate = catchRate;
	}
	public Pokemon (String nome, int HP, String tipo, int catchRate, Ataque atk1, Ataque atk2) {
		this.nome = nome;
		this.HP = HP;
		maxHP = HP;
		this.tipo = new Type(tipo);
		this.atk1 = atk1;
		this.atk2 = atk2;
	}
	public Pokemon (String nome, int HP, String tipo, int catchRate, Ataque atk1, Ataque atk2, Ataque atk3) {
		this.nome = nome;
		this.HP = HP;
		maxHP = HP;
		this.tipo = new Type(tipo);
		this.atk1 = atk1;
		this.atk2 = atk2;
		this.atk3 = atk3;
	}
	public Pokemon (String nome, int HP, String tipo, int catchRate, Ataque atk1, Ataque atk2, Ataque atk3, Ataque atk4) {
		this.nome = nome;
		this.HP = HP;
		maxHP = HP;
		this.tipo = new Type(tipo);
		this.atk1 = atk1;
		this.atk2 = atk2;
		this.atk3 = atk3;
		this.atk4 = atk4;
	}
	//Reduz a vida do pokemon que recebeu um certo dano. A vida
	//de um pokemon nao pode ser negativa.
	public void levaDano (int dano) {
		if ((HP - dano) >= 0) HP -= dano;
		else HP = 0;
	}
	//Recupera a vida de um pokemon em um valor maximo igual a
	//"cura". O HP de um pokemon nunca pode ultrapassar seu maxHP.
	//Pokemon fora de batalha nao pode ser curado. Retorna o valor curado.
	public int curaHP (int cura) {
		if ((HP + cura) <= maxHP && HP != 0) {
			HP += cura;
			return cura;
		}
		if (HP == 0) return -1;
		else {
			int curaReal = maxHP - HP;
			HP = maxHP;
			return curaReal;
		}
	}
	//Retorna o nome do Pokemon.
	public String getNome() {
		return nome;
	}
	//Retorna o tipo do Pokemon.
	public Type getTipo() {
		return tipo;
	}
	//Retornao HP atual do Pokemon.
	public int getHP() {
		return HP;
	}
	//Retorna o HP maximo do Pokemon.
	public int getMaxHP() {
		return maxHP;
	}
	public Ataque getAtaque(int num) {
		if(num == 1 && atk1 != null) return atk1;
		if(num == 2 && atk2 != null) return atk2;
		if(num == 3 && atk3 != null) return atk3;
		if(num == 4 && atk4 != null) return atk4;
		for (int i = 1; i <= 4; i++) {
			if(i == 1 && atk1 != null) return atk1;
			if(i == 2 && atk2 != null) return atk2;
			if(i == 3 && atk3 != null) return atk3;
			if(i == 4 && atk4 != null) return atk4;
		}
		return null;
	}
	public int getCatchRate() {
		return catchRate;
	}
}
