package pres;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

import dao.DaoImpl;
import dao.IDao;
import metier.IMetier;
import metier.IMetierImpl;

public class Pres1 {
	/**
	 * La classe Pres1(le code commenté) est un fabrique d'objet,
	 * Car, c'est la seule qui n'est pas fermée à la modification
	 * et dans laquelle je peux donc instancier des objets (new...)
	 * 
	 */
	public static void main(String[] args) throws Exception {
		/*
		 * Nous avons fait une injection des dépendances par instanciation statique (en utilisant 'new')
		 *Les 3 lignes de code suivantes permettent de ne plus avoir de nullpointe rexception à l'execution du main
		 *
		 *Dans le fichier config.txt : dao.DaoImpl
		 */
		/*
		 *DaoImpl dao = new DaoImpl();
		 *MetierImpl metier = new MetierImpl();
		 *metier.setDao(dao); //Injection du dao dans le code
		 *System.out.println(metier.calcul());
		 */
		
		/*
		 * Le code ci-dessous gère une instanciation dynamique comparé au code ci-dessus.
		 * Les éléments de config seront récupérés du fichier config.txt
		 */
		
		    Scanner scanner= new Scanner(new File("src/config.txt"));
			String daoClassName = scanner.nextLine(); // Pour récupérer le nom de la classe
			//On va charger dynamique les classes en mémoire
			Class cDao=Class.forName(daoClassName); // Si cette classe existe physiquement, charger le byte code (la classe) en mémoire
			IDao dao= (IDao) cDao.newInstance();// Permet de créer l'instance d'une classe mais retroune un objet de type Object. Vu qu'on est en train d'implémenter un DAO du coup caster avec 'IDao' 
			
			/*
			 * Le code qui va suivre est pour l'injection des dépendances et la création du métier
			 */
			String metierClassName=scanner.nextLine();
			Class cMetier=Class.forName(metierClassName);
			IMetier metier=(IMetier) cMetier.newInstance();
			
			//Comment invoquer dynamique la méthode d'un objet ? Cf. code ci-dessous.
			Method m=cMetier.getMethod("setDao", IDao.class);
			m.invoke(metier, dao); // Je suis en train d'invoquer la méthode m (setDao) sur l'objet metier et je lui transmet le paramètre dao dynamiquement.
			
			
			System.out.println(metier.calcul());
		}
}
