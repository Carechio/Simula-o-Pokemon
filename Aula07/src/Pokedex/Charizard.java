package Pokedex;

import Ataques.DragonRage;
import Ataques.Earthquake;
import Ataques.FlameThrower;
import Ataques.Wingattack;
import Exercicio01.Ataque;
import Exercicio01.Pokemon;

//http://pokemon.neoseeker.com/wiki/Charizard
public class Charizard extends Pokemon {
	private static Ataque atk1 = new FlameThrower();
	private static Ataque atk2 = new Wingattack();
	private static Ataque atk3 = new Earthquake();
	private static Ataque atk4 = new DragonRage();
	public Charizard() {
		super("Charizard", 78, "fire", 45, atk1, atk2, atk3, atk4);
	}
}
