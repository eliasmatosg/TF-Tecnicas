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
public class Street {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    private String name;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "district_id")
	private District district;

    protected Street() {}

    public Street(String name, District district) {
        this.name = name;
        this.district = district;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public District getDistrict() {
        return district;
    }
}