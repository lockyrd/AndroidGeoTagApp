package hr.pmf.math.android.geotagging.dao;

import android.content.Context;

public class DAOProvider {
	static DAO dao;
	
	private DAOProvider(){}
	
	public static DAO getDAO(Context context){
		if(dao == null){
			DBAdapter adapter = new DBAdapter(context);
			dao = new SQLDAO(adapter);
			
		}
		return dao;
	}
}
