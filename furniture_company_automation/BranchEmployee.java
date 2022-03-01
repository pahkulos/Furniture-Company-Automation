
public class BranchEmployee extends Person{
	private Branch branch;
	
	/**
     * Constructor for the branch employee with its branch,name,surname and id.
     * @param branch to which the branch employee belongs.
     * @param name branch employee's name.
     * @param surname branch employee's surname.
     */
	public BranchEmployee(String name, String surname) {
		super(name, surname);
		/*if(branch==null)
			throw new NullPointerException("branch is null");
		this.branch=branch;*/
	}
	
	public boolean stockOf(AbstractProduct product) {
		return getBranch().getProducts().contains(product)>=0;
	}
	public boolean addProduct(AbstractProduct product) {
		return getBranch().getProducts().add(product);
	}
	public boolean removeProduct(AbstractProduct product) {
		return getBranch().getProducts().remove(product);
	}
	public void makesell(Customer customer,AbstractProduct product) {
		if(stockOf(product)==false) 
			infoToManager(product);
		
		
		if(register(customer)==true) {
			System.out.println("Welcome "+customer.getName()+" "+customer.getSurname()+". You are subscribed");
		}
		previousOrderOf(customer.getId()).add(product);
		getBranch().getProducts().remove(product);
		System.out.println(customer.getName()+" bought "+product.toString());
	}
	private boolean register(Customer customer){
		return getBranch().getSubCustomers().add(customer);
	}
	public array<AbstractProduct> previousOrderOf(int id) {
		int i;
		for(i=0;i<getBranch().getSubCustomers().size();i++) {
			if(getBranch().getSubCustomers().get(i).getId()==id)
				return getBranch().getSubCustomers().get(i).getOrders();
		}
		return null;
	}
	
	public void infoToManager(AbstractProduct product){
		System.out.println("The product is not available in the store, it is currently supplied.");
		getBranch().getCompany().getAdministrator().addProduct(getBranch(), product);
	}
    public Branch getBranch() { return branch; }
    public void setBranch(Branch branch) {this.branch=branch;  }
    @Override
	public String toString() {
		return String.format("name: %s	surname: %s	\n",getName(),getSurname());
	}
    
	@Override
    public boolean equals(Object o)
    {
		return toString().equals(o.toString());

    }
}
