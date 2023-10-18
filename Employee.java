import java.util.*;
class Responsibility{
	private String responsibility;
	Responsibility(String responsibility){
		this.responsibility=responsibility;
	}
	@Override
        public boolean equals(Object o) {
      		if (o==this) {	
        		return true;  
       		 }  

		if (o==null||this.getClass()== o.getClass()){ 
			return false;
		}
        	return this.responsibility.equals(o);
  	 }  
	@Override
	public int hashCode() {
        	 return Objects.hash(responsibility);
    }
	
}
interface Role{
	Set<Responsibility> getResponsibilities();
}
								//Manager class
class Manager implements Role{
	private Set<Responsibility> responsibility=new HashSet<>();
        Manager(){
		responsibility.add(new Responsibility("hire"));
	 	responsibility.add(new Responsibility("fire"));
		responsibility.add(new Responsibility("appraisal"));
	}
	@Override
	public Set<Responsibility> getResponsibilities(){
		return responsibility;
	}
}

								//TRainer class
class Trainer implements Role{
	private Set<Responsibility> responsibility=new HashSet<>();
	public Trainer(){
		responsibility.add(new Responsibility("code"));
		responsibility.add(new Responsibility("test"));
		responsibility.add(new Responsibility("debug"));
		responsibility.add(new Responsibility("train"));
	}
	@Override
	public Set<Responsibility> getResponsibilities(){
		return responsibility;
	}
}

								//Devlober class
class Developer implements Role{
	private Set<Responsibility> responsibility=new HashSet<>();
	public Developer(){
		responsibility.add(new Responsibility("code"));
		responsibility.add(new Responsibility("test"));
		responsibility.add(new Responsibility("debug"));
		responsibility.add(new Responsibility("design"));
	}
	@Override
	public Set<Responsibility> getResponsibilities(){
		return responsibility;
	}
}
								//Lead
class Lead implements Role{
	Set<Responsibility> responsibility=new HashSet<>();
	public Lead(){
		responsibility.add(new Responsibility("hire"));
		responsibility.add(new Responsibility("test"));
		responsibility.add(new Responsibility("debug"));
		responsibility.add(new Responsibility("design"));
	}
	@Override
	public Set<Responsibility> getResponsibilities(){
		return responsibility;
	}
}

class Employee{
    private String name;
    private byte age;
    private Set<Role> roles = new HashSet<>();

    public Employee(String name, byte age) {
        this.name = name;
        this.age = age;
    }

    public void addRole(Role role) {
	if(roles.add(role))
        	System.out.println("\nRole added successfully\n");
        else
		System.out.println("\nRole already exist\n");

    }

    public void removeRole(Role role) {
		if(roles.remove(role))
			System.out.println("\nRole removed successfully\n");
		else
			System.out.println("\nRole doesn't exist\n");
    }

    public Set<Role> getRoles() {
        return roles;
    }
    public String getName(){
    	return this.name;
    }
   /* public void printName(){
        System.out.println(this.name);
	System.out.println(this.age);
	System.out.println(this.roles);
    }*/

}
class Company{
	String name;
	String address;
	Company(String name,String address){
		this.name=name;
		this.address=address;
	}
	private List<Employee> employees=new ArrayList<>();
	public void addEmployee(Employee e) {
		employees.add(e);
	}
	public void printEmployeeWithResponsibility(String responsibility){
		for(Employee employee :employees){
			int i=0;
			for(Role role:employee.getRoles()){
				for(Responsibility resp:role.getResponsibilities()){
					if(resp.equals(responsibility)){
						System.out.println(employee.getName());
						i=1;
						break;
					}		
				}
				if(i==1)
                                        break;
			}
			
		}
	}
	public void showEmployee(){
		 for(Employee employee :employees)
                        System.out.println(employee.getName());

	}

	public Employee getEmployee(String name){
		for(Employee employee :employees){
			if(employee.getName().equals(name))
				return employee;
		}
		return null;
	}
}
class Companies{
	private List<Company> allcompanies=new ArrayList<>();
	public void addCompany(Company c) {
		allcompanies.add(c);
	}
	
	
	public Company getCompany(String name){
		for(Company company :allcompanies){
			if(company.name.equals(name))
				return company;
		}
		return null;
	}
}
