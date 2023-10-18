import java.util.*;
public class Testmain {
    public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	Manager objm=new Manager();
	Trainer objt=new Trainer();
	Developer objd=new Developer();
	Lead objl=new Lead();
	Companies all=new Companies();
   	boolean loop = true;
    	while (loop)
      	   {
		System.out.println("1.Add Employee  \n2.Add Role \n3.Remove Role\n4.Show Employee\n5.Filter Employee with responsibility \n6.Add company\n7.Exit");
		int choice = sc.nextInt();
		sc.nextLine();
		switch (choice){
	  		case 1:{
	  			System.out.println ("Enter the Company Name:");
                                String sname=sc.nextLine();
                                Company cmp=all.getCompany(sname);
                                if(cmp==null){
                                        System.out.println("Company not found");
                                        break;
                                }
	     		        System.out.println ("Enter the Employee Name:");
	     		        String name=sc.nextLine();
	     		        System.out.println ("Enter the age:");
	     		        byte age=sc.nextByte();
	     		        sc.nextLine();
				Employee ob=new Employee(name,age);
	     		        System.out.println ("Enter the Role to be add\n1.Manager\n2.Trainer\n3.Developer\n4.Lead");
	     		        byte role=sc.nextByte();
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
	 		 	System.out.println ("Enter the Company Name:");
                                String sname=sc.nextLine();
                                Company cmp=all.getCompany(sname);
                                if(cmp==null){
                                        System.out.println("Company not found");
                                        break;
                                }
				System.out.println("Enter the employee name");
				String name=sc.nextLine();
	 		 	Employee ob=cmp.getEmployee(name);
	 		 	byte c=1;
	 		 	 while(ob==null&&c==1){
					System.out.println("Employee doesn't exist\nPress 1 to continue");
					c=sc.nextByte();
					name=sc.nextLine();
					if(c==1){
						System.out.println("Enter the employee name");
						name=sc.nextLine();
	 		 			ob=cmp.getEmployee(name);
					}
				}
				if(c!=1)
					break;
				System.out.println("Enter the role to be add\n1.Manager\n2.Trainer\n3.Developer\n4.Lead");
				byte role=sc.nextByte();
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
				System.out.println ("Enter the Company Name:");
                                String sname=sc.nextLine();
                                Company cmp=all.getCompany(sname);
                                if(cmp==null){
                                        System.out.println("Company not found");
                                        break;
                                }
				System.out.println("Enter the employee name");
				String name=sc.nextLine();
	 		 	Employee ob=cmp.getEmployee(name);
	 		 	byte c=1;
	 		 	 while(ob==null&&c==1){
					System.out.println("Employee doesn't exist\nPress 1 to continue");
					c=sc.nextByte();
					name=sc.nextLine();
					if(c==1){
						System.out.println("Enter the employee name");
						name=sc.nextLine();
	 		 			ob=cmp.getEmployee(name);
					}
				}
				if(c!=1)
					break;
                                System.out.println("Enter the role to be remove\n1.Manager\n2.Trainer\n3.Developer\n4.Lead");
                                byte role=sc.nextByte();
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
	    			System.out.println ("Enter the Company Name:");
                                String sname=sc.nextLine();
                                Company cmp=all.getCompany(sname);
                                if(cmp==null){
                                        System.out.println("Company not found");
                                        break;
                                }
				System.out.println("Employees in the organaization");
				cmp.showEmployee();
	      			break;
	    		}
	    		case 5:{
	    			System.out.println ("Enter the Company Name:");
                                String sname=sc.nextLine();
                                Company cmp=all.getCompany(sname);
                                if(cmp==null){
                                        System.out.println("Company not found");
                                        break;
                                }
				System.out.println("Enter the Responsibility");
                                String resp=sc.nextLine();
				cmp.printEmployeeWithResponsibility(resp);
	      			break;
	    		}
	    		case 6:{
	    			System.out.println ("Enter the Company Name:");
	     		        String name=sc.nextLine();
	     		        System.out.println ("Enter Address :");
	     		        String ad=sc.nextLine();
	     		        Company cmp=all.getCompany(name);
                                if(cmp!=null){
                                        System.out.println("Company name already exist ");
                                        break;
                                }
	     		        Company obj=new Company(name,ad);
	     		        all.addCompany(obj);
	     		        break;
	    		}
	  		case 7:{
	      			loop=false;
	 		 }
      	   }
       }
    }
}
