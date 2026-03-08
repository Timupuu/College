import javax.swing.*;

public class g3 extends JFrame {
    public g3() {
        // --- Set properties inside constructor ---
        setTitle("Student Profile");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
                       
        // Finalize visibility
        setVisible(true);
    }
   
public static void main(String[] args) {
    // --- Use SwingUtilities.invokeLater() ---
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            new g3(); // This calls the constructor we defined above
        }
    });
}
}
