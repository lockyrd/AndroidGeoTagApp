package hr.pmf.math.android.geotagging.dao;

import java.util.List;

import android.database.sqlite.SQLiteDatabase;

@SuppressWarnings("unused")
public class SQLDAO implements DAO {
	
	private DBAdapter db;
	
	public SQLDAO(DBAdapter adapter){
		this.db = adapter;
	}

	@Override
	public TagEntry getEntry(String id) {
		return db.getEntry(id);
	}

	@Override
	public List<TagEntry> getEntries() {
		return db.getEntries();
	}

	@Override
	public void deleteEntry(String id) {
		db.deleteEntry(id);
	}

	@Override
	public void addEntry(String title, String description,
			String path) {
		db.addEntry(title,description,path);
	}

}
