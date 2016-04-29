package Pokedex;

import Ataques.Quickattack;
import Ataques.Scratch;
import Ataques.Tackle;
import Exercicio01.Ataque;
import Exercicio01.Pokemon;

//http://pokemon.neoseeker.com/wiki/Rattata
public class Ratata extends Pokemon {
	private static Ataque atk1 = new Quickattack();
	private static Ataque atk2 = new Tackle();
	private static Ataque atk3 = new Scratch();
	public Ratata() {
		super("Ratata", 30, "normal", 255, atk1, atk2, atk3);
	}
}
