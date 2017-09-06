public class Main {
	public static void main(String[] args) {
		Employee[] emplArray = new Employee[5]; // Вначале объявляем массив объектов
		emplArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 41);
		emplArray[1] = new Employee("Petrov Petr", "Senior Engineer", "ppetrov@mailbox.com", "89211111", 40000, 30);
		emplArray[2] = new Employee("Fedorov Fedor", "Lead Engineer", "ffedorov@mailbox.com", "892222", 50000, 42);
		emplArray[3] = new Employee("Sidorov Sidor", "Tech Manager", "ssidorov@mailbox.com", "89233333", 60000, 43);
		emplArray[4] = new Employee("Dmitriev Dmitriy", "Tech Director", "ddmitriev@mailbox.com", "89244442", 70000, 25);

		for (Employee employee : emplArray) {
			if (employee.getAge() > 40) employee.getAllInfo();
		}

	}
}
