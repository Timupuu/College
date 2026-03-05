import javax.swing.SwingUtilities;
import javax.swing.*;
import java.awt.*;

 class Student {
    private String studentId;
    private String name;
    private String course;

    public Student(String studentId, String name, String course) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
    }

    // Method to return HTML for JLabel display
    public String getFormattedHTML() {
        return "<html>" +
               "<div style='text-align: center; padding: 20px;'>" +
               "<h1>Student ID Card</h1>" +
               "<hr>" +
               "<p><b>ID:</b> " + studentId + "</p>" +
               "<p><b>Name:</b> " + name + "</p>" +
               "<p><b>Course:</b> " + course + "</p>" +
               "</div>" +
               "</html>";
    }
}
class IDCardWindow extends JFrame {

  public IDCardWindow(Student student) {
    // Basic window setup
    setTitle("ID Card Preview - " + student.getFormattedHTML().replaceAll("<[^>]*>", "")); // Stripping HTML for title
    setSize(450, 300);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
    setLocationRelativeTo(null); // Center the window

    // Create and add the JLabel
    JLabel idLabel = new JLabel(student.getFormattedHTML());
    idLabel.setHorizontalAlignment(SwingConstants.CENTER);

    add(idLabel);

    // Make it visible
    setVisible(true);
  }
}
public class MainLauncher {
  public static void main(String[] args) {
    // Use invokeLater for thread-safety
    SwingUtilities.invokeLater(() -> {
      // 1. Create at least two Student objects
      Student student1 = new Student("S101", "Mahabir Pungi", "Computing");
      Student student2 = new Student("S102", "Bhanu Syam Regmi", "Networking");

      // 2. Open two windows using the same viewer class
      new IDCardWindow(student1);
      new IDCardWindow(student2);
    });
  }
}
