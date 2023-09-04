import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RangeGame extends JPanel implements ActionListener, KeyListener {
    final JFrame frame=new JFrame();
    private final JButton higherButton=new JButton("Higher");
    private final JButton equalButton=new JButton("Equal");
    private final JButton lowerButton=new JButton("Lower");

    private  boolean play;
    private int lives;
    private int randomNumber;
    private int rightGuesses;
    private int wrongGuesses;
    private boolean right;
    private boolean lost;
    RangeGame(){
        SpringLayout layout=new SpringLayout();
        this.setLayout(layout);

        higherButton.setPreferredSize(new Dimension(90,20));
        layout.putConstraint(SpringLayout.WEST, higherButton, 40, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, higherButton, 200, SpringLayout.NORTH, this);
        higherButton.addActionListener(this::Higher);
        higherButton.addKeyListener(this);

        equalButton.setPreferredSize(new Dimension(90,20));
        layout.putConstraint(SpringLayout.WEST, equalButton, 145, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, equalButton, 200, SpringLayout.NORTH, this);
        equalButton.addActionListener(this::Equal);
        equalButton.addKeyListener(this);

        lowerButton.setPreferredSize(new Dimension(90,20));
        layout.putConstraint(SpringLayout.WEST, lowerButton, 245, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, lowerButton, 200, SpringLayout.NORTH, this);
        lowerButton.addActionListener(this::Lower);
        lowerButton.addKeyListener(this);

        this.setSize(400,400);
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.add(higherButton,BorderLayout.CENTER);
        this.add(equalButton);
        this.add(lowerButton);



        frame.add(this);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setSize(400,400);
        frame.setResizable(false);

    }

    public void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);

        graphics.setColor(Color.ORANGE);
        graphics.setFont(new Font("serif",Font.BOLD,30));
        graphics.drawString("HIGHER OR LOWER",35,100);

        graphics.setColor(Color.ORANGE);
        graphics.setFont(new Font("serif",Font.BOLD,30));
        graphics.drawString("GUESS!",140,130);


        graphics.setColor(Color.YELLOW);
        graphics.setFont(new Font("serif", Font.BOLD, 15));
        graphics.drawString("Lives "+lives+"/50!", 140, 350);

        if(!play) {
            graphics.setColor(Color.YELLOW);
            graphics.setFont(new Font("serif", Font.BOLD, 10));
            graphics.drawString("The CURRENT NUMBER is:  "+randomNumber+"!", 105, 190);

            if(lost){
                int guesses=rightGuesses+wrongGuesses;
                graphics.setColor(Color.YELLOW);
                graphics.setFont(new Font("serif", Font.BOLD, 15));
                graphics.drawString("Game Over!!!You Have "+rightGuesses+" right guesses" +
                        " out of "+guesses+"!", 50, 330);

                graphics.drawString("Press ESC to close!*Buttons wont work*", 80, 305);
            }
        }
        if(play){
            graphics.setColor(Color.YELLOW);
            graphics.setFont(new Font("serif", Font.BOLD, 10));
            graphics.drawString("CURRENT NUMBER is "+ randomNumber+" ", 105, 190);

            if(!right){
                graphics.setColor(Color.YELLOW);
                graphics.setFont(new Font("serif", Font.BOLD, 15));
                graphics.drawString("Wrong Guess!!!", 140, 330);
            }
            else{
                graphics.setColor(Color.YELLOW);
                graphics.setFont(new Font("serif", Font.BOLD, 15));
                graphics.drawString("Right Guess!!!", 140, 330);
            }
        }

    }

    public int getRandomNumber(int min, int max) {

        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        randomNumber=getRandomNumber(0,100);
        lives=50;
        lost=false;


        frame.setVisible(true);
    }

    public void Higher(ActionEvent h) {
        if(!lost) {
            if (!play) {
                lives = 50;
                rightGuesses = 0;
                wrongGuesses = 0;
                play = true;
            }

            int previusNumber = randomNumber;
            randomNumber = getRandomNumber(0, 100);

            if (randomNumber > previusNumber) {
                right = true;
                rightGuesses++;
            } else {
                right = false;
                wrongGuesses++;
                int diff = Math.abs(randomNumber - previusNumber);
                lives -= diff;

            }

            if (lives <= 0) {
                lives = 0;
                play = false;
                lost = true;
            }

            repaint();
        }
    }

    public void Equal(ActionEvent h) {
        if(!lost) {
            if (!play) {
                lives = 50;
                rightGuesses = 0;
                wrongGuesses = 0;
                play = true;
            }

            int previusNumber = randomNumber;
            randomNumber = getRandomNumber(0, 100);

            if (randomNumber == previusNumber) {
                right = true;
                rightGuesses++;
                lives += 20;
                if (lives > 50) {
                    lives = 50;
                }
            } else {
                right = false;
                wrongGuesses++;
                int diff = Math.abs(randomNumber - previusNumber);
                lives -= diff;
            }

            if (lives <= 0) {
                lives = 0;
                play = false;
                lost = true;
            }
            repaint();
        }
    }

    public void Lower(ActionEvent h) {
        if(!lost) {
            if (!play) {
                lives = 50;
                rightGuesses = 0;
                wrongGuesses = 0;
                play = true;

            }

            int previusNumber = randomNumber;
            randomNumber = getRandomNumber(0, 100);

            if (randomNumber < previusNumber) {
                right = true;
                rightGuesses++;
            } else {
                right = false;
                wrongGuesses++;
                int diff = Math.abs(randomNumber - previusNumber);
                lives -= diff;

            }

            if (lives <= 0) {
                lives = 0;
                play = false;
                lost = true;
            }

            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {

            if(lost){
                frame.dispose();
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}
