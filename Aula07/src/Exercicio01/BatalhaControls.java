package Exercicio01;

import java.util.Random;
import java.util.Scanner;

import Pokedex.Arcanine;
import Pokedex.Blastoise;
import Pokedex.Charizard;
import Pokedex.Crobat;
import Pokedex.Dragonite;
import Pokedex.Nidoqueen;
import Pokedex.Ratata;
import Pokedex.Raticate;
import Pokedex.Rayquaza;
import Pokedex.Scyther;
import Pokedex.Starmie;

public class BatalhaControls extends Controller{
	
	//O Eveneto Ataque implementa um Ataque do Pokemon Ativo (atacante)
	//sobre o Pokemon inativo (defensor) da Arena.
	private class Ataque extends Event {
		private Pokemon atacante;
		private Pokemon defensor;
		private Arena batalha;
		private int turno;
		private int ataque;
		public Ataque (long eventTime, Arena batalha, int turno, double ataque) {
			super(eventTime);
			atacante = batalha.getPokemon(turno);
			defensor = batalha.getPokemonInat(turno);
			this.batalha = batalha;
			this.turno = turno;
			this.ataque = (int) ((ataque *10)-10);
			if(ataque == 1.0) {
				Random gerador = new Random();
				this.ataque = gerador.nextInt(4) + 1;
			}
		}
		public void action() {
			int def = defensor.getTipo().getCode();
			int atk = atacante.getTipo().getCode();
			double modificador = Type.getMod(atk, def);
			if (modificador == 2.0) System.out.println("Foi super efetivo!");
			if (modificador == 0.5) System.out.println("Nao foi muito efetivo");
			if (modificador == 0.0) System.out.println("O ataque nao surtiu efeito");
			int dano = 0;
			if (ataque == 1) dano = (int) (atacante.getAtaque(1).usaAtaque() * modificador);
			else if (ataque == 2) dano = (int) (atacante.getAtaque(2).usaAtaque() * modificador);
			else if (ataque == 3) dano = (int) (atacante.getAtaque(3).usaAtaque() * modificador);
			// (ataque == 4.0)
			else dano = (int) (atacante.getAtaque(4).usaAtaque() * modificador);
			defensor.levaDano(dano);
			System.out.println(defensor.getNome() +  " tem: " + defensor.getHP() + " de vida");
			if (defensor.getHP() == 0) {
				System.out.println(defensor.getNome() + " esta fora de combate!");
				batalha.getTreinadorInat(turno).perdePok();
				if (batalha.getTreinadorInat(turno).getNumPok() == 0) {
					batalha.venceu(batalha.getTreinador(turno));
					System.out.println("Treinador " + batalha.getVencedor().getNome() + " e' o vencedor da batalha!");
				}
				else {
					//Pokemon fora de combate é substituido.
					int turnoInat;
					if (turno == 1) turnoInat = 2;
					else turnoInat = 1;
					batalha.alteraPokemon(batalha.getTreinadorInat(turno).getNextPokemon(), turnoInat);
					System.out.println("Treinador " + batalha.getTreinadorInat(turno).getNome() + " enviou " + batalha.getPokemonInat(turno).getNome() + " para a batalha.");
				}
			}
		}
		public String description() {
			return atacante.getNome() + " usou " + atacante.getAtaque(ataque).getNome() + " em " + defensor.getNome();
		}
	}
	
	//O Evento UsarItem implementa a utilização de um item de cura (+5 HP)
	//O treinador ativo utiliza o item sobre o Pokemon ativo na Arena.
	private class UsarItem extends Event {
		private Pokemon receptor;
		private int cura = 20;
		public UsarItem (long eventTime, Arena batalha, int turno) {
			super(eventTime);
			receptor = batalha.getPokemon(turno);
		}
		public void action() {
			cura = receptor.curaHP(cura);
			System.out.println(receptor.getNome() + " curou " + cura + " HP \n" + receptor.getNome() + " tem: " + receptor.getHP() + " de vida");
		}
		public String description() {
			if (cura >= 0) {
				return "Treinador usou uma potion";
			}
			else return "";
		}
	}
	
