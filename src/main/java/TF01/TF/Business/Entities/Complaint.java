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
public class Complaint {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    private String title;
    private String description;
    private String imageLink;
    private Boolean hasBeenSolved;
    private Date date;

    // TODO:  bairro, endereço e categoria

    protected Complaint() {};

    public Complaint(String title, String description, String imageLink, Date date) {
        this.title = title;
        this.description = description;
        this.imageLink = imageLink;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageLink() {
        return imageLink;
    }

    public Date getDate() {
        return date;
    }
}