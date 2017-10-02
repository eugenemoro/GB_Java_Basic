import java.util.ArrayList;
import java.util.List;

public class Map {
	private char[][] map;

	public Map(int size) {
		map = new char[size][size];
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				map[i][j] = '*';
			}
		}
	}

	public Map(char[][] map) {
		this.map = map;
	}

	public char[][] getMap() {
		return map;
	}

	public void updateMap(int x, int y, char symb) {
		map[x][y] = symb;
	}

	public boolean isMapFull(){
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				if(map[i][j] == '*') return false;
			}
		}
		return true;
	}

	public boolean checkWin(char symb){
		for (int i = 0; i < map.length; i++) {
			int countX = 0;
			int countY = 0;
			int countD1 = 0;
			int countD2 = 0;
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == symb) countX++; else countX = 0;
				if (map[j][i] == symb) countY++; else countY = 0;
				if (map[j][j] == symb) countD1++;
				if (map[map[i].length - 1 - j][j] == symb) countD2++;
				if (countX == map.length || countY == map.length || countD1 == map.length || countD2 == map.length) return true;
			}
		}
		return false;
	}

	public List emptyCells() {
		ArrayList<int[]> availableCells = new ArrayList<>();

		if (checkWin('X') || checkWin('O') || isMapFull())
			return availableCells;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == '*') availableCells.add(new int[]{i,j});
			}
		}
		return availableCells;
	}
}
