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
	
	public List<Customer> getAllCustomers(boolean status, String text) {
		if (status == true) {			
			return entityManager
					.createNamedQuery("customer.selectAllActivated", Customer.class)
					.setParameter("activated", status)
					.getResultList();
		} else {			
			String pattern = "%" + text + "%";
			return entityManager
					.createNamedQuery("customer.selectAllFiltered", Customer.class)
					.setParameter("filterString", pattern)
					.getResultList();
		}
	}
}
