import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Shadowdancer on 05.11.2017.
 */
public class GameField extends JPanel implements ActionListener{
    private int leftBorderOfRoad;
    private int roadWidth;
    private int rightBorderOfRoad;
    private int roadLength;
    private JButton buttonStart;
    private JButton buttonOptions;
    private Prepatstviya[] prepatstviya;
    private Timer timer;
    private Moto moto;

    public GameField() {
        roadLength = 300;
        leftBorderOfRoad = 150;
        roadWidth = 200;
        rightBorderOfRoad = 150;
        //temp potom perepisat` nado
        setSize(leftBorderOfRoad+roadWidth+rightBorderOfRoad, roadLength);
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
        initGame();
    }

    private void initGame(){
        moto = new Moto(leftBorderOfRoad, roadWidth, roadLength);
        prepatstviya = new Prepatstviya[3];
        for (int i = 0; i < prepatstviya.length; i++) {
            prepatstviya[i] = new Prepatstviya(leftBorderOfRoad, roadWidth, roadLength);
        }
        timer = new Timer(150, this);
        timer.start();
    }

    private void renderRoad(Graphics g){
        g.drawLine(leftBorderOfRoad, 0, leftBorderOfRoad, roadLength);
        g.drawLine(leftBorderOfRoad+roadWidth, 0, leftBorderOfRoad+roadWidth, roadLength);
    }

    private void renderBoards(Graphics g){
        g.drawLine(0, 0, leftBorderOfRoad+roadWidth+rightBorderOfRoad,0);
        g.drawLine(leftBorderOfRoad+roadWidth+rightBorderOfRoad,0, leftBorderOfRoad+roadWidth+rightBorderOfRoad, roadLength);
        g.drawLine(leftBorderOfRoad+roadWidth+rightBorderOfRoad, roadLength, 0, roadLength);
        g.drawLine(0, roadLength, 0, 0);
    }

    private void renderMoto(Graphics g){
        g.fillRect(moto.getPositionX(),moto.getPositionY(),10, 20);
    }

    private void renderPrepatstviya(Graphics g){
        for (int i = 0; i < prepatstviya.length; i++) {
            g.fillRect(prepatstviya[i].getPositionX(), prepatstviya[i].getPositionY(), prepatstviya[i].getSize(), prepatstviya[i].getSize());
            prepatstviya[i].update();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    class FieldKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            System.out.println("1");
            System.out.println(e);
            System.out.println(key);
            moto.moveMoto(e);
//            if (key == KeyEvent.VK_LEFT) {
//
//            }
//            if (key == KeyEvent.VK_RIGHT){
//
//            }
//            if (key == KeyEvent.VK_UP){
//
//            }
//            if (key == KeyEvent.VK_DOWN){
//
//            }

        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        renderBoards(g);
        renderRoad(g);
        renderPrepatstviya(g);
        renderMoto(g);
    }
}
