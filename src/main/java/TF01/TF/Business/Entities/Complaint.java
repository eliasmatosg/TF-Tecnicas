package TF01.TF.Business.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

@Entity(name = "complaint")
public class Complaint {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String title;
    private String description;
    private String imageLink;
    private Boolean hasBeenSolved;
    private String date;
    private String district;
    private String category;
    private String address;
    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="complaint")
	private List<Comment> comments;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    protected Complaint() {};

    public Complaint(String title, String description, String imageLink, String category, String district, String address) {
        //this.user = user;
        this.district = district;
        this.title = title;
        this.description = description;
        this.imageLink = imageLink;
        this.date = new Date().toString();
        this.hasBeenSolved = false;
        this.category = category;
        this.address = address;
        this.comments = new ArrayList<Comment>();
    }


    public void setUser(User user){
        this.user = user;
    }

    public List<Comment> comments(){
        return this.comments;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getHasBeenSolved() {
        return hasBeenSolved;
    }

    public void toggleHasBeenSolved() {
        hasBeenSolved = !hasBeenSolved;
    }

    public String getAddress() {
        return address;
    }

    public void setStreet(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int totalComments(){
        return this.comments.size();
    }
}