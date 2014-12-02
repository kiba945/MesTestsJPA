package org.afpa59.patrice.donnees;

import java.io.Serializable;

public class Notice implements Serializable{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String langue ;
	  public Notice(){
	    this.langue = "Français";
	  }
	  public Notice(String lang){
	    this.langue = lang;
	  }
	  public String toString() {
	    return "\t Langue de la notice : " + this.langue + "\n";
	  }
	}