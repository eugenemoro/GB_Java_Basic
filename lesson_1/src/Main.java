public class Main {
	public static void main(String[] args){
		byte a = 1;
		short b = 2;
		int c = 3;
		long d = 4L;

		float e = 1.2f;
		double f = 3.14;

		boolean g = true;

		char h = 'a';

		String str = "temp";
	}

	public static int task3(int a, int b, int c, int d){
		return a * (b + (c / d));
	}

	public static boolean task4(int a, int b){
		return (a + b > 10 && a + b < 20);
	}

	public static void task5(int a){
		if (a < 0)
			System.out.println("Число отрицательное");
		else
			System.out.println("Число положительное");
	}

	public static boolean task6(int a){
		return a < 0;
	}

	public static void task7(String name){
		System.out.println("Привет, " + name + "!");
	}

	public static boolean task8(int year){
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
	}

}
