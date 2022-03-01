/**
 * Administrator class extends Person.
 * @author UgurER
 */
public class Administrator extends Person {
	private FurnitureCompany company;
	
	public FurnitureCompany getCompany() {return company;}
	
	private void setCompany(FurnitureCompany company) {this.company = company;}
	
	public Administrator(FurnitureCompany company,String adminName, String adminSurname) throws AlreadyExistException {
		super(adminName, adminSurname);
		if(company==null)
			throw new NullPointerException("company is null");
		setCompany(company);
		getCompany().addAdminstrator(this);
	}
	/**
	 * adds employee
	 * @param branch newEmployee's branch
	 * @param newEmployee new employee
	 * @throws ArrayIndexOutOfBoundsException 
	 * @throws AlreadyExistException	if the worker is already working
	 * @throws CompanyIsDifferentException if the branch belongs different company
	 */
	public void addEmployee(Branch branch,BranchEmployee newEmployee) throws ArrayIndexOutOfBoundsException, AlreadyExistException, CompanyIsDifferentException {
		if(branch==null)
			throw new NullPointerException("branch is null, you can't add employee");
		
		if(branch.getCompany()!=getCompany())
			throw new CompanyIsDifferentException(branch.getName()+" belongs to another company.");
		
		for(int i=0;i<getCompany().getBranch().size();i++) {
			if(getCompany().getBranch().get(i).getEmployees().contains(newEmployee)>=0)
				throw new AlreadyExistException(newEmployee.getName()+" "+newEmployee.getSurname()+" is already working in "+getCompany().getBranch().get(i).getName());
		}
		newEmployee.setBranch(branch);
		branch.getEmployees().add(newEmployee);
		System.out.println(newEmployee.getName()+" is added");
	}
	
	/**
	 * removes employee
	 * @param employee employee to be fired
	 */
	public void removeEmployee(BranchEmployee employee) {
		if(employee==null)
			throw new NullPointerException("employee is null!!!");
		
		if(employee.getBranch()!=null) {
			employee.getBranch().getEmployees().remove(employee);
			System.out.println(employee.getName()+" is removed");
		}
		else
			throw new NullPointerException("branch of employee is null");
	}
	
	/**
	 * Admin queries the product
	 * @param branch branch
	 * @param product product to be query
	 */
	public void productQuery(Branch branch,AbstractProduct product) {
		if(branch.getProducts().add(product)==false) 
			System.out.println(product.getName()+" is exist");
		else
			System.out.println(product.getName()+" is currently supplied");
	}
	/**
	 * adds branch
	 * @param branch new branch
	 */
	public void addBranch(Branch branch) {
		branch.setCompany(getCompany());
		getCompany().getBranch().add(branch);
		System.out.println(branch.getName()+" is opened");
	}
	/**
	 * removes branch
	 * @param branch branch to be closed
	 */
	public void removeBranch(Branch branch) {
		if(branch==null)
			throw new NullPointerException("branch is null!!!");
		getCompany().getBranch().remove(branch);
		System.out.println(branch.getName()+" is closed");
		for(int i=0;i<branch.getEmployees().size();i++) {
			branch.getEmployees().get(i).setBranch(null);
		}
	}
	/**
	 * adds product
	 * @param branch company's branch
	 * @param product product to be added
	 */
	public void addProduct(Branch branch,AbstractProduct product) {
		branch.getProducts().add(product);
	}
	
	/**
	 * adds multiple products
	 * @param branch company's branch
	 * @param products products to be added
	 */
	public void addAllProducts(Branch branch,array<AbstractProduct> products) {
		branch.getProducts().addAll(products);
	}
	
	/**
	 * shows Branchs at company
	 * @return return string of branch
	 */
	public String seeBranchs() {
		String newString="";
		for(int i=0 ; i < getCompany().getBranch().size(); ++i) {
			newString+=getCompany().getBranch().get(i).toString()+"\n";
        }
		return newString;
	}
	@Override
    public String toString()
    {
		return String.format("Adminstrator name: %s %s ",getName(),getSurname());
    }
}
