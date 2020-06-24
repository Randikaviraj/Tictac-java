
import javax.swing.JOptionPane;

/**
 * Display
 */
public class Display {
    private static String player1_msg = "Next--Player 1's Chance";
    private static String player2_msg = "Next--Player 2's Chance";

    public static void display(int player) {
        if (player == 1) {
            JOptionPane.showMessageDialog(null, Display.player1_msg);
        } else {
            JOptionPane.showMessageDialog(null, Display.player2_msg);
        }

    }

}