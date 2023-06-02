package customSorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeByAge implements Comparator<Employee>{

	@Override
	public int compare(Employee x, Employee y) {
		Integer i=x.getAge();// Auto boxing
		Integer j=y.getAge();
		return i.compareTo(j);
		// compare to is applicable only for non primitive type of data
		// return x.getAge()-y.getAge();	

}
}
