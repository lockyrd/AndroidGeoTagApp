package hr.pmf.math.android.geotagging.dao;

public class TagEntry {
	private String id;
	private String title;
	private String description;
	private String location;
	private String path;
	
	public TagEntry(String id, String title, String description,
			String location, String path) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.location = location;
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

	public String getLocation() {
		return location;
	}

	public String getPath() {
		return path;
	}
	
	
}
