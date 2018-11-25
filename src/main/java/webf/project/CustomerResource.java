package webf.project;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Inject
	private CustomerService customerService;
	
	@Context
	private UriInfo uriInfo;
	
	@POST
	@Transactional
	public Response create(Customer customer) {
		entityManager.persist(customer);
		URI uri = uriInfo.getAbsolutePathBuilder().path(customer.getId().toString()).build();
		return Response.created(uri).build();
	}
	
	@GET
	@Path("/{id}")
	public Customer retrieve(@PathParam("id") Long id) {
		return entityManager.find(Customer.class, id);
	}
	
	@PUT
	@Path("/{id}")
	@Transactional
	public void update(@PathParam("id") Long id, Customer newCustomer) {
		Customer oldCustomer = entityManager.find(Customer.class, id);
		if (oldCustomer != null) {
			oldCustomer.setFirstName(newCustomer.getFirstName());
			oldCustomer.setLastName(newCustomer.getLastName());
			oldCustomer.setBirthDate(newCustomer.getBirthDate());
			oldCustomer.setActivated(newCustomer.getActivated());
		}
		else {
			throw new WebApplicationException(Status.NOT_FOUND);
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Transactional
	public void delete(@PathParam("id") Long id) {
		Customer customer = entityManager.find(Customer.class, id); // muss vor delete geladen werden
		if (customer != null) {
			entityManager.remove(customer);
		}
		else {
			throw new WebApplicationException(Status.NOT_FOUND);
		}
	}
	
	@GET
	public List<Customer> retrieveAll() {
		return customerService.getAllCustomers();
	}
	
}
