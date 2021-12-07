package users;

import java.awt.Choice;
import java.util.Scanner;

import util.Util;

public class Conseiller extends User implements AutorisationConseiller{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5520206114601144113L;

	public Conseiller(String nom, String prenom, String dateDeNaissance, String adresse, String login) {
		super(nom, prenom, dateDeNaissance, adresse);
		this.id = Util.numConseillerGenerator();
		this.login = login;
	}

	@Override
	public void affichermenu(Scanner in) {

		do {
			System.out.println("----------------------------------------------------------------");
			System.out.println("                        Menu Conseiller                         ");
			System.out.println("----------------------------------------------------------------");
			System.out.println(String.format("%-16s", "3. Rechercher Compte"));
			System.out.println(String.format("%-16s", "4. Rechercher Client"));
			System.out.println(String.format("%-16s", "1. Info Client"));
			System.out.println(String.format("%-16s", "2. Info Comptes"));
			System.out.println(String.format("%-16s", "3. Fiche Client"));
			System.out.println(String.format("%-16s", "4. Historique Transaction"));
			System.out.println(String.format("%-16s", "5. Virement"));
			System.out.println(String.format("%-16s", "6. Approvisionner"));
			System.out.println(String.format("%-16s", "7. Retirer"));
			System.out.println(String.format("%-16s", "8. Creer Compte"));
			System.out.println(String.format("%-16s", "9. Creer Client"));
			System.out.println(String.format("%-16s", "10. Modifier Adresse"));
			System.out.println(String.format("%-16s", "11. Modifier Infos"));
			System.out.println();
			System.out.println(String.format("%-16s", "0. Quitter l'application CDA BANK"));
			System.out.println("----------------------------------------------------------------");
			int choi
		} while (Choice = 0);
		
	}

}
