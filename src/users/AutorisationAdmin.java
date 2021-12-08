package users;

import java.util.Scanner;

import bank.Agence;
import bank.CdaBank;
import comptes.CompteBancaire;
import util.Util;

public interface AutorisationAdmin extends AutorisationConseiller{
	
	
	public default Agence newAgence(Scanner in) {
		String codeAgence;
		do {
			codeAgence = Util.numAgenceGenerator();
		} while (codeAgence.equals(null));
		System.out.println("Adresse : ");
		String addresse = in.next();
		Agence agence = new Agence(addresse);
		CdaBank.getListAgences().add(agence);
		return agence;
	}
	
	public default void desactiverClient(String idClient) {
		Client client = Util.findClientById(idClient);
		client.setIsActif(false);
		for (CompteBancaire compte : client.getListeComptes()) {
			compte.desactiverCompte();
		}
	}
	public default void desactiverCompte(String numCompte) {
		CompteBancaire compte = Util.findCompteById(numCompte);
		compte.desactiverCompte();
	}
}
