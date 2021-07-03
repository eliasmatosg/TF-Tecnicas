package TF01.TF.Application.DTOs;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComplaintDTO {
	private String title;
	private String description;
	private String date;
	private boolean solved;
	private String category;
	private String street;
	private String imageLink;
	private String userName;
	private String district;
	private Long id;
	private List<CommentDTO> comments;

	public ComplaintDTO(String title, String description, String date, boolean solved, String category, String street, String userName
											, String imageLink, String district, Long id, List<CommentDTO> comments){
		this.title = title;
		this.description = description;
		this.date = date;
		this.solved = solved;
		this.category = category;
		this.street = street;
		this.userName = userName;
		this.imageLink = imageLink;
		this.district = district;
		this.id = id;	
		this.comments = comments;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setSolved(boolean solved) {
		this.solved = solved;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getDate() {
		return date;
	}

	public boolean getSolved() {
		return solved;
	}

	public String getCategory() {
		return category;
	}

	public String getStreet() {
		return street;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void addComment(CommentDTO comment) {
		comments.add(comment);
	}

	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}
}
