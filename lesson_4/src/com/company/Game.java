package com.company;

import java.util.*;

public class Game {
    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = SIZE;
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static boolean turn;
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args){
        game();
    }
    public static void game(){
        initMap();
        printMap();
        System.out.println("Выберите X или O");
        while (true) {
            String temp = scanner.nextLine().toUpperCase();
            if (temp.equals("X") || temp.equals("Х")) {
                turn = true;
                break;
            } else if (temp.equals("O") || temp.equals("О")) {
                turn = false;
                break;
            } else {
                System.out.println("Неверный ввод. Повторите ввод.");
            }
        }

        while(true){
            if (turn) humanTurn(); else aiTurn();
            printMap();
            if(checkWin(map, DOT_X)){
                if (turn) System.out.println("Победил человек"); else System.out.println("Победил ИИ");
                break;
            }
            if(isMapFull(map)){
                System.out.println("Ничья");
                break;
            }
            if (turn) aiTurn(); else humanTurn();
            printMap();
            if(checkWin(map, DOT_O)){
                if (turn) System.out.println("Победил ИИ"); else System.out.println("Победил человек");
                break;
            }
            if(isMapFull(map)){
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static void humanTurn(){
        int x,y;
        do{
            System.out.println("Введите координаты в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }while(!isCellValid(x,y));
        if (turn) map[y][x] = DOT_X;
        else map[y][x] = DOT_O; //Координата х идет по горизонтали, за нее отвечает строка, а за коодинату y отвечает столбец. В массиве эти значения идут наоборот
    }
    public static void aiTurn(){
        int x,y;
        int[] resultOfMinMax = minimax(map,(turn) ? 'O' : 'X', 5);
        x = resultOfMinMax[2];
        y = resultOfMinMax[1];
        if (turn) map[y][x] = DOT_O;
        else map[y][x] = DOT_X;
    }
    public static boolean isCellValid(int x,int y){
        if(x< 0 || x >= SIZE || y < 0 || y >= SIZE ) return false; //проверяем попадают ли введеные координаты в размер поля
        if(map[y][x] == DOT_EMPTY) return true; //проверяем, что там нет символов игроков
        return false;
    }
    public static boolean isMapFull(char[][] mapCopy){
        for(int i = 0; i < mapCopy.length; i++){
            for(int j = 0; j < mapCopy[i].length; j++){
                if(map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean checkWin(char[][] mapCopy, char symb){
        for (int i = 0; i < mapCopy.length; i++) {
            int countX = 0;
            int countY = 0;
            int countD1 = 0;
            int countD2 = 0;
            for (int j = 0; j < mapCopy[i].length; j++) {
                if (mapCopy[i][j] == symb) countX++;
                if (mapCopy[j][i] == symb) countY++;
                if (mapCopy[j][j] == symb) countD1++;
                if (mapCopy[mapCopy[i].length - 1 - j][j] == symb) countD2++;
                if (countX == DOTS_TO_WIN || countY == DOTS_TO_WIN || countD1 == DOTS_TO_WIN || countD2 == DOTS_TO_WIN) return true;
            }
        }
        return false;
    }

    public static void initMap(){
        map = new char[SIZE][SIZE];
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap(){
        for(int i = 0; i <= SIZE; i++){
            System.out.print(i + " "); //Выводим шапку с подсказками координат
        }
        System.out.println();
        for(int i = 0; i < SIZE; i++){
            System.out.print(i+1 + " "); //выводим подсказку по координатам по вертикали
            for(int j = 0; j < SIZE; j++){
                System.out.print(map[i][j] + " "); //основной цикл вывода карты на экран
            }
            System.out.println();
        }
        System.out.println();
    }

    public static List emptyCells(char[][] map) {
        ArrayList<int[]> availableCells = new ArrayList<>();

        if (checkWin(map,'X') || checkWin(map,'O') || isMapFull(map))
            return availableCells;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == '*') availableCells.add(new int[]{i,j});
            }
        }
        return availableCells;
    }

    public static int[] minimax(char[][] map, char symb, int depth){
        char[][] mapCopy = map.clone();
        List<int[]> nextMoves = emptyCells(mapCopy);
        char aiSymb = (!turn) ? 'X' : 'O';
        char huSymb = (turn) ? 'X' : 'O';
        int bestScore = (symb == aiSymb) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        int currentScore;
        int bestRow = -1;
        int bestCol = -1;

        if (checkWin(mapCopy, aiSymb) || checkWin(mapCopy, huSymb) || nextMoves.isEmpty() || depth == 0) {
            bestScore = countScore(mapCopy);
        } else {
            for (int[] move : nextMoves) {
                mapCopy[move[0]][move[1]] = symb;
                if (symb == aiSymb) {
                    currentScore = minimax(mapCopy, huSymb, depth - 1)[0];
                    if (currentScore > bestScore) {
                        bestScore = currentScore;
                        bestRow = move[0];
                        bestCol = move[1];
                    }
                } else {
                    currentScore = minimax(mapCopy, aiSymb, depth - 1)[0];
                    if (currentScore < bestScore) {
                        bestScore = currentScore;
                        bestRow = move[0];
                        bestCol = move[1];
                    }
                }
                // Undo move
                mapCopy[move[0]][move[1]] = '*';
            }
        }
        return new int[] {bestScore, bestRow, bestCol};
    }

    public static int countScore(char[][] map) {
        char aiSymb = (!turn) ? 'X' : 'O';
        char huSymb = (turn) ? 'X' : 'O';
        int score = 0;

        for (int i = 0; i < map.length; i++) {
            int countXai = 0;
            int countYai = 0;
            int countD1ai = 0;
            int countD2ai = 0;
            int countXhu = 0;
            int countYhu = 0;
            int countD1hu = 0;
            int countD2hu = 0;
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == aiSymb) countXai++;
                if (map[j][i] == aiSymb) countYai++;
                if (map[j][j] == aiSymb) countD1ai++;
                if (map[map[i].length - 1 - j][j] == aiSymb) countD2ai++;
                if (map[i][j] == huSymb) countXhu++;
                if (map[j][i] == huSymb) countYhu++;
                if (map[j][j] == huSymb) countD1hu++;
                if (map[map[i].length - 1 - j][j] == huSymb) countD2hu++;
                if (countXai == DOTS_TO_WIN || countYai == DOTS_TO_WIN || countD1ai == DOTS_TO_WIN || countD2ai == DOTS_TO_WIN) score += 100;
                if (countXhu == DOTS_TO_WIN || countYhu == DOTS_TO_WIN || countD1hu == DOTS_TO_WIN || countD2hu == DOTS_TO_WIN) score -= 100;
                if (countXai == DOTS_TO_WIN-1 || countYai == DOTS_TO_WIN-1 || countD1ai == DOTS_TO_WIN-1 || countD2ai == DOTS_TO_WIN-1) score +=10;
                if (countXhu == DOTS_TO_WIN-1 || countYhu == DOTS_TO_WIN-1 || countD1hu == DOTS_TO_WIN-1 || countD2hu == DOTS_TO_WIN-1) score -=10;
                if (countXai == DOTS_TO_WIN-2 || countYai == DOTS_TO_WIN-2 || countD1ai == DOTS_TO_WIN-2 || countD2ai == DOTS_TO_WIN-2) score +=1;
                if (countXhu == DOTS_TO_WIN-2 || countYhu == DOTS_TO_WIN-2 || countD1hu == DOTS_TO_WIN-2 || countD2hu == DOTS_TO_WIN-2) score -=1;
            }
        }
        return score;
    }
}
