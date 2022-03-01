
public class Customer extends Person {
	private String e_mail;
	private String password;
	private String address;
	private String phone;
	private array<AbstractProduct> orders;
	private int id;
	private FurnitureCompany company;
	
	private FurnitureCompany getCompany() {
		return company;
	}
	public Customer(FurnitureCompany company,String name, String surname,String e_mail,String password) throws AlreadyExistException {
		super(name, surname);
		if(company==null)
			throw new NullPointerException("company is null");
		else {
			this.e_mail=e_mail;
			this.password=password;
			this.company=company;
			orders=new array<>();
			getCompany().addCustomer(this);
		}
	}
	public void seeProducts() {
		for(int i=0; i<getCompany().getBranch().size() ;i++)
			System.out.println(getCompany().getBranch().get(i).showProducts());
	}
	public String seeOrders() {
		String newString="Previous Orders: \n";
		for(int i=0 ; i < getOrders().size(); ++i) {
			newString+=getOrders().get(i).toString()+"\n";
        }
		return newString;
	}
	
	public void shopOnline(AbstractProduct product,String address,String phone) {
		
		if(product==null||product.getName()==null)
			throw new NullPointerException("product is null");
		else {
			this.address=address;
			this.phone=phone;
			array<Branch> branchs=getCompany().getBranch();
			int i=0;
			for(i=0;i < branchs.size(); i++) {
				if(branchs.get(i).getEmployees().getCapacity()!=0) { 
					branchs.get(i).getEmployees().get(0).makesell(this, product);
					return;
				}
			}
			throw new NullPointerException("there are no employees in the company");
			
		}
	}
	public void addNewOrder(AbstractProduct product) {
		orders.add(product);
	}
	protected array<AbstractProduct> getOrders() {
		return orders;
	}
	protected String getE_mail() {
		return e_mail;
	}
	protected void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	protected String getPassword() {
		return password;
	}
	protected void setPassword(String password) {
		this.password = password;
	}
	/**
     * Getter function for id variable of person.
     * @return id of person.
     */
	public int getId() {
		return id;
	}
	/**
     * Setter function for id variable of person.
     * @param id of person.
     */
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return String.format("name: %s	surname: %s	email: %s id: %d\n",getName(),getSurname(),getE_mail(),getId());
	}
	@Override
    public boolean equals(Object o)
    {
		return getName()==((Customer) o).getName() && getSurname()==((Customer) o).getSurname();
    }
}
