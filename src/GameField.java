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
    private JButton buttonStop;
    private Prepatstviya[] prepatstviya;
    private Timer timer;
    private Hero hero;

    public GameField() {
        roadLength = 300;
        leftBorderOfRoad = 150;
        roadWidth = 200;
        rightBorderOfRoad = 150;
        //temp potom perepisat` nado
        setSize(leftBorderOfRoad+roadWidth+rightBorderOfRoad, roadLength);

        addButton();

        initGame();

        this.addKeyListener(new FieldKeyListener());
        this.setFocusable(true);
    }

    private void addButton(){
        setLayout(null);
        
        buttonStart = new JButton("Start");
        buttonStop = new JButton("Stop");
        buttonOptions = new JButton("Options");

        add(buttonStart);
        add(buttonStop);
        add(buttonOptions);

        buttonStart.setBounds(leftBorderOfRoad/5,roadLength/10*1,leftBorderOfRoad/5*3,roadLength/10);
        buttonStop.setBounds(leftBorderOfRoad/5,roadLength/10*3,leftBorderOfRoad/5*3,roadLength/10);
        buttonOptions.setBounds(leftBorderOfRoad/5,roadLength/10*5,leftBorderOfRoad/5*3,roadLength/10);
    }

    private void initGame(){
        hero = new Hero(leftBorderOfRoad, roadWidth, roadLength);
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

    private void renderHero(Graphics g){
//        g.fillRect(moto.getPositionX(),moto.getPositionY(),10, 20);
//        System.out.println(moto.getImg());
        g.drawImage( hero.getImg(), hero.getPositionX(), hero.getPositionY(), this);
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        renderBoards(g);
        renderRoad(g);
        renderPrepatstviya(g);
        renderHero(g);
    }

    class FieldKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
             hero.moveHero(e);
        }
    }
}
