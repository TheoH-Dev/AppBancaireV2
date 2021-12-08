package users;

import java.io.Serializable;
import java.util.Scanner;

import application.SubMenu;
import bank.Agence;
import bank.CdaBank;
import util.Util;

public class Admin extends User implements Serializable, AutorisationAdmin{

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
		boolean quitter = false;
		int choice;
		do {
			System.out.println("----------------------------------------------------------------");
			System.out.println("                           Menu Admin                           ");
			System.out.println("----------------------------------------------------------------");
			System.out.println(String.format("%-16s", "1. Rechercher Compte"));
			System.out.println(String.format("%-16s", "2. Rechercher Client"));
			System.out.println(String.format("%-16s", "3. Info Client"));
			System.out.println(String.format("%-16s", "4. Info Comptes"));
			System.out.println(String.format("%-16s", "5. Fiche Client"));
			System.out.println(String.format("%-16s", "6. Historique Transaction"));
			System.out.println(String.format("%-16s", "7. Virement"));
			System.out.println(String.format("%-16s", "8. Approvisionner"));
			System.out.println(String.format("%-16s", "9. Retirer"));
			System.out.println(String.format("%-16s", "10. Creer Compte"));
			System.out.println(String.format("%-16s", "11. Creer Client"));
			System.out.println(String.format("%-16s", "12. Modifier Adresse"));
			System.out.println(String.format("%-16s", "13. Modifier Infos"));
			System.out.println(String.format("%-16s", "14. Creer Agence"));
			System.out.println(String.format("%-16s", "15. Desactiver Client"));
			System.out.println(String.format("%-16s", "16. Desactiver Compte"));
			System.out.println();
			System.out.println(String.format("%-16s", "0. Quitter l'application CDA BANK"));
			System.out.println("----------------------------------------------------------------");
			choice = Util.verifInput(in);

			String idClient;
			Client client;

			switch (choice) {
			case 1:
				SubMenu.findCompteByid(in);
				break;
			case 2:
				SubMenu.rechercheClientMenu(in);
				break;
			case 3:
				SubMenu.infoClient(in);
				break;
			case 4:
				SubMenu.infoComptes(in);
				break;
			case 5:
				SubMenu.ficheClient(in);
				break;
			case 6:
				SubMenu.historiqueTransaction(in);
				break;
			case 7:
				SubMenu.virerVers(in);
				break;
			case 8:
				SubMenu.approvisionner(in);
				break;
			case 9:
				SubMenu.retirer(in);
				break;
			case 10:

				System.out.println("Entrez un code client :");

				try {
					idClient = in.next();
					client = Util.findClientById(idClient);
					if (!client.equals(null)) {
						int i = SubMenu.creerCompteMenu(in);
						ouvrirCompte(idClient, i);
					} else {
						System.out.println("Erreur Client introuvable");
					}
				} catch (java.lang.NullPointerException e1) {
					System.out.println("Erreur Client introuvable");
					affichermenu(in);
				}

				break;
			case 11:
				try {
					System.out.println("Entrez le code Agence");
					String codeAgence = in.next();
					Util.findAgenceById(codeAgence);
					newClient(codeAgence, in);
					break;
				} catch (java.lang.NullPointerException e) {
					System.out.println("impossible agence introuvable");
					affichermenu(in);
					break;
				}
			case 12:
				try {
					System.out.println("Entrez un code client : ");
					idClient = in.next();
					client = Util.findClientById(idClient);
					String newAdresse = in.next();
					modifAdresse(idClient, newAdresse);
					;
				} catch (java.lang.NullPointerException e) {
					System.out.println("Erreur Client introuvable");
					affichermenu(in);
				}
				break;
			case 13:
				try {
					System.out.println("Entrez un code client : ");
					idClient = in.next();
					client = Util.findClientById(idClient);
					modifInfo(in, idClient);
				} catch (java.lang.NullPointerException e) {
					System.out.println("Erreur Client introuvable");
					affichermenu(in);
				}
				break;
			case 14:
				Agence agence = newAgence(in);
				System.out.println("Nouvelle agence cree son code est : "+ agence.getCodeAgence());
				break;
			case 15:
				try {
					System.out.println("Entrez un code client : ");
					idClient = in.next();
					Util.findClientById(idClient);
					desactiverClient(idClient);
				} catch (java.lang.NullPointerException e) {
					System.out.println("Erreur Client introuvable");
					affichermenu(in);
				}
				
				break;
			case 16:
				try {
					System.out.println("Entrez un numero de compte : ");
					String numCompte = in.next();
					Util.findCompteById(numCompte);
					desactiverCompte(numCompte);
				} catch (java.lang.NullPointerException e) {
					System.out.println("Erreur Client introuvable");
					affichermenu(in);
				}
				break;
			case 0:
				quitter = true;
				System.out.println("Merci au revoir");
				Util.saveAgence(CdaBank.getListAgences());
				Util.saveEmployee(CdaBank.getEmployeList());
				break;
			default:
				System.out.println("Entrée invalide");
				affichermenu(in);
				break;
			}
		} while (!quitter);
	}

}
