import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
	private Controller controller;
	private JPanel jBottomPanel;
	private JButton jbStart;
	private JButton jbExit;
	private JLabel jlSide;
	private JLabel jlSideChosen;
	private GameField gf;

	public View(){
		setTitle("Tic-Tac-Toe");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(500,500);
		setLocationRelativeTo(null);

		jBottomPanel = new JPanel();
		jBottomPanel.setLayout(new GridLayout());

		jlSide = new JLabel("Side:");
		jlSideChosen = new JLabel("");
		jbStart = new JButton("Start Game");
		jbExit = new JButton("Exit");

		jBottomPanel.add(jlSide);
		jBottomPanel.add(jlSideChosen);
		jBottomPanel.add(jbStart);
		jBottomPanel.add(jbExit);
		//gf = new GameField(controller);
		//add(gf, BorderLayout.CENTER);
		add(jBottomPanel, BorderLayout.SOUTH);
		setVisible(true);

		showSideDialog();
	}

	public void showSideDialog(){
		Object[] options = {"X", "O"};
		int n = JOptionPane.showOptionDialog(this,
						"Choose what you gonna play? \nPress \"Start Game\" then!",
						"Choose side",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						options,
						options[0]);
		if (n == JOptionPane.YES_OPTION) {
			jlSideChosen.setText("X");
		} else if (n == JOptionPane.NO_OPTION) {
			jlSideChosen.setText("O");
		} else {
			System.exit(0);
		}
	}

	public JPanel getjBottomPanel() {
		return jBottomPanel;
	}

	public void setjBottomPanel(JPanel jBottomPanel) {
		this.jBottomPanel = jBottomPanel;
	}

	public JButton getJbExit() {
		return jbExit;
	}

	public void setJbExit(JButton jbExit) {
		this.jbExit = jbExit;
	}

	public void setGf(Controller controller) {
		gf = new GameField(controller);
	}

	public GameField getGf(){
		return gf;
	}

	public JButton getJbStart() {
		return jbStart;
	}

	public JLabel getJlSideChosen() {
		return jlSideChosen;
	}

	public void showGameFinishDialog(String str){
		Object[] options = {"Yes", "No"};
		int n = JOptionPane.showOptionDialog(this,
						str + "\nWanna play again?",
						"Finished",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						options,
						options[0]);
		if (n == JOptionPane.YES_OPTION) {
			showSideDialog();
		} else if (n == JOptionPane.NO_OPTION) {
			System.exit(0);
		} else {
			System.exit(0);
		}
	}
}
