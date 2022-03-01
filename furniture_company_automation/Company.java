
public interface Company {
	public void addAdminstrator(Administrator administrator) throws AlreadyExistException;
	public void addCustomer(Customer customer) throws AlreadyExistException;
	public Administrator getAdministrator();
	public array<Branch> getBranch();
	public array<Customer> getCustomer();
	public String getCompanyName();
}
