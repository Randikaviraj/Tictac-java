import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;

/**
 * ResultFrame
 */
public class ResultFrame extends JFrame{

    
    ResultFrame(int player){ //ovverloading constructors for win situation
        super("Hey game is end...");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel=new JPanel(){
            public void paint(Graphics g) {
                g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                g.setColor(Color.red);
                g.drawString("Player "+player+" win the game",80,200);
            }
        };

        getContentPane().add(panel);

        JButton btn=new JButton("Close Game");
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });
        panel.add(btn);
        pack();
        setSize(400,400);
        setVisible(true);
    }


    ResultFrame(){//ovverloading constructors for draw situation
        super("Hey game is end...");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel=new JPanel(){
            public void paint(Graphics g) {
                g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                g.setColor(Color.red);
                g.drawString("Game is draw..",80,200);
            }
        };

        getContentPane().add(panel);

        JButton btn=new JButton("Close Game");
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });
        panel.add(btn);

        pack();
        setSize(400,400);
        setVisible(true);
    }

    
}