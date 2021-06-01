
import java.util.Random;

public class Batalha {
	public boolean vencedor = false;
	public boolean vez_atacar = false;
	
	Random num_generator = new Random();
	
	// Definindo atributos dos monstros
	

	public static void main(String[] args) {
		Batalha partida = new Batalha();
		
		Monstro primeiro, segundo;
				
		Monstro monstro1 = new Monstro();
		Monstro monstro2 = new Monstro();

		monstro1.setNome("Pablito");
		monstro2.setNome("Joãozin");
		
		System.out.println(monstro1.getNome() + " x " + monstro2.getNome());
		System.out.println("A batalha já irá começar.");
		
		int ver = partida.num_generator.nextInt(2);
		
		if (ver == 1) {
			primeiro = monstro1;
			segundo = monstro2;
		} else {
			primeiro = monstro2;
			segundo = monstro1;
		}
		
		do {
			if (partida.vez_atacar == false) {
				System.out.println("Sua vez: " + segundo.getNome());
				partida.attack(primeiro);
				partida.vez_atacar = true;
			} else {
				System.out.println("Sua vez: " + primeiro.getNome());
				partida.attack(segundo);
				partida.vez_atacar = false;
			}
			
			partida.check_ganhou(primeiro, segundo, partida);
			
		} while (!partida.vencedor);
		
		System.out.println("Encerrando Batalha.");
	
	}
	
	public void check_ganhou(Monstro monstro1, Monstro monstro2, Batalha partida) {
		int life_1 = monstro1.getLife();
		int life_2 = monstro2.getLife();
		if (life_1 <= 0) {
			String nomeVencedor = monstro2.getNome();
			System.out.println(nomeVencedor + " é o vencedor, parabéns!");
			partida.vencedor = true;
		} else if (life_2 <= 0) {
			String nomeVencedor = monstro1.getNome();
			System.out.println(nomeVencedor + " é o vencedor, parabéns!");
			partida.vencedor = true;
		}
		
	}
	
	public void attack(Monstro oponente) {
		int attack_value = num_generator.nextInt(15);
		int defense_value = num_generator.nextInt(20);
		int damage = defense_value - attack_value;
		
		if (damage > 0) {
			int oponent_life = oponente.getLife();
			oponente.setLife(oponent_life - damage);
			System.out.println(oponente.getNome() + " Levou " + damage + " de dano e ficou com " + oponente.getLife() + " de HP");
		} else {
			System.out.println(oponente.getNome() + " defendeu o attack.");
		}
	}

}
