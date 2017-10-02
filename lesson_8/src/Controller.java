import com.sun.org.apache.xpath.internal.operations.Mod;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
	private static int size = 3;
	private Model model;
	private View view;
	private boolean canMakeMove = true;
	private boolean gameFinished = false;

	public Controller(Model m, View v) {
		model = m;
		view = v;
		initView();
	}

	private void initView() {
		view.setGf(this);
		view.getGf().setSize(size);
	}

	public void initController(){
		view.getJbStart().addActionListener(e -> startPressed());
		view.getJbExit().addActionListener(e -> exitPressed());
	}

	private void exitPressed() {
		System.exit(0);
	}

	private void startPressed(){
		gameFinished = false;
		view.getJbStart().setText("Restart Game");
		char huSymb;
		char aiSymb;
		if (view.getJlSideChosen().getText().equals("X")){
			huSymb = 'X';
			aiSymb = 'O';
		} else {
			huSymb = 'O';
			aiSymb = 'X';
		}
		model.initModel(size, huSymb, aiSymb, this);
		view.add(view.getGf(), BorderLayout.CENTER);
		view.repaint();
		view.setVisible(true);
	}

	public void updateMap(int x, int y) {
		if (canMakeMove) {
			canMakeMove = false;
			canMakeMove = model.makeMove(x, y);
		}
	}

	public char[][] getMap() {
		return model.getMap().getMap();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//e.getSource().equals();
	}

	public void gameFinished(String str) {
		if (!gameFinished) {
			gameFinished = true;
			view.showGameFinishDialog(str);
		}
	}

	public void repaintView() {
		view.repaint();
		view.setVisible(true);
	}

}
