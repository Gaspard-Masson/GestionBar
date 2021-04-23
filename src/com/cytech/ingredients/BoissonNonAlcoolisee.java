package com.cytech.ingredients;


public class BoissonNonAlcoolisee extends Boisson {
	
	private float degre;
	
	public BoissonNonAlcoolisee(String nomB, float contenance, double prixB, int quantite, float degreSucre) {
		super(nomB, contenance, prixB, quantite);
		if(degreSucre <0) {
			System.out.print("ERROR le degre de sucre est incorrect");
			System.exit(1);
		}else {
			this.degre = degreSucre;
		}
		
	}

	public float getDegre() {
		return degre;
	}

	public void setdegre(float degre) {
		this.degre = degre;
	}
	
}
