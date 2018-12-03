package webf.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="t_customer")
@NamedQueries({
	@NamedQuery(name="customer.selectAll", query="SELECT c from Customer c"),
	@NamedQuery(name="customer.selectAllActivated", query="SELECT c from Customer c WHERE c.activated = :activated")
})
public class Customer {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) // Primary Key, use server side strategy (auto_increment)
	private Long id;
	
	@Column(length=100, nullable=false)
	private String firstName;
	
	@Column(length=100, nullable=false)
	private String lastName;
	
	@Column(length=15, nullable=false)
	private String birthDate;
	
	@Column(nullable=false)
	private boolean activated;
	
	public Customer() {}
	
	public Customer(Long id, String firstName, String lastName, String birthdate, boolean activated) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthdate;
		this.activated = activated;
	}
	
	public Customer(String firstName, String lastName, String birthdate, boolean activated) {
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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public boolean getActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", activated=" + activated + "]";
	}
	
	

}
