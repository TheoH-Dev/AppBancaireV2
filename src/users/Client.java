package users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

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
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("                          Menu Client                           ");
		System.out.println("----------------------------------------------------------------");
		System.out.println(String.format("%-16s", "1. Info Client"));
		System.out.println(String.format("%-16s", "2. Info Comptes"));
		System.out.println(String.format("%-16s", "3. Fiche Client"));
		System.out.println(String.format("%-16s", "4. Historique Transaction"));
		System.out.println(String.format("%-16s", "5. Virement"));
		System.out.println(String.format("%-16s", "6. Approvisionner"));
		System.out.println(String.format("%-16s", "7. Retirer"));
		System.out.println();
		System.out.println(String.format("%-16s", "0. Quitter l'application CDA BANK"));
		System.out.println("----------------------------------------------------------------");
		
		
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}



	
}
