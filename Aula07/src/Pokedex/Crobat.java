package Pokedex;

import Ataques.Bite;
import Ataques.Fly;
import Ataques.Quickattack;
import Ataques.Wingattack;
import Exercicio01.Ataque;
import Exercicio01.Pokemon;

//http://pokemon.neoseeker.com/wiki/Crobat
public class Crobat extends Pokemon {
	private static Ataque atk1 = new Quickattack();
	private static Ataque atk2 = new Wingattack();
	private static Ataque atk3 = new Bite();
	private static Ataque atk4 = new Fly();
	public Crobat() {
		super("Crobat", 85, "flying", 90, atk1, atk2, atk3, atk4);
	}
}
