
/**
 * MyListner
 */
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;
import java.lang.Math;

public class MyListner implements ActionListener { //implements ActionListner interface
    private JButton btn;
    private int row;
    private int col;
    private static JButton[][] btns;
    private static boolean player1 = false;
    private static int no_of_completed=0;
    
  
    private static JFrame frame;
    

    MyListner(JButton btn,int row,int col) {
        this.btn = btn;
        this.row=row;
        this.col=col;
    }

    public static void setButtonArray(JButton[][] btns) {
        MyListner.btns = btns;
        
    }

    public static void setFrameRef(JFrame frame) {
        MyListner.frame = frame;
    }

    private  boolean checkGame() { //method for check win or draw or still not 
        boolean test=false;
        String str;
        
        str = MyListner.btns[this.row][this.col].getText();

        for (int j = 0; j < MyListner.btns[0].length; j++) { //check the row related to clicked button
            if (!str.equals(MyListner.btns[this.row][j].getText())) {
                test = false;
                break;
            }
            test = true;
        }
        if (test){
            return test;
        }


        
      
        for (int j = 0; j < MyListner.btns.length; j++) { //check the collumn related to clicked button
            if (!str.equals(MyListner.btns[j][this.col].getText())) {
                test = false;
                break;
            }
            test = true;
        }
        if (test){
            return test;
        }
      

        
       
        for (int i = 0; i < MyListner.btns.length; i++) { //check main diagonal
            if (!str.equals(MyListner.btns[i][i].getText())) {
                test = false;
                break;
            }
            test = true;
        }
        if (test){
            return test;
        }
        
        
   
        for (int i = 0; i < MyListner.btns.length; i++) { //check the other diagonal
            if (!str.equals(MyListner.btns[i][MyListner.btns.length-1- i].getText())) {
                test = false;
                break;
            }
            test = true;
        }
        return test;

    }

    public void actionPerformed(ActionEvent event) { //implement the interface method to do when clicked button
        

        if (player1) {
            if (!(this.btn.getText().equals("1") || this.btn.getText().equals("2"))) {
                MyListner.player1 = !MyListner.player1;
                MyListner.no_of_completed=MyListner.no_of_completed+1;
                this.btn.setText("2");
            }else{
                return;
            }//check whether clicked earlier

            if (!this.checkGame()){
                if(MyListner.no_of_completed==Math.pow(MyListner.btns.length,2)){
                    new ResultFrame();//checked whether draw then open result screen
                    MyListner.frame.dispose(); //close current window
                    return;
                }
                 Display.display(1); //otherwise go to next turn
            }  
            else { //not draw and then win one player

                new ResultFrame(2); //display winner
                MyListner.frame.dispose();
            }

        } else {
            if (!(this.btn.getText().equals("1") || this.btn.getText().equals("2"))) {
                MyListner.player1 = !MyListner.player1;
                MyListner.no_of_completed=MyListner.no_of_completed+1;
                this.btn.setText("1");
            }else{
                return;
            }//check whether clicked earlier

            if (!this.checkGame()){
                if(MyListner.no_of_completed==Math.pow(MyListner.btns.length,2)){
                    new ResultFrame();
                    MyListner.frame.dispose();
                    return;
                }
                Display.display(2);
            }
            else {

                new ResultFrame(1);
                MyListner.frame.dispose();
            }

        }
    }
}