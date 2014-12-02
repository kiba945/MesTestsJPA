package org.afpa59.patrice.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.afpa59.patrice.donnees.Article;
import org.afpa59.patrice.donnees.Client;
import org.afpa59.patrice.utils.ES;

public class MonJPA01 extends MonJPABase{

	public void test() {
		// TODO Auto-generated method stub
		String elt = "";

		// Injection du manager, qui s'occupe de la connexion avec la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test_persistence");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		et.begin();

		elt = ES.saisie("*** CREATION en JPA****\n"
				+ "Quel entite? (art,clt,cde) ");

		switch (elt) {
		case "art":
			
			Article article = creerArticle();
			
			em.persist(article);

			em.flush();	//Envoi sur la Base de donnée
			et.commit();	//Validation de l'envoi

			ES.affiche("     ****** Votre Article ******\n"
					+ article.toString()
					+ "\n     ****** a bien été crée ******");

			break;

		case "clt":
			
			Client clt = creerClient();	
			
			em.persist(clt);	

			em.flush();	//Envoi sur la Base de donnée
			et.commit();	//Validation de l'envoi

			ES.affiche("     ****** Votre client ******\n"
					+ clt.toString()
					+ "\n     ****** a bien été crée ******");

			break;

		case "cde":

			break;
		}

		em.close();
		emf.close();

	}

}
