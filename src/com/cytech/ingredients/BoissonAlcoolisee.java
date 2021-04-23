package com.cytech.ingredients;

public class BoissonAlcoolisee extends Boisson {

	private float degre;

	public BoissonAlcoolisee(String nomB, float contenance, double prixB, int quantite, float degreAlcool) {
		super(nomB, contenance, prixB, quantite);
		if(degreAlcool <0) {
			System.out.print("ERROR le degre d'alcool est incorrect");
			System.exit(1);
		}else {
			this.degre = degreAlcool;
		}
	}
	
	public float getDegre() {
		return degre;
	}

	public void setdegre(float degre) {
		this.degre = degre;
	}
	
}
