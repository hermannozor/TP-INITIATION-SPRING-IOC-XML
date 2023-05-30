package pres;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import metier.IMetier;
import metier.IMetierImpl;


public class presAvecSpringAnnot {
	public static void main(String[] args) {
		ApplicationContext ctx2 = new AnnotationConfigApplicationContext("dao","metier");
		

		IMetier metier = ctx2.getBean(IMetier.class);
		System.out.println(metier.calcul());
	}

}
