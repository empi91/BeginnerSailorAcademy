package student;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *  klasa generujaca ekran odpowiedzialny za czesc pomagajaca w nauce
 * @author fkorp
 *
 */
public class WikiPanel extends JPanel {
    /** zaladowanie grafik zastepujących przyciski*/
    private BufferedImage background;
    private ImageIcon menu_back = new ImageIcon("images/menu_back.png");
    private ImageIcon menu_next = new ImageIcon("images/menu_next.png");
    private ImageIcon qmark = new ImageIcon("images/qmark.png");

    public WikiPanel () throws IOException {
/** funkcja ustawiająca tło ramki*/
        File imageFile = new File("images/background.jpg");
        try {
            background = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.err.println("Bład odczytu obrazka");
            e.printStackTrace();
        }
        /** wywolanie funkcji budującej wlasciwy ekran tej podstrony*/
        wikilevel1();
    }

    /**
     * funkcja tworząca poziom pierwszy podręcznika do nauki
     * @throws IOException
     */
    public void wikilevel1 () throws IOException {
        JPanel level = new JPanel();
        level.setLayout(null);

        JButton back = new JButton (menu_back);
        JButton next = new JButton (menu_next);
        JButton one = new JButton (qmark);
        JButton two = new JButton (qmark);

        one.setOpaque(false);one.setContentAreaFilled(false);one.setBorderPainted(false);
        two.setOpaque(false);two.setContentAreaFilled(false);two.setBorderPainted(false);
        back.setOpaque(false);back.setContentAreaFilled(false);back.setBorderPainted(false);
        next.setOpaque(false);next.setContentAreaFilled(false);next.setBorderPainted(false);

        add(one);
        add(two);
        add(back);
        add(next);

        one.setBounds(544,496,60,60);
        two.setBounds(655,450,60,60);
        back.setBounds(10,20,200,100);
        next.setBounds(1000,20,250,150);

        JLabel descOne = new JLabel("THIS IS JIB");
        JLabel descTwo = new JLabel("THIS IS MAIN SAIL");

        descOne.setVisible(false);
        descTwo.setVisible(false);

        add(descOne);
        add(descTwo);

        descOne.setBounds(520,496,200,20);
        descTwo.setBounds(625,450,200,20);
        /** funkcja okreslająca efekt klikniecia w znaki zapytania oznaczające elementy do nauczenia*/
        one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                one.setVisible(false);
                descOne.setVisible(true);
            }
        });
        two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                two.setVisible(false);
                descTwo.setVisible(true);
            }
        });
        /** funkcja okreslająca dzialanie przycisku WSTECZ*/
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    WikiPanel.this.setVisible(false);
                    new BeginnerSailorAcademy();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        /** zaladowanie i wyswietlenie grafiki przedstawiającej omawiana jednostke*/
        BufferedImage myPicture = ImageIO.read(new File("images/level1.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(380,190,512,512);
        add(picLabel);
    }
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 0, 0, this);
    }
}
