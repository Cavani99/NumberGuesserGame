import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GuessGame extends JPanel implements ActionListener, KeyListener {

    final JFrame frame=new JFrame();
    private final JTextField text=new JTextField();
    private  boolean play;
    private boolean lost;
    private int lives;
    private int randomNumber;
    private int answer;
    private int rightGuesses;
    private int wrongGuesses;


    GuessGame(){

        SpringLayout layout=new SpringLayout();
        this.setLayout(layout);

        DocumentFilter filter = new UppercaseDocumentFilter();
        text.setPreferredSize(new Dimension(150,20));
        layout.putConstraint(SpringLayout.NORTH, text, 200, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, text, 100, SpringLayout.WEST, this);
        ((AbstractDocument) text.getDocument()).setDocumentFilter(filter);
        text.addKeyListener(this);


        this.setSize(400,400);
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.add(text,BorderLayout.CENTER);

        frame.add(this);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setSize(400,400);
        frame.setResizable(false);

    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        graphics.setColor(Color.ORANGE);
        graphics.setFont(new Font("serif",Font.BOLD,30));
        graphics.drawString("NUMBER GUESS!",85,100);

        graphics.setColor(Color.YELLOW);
        graphics.setFont(new Font("serif", Font.BOLD, 15));
        graphics.drawString("Lives "+lives+"/10!", 140, 350);

        if(!play) {
            graphics.setColor(Color.YELLOW);
            graphics.setFont(new Font("serif", Font.BOLD, 10));
            graphics.drawString("Write your first number from 1 to 10!", 105, 190);

            if(lost){
                int guesses=rightGuesses+wrongGuesses;
                graphics.setColor(Color.YELLOW);
                graphics.setFont(new Font("serif", Font.BOLD, 15));
                graphics.drawString("Game Over!!!You Have "+rightGuesses+" right guesses" +
                        " out of "+guesses+"!", 50, 330);

                graphics.drawString("Press ESC to close!*Game wont work*", 80, 305);
            }
        }
        if(play){
            graphics.setColor(Color.YELLOW);
            graphics.setFont(new Font("serif", Font.BOLD, 10));
            graphics.drawString("Number was "+ randomNumber+" ", 105, 190);

            if(randomNumber!=answer){
                graphics.setColor(Color.YELLOW);
                graphics.setFont(new Font("serif", Font.BOLD, 15));
                graphics.drawString("Wrong Guess!!!", 140, 330);
            }
            else{
                graphics.setColor(Color.YELLOW);
                graphics.setFont(new Font("serif", Font.BOLD, 15));
                graphics.drawString("Right Guess!!!You get some lives back!", 140, 330);
            }
        }

    }

    public int getRandomNumber(int min, int max) {

        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        randomNumber=getRandomNumber(1,10);
        lives=10;
        lost=false;

        frame.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode()==KeyEvent.VK_ENTER) {

            if (!lost) {
                if (!play) {
                    lives = 10;
                    play = true;
                    rightGuesses = 0;
                    wrongGuesses = 0;
                }
                if (!text.getText().equals("")) {
                    int diff = 0;
                    randomNumber = getRandomNumber(1, 10);
                    answer = Integer.parseInt(text.getText());
                    diff = Math.abs(answer - randomNumber);

                    if (diff != 0) {
                        lives -= diff;
                        wrongGuesses++;
                    } else {
                        lives += 5;
                        rightGuesses++;
                        if (lives > 10) {
                            lives = 10;
                        }
                    }

                    if (lives <= 0) {
                        lives = 0;
                        answer = 0;
                        play = false;
                        lost = true;
                        text.setText("");
                    }


                    repaint();
                } else {
                    System.out.println("Empty Text!!Write Something");
                }
            }
        }
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
