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

@Entity(name = "comment")
public class Comment {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String text;
    private String imageLink;
    @ManyToOne(fetch= FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
	private User user;
    protected Comment() {}
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "complaint_id", nullable = false)
    private Complaint complaint;

    public Comment(String text, String imageLink, User user, Complaint complaint) {
        this.text = text;
        this.imageLink = imageLink;
        this.user = user;
        this.complaint = complaint;
    }

    public Complaint getComment(){
        return complaint;
    }

    public void setComment(Complaint complaint){
        this.complaint = complaint;
    }

    public User getUser(){
        return this.user;
    }

    public Long getId() {
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