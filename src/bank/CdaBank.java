package bank;

import java.io.Serializable;
import java.util.ArrayList;



public class CdaBank implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -745084407592272815L;
	private static String nom = "CDA Bank";
	private static ArrayList<Agence> listAgences = new ArrayList<Agence>();
	
	public CdaBank(String nom) {
		CdaBank.nom = nom;
	}

	public String getNom() {
		return nom;
	}
	public static ArrayList<Agence> getListAgences() {
		return listAgences;
	}
	public static Agence getAgence(int i) {
		return listAgences.get(i);
	}
	public static void setListAgences(ArrayList<Agence> listAgences) {
		CdaBank.listAgences = listAgences;
	}
}
