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

@Entity
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private boolean isAdmin;

    // Many to Many?
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "comments")
	private Comment comments;
	
    @OneToMany(cascade=ALL, mappedBy="user")
	@JoinColumn(name = "complaints")
	private List<Complaint> complaints;

	protected User() {}

    public User(String name, boolean isAdmin) {
        this.name = name;
        this.isAdmin = isAdmin;
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

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public ArrayList getComplaints() {
        return complaints;
    }
}