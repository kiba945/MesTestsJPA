package org.afpa59.patrice.donnees;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="Client")
public class Client extends Entite{
	

	/****************************************/
	/* D�claration des variables d'instance */
	/****************************************/
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "adresse")
	private String adresse;
	
	@OneToMany(mappedBy = "clt")	//un client peut avoir plusieurs cdes	
	private List<Commande> commandes = new ArrayList<Commande>();
	
	/************************************/
	/*	D�claration des constructeurs	*/
	/************************************/
	/*** 1er constructeur ***/
	public Client(){}
	/*** 2�me constructeur avec des param�tres ***/
	public Client(int code, String nomClient, String prenomClient, String adresseClient){
		super(code);
		this.nom=nomClient;
		this.prenom=prenomClient;
		this.adresse=adresseClient;
	}
	
	/************************************/
	/*		D�claration des GETTEURS	*/
	/************************************/
	public String getNom(){return nom;}
	public String getPrenom(){return prenom;}
	public String getAdresse(){return adresse;}
	
	/************************************/
	/*		D�claration des SETTEURS	*/
	/************************************/
	public void setNom(String nomClient){this.nom=nomClient;}
	public void setPrenom(String prenomClient){this.prenom=prenomClient;}
	public void setAdresse(String adresseClient){this.adresse=adresseClient;}
	
	/************************************/
	/*		D�calaration des m�thodes	*/
	/************************************/
	/*** M�thode toString() retourne une cha�ne de caract�re  ***/
	public String toString(){return (super.toString()+" Nom: "+nom+
			" Pr�nom: "+prenom+" Adresse: "+adresse);}	
}
