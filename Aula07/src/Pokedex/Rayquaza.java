package Pokedex;

import Ataques.DragonRage;
import Ataques.Fly;
import Ataques.Quickattack;
import Ataques.Rage;
import Exercicio01.Ataque;
import Exercicio01.Pokemon;

//http://pokemon.neoseeker.com/wiki/Rayquaza
public class Rayquaza extends Pokemon {
	private static Ataque atk1 = new Quickattack();
	private static Ataque atk2 = new DragonRage();
	private static Ataque atk3 = new Fly();
	private static Ataque atk4 = new Rage();
	public Rayquaza() {
		super("Rayquaza", 105, "dragon", 3, atk1, atk2, atk3, atk4);
	}
}

