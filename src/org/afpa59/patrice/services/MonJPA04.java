package org.afpa59.patrice.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.afpa59.patrice.donnees.Article;
import org.afpa59.patrice.donnees.Client;
import org.afpa59.patrice.donnees.Commande;
import org.afpa59.patrice.utils.ES;

public class MonJPA04 {

	public void test() {
		String elt = "";
		int code;

		// Injection du manager, qui s'occupe de la connexion avec la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test_persistence");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		et.begin();

		elt = ES.saisie("*** RECHERCHE en JPA***\n"
				+ "Quel entite? (art,clt,cde) ");	

		switch (elt) {

		case "art":
			
			code = ES.saisie("*** RECHERCHE D'UN ARTICLE ***\n"
					+ "Vous cherchez quel article:", 1, Integer.MAX_VALUE);

			Article article;

			article = em.find(Article.class,code);

			if (article != null){

				ES.affiche("     ****** Votre Article trouvé******\n"
						+ article.toString());

			}else{
				ES.affiche("Article code " + code + " non trouvé");
			}
			
			break;
			
		case "clt":
			
			code = ES.saisie("*** RECHERCHE D'UN CLIENT ***\n"
					+ "Vous cherchez quel article:", 1, Integer.MAX_VALUE);

			Client client;

			client = em.find(Client.class,code);

			if (client != null){

				ES.affiche("     ****** Votre Client trouvé ******\n"
						+ client.toString());

			}else{
				ES.affiche("Client code " + code + " non trouvé");
			}
			
			break;
			
			
		case "cde":
			
			code = ES.saisie("*** RECHERCHE D'UNE COMMMANDE ***\n"
					+ "Vous cherchez quel article:", 1, Integer.MAX_VALUE);

			Commande cde;

			cde = em.find(Commande.class,code);

			if (cde != null){

				ES.affiche("     ****** Votre Commande trouvée ******\n"
						+ cde.toString());

			}else{
				ES.affiche("Commande code " + code + " non trouvée");
			}
			
			break;
			
		}





		//		em.flush();	//Envoi sur la Base de donnée
		//		et.commit();	//Validation de l'envoi

		em.close();
		emf.close();


	}
}
