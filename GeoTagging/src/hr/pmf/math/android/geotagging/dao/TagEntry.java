package hr.pmf.math.android.geotagging.dao;

public class TagEntry {
	private String id;
	private String title;
	private String description;
	private String path;
	
	public TagEntry(String id, String title, String description, String path) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.path = path;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getPath() {
		return path;
	}
	
	
}
