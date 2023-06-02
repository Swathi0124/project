package edbms;

public class Employee {
	private String id;
	private String name;
	private int age;
	private double salary;
	private static int count=101;
	public Employee(String name, int age, double salary) {
		this.id = "JSP"+count;
		count++;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Id:"+id+" Name:"+name+" Age:"+age+" Salary:"+salary;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
