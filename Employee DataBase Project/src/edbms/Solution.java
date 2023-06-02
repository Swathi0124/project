package edbms;

import java.util.Scanner;

import customException.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {
		Scanner ip= new Scanner(System.in);
		EmployeeManagementSystem ems=new EmployeeManagementSystemImp();
		while(true) {
			System.out.println("welcome to Employee DBMS");
			System.out.println("1.Add Emp\n2.Display Emp\n3.DisplayAll Emp\n4.Remove Emp");
			System.out.println("5.Remove All Emp\n6.Update Emp\n7.Count Emp\n8.Sort Emp");
			System.out.println("9. Find Emp lowest sal\n10.Find Emp with Heighest sal");
			System.out.println("11.Exit\nEnter the choice");
			int choice=ip.nextInt();
			switch(choice) {
			case 1:
				ems.addEmployee();
				break;
			case 2:
				ems.displayEmployee();
				break;
			case 3:
				ems.displayAllEmployee();
				break;
			case 4:
				ems.removeEmployee();
				break;
			case 5:
				ems.removeAllEmoployee();
				break;
			case 6:
				ems.updateEmployee();
				break;
			case 7:
				ems.countEmployee();
				break;
			case 8:
				ems.sortEmployee();
				break;
			case 9:
				ems.findEmployeeWithMinSAlary();
				break;
			case 10:
				ems.findEmployeeWithMaxSalary();
				break;
			case 11:
					System.out.println("Thank you!!...");
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

	}

		}