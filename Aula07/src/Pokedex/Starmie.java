package Pokedex;

import Ataques.Blizzard;
import Ataques.HydroPump;
import Ataques.Quickattack;
import Ataques.Waterpulse;
import Exercicio01.Ataque;
import Exercicio01.Pokemon;

//http://pokemon.neoseeker.com/wiki/Starmie
public class Starmie extends Pokemon {
	private static Ataque atk1 = new HydroPump();
	private static Ataque atk2 = new Waterpulse();
	private static Ataque atk3 = new Quickattack();
	private static Ataque atk4 = new Blizzard();
	public Starmie() {
		super("Starmie", 60, "water", 60, atk1, atk2, atk3, atk4);
	}
}
