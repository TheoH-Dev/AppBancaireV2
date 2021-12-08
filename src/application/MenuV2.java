package application;

import java.util.Scanner;

import users.Admin;
import users.Client;
import users.Conseiller;
import users.User;
import util.Util;

public class MenuV2 {
	public static void menuLogin(Scanner in) {
		boolean correct= false;
		do {
			System.out.println("----------------------------------------------------------------");
			System.out.println("                             Login                              ");
			System.out.println("----------------------------------------------------------------");
			System.out.println();
			System.out.print(String.format("%-16s", "Identifiant : "));
			String id = in.next();
			System.out.print(String.format("%-16s", "Mot de passe : "));
			String mdp = in.next();
			System.out.println();
			System.out.println(String.format("%-16s", "0. Quitter l'application CDA BANK"));
			System.out.println("----------------------------------------------------------------");
			User user;
		
				user = Util.findEmployeById(id);
				if (user == null) {
					user = Util.findClientById(id);					
				}
				if (user==null) {
					System.out.println("Erreur user=null");
				}
			
			try {
				if (user.getLogin().equals(mdp)) {
					if (user instanceof Client) {
						((Client) user).affichermenu(in);
						correct =true;
					} else if (user instanceof Conseiller) {
						((Conseiller) user).affichermenu(in);
						correct = true;
					} else if (user instanceof Admin) {
						((Admin) user).affichermenu(in);
						correct=true;
					}
				} else {
					System.out.println("Identifiant ou mot de passe incorrect");
				}
			} catch (NullPointerException e) {
				System.out.println("Entrée invalide");
			} 
		} while (!correct);

	}
}
