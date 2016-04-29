package Pokedex;

import Ataques.Bite;
import Ataques.Blizzard;
import Ataques.HydroPump;
import Ataques.Waterpulse;
import Exercicio01.Ataque;
import Exercicio01.Pokemon;

//http://pokemon.neoseeker.com/wiki/Blastoise
public class Blastoise extends Pokemon {
	private static Ataque atk1 = new HydroPump();
	private static Ataque atk2 = new Waterpulse();
	private static Ataque atk3 = new Blizzard();
	private static Ataque atk4 = new Bite();
	public Blastoise() {
		super("Blastoise", 79, "water", 45, atk1, atk2, atk3, atk4);
	}
}
