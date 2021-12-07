package comptes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import users.Client;
import util.Util;

public abstract class CompteBancaire implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4077560286391687512L;
	protected final LocalDate dateCreation = LocalDate.now();
	protected String numDeCompte;
	protected String codeAgence;
	protected Client proprietaire;
	protected boolean decouvertAutorise = false;
	protected int maxDecouvert = 0;
	protected ArrayList<Transaction> historiqueTransactions = new ArrayList<Transaction>();
	protected double solde = 0;
	protected double fraisDeCompte = 25;
	protected boolean Actif = true;

	public CompteBancaire(Client proprietaire, String codeAgence) {
		this.numDeCompte = Util.numCompteGenerator();
		this.codeAgence = codeAgence;
		this.proprietaire = proprietaire;
	}

	public abstract void fraisDeCompte();




	public String infoCompte() {
		String chaine = "";

		chaine += String.format("%-16s", numDeCompte);

		if (this instanceof CompteCourant) {
			chaine += String.format("%-16s", "Courant");
		} else if (this instanceof LivretA) {
			chaine += String.format("%-16s", "Livret A");
		} else if (this instanceof PlanEpargneLogement) {
			chaine += String.format("%-16s", "PEL");
		}

		chaine += String.format("%-16s", solde);

		if (solde >= 0) {
			chaine += String.format("%-16s", ":-)") + "\n";
		} else {
			chaine += String.format("%-16s", ":-(") + "\n";
		}

		return chaine + "\n";

	}
	
	public double getFraisDeCompte() {
		return fraisDeCompte;
	}
	public Client getProprietaire() {
		return proprietaire;
	}
	public String getNumDeCompte() {
		return numDeCompte;
	}
	public double getSolde() {
		return solde;
	}
	public boolean getDecouvertAutorise() {
		return decouvertAutorise;
	}
	public ArrayList<Transaction> getHistoriqueTransactions() {
		return historiqueTransactions;
	}
	public boolean isActif() {
		return Actif;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
	public void setDecouvertAutorise(boolean decouvertAutorise, int maxDecouvert) {
		this.decouvertAutorise = decouvertAutorise;
		this.maxDecouvert=maxDecouvert;
	}
	public void setCodeAgence(String codeAgence) {
		this.codeAgence = codeAgence;
	}
	
	public int getMaxDecouvert() {
		return maxDecouvert;
	}

	public void desactiverCompte() {
		Actif = false;
	}

}
