package customSorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeById implements Comparator<Employee>{

	@Override
	public int compare(Employee x, Employee y) {
		String i=x.getId();
		String j=y.getId();
		return i.compareTo(j);
		// retutn x.getId().compareTo(y.getId());
}
}
