package org.afpa59.patrice.donnees;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name= "Article")
public class Article extends Entite{

	/****************************************/
	/* Déclaration des variables d'instance */
	/****************************************/

	@Column( name = "designation")
	private String designation;

	@Column( name = "prix")
	private float prix;

	/************************************/
	/*	Déclaration des constructeurs	*/
	/************************************/
	/** 1er constructeur
	 * 
	 */
	public Article(){}

	/** 2ème constructeur avec des paramètres
	 * 
	 * @param Integer code
	 * @param String designation
	 * @param Float prix
	 */
	public Article(int code, String designation, float prix){
		super(code);
		this.designation=designation;
		this.prix=prix;
	}

	/** 3ème constructeur avec des paramètres
	 * 
	 * @param String designation
	 * @param Float prix
	 */
	public Article(String designation, float prix){
		this.designation=designation;
		this.prix=prix;
	}


	/************************************/
	/*		Déclaration des GETTEURS	*/
	/************************************/	
	/**
	 * @return String designation
	 */
	public String getDesignation(){return designation;}
	
	/**
	 * @return Float prix
	 */
	public float getPrix(){return prix;}

	/************************************/
	/*		Déclaration des SETTEURS	*/
	/************************************/
	/**
	 * @param designation
	 */	
	public void setDesignation(String designation){this.designation=designation;}	
	
	/**
	 * @param prix
	 */
	public void setPrix(float prix){this.prix=prix;}	
	
	

	/************************************/
	/*		Déclaration des méthodes	*/
	/************************************/
	/*** Méthode toString() retourne une chaîne de caractère  ***/
	public String toString(){return (super.toString()+" Designation: "+designation+
			" Prix: "+prix);}

	//	@Override
	//	public int hashCode() {
	//		final int prime = 31;
	//		int result = 1;
	//		result = prime * result
	//				+ ((designation == null) ? 0 : designation.hashCode());
	//		return result;
	//	}
	//
	//	@Override
	//	public boolean equals(Object obj) {
	//		if (this == obj)
	//			return true;
	//		if (obj == null)
	//			return false;
	//		if (getClass() != obj.getClass())
	//			return false;
	//		Article other = (Article) obj;
	//		if (designation == null) {
	//			if (other.designation != null)
	//				return false;
	//		} else if (!designation.equals(other.designation))
	//			return false;
	//		return true;
	//	}
	//


}
