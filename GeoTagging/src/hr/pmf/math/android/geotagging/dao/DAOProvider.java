package hr.pmf.math.android.geotagging.dao;

public class DAOProvider {
	static DAO dao;
	
	private DAOProvider(){}
	
	public static DAO getDAO(){
		return dao;
	}
}
