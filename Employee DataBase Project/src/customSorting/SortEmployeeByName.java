package customSorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeByName implements Comparator<Employee>{

	@Override
	public int compare(Employee x, Employee y) {
		  String i=x.getName();
		  String j=y.getName();
		return i.compareTo(j);
		//return x.getName().compareTo(y.getName());
	}

}
