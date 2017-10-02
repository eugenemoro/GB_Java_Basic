public class Model {
	private Map map;
	private Player player;
	private AI ai;
	private Controller controller;

	public void initModel(int size, char huSymb, char aiSymb, Controller controller) {
		map = new Map(size);
		player = new Player(huSymb);
		ai = new AI(aiSymb, size);
		this.controller = controller;
		if (aiSymb == 'X') ai.makeMove(map);
	}

	public boolean makeMove(int x, int y){
		if (cellIsEmpty(x, y)) {
			if (!checkEndOfGame()) {
				player.makeMove(map, x, y);
				controller.repaintView();
			}
			if (!checkEndOfGame()){
				ai.makeMove(map);
				controller.repaintView();
			}
			checkEndOfGame();
		}
		return true;
	}

	private boolean cellIsEmpty(int x, int y) {
		if (map.getMap()[x][y] == '*')
			return true;
		else
			return false;
	}

	public Map getMap() {
		return map;
	}

	public boolean checkEndOfGame(){
		if (map.isMapFull()) {
			controller.gameFinished("It's a draw!");
			return true;
		}
		if (map.checkWin(player.getSymb())) {
			controller.gameFinished("Congrats! You won!");
			return true;
		}
		if (map.checkWin(ai.getSymb())) {
			controller.gameFinished("Sorry! You stupido!");
			return true;
		}
		return false;
	}
}
