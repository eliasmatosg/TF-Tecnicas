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
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String name;
	private boolean admin;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "a ser criada")
	private Comment comments;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "a ser criada tb")
	private Complaint complaints;

	protected User() {}
}