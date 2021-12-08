package main;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

import application.Application;
import bank.Agence;
import bank.CdaBank;
import comptes.CompteCourant;
import users.Admin;
import users.Client;
import users.Conseiller;
import users.User;

public class Main implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8193926418870955482L;

	public static void main(String[] args) {
//		Agence agence1 = new Agence("Bordeaux");
//		CdaBank.getListAgences().add(agence1);
//		Client client1 = new Client("Cao", "Helene", "11/11/1111", "13 Rue de la montagne Roubaix","ABC123");
//		agence1.newClient(client1);
//		CompteCourant compteCourant1 = new CompteCourant(client1);
//		CompteCourant compteCourant2 = new CompteCourant(client1);
//		client1.getListeComptes().add(compteCourant1);
//		client1.getListeComptes().add(compteCourant2);
//		compteCourant1.setSolde(1500);
//		
//		Admin admin1 = new Admin("Hamond", "Theo", "17/03/1998", "13 Rue de truc", "ABC123");
//		CdaBank.getEmployeList().add(admin1);



		Application.demarrerApp();

	}

}
