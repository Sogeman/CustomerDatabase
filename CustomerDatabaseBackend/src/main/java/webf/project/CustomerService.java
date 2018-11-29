package webf.project;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CustomerService {

	@PersistenceContext //(unitName="CustomerPU")
	private EntityManager entityManager;
	
	public List<Customer> getAllCustomers() {
		return entityManager
				.createNamedQuery("customer.selectAll", Customer.class)
				.getResultList();
	}
	
	// TODO ADD function for Filter (bookmark)
}
