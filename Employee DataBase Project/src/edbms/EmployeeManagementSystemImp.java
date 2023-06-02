package edbms;

import java.security.DrbgParameters.NextBytes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customException.EmployeeNotFoundException;
import customException.InvalidChoiceException;
import customSorting.SortEmployeeByAge;
import customSorting.SortEmployeeById;
import customSorting.SortEmployeeByName;
import customSorting.SortEmployeeBySalary;

public class EmployeeManagementSystemImp implements EmployeeManagementSystem {
	//accepting input from the user
	Scanner ip=new Scanner(System.in);
	//creating the object of Map and specifying key and value
	Map<String,Employee> map= new LinkedHashMap<String,Employee>(); 
	@Override
	public void addEmployee() {
		//Accept name
		System.out.println("Enter the Name:");
		String name=ip.next();
		//Accept Age
		System.out.println("Enter the Age:");
		int age=ip.nextInt();
		// Accept sal
		System.out.println("Enter the Salary:");
		double  sal=ip.nextDouble();
		Employee emp=new Employee(name, age, sal);

		// key--> emp.id & value--->Employee object(emp)
		map.put(emp.getId(),emp);
		System.out.println("Added Employee into the database(map) successfully");
		System.out.println("Employee id is:"+emp.getId());


	}

	@Override
	public void displayEmployee() {
		System.out.println("Enter the Id:");
		String id=ip.next().toUpperCase();
		if(map.containsKey(id)) {
			System.out.println("Employee Found");
			System.out.println("Employee Details as follows:");
			Employee emp=map.get(id);
			System.out.println(emp);
		}
		else {
			//EmployeeNotFoundException
			try {
				throw new EmployeeNotFoundException("Employee not found in database");
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}


	}

	@Override
	public void displayAllEmployee() {
		//checking if the map is empty or not
		if(!map.isEmpty()) {
			System.out.println("Employee Details as follows");
			System.out.println("=================");
			Set<String> keys =map.keySet();
			for (String key : keys) {
				System.out.println(map.get(key));
			}
		}

		else {
			//EmployeeNotFoundException
			try {
				throw new EmployeeNotFoundException("Employee not found in database");
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeEmployee() {
		// accepting the id from the user 
		System.out.println("Enter the id:");
		String id=ip.next().toUpperCase();
		// checking whether the map contains the element or not
		if(map.containsKey(id)) {
			System.out.println("Id is Found!!");
			map.remove(id);
			System.out.println(id+"is removed succesfully!!");
		}
		else {
			//EmployeeNotFoundException
			try {
				throw new EmployeeNotFoundException("Employee not found in database to remove");
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}


	}

	@Override
	public void removeAllEmoployee() {
		// checking whether the map is containing element or not
		if(!map.isEmpty()) {
			System.out.println("Employees Found");
			map.clear();
			System.out.println("All Employees are Deleted");
		}
		else {
			try {
				String message="Employees not found to remove";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void updateEmployee() {

		System.out.println("Enter the id:");
		String id=ip.next().toUpperCase();
		if(map.containsKey(id)) {
			Employee emp=map.get(id);
			System.out.println("Employee id is found!!");
			System.out.println("1.update Age\n2.update name\n3.update sal");
			System.out.println("4.Exit\nEnter the choice");
			int choice=ip.nextInt();

			switch(choice) {
			case 1://accepting the Age
				System.out.println("Enter the Age:");
				int age=ip.nextInt();
				emp.setAge(age);
				System.out.println("Age Updated !!");

				break;
			case 2:
				System.out.println("Enter the Name:");
				String name=ip.next();
				emp.setName(name);
				System.out.println("Name Updated");
				break;
			case 3:
				System.out.println("Enter the Sal:");
				double sal=ip.nextDouble();
				emp.setSalary(sal);
				System.out.println("salary Updated");
				break;
			case 4:
				System.out.println("Thank you");
				System.exit(0);
			default:
				try {
					throw new InvalidChoiceException (" Enter valid choice");	
				}
				catch(InvalidChoiceException e){
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				String message="Employee id not found to Update";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void countEmployee() {
		System.out.println("Number of Employees in Database are"+map.size());
	}
	@Override
	public void sortEmployee() {
		// check whether map contains elements are not and convert value to List 
		//bcoz we cant sort the value(object) directly
		List<Employee> list= new ArrayList<Employee>();
		Set <String> keys=map.keySet();
		for (String key : keys) {
			//getting object/value and storing into the list
			list.add(map.get(key));
		}
		System.out.println("1.sort acc to Id\n2.sort acc to name\n3.sort acc to age");
		System.out.println("4.sort acc to sal\nEnter the choice");
		int choice=ip.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(list,new SortEmployeeById());
			for (Employee emp : list) {
				System.out.println(emp);
				}
			break;
		case 2:
			Collections.sort(list,new SortEmployeeByName());
			for (Employee emp : list) {
				System.out.println(emp);
				}
			break;
		case 3:
			Collections.sort(list,new SortEmployeeByAge());
			for (Employee emp : list) {
				System.out.println(emp);
				}
			break;
		case 4:
			Collections.sort(list,new SortEmployeeBySalary());
			for (Employee emp : list) {
				System.out.println(emp);
				}
			break;
		default:
			try {
				throw new InvalidChoiceException("Invalid choice...");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

		}
@Override
	public void findEmployeeWithMinSAlary() {
	/**creating the object of Array list
	 * getting the key of map and storing in set to traverse based on index position
	 * storing the  values of map inside the List which helps in Sorting 
	 * with the help of comparator obj
	 */
	List<Employee> list=new ArrayList<Employee>();
	Set<String> keys=map.keySet();
	for (String   key: keys) {
		list.add(map.get(key));
	}
	Collections.sort(list,new SortEmployeeBySalary());
	System.out.println("Employee with Heighest salary is:");
System.out.println(list.get(list.size()-1));

	}

	@Override
	public void findEmployeeWithMaxSalary() {
		List<Employee> list=new ArrayList<Employee>();
		Set<String> keys=map.keySet();
		for (String   key: keys) {
			list.add(map.get(key));
		}
		Collections.sort(list,new SortEmployeeBySalary());
		System.out.println("Employee with Lowest salary is:");
	System.out.println(list.get(0));


	}

}


