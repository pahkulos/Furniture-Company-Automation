
public class test {

	public static void main(String[] args) throws Exception {
		testFunctions();
	}
	public static void testFunctions() throws  ArrayIndexOutOfBoundsException, AlreadyExistException, IsNotValidException, CompanyIsDifferentException {
		System.out.println("Create company");
		
		FurnitureCompany company1= new FurnitureCompany("Holding 1");
		
		System.out.println(company1.toString());
		
		/*Admin Section*/
		System.out.println("\nAdd admin to company");
		Administrator admin=new Administrator(company1,"Ugur","ER");
		System.out.println(admin.toString());
		
		System.out.println("\nAdd branch to company");
		Branch branch1=new Branch("branch 1");
		admin.addBranch(branch1);
		System.out.println(company1.getBranch().get(0).toString());
		
		System.out.println("\nAdd another branch to company");
		Branch branch2=new Branch("branch 2");
		admin.addBranch(branch2);
		System.out.println(company1.getBranch().get(1).toString());
		
		System.out.println("\nAdd employee to branch 1");
		BranchEmployee employee1=new BranchEmployee("elon","musk");
		admin.addEmployee(branch1,employee1);
		System.out.println(company1.getBranch().get(0).getEmployees().get(0).toString());
		
		System.out.println("Add employee to branch 2");
		admin.addEmployee(branch2,new BranchEmployee("mark","zucker"));
		System.out.println(company1.getBranch().get(1).getEmployees().get(0).toString());
		
		System.out.println("product query with admin");
		admin.productQuery(branch2, new Chair(1,1));
		
		/*create and add products to first branch*/
		array<AbstractProduct> products=new array<>();
		products.add(new Chair(2,5));
		products.add(new Desk(2,1));
		products.add(new MeetingTable(2,1));
		products.add(new Cabinet(2));
		products.add(new Bookcase(2));
		
		admin.addAllProducts(branch1, products);
		admin.addAllProducts(branch2, products);
		
		/*Customer Section*/
		System.out.println("\nAdd customer to company");
		Customer customer1=new Customer(company1,"elon","musk","tesla.com","mars");
		System.out.println(customer1.toString());
		
		System.out.println("Add another customer to company for check id numbers");
	
		Customer customer2=new Customer(company1,"mark","musk","tesla.com","mars");
		System.out.println(customer2.toString());
		
		System.out.println("see all products at company as customers");
		customer1.seeProducts();
		
		System.out.println("Shop online:(this is first order.So, customer will subscribe)");
		customer1.shopOnline(new Chair(1,5), "mars","123123");
		
		System.out.println("see customer orders");
		System.out.println(customer1.seeOrders());
		
		System.out.println("if the desired product is not in stores(The customer will not re-register because he registered before.  ");
		customer1.shopOnline(new Chair(5,5),"mars","1222");
		
		
		/*Employee Section*/
		System.out.println("\nsell product with employee");
		employee1.makesell(customer1, new Desk(3,2));
		System.out.println(customer1.seeOrders());
		
		System.out.println("add product with employee");
		System.out.println("before add:");
		System.out.println(branch1.showProducts());
		employee1.addProduct(new MeetingTable(1,1));
		System.out.println("after add:");
		System.out.println(branch1.showProducts());
		
		System.out.println("remove product with employee");
		System.out.println("before remove:");
		System.out.println(branch1.showProducts());
		employee1.removeProduct(new MeetingTable(1,1));
		System.out.println("after remove:");
		System.out.println(branch1.showProducts());
		
		System.out.println("check stock of product inform to manager and make sell functıons of employees\n");
		
		Desk desk=new Desk(1,2);
		if(employee1.stockOf(desk)==false)
			employee1.infoToManager(desk);
		employee1.makesell(customer1,desk);
		
		
		/*Admin Section(remove branch and employee)*/
		System.out.println("add employee to branch 1");
		admin.addEmployee(branch1,new BranchEmployee("mark","zuckerburg"));
		
		System.out.println("remove employee:");
		System.out.println("before remove:\n"+branch1.showEmployees());
		admin.removeEmployee(employee1);
		System.out.println("after remove: "+branch1.showEmployees());
		
		System.out.println("remove branch:");
		System.out.println("before remove:\n"+admin.seeBranchs());
		admin.removeBranch(branch1);
		System.out.println("after remove:\n"+admin.seeBranchs());
		
		
		/*EXCEPTİONS*/
		System.out.println("\n\nSome possible exceptions");
		
		
		System.out.println("\n\n try to add invalid product");
		try {
		admin.addProduct(branch2, new Chair(10,10));
		}
		catch(IsNotValidException e) {
			System.out.println(e);
		}
		
		System.out.println("\nwhen the store is removed, the workers cannot access the store.");
		
		System.out.println("Employees at branch 1: "+branch1.showEmployees());
		admin.removeBranch(branch1);
		try {
			branch1.getEmployees().get(0).getBranch().showEmployees();
		}
		catch(NullPointerException e) {
			System.out.println(e);
		}
		
		System.out.println("\n\nif the company is null(the same applies to other null exceptions)");
		/*if the company is null*/
		try {
			Administrator admin1=new Administrator(null,"Uğur","ER");
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		System.out.println("\ntry to add one admin more at same company:");
		/* try to add one admin more at same company*/
		try {
		Administrator admin2=new Administrator(company1,"Ahmet","Turan");
		}
		catch(AlreadyExistException e){
			System.out.println(e);
		}
		
		System.out.println("\nwhile there is no branch in company, try to add employee");
		FurnitureCompany company= new FurnitureCompany("Holding 2");
		Administrator admin2=new Administrator(company,"Ahmet","Turan");
		Branch branch3=new Branch("store 1");
		try {
			admin2.addEmployee(branch3,new BranchEmployee("ahmet","ali"));
		}
		catch(CompanyIsDifferentException e){
			System.out.println(e);
		}
		
		System.out.println("\ntry to add same employee to another branch");
		Branch branch4=new Branch("store 2");
		admin2.addBranch(branch3);
		admin2.addBranch(branch4);
		admin2.addEmployee(branch3,new BranchEmployee("ahmet","ali"));
		try {
			admin2.addEmployee(branch4,new BranchEmployee("ahmet","ali"));
		}
		catch(AlreadyExistException e) {
			System.out.println(e);
		}
		
		System.out.println("\nwhen there are no employees in the company, try to shop with customer: ");
		FurnitureCompany company3= new FurnitureCompany("Holding 2");
		Administrator admin3=new Administrator(company3,"Ahmet","Turan");
		Branch branch5=new Branch("store 1");
		admin3.addBranch(branch5);
		Customer cust=new Customer(company3,"ugur","er","@.com","123");
		try {
		cust.shopOnline(new Chair(5,4), "bbbb", "aaaaa");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}	

}
