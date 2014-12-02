package org.afpa59.patrice.donnees;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "LigneDeCommande")
public class LigneDeCommande extends Entite{
	
	/****************************************/
	/* Déclaration des variables d'instance */
	/****************************************/	
	@Column(name = "quantite")
	private int quantite;
	
	@ManyToOne	// 
	@JoinColumn( name= "code_article")	//clé étrangére
	private Article art;

	@ManyToOne	// 
	@JoinColumn( name= "code_commande")
	private Commande cde;			
	
	
	/************************************/
	/*	Déclaration des constructeurs	*/
	/************************************/
	
	
	/*** 1er constructeur ***/
	public LigneDeCommande(){}
	
	
	/*** 2ème constructeur avec des paramètres ***/
	public LigneDeCommande(int code, int quantite){
		super(code);
		this.quantite=quantite;
	}

//	/*** 3ème constructeur avec des paramètres ***/
//	public LigneDeCommande(int quantite, Article art, Commande Cde){
//		this.quantite=quantite;
//		this.art=art;
//		
//	}
	
	/************************************/
	/*		Déclaration des GETTEURS	*/
	/************************************/
	public int getQuantite(){return quantite;}
	
	/************************************/
	/*		Déclaration des SETTEURS	*/
	/************************************/
	public void setQuantite(int quantite){this.quantite=quantite;}
	
	public Article getArt() {
		return art;
	}


	public void setArt(Article art) {
		this.art = art;
	}


	public Commande getCde() {
		return cde;
	}


	public void setCde(Commande cde) {
		this.cde = cde;
	}	
	
	/************************************/
	/*		Décalaration des méthodes	*/
	/************************************/
	
	/*** Méthode toString() retourne une chaîne de caractère  ***/
	public String toString(){return (super.toString()+" Quantité: "+quantite+"\n");}
	
}
