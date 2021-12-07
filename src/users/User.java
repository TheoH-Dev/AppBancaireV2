package users;

import java.io.Serializable;

public abstract class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4068702254740042044L;
	protected String nom;
	protected String prenom;
	protected String dateDeNaissance;
	protected String adresse;
	protected String id;
	protected String login;
	
	

	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}


	public void setId(String id) {
		this.id = id;
	}


	public User(String nom, String prenom, String dateDeNaissance, String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
	}
	

	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getDateDeNaissance() {
		return dateDeNaissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public String getId() {
		return id;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	
	
	

}
