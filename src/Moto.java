import java.awt.event.KeyEvent;

/**
 * Created by Shadowdancer on 05.11.2017.
 */
public class Moto {
    int positionX;
    int positionY;
    int speed;

    public Moto(int leftBorderOfRoad, int roadWidth, int roadLength) {
        this.positionX = leftBorderOfRoad+(roadWidth/2);
        this.positionY = roadLength-50;
        this.speed = 10;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void moveMoto(KeyEvent e){
        System.out.println(e);
    }
}
