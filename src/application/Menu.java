package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import bank.Agence;
import comptes.CompteBancaire;
import users.Client;
import util.Util;

public class Menu{


	public static void mainMenu() {

		System.out.println("----------------------------------------------------------------");
		System.out.println("                            Menu                                ");
		System.out.println("----------------------------------------------------------------");
		System.out.println(String.format("%-16s", "6. Imprimer Info Client"));
		System.out.println();
		System.out.println(String.format("%-16s", "0. Quitter l'application CDA BANK"));
		System.out.println("----------------------------------------------------------------");

	}

	public static boolean mainMenuChoice(Scanner in) {
		mainMenu();
		boolean quitter = false;
		String codeClient;
		Client client;
		String codeCompte;
		CompteBancaire compte;
		
		
		int choice = verifInput(in);

		
		switch (choice) {
		case 1: // creer client
			try {
				System.out.println("Entrez le code Agence");
				String codeAgence = in.next();
				Agence agence = Util.findAgenceById(codeAgence);
				agence.newClient(in);
				break;
			} catch (java.lang.NullPointerException e) {
				System.out.println("impossible agence introuvable");
				break;
			}
		case 2: // creer compte
			System.out.println("Entrez un code client :");

			try {
				codeClient = in.next();
				client = Util.findUserById(codeClient);
				if (!client.equals(null)) {
					creerCompteMenu();
					int i = creerCompteMenuChoice(in);
					client.ouvrirCompte(i);
				} else {
					System.out.println("Erreur Client introuvable");
				}
			} catch (java.lang.NullPointerException e1) {
				System.out.println("Erreur Client introuvable");
			}
			break;
		case 3: // rechercher compte
			System.out.println("Entrez le N°Compte");
			codeCompte = in.next();
			compte = Util.findCompteById(codeCompte);
			if (compte==null) {
				System.out.println("compte introuvable");
			}else {
				
			System.out.println(compte.infoCompte());
			// afficher menu options comptes(approvisionner virervers etc...
			}
			break;
		case 4: // rechercher client
			rechercheClientMenu();
			rechercheClientMenuChoice(in);
			break;
		case 5: // afficher liste des comptes
			try {
				System.out.println("Entrez un code client : ");
				codeClient = in.next();
				client = Util.findUserById(codeClient);
				System.out.println(client.infoComptes());
			} catch (java.lang.NullPointerException e) {
				System.out.println("Erreur Client introuvable");
			}
			break;
		case 6: // imprimer infoClient
			System.out.println("Entrez un code client : ");
			codeClient = in.next();
			client = Util.findUserById(codeClient);

			try {
				Util.txtWritter(client.ficheClient());
			} catch (java.lang.NullPointerException e) {
				System.out.println("erreur client introuvable");
			}
			break;
		case 0: // Retour
			System.out.println("Merci Au revoir");
			quitter = true;
			break;
		default:
			System.out.println("Choix incorrect!");
			break;
		}
		return quitter;
	}


	private static void creerCompteMenu() {
		System.out.println("----------------------------------------------------------------");
		System.out.println(String.format("%-16s", "1. Compte Courant"));
		System.out.println(String.format("%-16s", "2. Livret A"));
		System.out.println(String.format("%-16s", "3. Plan Epargne Logement"));
		System.out.println("----------------------------------------------------------------");
	}

	private static int creerCompteMenuChoice(Scanner in) {
		int choice = in.nextInt();
		if (choice == 1) {
			return 1;
		} else if (choice == 2) {
			return 2;
		} else if (choice == 3) {
			return 3;
		} else {
			return -1;
		}

	}

	private static void rechercheClientMenu() {
		System.out.println("----------------------------------------------------------------");
		System.out.println(String.format("%-16s", "1. Recherche par Nom"));
		System.out.println(String.format("%-16s", "2. Recherche par N� Compte"));
		System.out.println(String.format("%-16s", "3. Rechercher ID Client"));
		System.out.println("----------------------------------------------------------------");
	}

	private static void rechercheClientMenuChoice(Scanner in) {
		System.out.println("Selectionnez un type de recherche : ");
		int choice=verifInput(in);
		try {
			if (choice == 1) {
				System.out.println("Entrez le nom ");
				String nomClient = in.next();
				ArrayList<Client> sameName = Util.nbSameName(nomClient);
				for (Client client : sameName) {
					System.out.println(client.infoClient());
				}
			} else if (choice == 2) {
				System.out.println("Entrez le N°Compte ");
				String numCompte = in.next();
				Client client = Util.findUserById(numCompte);
				System.out.println(client.infoClient());
			} else if (choice == 3) {
				System.out.println("Entrez l'identifiant ");
				String idClient = in.next();
				Client client = Util.findUserById(idClient);
				System.out.println(client.infoClient());
			} else {
				System.out.println("Choix invalide");
			}
		} catch (java.lang.NullPointerException e) {
			System.err.println("Erreur client introuvable");
		}
	}
	
	private static int verifInput(Scanner in) {
		int choice=-1;
		do {
			String input = in.next();
			if (input.length() == 1 && Character.isDigit(input.charAt(0))) {
				choice = Character.getNumericValue(input.charAt(0));
			} else {
				System.out.println("choix invalide");
				choice = -1;
			} 
		} while (choice == -1);
		return choice;
	}

}
