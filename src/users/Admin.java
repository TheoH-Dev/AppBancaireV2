package users;

import java.util.Scanner;

import util.Util;

public class Admin extends User implements AutorisationAdmin{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6867732814936539727L;

	public Admin(String nom, String prenom, String dateDeNaissance, String adresse, String login) {
		super(nom, prenom, dateDeNaissance, adresse);
		this.id = Util.numAdminGenerator();
		this.login = login;
	
	}

	@Override
	public void affichermenu(Scanner in) {

		System.out.println("----------------------------------------------------------------");
		System.out.println("                           Menu Admin                           ");
		System.out.println("----------------------------------------------------------------");
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
		System.out.println(String.format("%-16s", "12. Creer Agence"));
		System.out.println(String.format("%-16s", "13. Desactiver Client"));
		System.out.println(String.format("%-16s", "14. Desactiver Compte"));
		System.out.println();
		System.out.println(String.format("%-16s", "0. Quitter l'application CDA BANK"));
		System.out.println("----------------------------------------------------------------");
		
	}

}
