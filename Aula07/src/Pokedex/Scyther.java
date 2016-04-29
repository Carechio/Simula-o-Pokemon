package Pokedex;

import Ataques.Cut;
import Ataques.Guillotine;
import Ataques.Quickattack;
import Ataques.RazorLeaf;
import Exercicio01.Ataque;
import Exercicio01.Pokemon;

//http://pokemon.neoseeker.com/wiki/Scyther
public class Scyther extends Pokemon {
	private static Ataque atk1 = new Quickattack();
	private static Ataque atk2 = new Cut();
	private static Ataque atk3 = new RazorLeaf();
	private static Ataque atk4 = new Guillotine();
	public Scyther() {
		super("Scyther", 70, "bug", 45, atk1, atk2, atk3, atk4);
	}
}

