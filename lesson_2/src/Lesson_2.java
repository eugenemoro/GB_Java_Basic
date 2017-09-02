import java.util.Arrays;

public class Lesson_2 {
	public static void main(String[] args) {
		//task1
		int[] ar0 = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
		for (int i = 0; i < ar0.length; i++) {
			ar0[i] = (ar0[i] == 0) ? 1 :  0;
		}

		//task2
		int[] ar1 = new int[8];
		for (int i = 0; i < 8; i++) {
			ar1[i] = i * 3;
		}

		//task3
		int[] ar2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
		for (int i = 0; i < ar2.length; i++) {
			if (ar2[i] < 6) ar2[i] *= 2;
		}

		//task4
		int[][] ar3 = new int[5][5];
		for (int i = 0; i < ar3.length; i++) {
				ar3[i][i] = 1;
				ar3[i][ar3[i].length-i-1] = 1;
		}


		//task5
		int[] ar4 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
		int min, max;
		min = max = ar4[0];
		for (int i = 0; i < ar4.length; i++) {
			if (ar4[i] < min) min = ar4[i];
			if (ar4[i] > max) max = ar4[i];
		}
		//System.out.println(min + " " + max);

		//task6
		//int[] test = {2,1,1,2,1};
		//System.out.println(task6(test));

		//task7
		int[] test = {0, 1, 2, 3, 4};
		System.out.println(Arrays.toString(task7(test, -1)));
	}

	public static boolean task6(int[] ar5){
		int sum1 = 0;
		int sum2;
		boolean result = false;
		for (int i = 0; i < ar5.length; i++) {
			sum2 = 0;
			sum1 += ar5[i];
			for (int j = i + 1; j < ar5.length; j++) {
				sum2 += ar5[j];
			}
			if (sum1 == sum2) {
				result = true;
				break;
			}
		}
		return result;
	}

	public static int[] task7(int[] ar6, int n) {
		int numOfElem = ar6.length;
		int numOfSteps = n;
		int tmp, t, j, k;

		while (numOfSteps !=0) {
			tmp = numOfElem%numOfSteps;
			numOfElem = numOfSteps;
			numOfSteps = tmp;
		}

		for (int i = 0; i < numOfElem; i++) {
			t = ar6[i];
			j = i;
			while (true){
				k = j + n;

				if (k >= ar6.length) k -= ar6.length;
				if (k < 0) k = ar6.length + k;
				if (k == i) break;

				ar6[j] = ar6[k];
				j = k;
			}
			ar6[j] = t;
		}



		return ar6;
	}

/*	public static int[] task7(int[] ar6, int n) {
		int tempElement1, tempElement2, tempSpot;
		int[] arChangedIndexes = new int[ar6.length]; //запоминаем индексы измененных элементов

		tempSpot = 0; //начальное условие
		tempElement1 = ar6[0];

		for (int i = 0; i < ar6.length; i++) {
			// расчет следующего индекса с проверкой на переход через начало или конец массива
			if (tempSpot + n >= ar6.length) {
				tempSpot = tempSpot + n - ar6.length;
			}
			else if (tempSpot + n < 0) {
				tempSpot = ar6.length + (tempSpot + n);
			}
			else tempSpot += n;

			//проверяем не были ли изменен элемент ранее
			if (arChangedIndexes[tempSpot] == 1) {
				//если был, ищем индекс следующего неизмененного элемента
				for (int j = 0; j < arChangedIndexes.length; j++) {
					if (arChangedIndexes[j] == 0) {
						//запоминаем элемент
						if (j + n >= ar6.length) {
							tempSpot = j + n - ar6.length;
						}
						else if (j + n < 0) {
							tempSpot = ar6.length + (j + n);
						}
						else tempSpot = j + n;
						tempElement1 = ar6[j];
						//выходим из цикла
						break;
					}
				}
			}
			//запоминаем во временное хранилище изменяемый элемент
			tempElement2 = ar6[tempSpot];
			//заменяем его элементом из постояннго хранилища
			ar6[tempSpot] = tempElement1;
			//помечаем как изменный
			arChangedIndexes[tempSpot] = 1;
			//перемещаем элемент из временного хранилища в постоянное
			tempElement1 = tempElement2;
		}
		return ar6;
	}*/
}

/*
 	// Эта версия работает для n > 0 и массива с нечетным количеством элементов

 	public static int[] task7(int[] ar6, int n) {
		int tempElement1, tempElement2, tempSpot;
		tempSpot = 0;
		tempElement1 = ar6[0];
		for (int i = 0; i < ar6.length; i++) {
			if (tempSpot + n >= ar6.length) {
				tempSpot = tempSpot + n - ar6.length;
			}
			else if (tempSpot < 0) {
				tempSpot = ar6.length + (tempSpot + n);
			}
			else tempSpot += n;
			tempElement2 = ar6[tempSpot];
			ar6[tempSpot] = tempElement1;
			tempElement1 = tempElement2;
		}
		return ar6;
	}
*/