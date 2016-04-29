package Pokedex;

import Ataques.Hyperfang;
import Ataques.Quickattack;
import Ataques.Scratch;
import Ataques.Tackle;
import Exercicio01.Ataque;
import Exercicio01.Pokemon;

//http://pokemon.neoseeker.com/wiki/Raticate
public class Raticate extends Pokemon {
	private static Ataque atk1 = new Hyperfang();
	private static Ataque atk2 = new Quickattack();
	private static Ataque atk3 = new Tackle();
	private static Ataque atk4 = new Scratch();
	public Raticate() {
		super("Raticate", 55, "normal", 127, atk1, atk2, atk3, atk4);
	}
}

