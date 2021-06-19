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
public class OfficialOrgan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

    // Many to Many?
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "comments")
	private Comment comments;
	
    @OneToMany(cascade=ALL, mappedBy="officialOrgan")
	private List<Complaint> complaints;

	protected OfficialOrgan() {}

    public OfficialOrgan(String name, boolean isAdmin) {
        this.name = name;
        this.complaints = new ArrayList<>();
    }

    @Override
    public String toString() {
      return String.format(
          "OfficialOrgan: [id=%d, name='%s']",
          id, name);
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

    public ArrayList getComplaints() {
        return complaints;
    }
}