	//O Evento fugir implementa o fim da batalha por desistência.
	//O treinador ativo desiste da batalha e foge.
	private class Fugir extends Event {
		private int turno;
		private Arena batalha;
		public Fugir (long eventTime, Arena batalha, int turno) {
			super(eventTime);
			this.turno = turno;
			this.batalha = batalha;
		}
		public void action() {
			batalha.venceu(batalha.getTreinadorInat(turno));
			System.out.println("Treinador " + batalha.getVencedor().getNome() + " e' o vencedor da batalha!");
		}
		public String description() {
			return "Treinador " + batalha.getTreinador(turno).getNome() + " fugiu";
		}
	}
	
	//O Evento TrocaPokemon implementa a substituicao do pokemon ativo por outro pokemon.
	private class TrocaPokemon extends Event {
		private Pokemon substituido;
		private Pokemon atual;
		private Arena batalha;
		private int turno;
		public TrocaPokemon (long eventTime, Arena batalha, int turno, Pokemon atual) {
			super(eventTime);
			substituido = batalha.getPokemon(turno);
			this.atual = atual;
			this.batalha = batalha;
			this.turno = turno;
		}
		public void action() {
			if (atual != null) batalha.alteraPokemon(atual, turno);
		}
		public String description() {
			if (atual != null) return "Treinador trocou " + substituido.getNome() + " por " + atual.getNome();
			else return "Nao há pokemon para ser trocado";
		}
	}
	
	private class Pokebola extends Event {
		private Pokemon capturado;
		private Treinador apanhador;
		private Arena batalha;
		private int turno;
		public Pokebola (long eventTime, Arena batalha, int turno) {
			super(eventTime);
			capturado = batalha.getPokemonInat(turno);
			apanhador = batalha.getTreinador(turno);
			this.batalha = batalha;
			this.turno = turno;
		}
		public void action(){
			double f = (capturado.getMaxHP()*255*4)/(capturado.getHP()*12);
			int catchRate = capturado.getCatchRate();
			double probabilidade = ((catchRate + 1)*(f + 1))/256;
			Random p = new Random();
			if (batalha.getTreinadorInat(turno).getNome() != "Selvagem") {
				System.out.println(capturado.getNome() + " nao e' um pokemon selvagem.\nPokebola nao surtiu efeito.");
			}
			else {
				if(p.nextDouble() <= probabilidade) {
					System.out.println(capturado.getNome() + " foi capturado com sucesso!");
					batalha.venceu(batalha.getTreinador(turno));
				}
				else {
					System.out.println(capturado.getNome() + " libertou-se!");
				}
			}
		}
		public String description() {
			return apanhador.getNome() + " lancou uma pokebola!";
		}
	}
	
	private class Turno extends Event {
		private Arena batalha;
		private int turno;
		private double acao;
		private long time;
		
		public Turno (long eventTime, Arena batalha, int turno, double acao) {
			super(eventTime);
			time = eventTime;
			this.batalha = batalha;
			this.turno = turno;
			this.acao = acao;
		}
		public void action() {
			if(acao >= 1.0 && acao < 2.0) addEvent(new Ataque(time, batalha, turno, acao));
			if(acao == 2.0) addEvent(new UsarItem(time, batalha, turno));
			if(acao == 2.1) addEvent(new Pokebola(time, batalha, turno));
			if(acao >= 3.0 && acao < 4.0) {
				int numPok = (int) ((acao * 10) - 30);
				addEvent(new TrocaPokemon(time, batalha, turno, batalha.getTreinador(turno).getPokemon(numPok)));
			}
			if(acao == 4.0) addEvent(new Fugir(time, batalha, turno));
		}
		public String description() {
			return batalha.getTreinador(turno).getNome() + ":";
		}
	}
	
