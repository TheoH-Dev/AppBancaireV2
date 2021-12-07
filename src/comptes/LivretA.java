package comptes;

import users.Client;

public class LivretA extends Epargne {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6010395459094127947L;
	private double taxeEpargne = 0.1*solde;
	
	public LivretA(Client proprietaire) {
		super(proprietaire);
	}
	
	@Override
	public void fraisDeCompte() {
		solde -= fraisDeCompte+taxeEpargne;
	}
	


}
