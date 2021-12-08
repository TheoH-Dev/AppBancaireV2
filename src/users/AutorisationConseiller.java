package users;

import java.util.Scanner;

import bank.Agence;
import bank.CdaBank;
import comptes.CompteBancaire;
import comptes.CompteCourant;
import comptes.LivretA;
import comptes.PlanEpargneLogement;
import util.Util;

public interface AutorisationConseiller extends AutorisationClient{
	
	public default void ouvrirCompte(String idClient, int i) {
		Client client = Util.findClientById(idClient);
		CompteBancaire compte;

		if (client.verifNombreComptes() && i == 1) {
			compte = new CompteCourant(client);
			client.getListeComptes().add(compte);
		} else if (client.verifNombreComptes() && i == 2) {
			compte = new LivretA(client);
			client.getListeComptes().add(compte);
		} else if (client.verifNombreComptes() && i == 3) {
			compte = new PlanEpargneLogement(client);
			client.getListeComptes().add(compte);
		}	else {
			System.out.println("Entrée invalide");
		}
	}

	public default void newClient(String codeAgence, Scanner in) {
		Agence agence = Util.findAgenceById(codeAgence);
		System.out.println("Nom : ");
		String nom = in.next();
		System.out.println("Prenom : ");
		String prenom = in.next();
		System.out.println("Date de naissance : ");
		String dateNaissance = in.next();
		System.out.println("Adresse : ");
		String adresse = in.next();
		System.out.println("Login : ");
		String login = in.next();
		Client client = new Client(nom, prenom, dateNaissance, adresse, login);
		client.setCodeAgence(codeAgence);
		agence.getListClient().add(client);
	}

	public default void modifAdresse(String idClient, String newAdresse) {
			Client client = Util.findClientById(idClient);
			client.setAdresse(newAdresse);
		}
	public default void modifInfo(Scanner in, String idClient) {
			System.out.println("Nom : ");
			String nom = in.next();
			System.out.println("Prenom : ");
			String prenom = in.next();
			System.out.println("Date de naissance : ");
			String dateNaissance = in.next();
			System.out.println("Adresse : ");
			String adresse = in.next();
			Client client = Util.findClientById(idClient);
			System.out.println("Login : ");
			String login = in.next();
			client.setNom(nom);
			client.setPrenom(prenom);
			client.setDateDeNaissance(dateNaissance);
			client.setAdresse(adresse);
			client.setLogin(login);
		}
}
