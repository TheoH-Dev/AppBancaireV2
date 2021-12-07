package bank;

import java.io.Serializable;
import java.util.ArrayList;

import users.Client;
import util.Util;

public class Agence implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4066617186048717040L;
	private String codeAgence;
	private String adresse;
	private ArrayList<Client> listClient = new ArrayList<Client>(1);
	
	public Agence(String adresse) {
		this.codeAgence = Util.numAgenceGenerator();
		this.adresse = adresse;
	}
	

	public void newClient(Client client) {
		client.setCodeAgence(codeAgence);
		listClient.add(client);
	}
	
	public ArrayList<Client> getListClient() {
		return listClient;
	}
	public Client getClient(int i) {
		return listClient.get(i);
	}
	public String getCodeAgence() {
		return codeAgence;
	}
	public String getAdresse() {
		return adresse;
	}



}
