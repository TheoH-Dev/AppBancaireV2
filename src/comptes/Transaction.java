package comptes;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaction implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5412185438959954863L;
	private final LocalDate date;
	private final String origine;
	private final double montant;
	private final String destination;
	
	

	public Transaction(String origine, double montant, String destination) {
		this.origine = origine;
		this.montant = montant;
		this.destination = destination;
		date = LocalDate.now();
	}


	

	public Transaction(String numDeCompte, double montant, CompteBancaire compteDestination) {
		this.origine = numDeCompte;
		this.montant = montant;
		this.destination = compteDestination.getNumDeCompte();
		date = LocalDate.now();
	}
	public String getOrigine() {
		return origine;
	}
	public double getMontant() {
		return montant;
	}
	public String getDestination() {
		return destination;
	}
	public LocalDate getDate() {
		return date;
	}
}
