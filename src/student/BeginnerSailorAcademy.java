package student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * glowna klasa inicjalizujaca wszystkie moduly niezbedne do uruchomienia glownego ekranu gry
 * @author Filip Korpet
 */
public class BeginnerSailorAcademy {
    /** zaladowanie grafik odpowiadających za glowne przyciski nawigacyjne  */
    private ImageIcon menu_start = new ImageIcon("images/menu_start.png");
    private ImageIcon menu_wiki = new ImageIcon("images/menu_wiki.png");
    private ImageIcon menu_exit = new ImageIcon("images/menu_exit.png");
    /**  utworzenie ramki, panelu glownego, oraz odwolanie sie do konstruktorów 3 podstron aplikacji     */
    JFrame frame = new JFrame();
    JPanel window = new JPanel ();
    GamePanel level1 = new GamePanel();
    MenuPanel menu = new MenuPanel();
    WikiPanel wiki = new WikiPanel();
    /** inicjalizacja trzech przyciskow menu */
    JButton menu1 = new JButton(menu_start);
    JButton menu2 = new JButton(menu_wiki);
    JButton menu3 = new JButton(menu_exit);
    /** oraz layoutu umozliwijącego przełączanie sie pomiedzy nimi*/
    CardLayout layout = new CardLayout();
    /** dane określające wymiary i położenie głownego okna gry*/
    int windowWidth = 1280;
    int windowHeight = 1080;
    int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    int cornerX = (screenWidth - windowWidth)/2;
    int cornerY = (screenHeight - windowHeight)/2;

    /**
     * konstruktor głownego okna gry
     * @throws IOException
     */
    public BeginnerSailorAcademy() throws IOException {
        wiki.setLayout(null);
        level1.setLayout(null);
        window.setLayout(layout);
        menu.add(menu1);
        menu.add(menu2);
        menu.add(menu3);

        window.add(menu, "MENU");
        window.add(level1, "GAME");
        window.add(wiki, "WIKI");

        layout.show(window, "MENU");
        /** ustawienie przycików menu jako przeźroczystych*/
        menu1.setOpaque(false);menu1.setContentAreaFilled(false);menu1.setBorderPainted(false);
        menu2.setOpaque(false);menu2.setContentAreaFilled(false);menu2.setBorderPainted(false);
        menu3.setOpaque(false);menu3.setContentAreaFilled(false);menu3.setBorderPainted(false);
        /** fukcje umozliwiające przełączanie się pomiedzy poszczególnymi oknami*/
        menu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.show(window, "GAME");
            }
        });
        menu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.show(window, "WIKI");
            }
        });
        menu3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(1);
            }
        });
        frame.add(window);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1280,1080);
        frame.setLocation(cornerX, cornerY);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
     * metoda uruchamiająca grę
     * @param args
     * @throws IOException
     */
    public static void main (String[] args) throws IOException {
        new BeginnerSailorAcademy();
    }
}
