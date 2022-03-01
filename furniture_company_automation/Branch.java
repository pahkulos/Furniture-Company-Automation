/**
 * Branch class.
 * @author UgurER
 */
public class Branch {
	private String name;
	private FurnitureCompany company;
	private array<Customer> subCustomers;
	private array<BranchEmployee> employees;
	private array<AbstractProduct> products;
	
	/**
	 * One parameter constructor.
	 * @param name branch name
	 */
	Branch(String name){
		this.name=name;
		subCustomers=new array<>();
		employees=new array<>();
		products=new array<>();
		company=null;
	}
	/**
	 * Setter function for branch name.
	 * @param name branch name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Getter function for branch name.
	 * @return name of branch
	 */
	public String getName() {
		return name;
	}
	/**
	 * Getter function for subscribed customers.
	 * @return array of subscribed customers
	 */
	public array<Customer> getSubCustomers() {
		return subCustomers;
	}
	/**
	 * Getter function for employees.
	 * @return array of employees
	 */
	public array<BranchEmployee> getEmployees() {
		return employees;
	}
	/**
	 * Getter function for company.
	 * @return company
	 */
	public FurnitureCompany getCompany() {
		return company;
	}
	
	/**
	 * Getter function for products.
	 * @return array of products.
	 */
	public array<AbstractProduct> getProducts() {
		return products;
	}

	@Override
	public String toString() {
		return String.format("company name: %s  branch name: %s",company.getCompanyName(),name);
	}
	
	/**
	 * Setter function for company.
	 * @param company company
	 */
    public void setCompany(FurnitureCompany company) {
		this.company = company;
	}
    /**
     * shows products
     * @return String of all products
     */
	public String showProducts()
    {
		String newString="";
		for(int i=0 ; i < products.size(); ++i) {
			newString+=name+": "+products.get(i).toString()+"\n";
        }
		return newString;
    }
	
	/**
     * shows employees
     * @return String of all employees
     */
	public String showEmployees() {
    	String newString="";
		for(int i=0 ; i < employees.size(); ++i) {
			newString+=employees.get(i).toString()+"\n";
        }
		return newString;
    }
	/**
     * Check if the array are same.
     * @param o other object to compare them.
     * @return true if they are same. Otherwise return false.
     */
	@Override
    public boolean equals(Object o)
    {
		return toString().equals(o.toString());
    }
	
}