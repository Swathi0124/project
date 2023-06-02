package customSorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeBySalary implements Comparator<Employee>{

	@Override
	public int compare(Employee x, Employee y) {
		Double i=x.getSalary();// Auto Boxing
		Double j=y.getSalary();

		return i.compareTo(j) ;
	}

}
