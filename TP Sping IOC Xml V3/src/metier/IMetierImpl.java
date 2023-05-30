package metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dao.IDao;

@Service(value="metier")
public class IMetierImpl implements IMetier {

	/*
	 * Couplage faible
	 * 
	 * (On ne doit pas faire 
	 * private IDao dao = new car IDao est un interface et
	 * en faisant IDao dao = new... ça devient un couplage fort)
	 */
	@Autowired
	private IDao dao;
	
	/*
	 * IDap est private. Il me faut donc un setter
	 * qui me permettra d'injecter ma dépendance
	 * Pas besoin de getter
	 */
	public void setDao(IDao dao) {
		this.dao = dao;
		System.out.println("Injection des dépendances");
	}
	@Override
	public double calcul() {
		/*
		 * Utilisation du polymorphisme
		 */
		double d = dao.getData();
		double res = d*23;
		return res;
	}
	
	public void init() {
		System.out.println("Initialisation de MetierImpl");
	}
	public IMetierImpl() {
		System.out.println("Instanciation de Metier");
	}

}
