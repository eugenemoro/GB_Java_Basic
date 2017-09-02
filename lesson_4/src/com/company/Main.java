package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Random random = new Random();
    public static void main(String[] args) {
        guessWord();
//        int userChoice = 1;
//        do{
//            guessNumber();
//            System.out.println("Хотите поиграть еще? 1 - да, 0 - нет");
//            userChoice = sc.nextInt();
//        }while(userChoice == 1);

    }
    public static void guessNumber(){
        int randomNumber = random.nextInt(10);
        System.out.println(randomNumber);
        System.out.println("Загадано число от 0 до 9, угадать с 3-х попыток");
        for(int i = 0; i < 3; i++){
            System.out.println("Введите число");
            int userNumber = sc.nextInt();
            if(userNumber == randomNumber){
                System.out.println("Вы победили!");
                break;
            }
            if(userNumber < randomNumber) System.out.println("Загаданное число больше");
            if(userNumber > randomNumber) System.out.println("Загаданное число меньше");
            if(i==2) System.out.println("Вы проиграли. Загаданное число " + randomNumber);
        }

    }
    public static void guessWord(){
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        char[] temp = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
        String keyWord = words[random.nextInt(words.length)];
        System.out.println(keyWord);
        String str;
        do{
            System.out.println("Введите слово");
            str = sc.nextLine();
            if(str.equals(keyWord)){
                System.out.println("Вы победили!");
                break;
            }else{
                int length;
                if(keyWord.length() < str.length()) length = keyWord.length();
                else length = str.length();
                for(int i = 0; i < length; i++){
                    if((keyWord.charAt(i) == str.charAt(i)) && temp[i] == '#') temp[i] = keyWord.charAt(i);
                }
            }
            System.out.println(temp);
        }while(!str.equals(keyWord));

    }
}
