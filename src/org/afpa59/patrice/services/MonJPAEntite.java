package org.afpa59.patrice.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.afpa59.patrice.donnees.Article;
import org.afpa59.patrice.donnees.Client;
import org.afpa59.patrice.donnees.Commande;

public interface MonJPAEntite {
	/************************************************/
	/*		D�claration des signatures de m�thode	*/
	/************************************************/
	
	public Article creerArticle();
	
	public Client creerClient();
	
	public Commande creerCommande();

}