import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameField extends JPanel {
    public int size;
    private Controller controller;

    private int width;
    private int height;
    private int cellWidth;
    private int cellHeight;

    public GameField(Controller controller){
        this.controller = controller;
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                //System.out.println(e.getX() + " " + e.getY());
                int clX = e.getX() / cellWidth;
                int clY = e.getY() / cellHeight;
                //System.out.println(clX + " " + clY);
                controller.updateMap(clX, clY);
                repaint();
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        width = getWidth();
        height = getHeight();
        cellHeight = height/size;
        cellWidth = width/size;
        for(int i = 0; i < size + 1; i++){
            g.drawLine(0, i*cellHeight, width, i*cellHeight); //горизонтальная
            g.drawLine(i*cellWidth, 0, i*cellWidth, height); //вертикальная
        }
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(controller.getMap()[i][j] == 'O'){
                    g.setColor(Color.BLACK);
                    g.drawOval(i*cellWidth + 10, j*cellHeight + 10, cellWidth - 20, cellHeight - 20);
                }
                if(controller.getMap()[i][j] == 'X'){
                    g.setColor(Color.BLACK);
                    g.drawLine(i*cellWidth + 10, j*cellHeight + 10, (i+1)*cellWidth - 20, (j+1)*cellHeight - 20);
                    g.drawLine(i*cellWidth + 10, (j+1)*cellHeight - 20, (i+1)*cellWidth - 20, j*cellHeight + 10);
                }
            }
        }
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
