import java.util.*;
public class Testmain {
    public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	Manager objm=new Manager();
	Trainer objt=new Trainer();
	Developer objd=new Developer();
	Lead objl=new Lead();
	Company cmp=new Company();
   	boolean loop = true;
    	while (loop)
      	   {
		System.out.println("1.Add Employee  \n2.Add Role \n3.Remove Role\n4.Show Employee\n5.Filter Employee with responsibility \n6. Exit");
		int choice = sc.nextInt();
		sc.nextLine();
		switch (choice){
	  		case 1:{
	     		        System.out.println ("Enter the Employee Name:");
	     		        String name=sc.nextLine();
	     		        System.out.println ("Enter the age:");
	     		        int age=sc.nextInt();
	     		        sc.nextLine();
				Employee ob=new Employee(name,age);
	     		        System.out.println ("Enter the Role to be add\n1.Manager\n2.Trainer\n3.Developer\n4.Lead");
	     		        int role=sc.nextInt();
				sc.nextLine();
				switch (role){
                        		case 1:{
						ob.addRole(objm);
                                		break;
                        		 }
                         		case 2:{
						ob.addRole(objt);
                        	        	break;
                       			 }

                        		case 3:{
						ob.addRole(objd);
                               			break;
                        		}
                       			case 4:{
                               			ob.addRole(objl);
                       			 }
                       		}
				cmp.addEmployee(ob);
				System.out.println(name+" was added as an employee\n");
	     			break;
	   		 }
	 		 case 2:{
				System.out.println("Enter the employee name");
				String name=sc.nextLine();
	 		 	Employee ob=cmp.getEmployee(name);
	 		 	 if(ob==null){
					System.out.println("Employee doesn't exist");
					break;
				}
				System.out.println("Enter the role to be add\n1.Manager\n2.Trainer\n3.Developer\n4.Lead");
				int role=sc.nextInt();
                                sc.nextLine();
                                switch (role){
                                        case 1:{
                                                ob.addRole(objm);
                                                break;
                                         }
                                        case 2:{
                                                ob.addRole(objt);
                                                break;
                                         }
					 
                                        case 3:{
                                                ob.addRole(objd);
                                                break;
                                        }
                                        case 4:{
                                                ob.addRole(objl);
                                         }
				}
	     			break;
	    		}

	  		case 3:{
				System.out.println("Enter the employee name");
                                String name=sc.nextLine();
                                Employee ob=cmp.getEmployee(name);
                                if(ob==null){
					System.out.println("Employee doesn't exist");
					break;
				}
                                System.out.println("Enter the role to be remove\n1.Manager\n2.Trainer\n3.Developer\n4.Lead");
                                int role=sc.nextInt();
                                sc.nextLine();
                                switch (role){
                                        case 1:{
                                                ob.removeRole(objm);
                                                break;
                                         }
                                        case 2:{
                                                ob.removeRole(objt);
                                                break;
                                         }

                                        case 3:{
                                                ob.removeRole(objd);
                                                break;
                                        }
                                        case 4:{
                                                ob.removeRole(objl);
                                         }

	      			}
	      			break;
	    		}
	    		case 4:{
				System.out.println("Employees in the organaization");
				cmp.showEmployee();
	      			break;
	    		}
	    		case 5:{
				System.out.println("Enter the Responsibility");
                                String resp=sc.nextLine();
				cmp.printEmployeeWithResponsibility(resp);
	      			break;
	    		}
	  		case 6:{
	      			loop=false;
	 		 }
      	   }
       }
    }
}
