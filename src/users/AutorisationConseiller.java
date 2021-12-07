package users;

import java.util.Scanner;

import bank.Agence;
import comptes.CompteBancaire;
import comptes.CompteCourant;
import comptes.LivretA;
import comptes.PlanEpargneLogement;
import util.Util;

public interface AutorisationConseiller extends AutorisationClient{
	
	public default void ouvrirCompte(String idClient, int i) {
		Client client = Util.findUserById(idClient);
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
		agence.getListClient().add(client);
		client.setCodeAgence(codeAgence);
	}

		public default void modifAdresse(String idClient, String newAdresse) {
			Client client = Util.findUserById(idClient);
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
			Client client = Util.findUserById(idClient);
			System.out.println("Login : ");
			String login = in.next();
			client.setNom(nom);
			client.setPrenom(prenom);
			client.setDateDeNaissance(dateNaissance);
			client.setAdresse(adresse);
			client.setLogin(login);
		}
}
