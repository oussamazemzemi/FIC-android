package info.androidhive.slidingmenu;

public class Event {

	Integer id;
	String image;
	String video;
	String description;
	
	public Event(Integer id, String image, String video) {
		super();
		this.id = id;
		this.image = image;
		this.video = video;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Track [title=" + image + ", singer=" + video + "]";
	}

}
