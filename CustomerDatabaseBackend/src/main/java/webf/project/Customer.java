package webf.project;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_customer")
@NamedQuery(name="customer.selectAll", query="Select n from Customer n")
public class Customer {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) // Primary Key, use server side strategy (auto_increment)
	private Long id;
	
	@Column(length=100, nullable=false)
	private String firstName;
	
	@Column(length=100, nullable=false)
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date birthDate;
	
	@Column(nullable=false)
	private Boolean activated;
	
	public Customer() {}
	
	public Customer(Long id, String firstName, String lastName, Date birthdate, Boolean activated) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthdate;
		this.activated = activated;
	}
	
	public Customer(String firstName, String lastName, Date birthdate, Boolean activated) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthdate;
		this.activated = activated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Boolean getActivated() {
		return activated;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", activated=" + activated + "]";
	}
	
	

}
