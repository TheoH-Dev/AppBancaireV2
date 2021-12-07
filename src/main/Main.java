package main;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

import application.Application;
import bank.Agence;
import bank.CdaBank;
import comptes.CompteCourant;
import users.Client;

public class Main implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8193926418870955482L;

	public static void main(String[] args) {
		
//		Agence agence1 = new Agence("Bordeaux");
//		CdaBank.newAgence(agence1);
//		Client client1 = new Client("Hamond", "Theo", "17/03/1998", "13 Rue de la montagne 33600 Bordeaux");
//		agence1.newClient(client1);
//		CompteCourant compteCourant1 = new CompteCourant(client1);
//		CompteCourant compteCourant2 = new CompteCourant(client1);
//		client1.ouvrirCompte(compteCourant1);
//		client1.ouvrirCompte(compteCourant2);
//		compteCourant1.approvisionner(1500);
//		compteCourant1.retirer(300);
//		compteCourant1.virerVers(compteCourant2, 200);
//		System.out.println(compteCourant1.historiqueCompte());
//		System.out.println(compteCourant2.historiqueCompte());
		Application.demarrerApp();
		System.out.println(System.getProperty("user.home")+"\\");
		Path path = Paths.get(System.getProperty("user.dir"),"imprime.txt");
		System.out.println(path);
	}

}
