import java.util.Arrays;
import java.util.List;

public class AI {
	private char symb;
	private int dotsToWin;

	public AI(char symb, int dotsToWin){
		this.dotsToWin = dotsToWin;
		this.symb = symb;
	}

	public char getSymb(){
		return symb;
	}

	public void makeMove(Map map) {
		int[] resultOfMinMax = minimax(map, symb, 2);
		map.updateMap(resultOfMinMax[1], resultOfMinMax[2], symb);
	}

	public int[] minimax(Map mapInitial, char symb, int depth){
		Map map = new Map(mapInitial.getMap());
		char[][] mapCopy = map.getMap().clone();
		List<int[]> nextMoves = map.emptyCells();
		char aiSymb = (getSymb() == 'X') ? 'X' : 'O';
		char huSymb = (getSymb() == 'O') ? 'X' : 'O';
		int bestScore = (symb == aiSymb) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

		int currentScore;
		int bestRow = -1;
		int bestCol = -1;

		if (map.checkWin(aiSymb) || map.checkWin(huSymb) || nextMoves.isEmpty() || depth == 0) {
			bestScore = countScore(mapCopy);
		} else {
			for (int[] move : nextMoves) {
				mapCopy[move[0]][move[1]] = symb;
				if (symb == aiSymb) {
					currentScore = minimax(map, huSymb, depth - 1)[0];
					if (currentScore > bestScore) {
						bestScore = currentScore;
						bestRow = move[0];
						bestCol = move[1];
					}
				} else {
					currentScore = minimax(map, aiSymb, depth - 1)[0];
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


	public int countScore(char[][] map) {
		char aiSymb = symb;
		char huSymb = (symb == 'X') ? 'O' : 'X';
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
				if (countXai == dotsToWin || countYai == dotsToWin || countD1ai == dotsToWin || countD2ai == dotsToWin) score += 100;
				if (countXhu == dotsToWin || countYhu == dotsToWin || countD1hu == dotsToWin || countD2hu == dotsToWin) score -= 100;
				if (countXai == dotsToWin-1 || countYai == dotsToWin-1 || countD1ai == dotsToWin-1 || countD2ai == dotsToWin-1) score +=10;
				if (countXhu == dotsToWin-1 || countYhu == dotsToWin-1 || countD1hu == dotsToWin-1 || countD2hu == dotsToWin-1) score -=10;
				if (countXai == dotsToWin-2 || countYai == dotsToWin-2 || countD1ai == dotsToWin-2 || countD2ai == dotsToWin-2) score +=1;
				if (countXhu == dotsToWin-2 || countYhu == dotsToWin-2 || countD1hu == dotsToWin-2 || countD2hu == dotsToWin-2) score -=1;
			}
		}
		return score;
	}
}