	//main controla as acoes utilizadas pelos treinadores turno a turno.
	public static void main(String[] args) {
		
		Charizard charizard = new Charizard();
		Blastoise blastoise = new Blastoise();
		Arcanine arcanine = new Arcanine();
		Raticate raticate = new Raticate();
		Crobat crobat = new Crobat();
		Dragonite dragonite = new Dragonite();
		Nidoqueen nidoqueen = new Nidoqueen();
		Rayquaza rayquaza = new Rayquaza();
		Scyther scyther = new Scyther();
		Starmie starmie = new Starmie();
		
		Pokemon[] pokemonAsh = new Pokemon[6];
		pokemonAsh[0] = charizard;
		pokemonAsh[1] = arcanine;
		pokemonAsh[2] = starmie;
		pokemonAsh[3] = rayquaza;
		pokemonAsh[4] = scyther;
		
		Treinador ash = new Treinador("Ash", pokemonAsh);
		
		Pokemon[] pokemonGary = new Pokemon[6];
		pokemonGary[0] = blastoise;
		pokemonGary[1] = raticate;
		pokemonGary[2] = nidoqueen;
		pokemonGary[3] = crobat;
		pokemonGary[4] = dragonite;
		
		Treinador gary = new Treinador("Gary", pokemonGary);
		
		Arena batalha = new Arena(ash, gary, charizard, blastoise);
		long tm = System.currentTimeMillis();
		
		if (args[0] == "1") {
			BatalhaControls bc = new BatalhaControls();
			System.out.println("Comeca batalha");
			double[] acao1vet = {1.1, 1.2, 3.4, 2.0, 1.1, 1.2, 1.3, 1.4, 1.1, 1.2, 1.3, 1.4};
			double[] acao2vet = {1.1, 3.3, 1.3, 1.3, 1.3, 2.0, 1.3, 1.3, 1.3, 2.0, 1.3, 1.3};
			for (int i = 0; i < acao1vet.length && batalha.getVencedor() == null; i++) {
				System.out.println ("\nNova rodada");
				if (acao1vet[i] <= acao2vet[i]) {
					bc.addEvent(bc.new Turno(tm, batalha, 1, acao1vet[i]));
					bc.run();
					tm += 3000;
					if (batalha.getVencedor() == null) {
						bc.addEvent(bc.new Turno(tm, batalha, 2, acao2vet[i]));
						bc.run();
					}
					tm += 3000;
				}
				else {
					bc.addEvent(bc.new Turno(tm, batalha, 2, acao2vet[i]));
					bc.run();
					tm += 3000;
					if (batalha.getVencedor() == null) {
						bc.addEvent(bc.new Turno(tm, batalha, 1, acao1vet[i]));
						bc.run();
					}
					tm += 3000;
				}
			}
		}
		else {
			Scanner scanner = new Scanner(System.in);
			boolean achouSelvagem = false;
			int semente = 1000;
			while(achouSelvagem == false) {
				int movimento;
				movimento = scanner.nextInt();
				Random r;
				if (movimento == 1) {
					System.out.println("Nothing happened");
					//anda no chao.
					semente += 1000;
				}
				else {
					r = new Random(semente);
					double probabilidade = r.nextDouble();
					System.out.println(probabilidade);
					if(probabilidade > 0.8) {
						achouSelvagem = true;
						Pokemon[] pokemonSelvagem = new Pokemon[6];
						Pokemon ratata = new Ratata();
						pokemonSelvagem[0] = ratata;
						Treinador selvagem = new Treinador("Selvagem", pokemonSelvagem);
						Arena bush = new Arena (ash, selvagem, charizard, ratata); 
						
						BatalhaControls bc = new BatalhaControls();
						System.out.println("Um pokemon selvagem apareceu!");
						double[] acaoSelvagem = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
						double[] acao1vet = {2.1, 2.1, 2.1, 2.1, 1.1, 1.2, 1.3, 1.4, 1.1, 1.2, 1.3, 1.4};
						for (int i = 0; i < acao1vet.length && bush.getVencedor() == null; i++) {
							System.out.println ("\nNova rodada");
							if (acaoSelvagem[i] <= acao1vet[i]) {
								bc.addEvent(bc.new Turno(tm, bush, 2, acaoSelvagem[i]));
								bc.run();
								tm += 3000;
								if (batalha.getVencedor() == null) {
									bc.addEvent(bc.new Turno(tm, bush, 1, acao1vet[i]));
									bc.run();
								}
								tm += 3000;
							}
							else {
								bc.addEvent(bc.new Turno(tm, batalha, 1, acao1vet[i]));
								bc.run();
								tm += 3000;
								if (batalha.getVencedor() == null) {
									bc.addEvent(bc.new Turno(tm, batalha, 2, acaoSelvagem[i]));
									bc.run();
								}
								tm += 3000;
							}
						}
					}
					else {
						System.out.println("Nothing Happened.");
						semente += 1000;
					}
				}
			}
			scanner.close();
		}
	}
}
