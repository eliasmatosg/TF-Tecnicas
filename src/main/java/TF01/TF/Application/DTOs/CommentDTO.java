package TF01.TF.Application.DTOs;

public class CommentDTO {
	private String userName;
	private String text;

	public CommentDTO(String userName, String text){
		this.userName = userName;
		this.text = text;
	}

	public String getUserName(){
		return this.userName;
	}

	public String getText(){
		return this.text;
	}
}

