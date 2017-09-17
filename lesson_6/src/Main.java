public class Main {
	public static void main(String[] args) {
		Dog dog1 = new Dog("Rex");
		System.out.println(dog1.getName() + " run: " + dog1.run(220)
																			+ " swim: " + dog1.swim(10)
																			+ " jump: " + dog1.jump(0.1));
		Cat cat1 = new Cat("Fluffy");
		System.out.println(cat1.getName() + " run: " + cat1.run(100)
						+ " swim: " + cat1.swim(0.1)
						+ " jump: " + cat1.jump(1.1));

	}
}
