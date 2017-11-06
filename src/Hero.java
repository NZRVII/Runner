import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Shadowdancer on 05.11.2017.
 */
public class Hero {
    int positionX;
    int positionY;
    int speed;
    BufferedImage img;
    int imgSizeX;
    int imgSizeY;
    int leftBorderOfRoad;
    int roadWidth;
    int roadLength;

    public Hero(int leftBorderOfRoad, int roadWidth, int roadLength) {
        this.leftBorderOfRoad = leftBorderOfRoad;
        this.roadWidth = roadWidth;
        this.roadLength = roadLength;
        this.positionX = leftBorderOfRoad+(roadWidth/2);
        this.positionY = roadLength-50;
        this.speed = 10;
        loadImg();
    }

    private void loadImg(){
        img = null;
        try {
            img = ImageIO.read(new File("hero.png"));
            imgSizeX = img.getWidth();
            imgSizeY = img.getHeight();
        } catch (Exception e){
            System.out.println("img ne zagryzilsa");
        }
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void moveHero(KeyEvent e){
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            positionX -= speed;
            if (positionX < leftBorderOfRoad){
                positionX = leftBorderOfRoad;
            }
        }
        if (key == KeyEvent.VK_RIGHT){
            positionX += speed;
            if (positionX > leftBorderOfRoad+roadWidth-imgSizeX){
                positionX = leftBorderOfRoad+roadWidth-imgSizeX;
            }
        }
        if (key == KeyEvent.VK_UP){
            positionY -= speed;
            if (positionY < 0){
                positionY = 0;
            }
        }
        if (key == KeyEvent.VK_DOWN){
            positionY += speed;
            if (positionY > roadLength-imgSizeY){
                positionY = roadLength-imgSizeY;
            }
        }
    }
}
