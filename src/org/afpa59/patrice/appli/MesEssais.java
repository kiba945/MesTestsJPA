package org.afpa59.patrice.appli;

import org.afpa59.patrice.iu.IuClasses;
import org.afpa59.patrice.iu.IuJDBC;
import org.afpa59.patrice.iu.IuJPA;
import org.afpa59.patrice.iu.IuJFrame;
import org.afpa59.patrice.iu.IuStream;
import org.afpa59.patrice.utils.ES;


public class MesEssais {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choix;

		do{
			choix = menuGeneral();
			switch(choix){
			case 1: IuClasses.menuGeneral(); break;
			case 2: IuJFrame.menuGeneral(); break;
			case 3: IuStream.menuGeneral(); break;
			case 4: IuJDBC.menuGeneral(); break;
			case 5: IuJPA.menuGeneral(); break;
			case 6: break;
			case 7: break;
			case 8: break;
			case 9: break;
			case 10: break;
			default: break;

			}
		}while(choix != 0);
		ES.affiche("\n\t AU REVOIR ... A BIENTOT!!");
	}

	/*** M�thode menuGeneral qui affiche un menu avec 2 choix
	 * et retourne un entier qui correspondant au choix ***/
	static int menuGeneral(){
		String s = "\n\t\t\t   BIENVENUE \n\n"+
				"\t\t 01. Test CLASSES (import � faire)\n"+
				"\t\t 02. Test JFRAME (import � faire) \n"+
				"\t\t 03. Test STREAM (import � faire) \n"+
				"\t\t 04. Test JDBC  \n"+
				"\t\t 05. Test JPA  \n"+
				"\t\t 06. Test (� venir)  \n"+
				"\t\t 07. Test (� venir) \n"+
				"\t\t 08. Test (� venir)  \n"+
				"\t\t 09. Test (� venir)  \n"+
				"\t\t 10. Test (� venir)  \n"+
				"\t\t FIN .............. 0\n\n"+
				"\t\t             Choix : ............ ";
		return ES.saisie(s, 0, 10);
	}		
}

