package TF01.TF.Application.DTOs;

public class CommentDTO {
	private String userName;
	private String text;
	private String title;
	private String category;
	private boolean hasBeenSolved;
	private String date;
	private String imageLink;
	private String address;
	private String district;

	public CommentDTO(String userName, String text, String title,
										String category, boolean hasBeenSolved, String date,
										String imageLink, String address, String district){
		this.userName = userName;
		this.text = text;
		this.title = title;
		this.category = category;
		this.hasBeenSolved = hasBeenSolved;
		this.date = date;
		this.imageLink = imageLink;
		this.address = address;
		this.district = district;
	}

	public String getUserName(){
		return this.userName;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public boolean isHasBeenSolved() {
		return hasBeenSolved;
	}

	public String getDate() {
		return date;
	}

	public String getImageLink() {
		return imageLink;
	}

	public String getAddress() {
		return address;
	}

	public String getDistrict() {
		return district;
	}

	public String getText(){
		return this.text;
	}
}

