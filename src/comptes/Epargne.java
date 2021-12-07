package comptes;

import users.Client;

public abstract class Epargne extends CompteBancaire{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6758493067429554333L;
	protected double taxeEpargne;
	
	public Epargne(Client proprietaire) {
		super(proprietaire, proprietaire.getCodeAgence());
		this.fraisDeCompte = super.fraisDeCompte+taxeEpargne;
		
	}

}
