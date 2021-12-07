package comptes;

import users.Client;

public class PlanEpargneLogement extends Epargne{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5300557472758762213L;
	private double taxeEpargne = 0.025*solde;
	
	public PlanEpargneLogement(Client proprietaire) {
		super(proprietaire);
		
	}
	
	@Override
	public void fraisDeCompte() {
		solde -= fraisDeCompte+taxeEpargne;
	}

}
