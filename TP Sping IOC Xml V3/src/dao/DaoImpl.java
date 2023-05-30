package dao;

import org.springframework.stereotype.Component;

@Component(value="dao")
public class DaoImpl implements IDao {

	@Override
	public double getData() {
		/*
		 * Exemple d'algorithme
		 * je me connecte à la bd
		 */
		double data = 98;
		return data;
	}
	
	public void init() {
		System.out.println("Instanciation de Dao Impl");
	}

}
