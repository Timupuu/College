import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class SubscriptionGUI{
  public static void main(String[] args) {

    ArrayList <AIModel> models = new ArrayList<>();
    
    JFrame frame = new JFrame("Subscription Form");
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(10, 2, 10, 10)); 

    JLabel modelNameLabel = new JLabel("Name:");
    JTextField modelNameField = new JTextField(20);

    JLabel priceLabel = new JLabel("Pricing:");
    JTextField priceField = new JTextField(20);

    JLabel parameterCountLabel = new JLabel("Parameter Count:");
    JTextField parameterCountField = new JTextField(20);

    JLabel contextWindowSizeLabel = new JLabel("Context Window:");
    JTextField contextWindowSizeField = new JTextField(20);

    //JLabel inipromquotaLabel = new JLabel("Inital Prompt Quota:");
    //JTextField ageField = new JTextField(20);

    JLabel slotsAvailableLabel = new JLabel("Initial Team Members:");
    JTextField slotsAvailableField = new JTextField(20);

    JLabel promptTextLabel = new JLabel("Prompt Text:");
    JTextField promptTextField = new JTextField(20);

    JLabel outputLengthLabel = new JLabel("Response Length:");
    JTextField outputLengthField = new JTextField(20);

    JLabel memberNameLabel = new JLabel("Name of Member:");
    JTextField memberNameField = new JTextField(20);

    JLabel indexLabel = new JLabel("Index number:");
    JTextField indexField = new JTextField(20);

    panel.add(modelNameLabel); panel.add(modelNameField);
    panel.add(priceLabel); panel.add(priceField);
    panel.add(parameterCountLabel); panel.add(parameterCountField);
    panel.add(contextWindowSizeLabel); panel.add(contextWindowSizeField);
    //panel.add(ageLabel); panel.add(ageField);
    panel.add(slotsAvailableLabel); panel.add(slotsAvailableField);
    panel.add(promptTextLabel); panel.add(promptTextField);
    panel.add(outputLengthLabel); panel.add(outputLengthField);
    panel.add(memberNameLabel); panel.add(memberNameField);
    panel.add(indexLabel); panel.add(indexField);

    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
    frame.add(panel);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);


  }

public int getValidatedIndex(JTextField indexField, ArrayList<AIModel> models) {
    int displayNumber = -1;
    try {
        int input = Integer.parseInt(indexField.getText().trim());
        if (input >= 0 && input < models.size()) {
            displayNumber = input;
        } else {
            JOptionPane.showMessageDialog(null, "Index out of range. Please enter a value between 0 and " + (models.size() - 1) + ".", "Invalid Index", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Please enter a valid integer for the index.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
    }
    return displayNumber;
}

}
