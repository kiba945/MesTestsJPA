package org.afpa59.patrice.services;

import org.afpa59.patrice.donnees.Article;
import org.afpa59.patrice.donnees.Client;
import org.afpa59.patrice.donnees.Commande;
import org.afpa59.patrice.utils.ES;

public class MonJPABase implements MonJPAEntite {
	/************************************/
	/*		Déclaration des méthodes	*/
	/************************************/

	/**
	 * @return
	 */
	@Override
	public Article creerArticle() {
		String designation = ES.saisie("Votre désignation Article:");
		Float prix = ES.saisie("Votre prix Article", 1, Float.MAX_VALUE);

		Article article;

		article = new Article();

		article.setDesignation(designation);
		article.setPrix(prix);

		return article;
	}

	/**
	 * @return
	 */
	@Override
	public Client creerClient() {

		String nom = ES.saisie("Nom: ");
		String prenom = ES.saisie("Prenom: ");
		String adresse = ES.saisie("Adresse: ");

		Client clt;

		clt = new Client();

		clt.setNom(nom);
		clt.setPrenom(prenom);
		clt.setAdresse(adresse);

		return clt;
	}

	/** 
	 *@return
	 */
	@Override
	public Commande creerCommande() {

		return null;
	}



}
