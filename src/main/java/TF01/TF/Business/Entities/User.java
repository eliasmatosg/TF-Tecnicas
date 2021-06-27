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
import java.util.List;
import java.util.ArrayList;

@Entity(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private boolean isAdmin;
    private boolean isOfficialOrgan;
    @OneToMany(cascade= CascadeType.ALL, mappedBy="user")
    @JoinColumn(name = "complaint_id")
	private List<Complaint> complaints;
    @OneToMany()
    @JoinColumn(name = "comment_id", nullable = false)
    private List<Comment> comments;

	protected User() {}
    public User(String name, boolean isAdmin, boolean isOfficialOrgan) {
        this.name = name;
        this.isAdmin = isAdmin;
        this.isOfficialOrgan = isOfficialOrgan;
        this.complaints = new ArrayList<>();
    }

    @Override
    public String toString() {
      return String.format(
          "User: [id=%d, name='%s', isAdmin='%b']",
          id, name, isAdmin);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public boolean getIsOfficialOrgan() {
        return isOfficialOrgan;
    }

    public void toggleIsAdmin() {
        this.isAdmin = !isAdmin;
    }

    
    public void toggleIsOfficialOrgan() {
        this.isOfficialOrgan = !isOfficialOrgan;
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }
}