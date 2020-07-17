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
 * Klasa budujaca pole graficzne czesci aplikacji odpowiadajacej za wlasciwa gre
 */
public class GamePanel extends JPanel {
    private BufferedImage background;
    private ImageIcon menu_back = new ImageIcon("images/menu_back.png");
    private ImageIcon menu_next = new ImageIcon("images/menu_next.png");
    private ImageIcon qmark = new ImageIcon("images/qmark.png");

    /**
     * konstruktor pola graficznego gry
     * @throws IOException
     */
    public GamePanel () throws IOException {
        File imageFile = new File("images/background.jpg");
        try {
            background = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.err.println("Bład odczytu obrazka");
            e.printStackTrace();
        }
        initlevel1();
    }

    /**
     * funkcja zawierająca wszystkie elementy ekranu rozgrywki
     * @throws IOException
     */
    public void initlevel1 () throws IOException {
        JPanel level = new JPanel();
        level.setLayout(null);

        JButton back = new JButton (menu_back);
        JButton next = new JButton (menu_next);
        JButton one = new JButton (qmark);
        JButton two = new JButton (qmark);
        JButton three = new JButton (qmark);
        JButton four = new JButton (qmark);

        JTextField foresail = new JTextField("MARSEL DOLNY");
        JTextField lowerTopSail = new JTextField("MARSEL GÓRNY");
        JTextField flyingJib = new JTextField("LATACZ");
        JTextField mizzen = new JTextField("BEZAN");

        JTextField ans1 = new JTextField("");
        JTextField ans2 = new JTextField("");
        JTextField ans3 = new JTextField("");
        JTextField ans4 = new JTextField("");


        foresail.setDragEnabled(true);
        lowerTopSail.setDragEnabled(true);
        flyingJib.setDragEnabled(true);
        mizzen.setDragEnabled(true);
        ans1.setDragEnabled(true);
        ans2.setDragEnabled(true);
        ans3.setDragEnabled(true);
        ans4.setDragEnabled(true);

        one.setOpaque(false);one.setContentAreaFilled(false);one.setBorderPainted(false);
        two.setOpaque(false);two.setContentAreaFilled(false);two.setBorderPainted(false);
        three.setOpaque(false);three.setContentAreaFilled(false);three.setBorderPainted(false);
        four.setOpaque(false);four.setContentAreaFilled(false);four.setBorderPainted(false);

        back.setOpaque(false);back.setContentAreaFilled(false);back.setBorderPainted(false);
        next.setOpaque(false);next.setContentAreaFilled(false);next.setBorderPainted(false);

        add(back); add(one); add(two); add(three); add(four);
        add(foresail); add(lowerTopSail); add(flyingJib); add(mizzen);
        add(ans1); add(ans2); add(ans3); add(ans4);
        ans1.setVisible(false);
        ans2.setVisible(false);
        ans3.setVisible(false);
        ans4.setVisible(false);
        ans1.setBounds(680,380,100,30);
        ans2.setBounds(680,500,100,30);
        ans3.setBounds(470,460,100,30);
        ans4.setBounds(860,450,100,30);

        back.setBounds(10,20,200,100);
        next.setBounds(1000,20,250,150);

        one.setBounds(680,380,60,60);
        two.setBounds(680,500,60,60);
        three.setBounds(470,460,60,60);
        four.setBounds(860,450,60,60);

        foresail.setBounds(96,900,100,30);
        lowerTopSail.setBounds(342,900,100,30);
        flyingJib.setBounds(588,900,100,30);
        mizzen.setBounds(834,900,100,30);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    GamePanel.this.setVisible(false);
                    new BeginnerSailorAcademy();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        add(next);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    initlevel1();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        /**
         * funkcja sprawdzająca poprawność udzielonych odpowiedzi
         */
        one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                one.setVisible(false);
                ans1.setVisible(true);
                ans1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        String answer = ans1.getText();
                        if (answer.equals("MARSEL GÓRNY")) ans1.setBackground(Color.GREEN);
                         else ans1.setBackground(Color.RED);
                    }
                });
            }
        });
        two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                two.setVisible(false);
                ans2.setVisible(true);
                ans2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        String answer = ans2.getText();
                        if (answer.equals("MARSEL DOLNY")) ans2.setBackground(Color.GREEN);
                        else ans2.setBackground(Color.RED);
                    }
                });
            }
        });
        three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                three.setVisible(false);
                ans3.setVisible(true);
                ans3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        String answer = ans3.getText();
                        if (answer.equals("BEZAN")) ans3.setBackground(Color.GREEN);
                        else ans3.setBackground(Color.RED);
                    }
                });
            }
        });
        four.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                four.setVisible(false);
                ans4.setVisible(true);
                ans4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        String answer = ans4.getText();
                        if (answer.equals("LATACZ")) ans4.setBackground(Color.GREEN);
                        else ans4.setBackground(Color.RED);
                    }
                });
            }
        });
        BufferedImage myPicture = ImageIO.read(new File("images/level2.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(380,190,640,529);
        add(picLabel);
    }
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 0, 0, this);
    }
}