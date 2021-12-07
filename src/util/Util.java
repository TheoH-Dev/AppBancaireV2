package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import bank.Agence;
import bank.CdaBank;
import comptes.CompteBancaire;
import users.Client;
import users.User;

public class Util implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3009602706825511632L;


	public static CompteBancaire findCompteById(String numCompte) {
		try {
			for (int i = 0; i < CdaBank.getListAgences().size(); i++) {
				Agence agence = CdaBank.getAgence(i);
				for (int j = 0; j < agence.getListClient().size(); j++) {
					Client client = agence.getClient(j);
					for (int k = 0; k < client.getListeComptes().size(); k++) {
						CompteBancaire compte = client.getCompte(k);
						if (compte.getNumDeCompte().equalsIgnoreCase(numCompte)) {
							return compte;

						}
					}
				}
			}
			return null;
		} catch (java.lang.NullPointerException e) {
			return null;
		}
	}

	public static Client findUserById(String numClient) {
		try {
			for (int i = 0; i < CdaBank.getListAgences().size(); i++) {
				Agence agence = CdaBank.getAgence(i);
				for (int j = 0; j < agence.getListClient().size(); j++) {
					Client client = agence.getClient(j);
					if (client.getId().equalsIgnoreCase(numClient)) {
						return client;
					}
				}
			}
			return null;
		} catch (java.lang.NullPointerException e) {
			return null;
		}
	}

	public static Client findClientByName(String nomClient) {
		try {
			for (int i = 0; i < CdaBank.getListAgences().size(); i++) {
				Agence agence = CdaBank.getAgence(i);
				for (int j = 0; j < agence.getListClient().size(); j++) {
					Client client = agence.getClient(j);
					if (client.getNom().equalsIgnoreCase(nomClient)) {
						return client;
					}
				}
			}
			return null;
		} catch (java.lang.NullPointerException e) {
			return null;
		}
	}

	public static Client findClientByCompte(String numCompte) {
		try {
			for (int i = 0; i < CdaBank.getListAgences().size(); i++) {
				Agence agence = CdaBank.getAgence(i);
				for (int j = 0; j < agence.getListClient().size(); j++) {
					Client client = agence.getClient(j);
					for (int k = 0; k < client.getListeComptes().size(); k++) {
						CompteBancaire compte = client.getCompte(k);
						if (compte.getNumDeCompte().equalsIgnoreCase(numCompte)) {
							return client;
						}
					}
				}
			}
			return null;
		} catch (java.lang.NullPointerException e) {
			return null;
		}
	}

	public static Agence findAgenceById(String numAgence) {
		try {
			for (int i = 0; i < CdaBank.getListAgences().size(); i++) {
				Agence agence = CdaBank.getAgence(i);
				if (agence.getCodeAgence().equalsIgnoreCase(numAgence)) {
					return agence;
				}
			}
		} catch (java.lang.NullPointerException e) {
			return null;
		}

		return null;
	}

	public static String numCompteGenerator() {
		boolean idIsDispo = false;
		do {
			String numCompte = UUID.randomUUID().toString().substring(0, 8);
			try {

				if (findCompteById(numCompte).equals(null)) {
					idIsDispo = true;
					return numCompte;
				} else {
					return null;
				}
			} catch (java.lang.NullPointerException e) {
				idIsDispo = true;
				return numCompte;
			}
		} while (!idIsDispo);
	}

	public static String numClientGenerator() {
		boolean idIsDispo = false;
		do {

			String numClient = UUID.randomUUID().toString().substring(0, 10);
			try {
				if (findUserById(numClient).equals(null)) {
					idIsDispo = true;
					return numClient;
				} else {
					return null;
				}
			} catch (java.lang.NullPointerException e) {
				idIsDispo = true;
				return numClient;
			}
		} while (!idIsDispo);
	}
	public static String numConseillerGenerator() {
		boolean idIsDispo = false;
		do {
			
			String numClient = "CO";
			numClient += UUID.randomUUID().toString().substring(0, 4);
			try {
				if (findUserById(numClient).equals(null)) {
					idIsDispo = true;
					return numClient;
				} else {
					return null;
				}
			} catch (java.lang.NullPointerException e) {
				idIsDispo = true;
				return numClient;
			}
		} while (!idIsDispo);
	}
	public static String numAdminGenerator() {
		boolean idIsDispo = false;
		do {
			String numClient = "ADM";
			numClient += UUID.randomUUID().toString().substring(0, 2);
			try {
				if (findUserById(numClient).equals(null)) {
					idIsDispo = true;
					return numClient;
				} else {
					return null;
				}
			} catch (java.lang.NullPointerException e) {
				idIsDispo = true;
				return numClient;
			}
		} while (!idIsDispo);
	}

	public static String numAgenceGenerator() {
		boolean idIsDispo = false;
		do {
			String numAgence = UUID.randomUUID().toString().substring(0, 8);
			try {
				if (findAgenceById(numAgence).equals(null)) {
					idIsDispo = true;
					return numAgence;
				} else {
					return null;
				}
			} catch (java.lang.NullPointerException e) {
				idIsDispo = true;
				return numAgence;
			}
		} while (!idIsDispo);
	}

	public static void txtWritter(String texte) {
		Path path = Paths.get(System.getProperty("user.dir"),"imprime.txt");
		File outFile = new File(path.toString());
		outFile.getParentFile().mkdirs();
		Writer writer;
		try {
			writer = new FileWriter(outFile);

			BufferedWriter br = new BufferedWriter(writer);

			br.write(texte);
			br.flush();
			br.close();
		} catch (IOException e) {
			System.err.println("creation fichier erreur");
			e.printStackTrace();
		}
	}

	public static void save(ArrayList<Agence> listAgence) {
 
        try
        {
            FileOutputStream fos = new FileOutputStream("BankData.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listAgence);
            oos.close();
            fos.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
	}

	public static void readSave() {

		ArrayList<Agence> dataList = new ArrayList<Agence>();
        
        try
        {
            FileInputStream fis = new FileInputStream("BankData.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            dataList = (ArrayList<Agence>) ois.readObject();
 
            ois.close();
            fis.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
            return;
        } 
        catch (ClassNotFoundException c) 
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
         
        //Verify list data
        for (Agence agence : dataList) {
            System.out.println(agence.getCodeAgence());
        }
        CdaBank.setListAgences(dataList);
	}
		
	
	public static ArrayList<Client> nbSameName(String nomClient) {
		ArrayList<Client> list = new ArrayList<Client>();
		try {
			for (int i = 0; i < CdaBank.getListAgences().size(); i++) {
				Agence agence = CdaBank.getAgence(i);
				for (int j = 0; j < agence.getListClient().size(); j++) {
					Client client = agence.getClient(j);
					if (client.getNom().equalsIgnoreCase(nomClient)) {
						list.add(client);
					}
				}
			}
			return list;
		} catch (java.lang.NullPointerException e) {
			return null;
		}
	}
	
	public static int verifInput(Scanner in) {
		int choice=-1;
		do {
			String input = in.next();
			if (input.length() == 1 && Character.isDigit(input.charAt(0))) {
				choice = Character.getNumericValue(input.charAt(0));
			} else {
				System.out.println("choix invalide");
				choice = -1;
			} 
		} while (choice == -1);
		return choice;
	}
}
