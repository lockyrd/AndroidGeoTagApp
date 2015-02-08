package hr.pmf.math.android.geotagging.dao;

import java.util.List;

public interface DAO {
	
	public TagEntry getEntry(String id);
	
	public List<TagEntry> getEntries();
	
	public void deleteEntry(String id);
	
	public void addEntry(String title, String description, String path);
	
}
