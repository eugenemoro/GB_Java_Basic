public class Player {
	private char symb;

	public Player(char symb){
		this.symb = symb;
	}

	public char getSymb() {
		return symb;
	}

	public void makeMove(Map map, int x, int y) {
		map.updateMap(x, y, symb);
	}
}
