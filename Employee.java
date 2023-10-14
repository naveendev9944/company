import java.util.*;
class Responsibility{
	private String responsibility;
	Responsibility(String responsibility){
		this.responsibility=responsibility;
	}
        public boolean equals(Object o) {  
      		if (o == this) {  
        		return true;  
       		 }  
      		if (!(o instanceof Responsibility)) {  
        		return false;  
     		 } 
     		 Responsibility s = (Responsibility) o;  
     		 return responsibility.equals(s.responsibility);  
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
	
	public Set<Responsibility> getResponsibilities(){
		return this.responsibility;
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
	
	public Set<Responsibility> getResponsibilities(){
		return this.responsibility;
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

	public Set<Responsibility> getResponsibilities(){
		return this.responsibility;
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
	public Set<Responsibility> getResponsibilities(){
		return this.responsibility;
	}
}

class Employee{
    private String name;
    private int age;
    private Set<Role> roles = new HashSet<>();

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addRole(Role role) {
        for(Role r:roles){
                if(r.equals(role)){
                        System.out.println("\nRole already exixst\n");
                        return;
                }
        }
	roles.add(role);
        System.out.println("\nRole added successfully\n");

    }

    public void removeRole(Role role) {
	for(Role r:roles){
		if(r.equals(role)){
			roles.remove(role);
			System.out.println("\nRole removed successfuul\n");
			return;
		}
	}
	System.out.println("\nThis Role is not exist for this employee\n");
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
						System.out.println(responsibility);
						break;
					}		
				}
			}
				if(i==1)
					break;
			
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
