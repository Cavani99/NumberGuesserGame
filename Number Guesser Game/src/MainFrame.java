import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    final JLabel title=new JLabel("GUESS GAME!");
    final Button guess=new Button();
    final Button range=new Button();

    MainFrame(){
        this.setTitle("Main");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);

        this.getContentPane().setBackground(Color.black);




        Panel p=new Panel();
        p.setSize(this.getSize());

        SpringLayout layout=new SpringLayout();
        p.setLayout(layout);

        title.setForeground(Color.blue);
        title.setSize(new Dimension(500,200));
        layout.putConstraint(SpringLayout.NORTH, title, 50, SpringLayout.NORTH, p);
        layout.putConstraint(SpringLayout.WEST, title, 200, SpringLayout.WEST, p);




        //the Buttons
        guess.setLabel("Number Guesser!");
        guess.setPreferredSize(new Dimension(160,40));
        layout.putConstraint(SpringLayout.NORTH, guess, 250, SpringLayout.NORTH, p);
        layout.putConstraint(SpringLayout.WEST, guess, 70, SpringLayout.WEST, p);
        guess.setForeground(Color.black);
        guess.setBackground(Color.white);
        guess.addActionListener(new GuessGame());

        range.setLabel("Higher,Equal,Lower Game!");
        range.setPreferredSize(new Dimension(160,40));
        layout.putConstraint(SpringLayout.NORTH, range, 250, SpringLayout.NORTH, p);
        layout.putConstraint(SpringLayout.WEST, range, 250, SpringLayout.WEST, p);
        range.setForeground(Color.black);
        range.setBackground(Color.white);
        range.addActionListener(new RangeGame());


        p.add(title);
        p.add(guess);
        p.add(range);
        this.add(p);

        this.setResizable(false);
        this.setVisible(true);
    }


}
