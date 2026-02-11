package application;

import java.util.Scanner;

import entities.Champion;

public class ProgramFight {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String name;
		int life, attack, armor;

		Champion championA, championB;

		System.out.println("Digite os dados do primeiro campeão:");
		System.out.print("Nome: ");
		name = sc.nextLine();
		System.out.print("Vida inicial: ");
		life = sc.nextInt();
		System.out.print("Ataque: ");
		attack = sc.nextInt();
		System.out.print("Armadura: ");
		armor = sc.nextInt();

		championA = new Champion(name, life, attack, armor);

		System.out.println("\nDigite os dados do Segundo campeão:");
		sc.nextLine();
		System.out.print("Nome: ");
		name = sc.nextLine();
		System.out.print("Vida inicial: ");
		life = sc.nextInt();
		System.out.print("Ataque: ");
		attack = sc.nextInt();
		System.out.print("Armadura: ");
		armor = sc.nextInt();

		championB = new Champion(name, life, attack, armor);

		System.out.print("\nQuantos turnos você deseja executar? ");
		int n = sc.nextInt();

		int turn = 0;
		while (turn < n && championA.getLife() != 0 && championB.getLife() != 0) {
			turn++;
			championA.takeDamage(championB);
			championB.takeDamage(championA);

			System.out.println("\nResultado do turno " + turn + ":");
			System.out.println(championA.status());
			System.out.println(championB.status());
		}

		System.out.println("\nFIM DO COMBATE");

		sc.close();

	}

}
