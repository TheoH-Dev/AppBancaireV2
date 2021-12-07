package comptes;

import users.Client;

public class CompteCourant extends CompteBancaire{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7760396109518810338L;

	public CompteCourant(Client proprietaire) {
		super(proprietaire, proprietaire.getCodeAgence());
	}

	@Override
	public void fraisDeCompte() {
		solde -= fraisDeCompte;
	}

}
