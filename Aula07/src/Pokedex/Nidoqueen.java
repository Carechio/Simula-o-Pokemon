package Pokedex;

import Ataques.Bite;
import Ataques.Earthquake;
import Ataques.Horndrill;
import Ataques.Megapunch;
import Exercicio01.Ataque;
import Exercicio01.Pokemon;

//http://pokemon.neoseeker.com/wiki/Nidoqueen
public class Nidoqueen extends Pokemon {
	private static Ataque atk1 = new Earthquake();
	private static Ataque atk2 = new Megapunch();
	private static Ataque atk3 = new Horndrill();
	private static Ataque atk4 = new Bite();
	public Nidoqueen() {
		super("Nidoqueen", 90, "ground", 45, atk1, atk2, atk3, atk4);
	}
}

