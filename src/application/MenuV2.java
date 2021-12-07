package application;

import java.util.Scanner;

import users.Admin;
import users.Client;
import users.Conseiller;
import users.User;
import util.Util;

public class MenuV2 {
	public static User menuLogin(Scanner in) {
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
		try {
			user = Util.findUserById(id);
		} catch (java.lang.NullPointerException e) {
			System.out.println("identifiant inexistant");
			return null;
		}
		if (user.getLogin().equals(mdp)) {
			if (user instanceof Client) {
				((Client) user).affichermenu();
			}else if (user instanceof Conseiller) {
				((Conseiller) user).affichermenu();
			}else if (user instanceof Admin) {
				((Admin) user).affichermenu();
			}
			return user;
		}else {
			return null;
		}
		
	}
}
