package org.afpa59.patrice.donnees;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


//@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass	// Annotation pour l'h�ritage
public class Entite {
	
	/****************************************/
	/* D�claration des variables d'instance */
	/****************************************/
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY) //Auto incremente l'ID
	private int code;
	
	/************************************/
	/*	D�claration des constructeurs	*/
	/************************************/
	/*** 1er constructeur ***/
	public Entite(){}
	/*** 2�me constructeur avec des param�tres ***/
	public Entite(int code){
		this.code=code;
	}
	
	/************************************/
	/*		D�claration des GETTEURS	*/
	/************************************/
	public int getCode(){return code;}
	
	/************************************/
	/*		D�claration des SETTEURS	*/
	/************************************/
	public void setCode(int code){this.code=code;}
	
	/************************************/
	/*		D�claration des m�thodes	*/
	/************************************/
	/*** M�thode toString() retourne une cha�ne de caract�re  ***/
	public String toString(){return ("Code: "+code);}
}
