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
public class District {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    private String name;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="district")
	private List<Street> streets;

    protected District() {}

    public District(String name) {
        this.name = name;
        this.streets = new ArrayList<>();
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

    public List<Street> getStreets() {
        return streets;
    }
}