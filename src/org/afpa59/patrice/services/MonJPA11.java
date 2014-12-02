package org.afpa59.patrice.services;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.afpa59.patrice.donnees.Client;
import org.afpa59.patrice.utils.ES;

public class MonJPA11 {

	public void test() {
		// TODO Auto-generated method stub
		 // Injection du manager, qui s'occupe de la connexion avec la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test_persistence");
		
		EntityManager em = emf.createEntityManager();
				
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		String mySelect;
		mySelect = "SELECT c.nom"
				+ " FROM "
				+ "Client as c";
		
		
		Query maRequete = em.createQuery(mySelect);
		
		List<Client> results = maRequete.getResultList();
		Iterator<Client> it = results.iterator();
		
		String st = "";
		while (it.hasNext()){
			Client c = it.next();
			st = st + "****" + c.getNom() + "\n";
		}
		
		ES.affiche(st);
				
	}

}
