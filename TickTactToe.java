import java.lang.Thread;

public class TickTactToe extends Thread{
    
    public void run(){ //ovverride the run method of Thread class
      MainFrame myfFrame=new MainFrame(3);
    }
    
    
    public static void main(String[] args) {
      TickTactToe mythread=new TickTactToe(); //create a new thread sub class
      mythread.start();  //start the thread
    
    }


}