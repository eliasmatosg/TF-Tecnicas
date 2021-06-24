package TF01.TF.Application.DTOs;
import java.util.Date;

public class ComplaintDTO {
	private String title;
	private String description;
	private Date date;
	private Boolean solved;
	private String category;
	private String street;

	public ComplaintDTO(String title, String description, Date date, Boolean solved, String category, String street){
		this.title = title;
		this.description = description;
		this.date = date;
		this.solved = solved;
		this.category = category;
		this.street = street;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Date getDate() {
		return date;
	}

	public Boolean getSolved() {
		return solved;
	}

	public String getCategory() {
		return category;
	}

	public String getStreet() {
		return street;
	}

}
