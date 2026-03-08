import javax.swing.*;

public class g4 extends JFrame {
    public g4() {
        // --- Set properties inside constructor ---
        setTitle("Student Profile");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String CardContent = "<html>" +
                                "<div style='align: center;'>" + 
                                    "<b>Name:</b> Shishir Mishra<br>" +
                                    "<b>Module:</b> Programming<br>" +
                                    "<b>College:</b> Islington College" +
                                "</div>" +
                               "</html>"; 
        JLabel idCardContent = new JLabel(CardContent, SwingConstants.CENTER);        idCardContent.setBounds(100, 100, 200, 100);
        add(idCardContent);

        // Finalize visibility
        setVisible(true);
    }

    public static void main(String[] args) {
      // --- Use SwingUtilities.invokeLater() ---
      SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
          new g4(); // This calls the constructor we defined above
        }
      });
    }
}
