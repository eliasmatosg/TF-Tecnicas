package TF01.TF.Business.Entities;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Comment {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    private String text;
    private String imageLink;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "user_id")
	private User user;
    
    protected Comment() {}

    public Comment(String text, String imageLink, User user) {
        this.text = text;
        this.imageLink = imageLink;
        this.user = user;
    }

    public getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

}