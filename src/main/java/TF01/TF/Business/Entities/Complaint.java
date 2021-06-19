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
import javax.persistence.OneToOne;

@Entity
public class Complaint {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    private String title;
    private String description;
    private String imageLink;
    private Boolean hasBeenSolved;
    private Date date;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "street_id")
	private Street street;

    protected Complaint() {};

    public Complaint(String title, String description, String imageLink, Date date, Boolean hasBeenSolved, Category category, Street street) {
        this.title = title;
        this.description = description;
        this.imageLink = imageLink;
        this.date = date;
        this.hasBeenSolved = hasBeenSolved;
        this.category = category;
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
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

    public Boolean getHasBeenSolved() {
        return hasBeenSolved;
    }

    public void toggleHasBeenSolved() {
        hasBeenSolved = !hasBeenSolved;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = treet;
    }
}