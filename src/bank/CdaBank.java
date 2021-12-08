package bank;

import java.io.Serializable;
import java.util.ArrayList;

import users.User;



public class CdaBank implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -745084407592272815L;
	private static String nom = "CDA Bank";
	private static ArrayList<Agence> listAgences = new ArrayList<Agence>();
	private static ArrayList<User> employeList = new ArrayList<User>();
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
	public static void setEmployeList(ArrayList<User> employeList) {
		CdaBank.employeList = employeList;
	}
	public static ArrayList<User> getEmployeList() {
		return employeList;
	}
}
