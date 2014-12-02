package org.afpa59.patrice.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.afpa59.patrice.donnees.Article;
import org.afpa59.patrice.donnees.Client;
import org.afpa59.patrice.donnees.Commande;
import org.afpa59.patrice.utils.ES;

public class MonJPA03 {

	public void test() {
		String elt = "";
		int code;

		// Injection du manager, qui s'occupe de la connexion avec la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test_persistence");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		et.begin();

		elt = ES.saisie("*** SUPPRESSION en JPA***\n"
				+ "Quel entite? (art,clt,cde) ");

		switch (elt) {
		case "art":
			code = ES.saisie("*** SUPPRESSION ***\n"
					+ "Votre code Article:", 1, Integer.MAX_VALUE);

			Article article;

			article = em.find(Article.class, code);

			if (article == null) {
				ES.affiche("Article code " + code + " non trouvé");

			} else {
				/**********************************************************/
				String rep = ES.saisie("Voulez-vous supprimer l'article : \n"
						+ article.toString()
						+ " ? (O/N)");

				if (rep.equals("o") || rep.equals("O")){

					try {

						em.remove(article);	

						em.flush();	//Envoi sur la Base de donnée
						et.commit();	//Validation de l'envoi
						
						ES.affiche("     ****** Votre Article ******\n"
								+ article.getCode()
								+ "\n     ****** a bien été supprimé ******");


					} catch (Exception e) {
						// TODO: handle exception

						System.out.println("Olala... Vous n'avez pas le droit d'effacer\n"
								+ article.toString());
					}


				}
				/**********************************************************/

			}

			break;

		case "clt":
			code = ES.saisie("Votre code Client:", 1, Integer.MAX_VALUE);	

			Client client;

			client = em.find(Client.class,code);

			if (client == null){
				ES.affiche("Client code " + code + " non trouvé");
			}else{
				/**********************************************************/
				String rep = ES.saisie("Voulez-vous supprimer le client : \n"
						+ client.toString()
						+ " ? (O/N)");

				if (rep.equals("o") || rep.equals("O")){
					try {

					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Olala... Vous n'avez pas le droit d'effacer :\n"
						+ client.toString());
					}
					
					em.remove(client);	

					em.flush();	//Envoi sur la Base de donnée
					et.commit();	//Validation de l'envoi
					
					ES.affiche("     ****** Votre Article ******\n"
							+ client.getCode()
							+ "\n     ****** a bien été supprimé ******");

				}
				/**********************************************************/
			}

			break;	

		case "cde":

			code = ES.saisie("Votre code Commande:", 1, Integer.MAX_VALUE);	

			Commande cde;

			cde = em.find(Commande.class,code);

			if (cde == null){
				ES.affiche("Commande code " + code + " non trouvé");
			}else{
				/**********************************************************/
				String rep = ES.saisie("Voulez-vous supprimer la commande : \n"
						+ cde.toString()
						+ " ? (O/N)");

				if (rep.equals("o") || rep.equals("O")){

					em.remove(cde);	

					em.flush();	//Envoi sur la Base de donnée
					et.commit();	//Validation de l'envoi
					
					ES.affiche("     ****** Votre Article ******\n"
							+ cde.getCode()
							+ "\n     ****** a bien été supprimé ******");

				}
				/**********************************************************/
			}

			break;
		}

		em.close();
		emf.close();

	}
}


