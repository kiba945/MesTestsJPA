package org.afpa59.patrice.donnees;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.afpa59.patrice.utils.DateUser;

@Entity
public class Commande extends Entite{

	/****************************************/
	/* Déclaration des variables d'instance */
	/****************************************/
	@Column(name = "code_cde")
	private String codeCde;

//	@Column(name = "date_cde")
//	private DateUser dateCde = new DateUser();

	@Column(name = "date_facture")
	private DateUser dateFact;
	//	
	//	private boolean etatFacture;	

	@ManyToOne	// Plusieurs commandes pour un client
	@JoinColumn(name = "code_client")
	private Client clt;


	@OneToMany(mappedBy = "cde")	
	private List<LigneDeCommande> listeCde = new ArrayList<LigneDeCommande>();

	@Column(name = "montantcommande")
	private float montantCommande;



	public List<LigneDeCommande> getListeCde() {
		return listeCde;
	}

	public void setListeCde(List<LigneDeCommande> listeCde) {
		this.listeCde = listeCde;
	}

	public Client getClt() {
		return clt;
	}
	public void setClt(Client clt) {
		this.clt = clt;
	}

	public float getMontantCommande() {
		return montantCommande;
	}
	public void setMontantCommande(float montantCommande) {
		this.montantCommande = montantCommande;
	}

	/************************************/
	/*	Déclaration des constructeurs	*/
	/************************************/
	/*** 1er constructeur ***/
	public Commande(){}
	/*** 2ème constructeur avec des paramètres ***/
	public Commande(String code, DateUser dateCde, ArrayList<LigneDeCommande> Cde){
		super.getCode();
		this.codeCde=code;
		//		this.dateCde=dateCde;
		//		this.listeCde=Cde;
	}

	/************************************/
	/*		Déclaration des GETTEURS	*/
	/************************************/
	public String getCodeCde(){return codeCde;}
	//	public DateUser getDateCde(){return dateCde;}
	//	public DateUser getDateFact(){return dateFact;}
	//	public boolean getEtatFacture(){return etatFacture;}

	public List<LigneDeCommande> getUneCommande(){return listeCde;}

	/************************************/
	/*		Déclaration des SETTEURS	*/
	/************************************/
	public void setCodeCde(String code){this.codeCde=code;}
	//	public void setDateCde(DateUser dateCde){this.dateCde=dateCde;}
	public void setUneCommande(ArrayList<LigneDeCommande> ldc){this.listeCde=ldc;}
	//	public void setDateFact(DateUser dateFact){this.dateFact = dateFact;}
	//	public void setEtatFacture(boolean etatFacture){this.etatFacture = etatFacture;}


	/************************************/
	/*		Décalaration des méthodes	*/
	/************************************/
	/*** Méthode toString() retourne une chaîne de caractère  ***/
	//	public String toString(){
	//		String st = new String();
	//		for(int i=0;i<taille();i++){
	//			st = st + listeCde.get(i).toString()+ "**\n";
	//		}
	//		return st;
	//	}

	@Override
	public String toString() {
		String st = "";
		String lignesCde = "";

		for (int i = 0; i < listeCde.size(); i++) {
			lignesCde = lignesCde
					+ listeCde.get(i).getArt().getCode()
					+ " *** "
					+ listeCde.get(i).getArt().getDesignation()
					+ " *** "
					+ listeCde.get(i).getQuantite()
					+ " *** "
					+ listeCde.get(i).getArt().getPrix()
					+ "\n";
		}

		st="Commande : " + codeCde + " à : "
				+ clt.getNom()
				+ " "
				+ clt.getPrenom()
				+ ", "
				+ clt.getAdresse()
				+ "\n"
				+ "************************************************\n"
				+ lignesCde
				+ "\n************************************************\n"
				+ "                             montantCommande=" + montantCommande;

		return st;
	}		

	public void ajouter(LigneDeCommande lg){listeCde.add(lg);}

	public void supprimer(LigneDeCommande lg){listeCde.remove(lg);}

	public LigneDeCommande retourner(int lg){
		if(taille()>0){
			return listeCde.get(lg);
		}
		return null;
	}

	public String cle() {return null;}

	/*** Méthode taille() retourne la taille de la liste des commandes  ***/
	public int taille(){return listeCde.size();}

}