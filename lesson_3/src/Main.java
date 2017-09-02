import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
						"carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
						"nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

		char[] quiz = new char[15];
		for (int i = 0; i < quiz.length; i++) {
			quiz[i] = '#';
		}

		String theWord = words[(int) Math.round(Math.random() * words.length)];

		System.out.println("Гадайте! :)");
		String guess = scanner.nextLine();
		while (!guess.equals(theWord)) {
			System.out.println("Слово не угадано");
			int min = Math.min(guess.length(), theWord.length());

			for (int i = 0; i < min; i++) {
				if (guess.charAt(i) == theWord.charAt(i)) quiz[i] = theWord.charAt(i);
			}

			System.out.println("Подсказка: " + Arrays.toString(quiz));
			guess = scanner.nextLine();
		}

		System.out.println("Слово угадано " + theWord.toUpperCase() + "!");
	}
}
