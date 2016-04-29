package Pokedex;

import Ataques.Bite;
import Ataques.FireBlast;
import Ataques.FlameThrower;
import Ataques.Stomp;
import Exercicio01.Ataque;
import Exercicio01.Pokemon;

//http://pokemon.neoseeker.com/wiki/Arcanine
public class Arcanine extends Pokemon {
	private static Ataque atk1 = new FlameThrower();
	private static Ataque atk2 = new Bite();
	private static Ataque atk3 = new Stomp();
	private static Ataque atk4 = new FireBlast();
	public Arcanine() {
		super("Arcanine", 90, "fire", 75, atk1, atk2, atk3, atk4);
	}
}
