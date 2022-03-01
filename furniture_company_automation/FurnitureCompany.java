
public class FurnitureCompany implements Company {
	private String companyName;
    private Administrator administrator;
    private array<Branch> branch;
    private array<Customer> customer;
    private int customerID=0;
   
	private void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	FurnitureCompany(String companyName){
		setCompanyName(companyName);
        branch = new array<>();
        customer=new array<>();
        administrator=null;
    }
	@Override
	public void addAdminstrator(Administrator administrator) throws AlreadyExistException {
		if(this.administrator!=null)
			throw new AlreadyExistException("The company already has 1 administrator. ");
		
		this.administrator=administrator;
		
	}
	@Override
	public void addCustomer(Customer customer) throws AlreadyExistException {
		if(this.customer.add(customer)==true) {
			customer.setId(++customerID);
			System.out.println(customer.getName()+"'s id is "+customerID);
		}
		else
			throw new AlreadyExistException("this customer already exist");
	}
	
	@Override
	public String getCompanyName() {
		return companyName;
	}
	
	@Override
	public Administrator getAdministrator() {
		return administrator;
	}
	
	@Override
	public array<Branch> getBranch() {
		return branch;
	}
	
	@Override
	public array<Customer> getCustomer() {
		return customer;
	}
	
	@Override
    public String toString()
    {
		return String.format("Company name: %s ",companyName);
    }
	
}
