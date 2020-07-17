package student;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *  klasa generujaca strone startowa - menu - wraz z tlem
 * @author fkorp
 *
 */
public class MenuPanel extends JPanel{

    private BufferedImage background;

    public MenuPanel () {
        File imageFile = new File("images/background.jpg");
        try {
            background = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.err.println("Bład odczytu obrazka");
            e.printStackTrace();
        }

    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 0, 0, this);
    }
}
