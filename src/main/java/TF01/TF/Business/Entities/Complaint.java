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
import javax.persistence.OneToOne;

import TF01.TF.Application.DTOs.CommentDTO;

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
    private boolean hasBeenSolved;
    private Date date;
    private String district;
    private String category;
    private String address;
    private boolean solvedByOfficialOrgan;
    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="complaint")
	private List<Comment> comments;
    @ManyToOne(fetch = FetchType.EAGER ,optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    protected Complaint() {};

    public Complaint(String title, String description, String imageLink, String category, String district, String address) {
        //this.user = user;
        this.district = district;
        this.title = title;
        this.description = description;
        this.imageLink = imageLink;
        this.category = category;
        this.address = address;
        this.comments = new ArrayList<Comment>();
    }


    public void setId(Long id) {
        this.id = id;
    }

    public boolean isSolvedByOfficialOrgan() {
        return solvedByOfficialOrgan;
    }

    public void setSolvedByOfficialOrgan(boolean solvedByOfficialOrgan) {
        this.solvedByOfficialOrgan = solvedByOfficialOrgan;
    }

    public void setHasBeenSolved(boolean hasBeenSolved) {
        this.hasBeenSolved = hasBeenSolved;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Long getId(){
        return this.id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getHasBeenSolved() {
        return hasBeenSolved;
    }

    public void toggleHasBeenSolved() {
        hasBeenSolved = !hasBeenSolved;
    }

    public void setNotSolved(){
        this.hasBeenSolved = false;
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

    public void addComment(Comment comment){
        this.comments.add(comment);
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int totalComments(){
        return this.comments.size();
    }
}