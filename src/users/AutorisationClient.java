package users;

import java.util.ArrayList;
import java.util.Scanner;

import comptes.CompteBancaire;
import comptes.Transaction;
import util.Util;

public interface AutorisationClient {

	
	public default String ficheClient(Client client) {
		return infoClient(client) + "\n" + infoComptes(client.getListeComptes());
	}

	public default String infoComptes(ArrayList<CompteBancaire> listeComptes) {
		String chaine = "";

		for (CompteBancaire compte : listeComptes) {
			chaine += compte.infoCompte();
		}
		return "----------------------------------------------------------------\n" + "Liste des comptes \n"
				+ "----------------------------------------------------------------\n"
				+ String.format("%-16s", "N° Compte") + String.format("%-16s", "Type")
				+ String.format("%-16s", "Solde") + String.format("%-16s", "Situation") + "\n" + chaine
				+ "----------------------------------------------------------------\n";

	}

	public default String infoClient(Client client) {
		return "----------------------------------------------------------------" + "\n" + 
				"Numero Client : "+ client.getId() + "\n" + 
				"Nom : " + client.getNom() + "\n" + 
				"Prenom : " + client.getPrenom() + "\n"+ 
				"Date de naissance : " + client.getDateDeNaissance() + "\n" + 
				"Adresse : " + client.getAdresse() + "\n"+ 
				"Numero Agence : " + client.getCodeAgence() + "\n"
				+ "----------------------------------------------------------------" + "\n";
	}

	public default String releveCompte(String numCompte) {
		CompteBancaire compte = util.Util.findCompteById(numCompte);
		String chaine = String.format("%-16s", "Date") + String.format("%-16s", "Origine")
				+ String.format("%-16s", "Montant") + String.format("%-16s", "Destinataire") + "\n"
				+ "----------------------------------------------------------------\n";
		for (Transaction transaction : compte.getHistoriqueTransactions()) {
			chaine += String.format("%-16s", transaction.getDate()) + String.format("%-16s", transaction.getOrigine())
					+ String.format("%-16s", transaction.getMontant())
					+ String.format("%-16s", transaction.getDestination()) + "\n";
		}
		return chaine;
	}

	public default void virerVers(String numCompteOrigine,String numCompteDestination, double montant) {
		CompteBancaire compteOrigine = Util.findCompteById(numCompteOrigine);
		CompteBancaire compteDestination = Util.findCompteById(numCompteDestination);
		
		
		
		if (verifDebitOrigine(montant, compteOrigine) && verifCreditDestination(compteDestination)) {
			Transaction virement = new Transaction(numCompteOrigine, montant, numCompteDestination);
			compteOrigine.setSolde(compteOrigine.getSolde()-montant) ;
			compteDestination.setSolde(compteOrigine.getSolde()+montant);
			compteOrigine.getHistoriqueTransactions().add(virement);
			compteDestination.getHistoriqueTransactions().add(virement);
		}
	}

	public default boolean verifCreditDestination(CompteBancaire compteDestination) {
		return compteDestination.isActif() && compteDestination.getProprietaire().isActif();
	}

	public default boolean verifDebitOrigine(double montant, CompteBancaire compteOrigine) {
		boolean verifOrigine = 	compteOrigine.getProprietaire().isActif() && compteOrigine.isActif() &&
								compteOrigine.getSolde()>=montant && !compteOrigine.getDecouvertAutorise() ||
								compteOrigine.getProprietaire().isActif() && compteOrigine.isActif() && 
								compteOrigine.getSolde()+compteOrigine.getMaxDecouvert()>=montant && compteOrigine.getDecouvertAutorise();
		return verifOrigine;
	}
	
	public default void approvisionner(String numCompteDestination, double montant) {
		CompteBancaire compte = Util.findCompteById(numCompteDestination);
		if (verifCreditDestination(compte)) {
			compte.setSolde(compte.getSolde()+montant);
			compte.getHistoriqueTransactions().add(new Transaction("", montant, numCompteDestination));
		}
	}
	public default void retirer(String numCompteOrigine, int montant) {
		CompteBancaire compte = Util.findCompteById(numCompteOrigine);
		if (verifDebitOrigine(montant, compte)) {
			compte.setSolde(compte.getSolde()-montant);
			compte.getHistoriqueTransactions().add(new Transaction(numCompteOrigine, montant * -1, ""));
		}
	}
	
	public void affichermenu(Scanner in);
}
