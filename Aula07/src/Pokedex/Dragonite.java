package Pokedex;

import Ataques.Blizzard;
import Ataques.Earthquake;
import Ataques.HydroPump;
import Ataques.Wingattack;
import Exercicio01.Ataque;
import Exercicio01.Pokemon;

//http://pokemon.neoseeker.com/wiki/Dragonite
public class Dragonite extends Pokemon {
	private static Ataque atk1 = new HydroPump();
	private static Ataque atk2 = new Wingattack();
	private static Ataque atk3 = new Earthquake();
	private static Ataque atk4 = new Blizzard();
	public Dragonite() {
		super("Dragonite", 91, "dragon", 45, atk1, atk2, atk3, atk4);
	}
}
