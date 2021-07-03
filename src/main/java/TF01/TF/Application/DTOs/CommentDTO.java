package TF01.TF.Application.DTOs;

public class CommentDTO {
	private String userName;
	private String text;
	private String imageLink;

	public CommentDTO(String userName, String text, String imageLink){
		this.userName = userName;
		this.text = text;
		this.imageLink = imageLink;
	}

	public CommentDTO() {
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImageLink() {
		return this.imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
}