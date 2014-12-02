package org.afpa59.patrice.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.afpa59.patrice.donnees.Article;
import org.afpa59.patrice.donnees.Client;
import org.afpa59.patrice.donnees.Commande;
import org.afpa59.patrice.utils.ES;

public class MonJPA02 {

	public void test() {
		String elt = "";
		int code;

		// Injection du manager, qui s'occupe de la connexion avec la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test_persistence");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		et.begin();

		elt = ES.saisie("*** MODIFICATION en JPA***\n"
				+ "Quel entite? (art,clt,cde) ");	

		switch (elt) {
		case "art":

			code = ES.saisie("Votre code Article:", 1, Integer.MAX_VALUE);	

			Article article;

			article = em.find(Article.class,code);

			if (article == null){
				ES.affiche("Article non trouvé");
			}else{
				String designation = ES.saisie("Votre désignation Article:");
				Float prix = ES.saisie("Votre prix Article", 1, Float.MAX_VALUE);

				article.setDesignation(designation);
				article.setPrix(prix);

				em.merge(article);	

				em.flush();	//Envoi sur la Base de donnée
				et.commit();	//Validation de l'envoi

				ES.affiche("     ****** Votre Article ******\n"
						+ "code: "
						+ article.getCode()
						+ "\n     ****** a bien été mise à jour ******");
			}

			break;

		case "clt":

			code = ES.saisie("Votre code Client:", 1, Integer.MAX_VALUE);	

			Client client;

			client = em.find(Client.class,code);

			if (client == null){
				ES.affiche("Client non trouvé");
			}else{
				String nom = ES.saisie("Nom: ");
				String prenom = ES.saisie("Prenom: ");
				String adresse = ES.saisie("Adresse: ");
				
				client.setNom(nom);
				client.setPrenom(prenom);
				client.setAdresse(adresse);
				
				em.merge(client);		

				em.flush();	//Envoi sur la Base de donnée
				et.commit();	//Validation de l'envoi

				ES.affiche("     ****** Votre client ******\n"
						+ client.toString()
						+ "\n     ****** a bien été mise à jour ******");
			}

			break;	
			
		case "cde":

			code = ES.saisie("Votre code Commande:", 1, Integer.MAX_VALUE);	

			Commande cde;

			cde = em.find(Commande.class,code);

			if (cde == null){
				ES.affiche("Commande non trouvé");
			}else{

				em.merge(cde);		

				em.flush();	//Envoi sur la Base de donnée
				et.commit();	//Validation de l'envoi

				ES.affiche("     ****** Votre commande ******\n"
						+ cde.toString()
						+ "\n     ****** a bien été mise à jour ******");
			}

			break;


		}
		em.close();
		emf.close();
	}
}	