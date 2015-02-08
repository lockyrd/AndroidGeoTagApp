package hr.pmf.math.android.geotagging.dao;

import android.content.Context;

public class DAOProvider {
	static DAO dao;
	
	private DAOProvider(){}
	
	public static DAO getDAO(Context context){
		if(dao == null){
			dao = new SQLDAO(new DBAdapter(context));
			
		}
		return dao;
	}
}
