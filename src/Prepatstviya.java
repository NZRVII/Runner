/**
 * Created by Shadowdancer on 05.11.2017.
 */
public class Prepatstviya {
    int positionX;
    int positionY;
    int speed;
    int roadLength;
    int size;
    int leftBorderOfRoad;
    int roadWidth;

    public Prepatstviya(int leftBorderOfRoad, int roadWidth, int roadLength) {
        this.leftBorderOfRoad = leftBorderOfRoad;
        this.roadWidth = roadWidth;
        this.roadLength = roadLength;
        this.positionX = leftBorderOfRoad + (int) (Math.random()*roadWidth);
        this.positionY = -roadLength + (int)(Math.random()*roadLength);
        this.size = 10;
        this.speed = 10 + (int) (Math.random()*10);
    }

    public void reCreate(){
        positionX = leftBorderOfRoad + (int) (Math.random()*roadWidth);
        positionY = -roadLength/10;
        speed = 10 + (int) (Math.random()*10);
    }

    public void update(){
        positionY += speed;
        if (positionY > roadLength) reCreate();
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getSpeed() {
        return speed;
    }

    public int getSize() {
        return size;
    }
}
