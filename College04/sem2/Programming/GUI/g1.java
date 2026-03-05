import javax.swing.*;
public class g1 {
  public static void main(String[] args) {

  // Create a new window (JFrame)
  JFrame frame = new JFrame("Libary Notice");
  frame.setSize(400, 300);
  frame.setTitle("Libary Notice");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setLayout(null); // absolute positioning
  frame.setVisible(true);

  // label
  JLabel label = new JLabel("Libary Opens at 7:00 AM");
  label.setBounds(150,125,200,25);
  // Add components to the frame
  frame.add(label);
  }
}
