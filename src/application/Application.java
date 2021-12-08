package application;

import java.io.Serializable;
import java.util.Scanner;

import bank.Agence;
import bank.CdaBank;
import users.Client;
import users.Conseiller;
import users.User;
import util.Util;

public class Application implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8271931228350969L;

	public static void demarrerApp() {

		Util.readSaveAgence();
		Util.readSaveEmployee();
		//
//		Conseiller conseiller1 = new Conseiller("Hitchcock", "Alfred", "11/11/1111", "Paris", "abc123");
//		CdaBank.getEmployeList().add(conseiller1);
		for (Agence agence : CdaBank.getListAgences()) {
			for (Client client : agence.getListClient()) {
				System.out.println("ID : "+client.getId()+" Login : "+client.getLogin());
			}
		}
		for (User employe : CdaBank.getEmployeList()) {
			System.out.println("ID : "+employe.getId()+" Login : "+employe.getLogin());
		}
		//
		Scanner in = new Scanner(System.in);
		MenuV2.menuLogin(in);
		Util.saveAgence(CdaBank.getListAgences());
		Util.saveEmployee(CdaBank.getEmployeList());
		in.close();
	}
}
