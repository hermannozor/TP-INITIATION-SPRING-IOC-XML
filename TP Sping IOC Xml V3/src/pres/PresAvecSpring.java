package pres;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import metier.IMetier;


public class PresAvecSpring {
	public static void main(String[] args) {
		//Démarrage spring en version XML avec injection des dépendances.
		ApplicationContext ctx=new ClassPathXmlApplicationContext("file:src/config.xml");
		
		//IMetier metier = (IMetier) ctx.getBean("metier");
		IMetier metier = ctx.getBean(IMetier.class);
		System.out.println(metier.calcul());
	}

}
