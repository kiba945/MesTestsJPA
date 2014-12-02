package org.afpa59.patrice.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.afpa59.patrice.donnees.Article;
import org.afpa59.patrice.donnees.Client;
import org.afpa59.patrice.donnees.Commande;
import org.afpa59.patrice.donnees.LigneDeCommande;
import org.afpa59.patrice.utils.DateUser;
import org.afpa59.patrice.utils.ES;

public class MonJPA08 {

	public void test() {
		// TODO Auto-generated method stub
		int codeClt;
		int codeArt;
		int qte;

		// Injection du manager, qui s'occupe de la connexion avec la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test_persistence");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		et.begin();
		
		/*********************CLIENT************************/	
		codeClt = ES.saisie("*** CLIENT COMANDE***\n"
				+ "Veuillez saisir le code Client:", 1, Integer.MAX_VALUE);
		
		Client clt = em.find(Client.class, codeClt);

		em.persist(clt);
		/**************************************************/
		
		/*********************ARTICLE************************/	
				
		codeArt = ES.saisie("*** ARTICLE COMMANDE ***\n"
				+ "Veuillez saisir le code Article:", 1, Integer.MAX_VALUE);
		
		Article art1 = em.find(Article.class,codeArt);		
		
		Article art2 = em.find(Article.class,2);	// Cadeau article offert
		
		/**************************************************/
		
		Commande cde = new Commande();

		/****************LigneCOMMANDE***************************/	
		LigneDeCommande ldc1 = new LigneDeCommande();
		LigneDeCommande ldc2 = new LigneDeCommande();
		
		
		qte = ES.saisie("Veuillez saisir la quantité commandée : ", 1, Integer.MAX_VALUE);
		
		ldc1.setQuantite(qte);
		ldc1.setArt(art1);
		ldc1.setCde(cde);

		em.persist(ldc1);		
		
		ldc2.setQuantite(1);	// Cadeau article offert
		ldc2.setArt(art2);
		ldc2.setCde(cde);
		
		em.persist(ldc2);
		/**************************************************/
		
		/****************COMMANDE***************************/	
		int numOrd;
		String numCde;
		Float totalCommande;
		DateUser dateJ = new DateUser();
		
		numOrd= cde.getCode()+1;
		numCde = ""+dateJ.getAnnee()+dateJ.getMois()+dateJ.getJour()+numOrd;
		
		cde.setCodeCde(numCde);
		
		cde.setClt(clt);
		
		cde.ajouter(ldc1);
		cde.ajouter(ldc2);

		totalCommande = ldc1.getArt().getPrix()*ldc1.getQuantite()
				+ ldc2.getArt().getPrix()*ldc2.getQuantite();
		
		cde.setMontantCommande(totalCommande);

		em.persist(cde);
		/**************************************************/			
		
		
		em.flush();	//Envoi sur la Base de donnée
		et.commit();	//Validation de l'envoi

		em.close();
		emf.close();

		ES.affiche("              ****** Votre Commande ****\n"
				+ cde.toString()
				+ "");

	}

	private Client creer() {
		// TODO Auto-generated method stub
		String nom;
		String prenom;
		String adresse;

		Client clt;

		clt = new Client();

		nom = ES.saisie("Nom: ");
		prenom = ES.saisie("Prenom: ");
		adresse = ES.saisie("adresse: ");

		clt.setNom(nom);
		clt.setPrenom(prenom);
		clt.setAdresse(adresse);


		return clt;
	}

}
