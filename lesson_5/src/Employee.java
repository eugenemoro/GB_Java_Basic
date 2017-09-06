public class Employee {
	private String name;
	private String position;
	private String email;
	private String phoneNumber;
	private int salary;
	private int age;

	public Employee(String name, String position, String email, String phoneNumber, int salary, int age) {
		setName(name);
		setPosition(position);
		setEmail(email);
		setPhoneNumber(phoneNumber);
		setSalary(salary);
		setAge(age);
	}

	public void getAllInfo() {
		System.out.println(new StringBuilder().append(getName() + " ")
						.append(getPosition() + " ")
						.append(getEmail() + " ")
						.append(getPhoneNumber() + " ")
						.append(getSalary() + " ")
						.append(getAge() + " "));
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
