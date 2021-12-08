package application;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import comptes.CompteBancaire;
import users.Client;
import util.Util;

public interface SubMenu {

	public static void findCompteByid(Scanner in) {
		String codeCompte;
		CompteBancaire compte;
		System.out.println("Entrez le N°Compte");
		codeCompte = in.next();
		compte = Util.findCompteById(codeCompte);
		if (compte==null) {
			System.out.println("Compte introuvable");
		}else {
			System.out.println(compte.infoCompte());
		}
	}
	
	static void rechercheClientMenu(Scanner in) {
		System.out.println("----------------------------------------------------------------");
		System.out.println(String.format("%-16s", "1. Recherche par Nom"));
		System.out.println(String.format("%-16s", "2. Recherche par N� Compte"));
		System.out.println(String.format("%-16s", "3. Rechercher ID Client"));
		System.out.println("----------------------------------------------------------------");
	
		
		System.out.println("Selectionnez un type de recherche : ");
		int choice = Util.verifInput(in);
		try {
			if (choice == 1) {
				System.out.println("Entrez le nom ");
				String nomClient = in.next();
				ArrayList<Client> sameName = Util.nbSameName(nomClient);
				for (Client client : sameName) {
					System.out.println(client.infoClient(client));
				}
			} else if (choice == 2) {
				System.out.println("Entrez le N°Compte ");
				String numCompte = in.next();
				Client client = Util.findClientById(numCompte);
				System.out.println(client.infoClient(client));
			} else if (choice == 3) {
				System.out.println("Entrez l'identifiant ");
				String idClient = in.next();
				Client client = Util.findClientById(idClient);
				System.out.println(client.infoClient(client));
			} else {
				System.out.println("Choix invalide");
			}
		} catch (java.lang.NullPointerException e) {
			System.err.println("Erreur client introuvable");
		}
	}
	static int creerCompteMenu(Scanner in) {
		System.out.println("----------------------------------------------------------------");
		System.out.println(String.format("%-16s", "1. Compte Courant"));
		System.out.println(String.format("%-16s", "2. Livret A"));
		System.out.println(String.format("%-16s", "3. Plan Epargne Logement"));
		System.out.println("----------------------------------------------------------------");
	
		int choice = Util.verifInput(in);
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
	
	static void infoClient(Scanner in) {
		String idClient;
		Client client;
		try {
			System.out.println("Entrez un code client : ");
			idClient = in.next();
			client = Util.findClientById(idClient);
			System.out.println(client.infoClient(client));
		} catch (java.lang.NullPointerException e) {
			System.out.println("Erreur Client introuvable");
		}
	}

	static void infoComptes(Scanner in) {
		String idClient;
		Client client;
		try {
			System.out.println("Entrez un code client : ");
			idClient = in.next();
			client = Util.findClientById(idClient);
			System.out.println(client.infoComptes(client.getListeComptes()));
		} catch (java.lang.NullPointerException e) {
			System.out.println("Erreur Client introuvable");
		}
	}

	public static void ficheClient(Scanner in) {
		String idClient;
		Client client;
		try {
			System.out.println("Entrez un code client : ");
			idClient = in.next();
			client = Util.findClientById(idClient);
			System.out.println(client.ficheClient(client));
		} catch (java.lang.NullPointerException e) {
			System.out.println("Erreur Client introuvable");
		}
	}

	public static void historiqueTransaction(Scanner in) {
		String codeCompte;
		CompteBancaire compte;
		System.out.println("Entrez le N°Compte");
		codeCompte = in.next();
		compte = Util.findCompteById(codeCompte);
		if (compte==null) {
			System.out.println("Compte introuvable");
		}else {
			System.out.println(compte.getProprietaire().releveCompte(compte.getNumDeCompte()));
		}
		
	}

	
	public static void virerVers(Scanner in) {
		String numCompteOrigine;
		CompteBancaire compteOrigine;
		String numCompteDestination;
		Double montant;
		System.out.println("Entrez le numero du compte d'origine : ");
		numCompteOrigine = in.next();
		compteOrigine = Util.findCompteById(numCompteOrigine);
		if (compteOrigine==null) {
			System.out.println("Compte introuvable (Si tu n'as pas les \n"
					+ "numero de comptes tu devra te login a nouveau petit Bug...)");

		}
		System.out.println("Entrez le numero du compte de destination : ");
		numCompteDestination = in.next();
		try {
			System.out.println("Entre le montant : ");
			montant = in.nextDouble();
		} catch (InputMismatchException exep) {
			System.out.println("Montant invalide");
			montant=(double) 0;
		}
		compteOrigine.getProprietaire().virerVers(numCompteOrigine, numCompteDestination, montant);
	}

	public static void approvisionner(Scanner in) {
		String numCompte;
		CompteBancaire compte;
		System.out.println("Entrez le N°Compte : ");
		numCompte = in.next();
		compte = Util.findCompteById(numCompte);
		if (compte==null) {
			System.out.println("Compte introuvable");
		}else {
			System.out.println("Entrez le montant : ");
			double montant = in.nextDouble();
			compte.getProprietaire().approvisionner(numCompte, montant);
		}
	}

	public static void retirer(Scanner in) {
		String numCompte;
		CompteBancaire compte;
		System.out.println("Entrez le N°Compte : ");
		numCompte = in.next();
		compte = Util.findCompteById(numCompte);
		if (compte==null) {
			System.out.println("Compte introuvable");
		}else {
			System.out.println("Entrez le montant : ");
			double montant = in.nextDouble();
			compte.getProprietaire().retirer(numCompte, montant);
		}
	}


}
