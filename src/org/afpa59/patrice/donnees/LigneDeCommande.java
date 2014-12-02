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
	/* D�claration des variables d'instance */
	/****************************************/	
	@Column(name = "quantite")
	private int quantite;
	
	@ManyToOne	// 
	@JoinColumn( name= "code_article")	//cl� �trang�re
	private Article art;

	@ManyToOne	// 
	@JoinColumn( name= "code_commande")
	private Commande cde;			
	
	
	/************************************/
	/*	D�claration des constructeurs	*/
	/************************************/
	
	
	/*** 1er constructeur ***/
	public LigneDeCommande(){}
	
	
	/*** 2�me constructeur avec des param�tres ***/
	public LigneDeCommande(int code, int quantite){
		super(code);
		this.quantite=quantite;
	}

//	/*** 3�me constructeur avec des param�tres ***/
//	public LigneDeCommande(int quantite, Article art, Commande Cde){
//		this.quantite=quantite;
//		this.art=art;
//		
//	}
	
	/************************************/
	/*		D�claration des GETTEURS	*/
	/************************************/
	public int getQuantite(){return quantite;}
	
	/************************************/
	/*		D�claration des SETTEURS	*/
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
	/*		D�calaration des m�thodes	*/
	/************************************/
	
	/*** M�thode toString() retourne une cha�ne de caract�re  ***/
	public String toString(){return (super.toString()+" Quantit�: "+quantite+"\n");}
	
}
