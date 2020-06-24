/**
 * MainFrame
 */

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridLayout;


public class MainFrame extends JFrame { //extend the JFrame
    private JButton [][] btns;

    MainFrame(int size){
        super("Tick Tact Toe");
        this.btns=new JButton[size][size];
        setLayout(new GridLayout(size, size)); //setlayout to set buttons
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(int i=0;i<3;i++){ //create buttons
            for(int j=0;j<3;j++){
                this.btns[i][j]=new JButton();
                this.btns[i][j].setBackground(Color.BLUE);
                this.btns[i][j].setOpaque(true);
                this.btns[i][j].setForeground(Color.RED);
                this.btns[i][j].addActionListener(new MyListner(btns[i][j],i,j));//register for event listner
                add(btns[i][j]); //add to frame
            }
        }

        MyListner.setButtonArray(this.btns); //call static method in MyListner class
        MyListner.setFrameRef(this);

        setSize(600,600);
        setVisible(true);
        Display.display(1); //static method in Display class for display pop up msg to user for get to know which
                             //users turn is this
    }
}