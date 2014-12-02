package org.afpa59.patrice.donnees;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


//@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass	// Annotation pour l'héritage
public class Entite {
	
	/****************************************/
	/* Déclaration des variables d'instance */
	/****************************************/
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY) //Auto incremente l'ID
	private int code;
	
	/************************************/
	/*	Déclaration des constructeurs	*/
	/************************************/
	/*** 1er constructeur ***/
	public Entite(){}
	/*** 2ème constructeur avec des paramètres ***/
	public Entite(int code){
		this.code=code;
	}
	
	/************************************/
	/*		Déclaration des GETTEURS	*/
	/************************************/
	public int getCode(){return code;}
	
	/************************************/
	/*		Déclaration des SETTEURS	*/
	/************************************/
	public void setCode(int code){this.code=code;}
	
	/************************************/
	/*		Déclaration des méthodes	*/
	/************************************/
	/*** Méthode toString() retourne une chaîne de caractère  ***/
	public String toString(){return ("Code: "+code);}
}
