package users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import application.SubMenu;
import bank.CdaBank;
import comptes.CompteBancaire;
import util.Util;

public class Client extends User implements Serializable, AutorisationClient {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2715409304858802095L;
	private String login;
	private ArrayList<CompteBancaire> listeComptes = new ArrayList<CompteBancaire>();;
	private boolean isActif = true;
	private String codeAgence;

	public Client(String nom, String prenom, String dateDeNaissance, String adresse, String login) {
		super(nom, prenom, dateDeNaissance, adresse);
		this.id = Util.numClientGenerator();
		this.setLogin(login);
	}

	public boolean verifNombreComptes() {
		try {
			listeComptes.trimToSize();
			if (listeComptes.size() < 3) {
				return true;
			} else {
				return false;
			}
		} catch (java.lang.NullPointerException e) {
			return true;
		}
	}

	public ArrayList<CompteBancaire> getListeComptes() {
		return listeComptes;
	}

	public CompteBancaire getCompte(int i) {
		return listeComptes.get(i);
	}

	public String getCodeAgence() {
		return codeAgence;
	}

	public boolean isActif() {
		return isActif;
	}

	public void setIsActif(boolean isActif) {
		this.isActif = isActif;
	}

	public void setCodeAgence(String codeAgence) {
		this.codeAgence = codeAgence;
	}

	@Override
	public void affichermenu(Scanner in) {
		boolean quitter = false;
		int choice;
		do {
			System.out.println("----------------------------------------------------------------");
			System.out.println("                          Menu Client                           ");
			System.out.println("----------------------------------------------------------------");
			System.out.println(String.format("%-16s", "1. Info Client"));
			System.out.println(String.format("%-16s", "2. Info Comptes"));
			System.out.println(String.format("%-16s", "3. Imprimer fiche Client"));
			System.out.println(String.format("%-16s", "4. Historique Transaction"));
			System.out.println(String.format("%-16s", "5. Virement"));
			System.out.println(String.format("%-16s", "6. Approvisionner"));
			System.out.println(String.format("%-16s", "7. Retirer"));
			System.out.println();
			System.out.println(String.format("%-16s", "0. Quitter l'application CDA BANK"));
			System.out.println("----------------------------------------------------------------");

			choice = Util.verifInput(in);

			switch (choice) {
			case 1:
				System.out.println(infoClient(this));
				break;
			case 2:
				System.out.println(infoComptes(listeComptes));
				break;
			case 3:
				try {
					Util.txtWritter(ficheClient(this));
				} catch (java.lang.NullPointerException e) {
					System.out.println("erreur client introuvable");
					affichermenu(in);
				}
				break;
			case 4:
				SubMenu.historiqueTransaction(in);
				break;
			case 5:
				SubMenu.virerVers(in);
				break;
			case 6:
				SubMenu.approvisionner(in);
				break;
			case 7:
				SubMenu.retirer(in);
				break;
			case 0:
				quitter = true;
				System.out.println("Merci au revoir");
				Util.saveAgence(CdaBank.getListAgences());
				Util.saveEmployee(CdaBank.getEmployeList());
				break;

			default:
				System.out.println("Entrée invalide");
				break;
			}
		} while (!quitter);

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
