import javax.swing.*;

/**
 * Created by Shadowdancer on 05.11.2017.
 */
public class MainWindow extends JFrame{
    int width;
    int height;

    public MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Runner Main Window");
        setVisible(true);
//        this.setResizable(false);
//        setLocationRelativeTo(null);

        GameField gf = new GameField();
        width = gf.getWidth()+100;
        height = gf.getHeight()+100;
        setSize(width, height);

        add(gf);
    }

    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
    }
}
