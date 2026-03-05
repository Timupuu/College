import javax.swing.*;
import java.awt.*;
public class g5 {
  public static void main(String[] args) {

  // Create a new window (JFrame)
  JFrame frame = new JFrame("Login Screen");
  frame.setSize(500, 400);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setLayout(null); // absolute positioning


  // text field
JTextField textField = new JTextField("Username");
textField.setBounds(30, 150, 110, 25);
// button
JButton button = new JButton("Click Me");
button.setBounds(150, 150, 90, 25);
button.setBackground(Color.GREEN);

// Add components to the frame
frame.add(textField);
frame.add(button);
frame.setVisible(true);

  }
}
