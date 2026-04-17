import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SubscriptionGUI {
  ArrayList<AIModel> models = new ArrayList<>();

  // Text fields for input
  JTextField modelNameField = new JTextField(20);
  JTextField priceField = new JTextField(20);
  JTextField parameterCountField = new JTextField(20);
  JTextField contextWindowSizeField = new JTextField(20);
 // JTextField promptQuotaField = new JTextField(20);
  JTextField slotsAvailableField = new JTextField(20);
  JTextField promptTextField = new JTextField(20);
  JTextField outputLengthField = new JTextField(20);
  JTextField memberNameField = new JTextField(20);
  JTextField indexField = new JTextField(20);

  JTextArea displayArea = new JTextArea(15, 40);

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new SubscriptionGUI().createAndShowGUI());
  }

  private void createAndShowGUI() {
    JFrame frame = new JFrame("Subscription Form");
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(12, 2, 10, 10)); 

    panel.add(new JLabel("Name:")); panel.add(modelNameField);
    panel.add(new JLabel("Pricing:")); panel.add(priceField);
    panel.add(new JLabel("Parameter Count:")); panel.add(parameterCountField);
    panel.add(new JLabel("Context Window:")); panel.add(contextWindowSizeField);
   // panel.add(new JLabel("Prompt Quota:")); panel.add(promptQuotaField);
    panel.add(new JLabel("Initial Team Members:")); panel.add(slotsAvailableField);
    panel.add(new JLabel("Prompt Text:")); panel.add(promptTextField);
    panel.add(new JLabel("Response Length:")); panel.add(outputLengthField);
    panel.add(new JLabel("Name of Member:")); panel.add(memberNameField);
    panel.add(new JLabel("Index number:")); panel.add(indexField);

    JButton addPersonalBtn = new JButton("Add Personal Plan");
    JButton addProBtn = new JButton("Add Pro Plan");
    JButton displayAllBtn = new JButton("Display All");
    JButton clearBtn = new JButton("Clear");
    JButton givePromptBtn = new JButton("Give a Prompt");
    JButton addTeamMemberBtn = new JButton("Add Team Member");

    panel.add(addPersonalBtn); panel.add(addProBtn);
    panel.add(displayAllBtn); panel.add(clearBtn);
    panel.add(givePromptBtn); panel.add(addTeamMemberBtn);

    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
    displayArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(displayArea);

    frame.add(panel, BorderLayout.NORTH);
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    addPersonalBtn.addActionListener(e -> addPersonalPlan());
    addProBtn.addActionListener(e -> addProPlan());
    displayAllBtn.addActionListener(e -> displayAll());
    clearBtn.addActionListener(e -> clearFields());
    givePromptBtn.addActionListener(e -> givePrompt());
    addTeamMemberBtn.addActionListener(e -> addTeamMember());
  }

  private int getValidatedIndex() {
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

  private void addPersonalPlan() {
    try {
      String name = modelNameField.getText().trim();
      double pricing = Double.parseDouble(priceField.getText().trim());
      int params = Integer.parseInt(parameterCountField.getText().trim());
      int context = Integer.parseInt(contextWindowSizeField.getText().trim());
      int quota = Integer.parseInt(promptQuotaField.getText().trim());
      PersonalPlan plan = new PersonalPlan(modelName, price, parameterCount, contextWindowSize, );
      models.add(plan);
      JOptionPane.showMessageDialog(null, "Personal Plan added.");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Invalid input for Personal Plan.", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void addProPlan() {
    try {
      String name = modelNameField.getText().trim();
      double pricing = Double.parseDouble(priceField.getText().trim());
      int params = Integer.parseInt(parameterCountField.getText().trim());
      int context = Integer.parseInt(contextWindowSizeField.getText().trim());
      int slots = Integer.parseInt(slotsAvailableField.getText().trim());
      ProPlan plan = new ProPlan(name, pricing, params, context, slots);
      models.add(plan);
      JOptionPane.showMessageDialog(null, "Pro Plan added.");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Invalid input for Pro Plan.", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void displayAll() {
    displayArea.setText("");
    for (int i = 0; i < models.size(); i++) {
      displayArea.append("Index: " + i + "\n" + models.get(i).toString() + "\n\n");
    }
  }

  private void clearFields() {
    modelNameField.setText("");
    priceField.setText("");
    parameterCountField.setText("");
    contextWindowSizeField.setText("");
    promptQuotaField.setText("");
    slotsAvailableField.setText("");
    promptTextField.setText("");
    outputLengthField.setText("");
    memberNameField.setText("");
    indexField.setText("");
  }

  private void givePrompt() {
    int idx = getValidatedIndex();
    if (idx != -1) {
      AIModel model = models.get(idx);
      if (model instanceof PersonalPlan) {
        String prompt = promptTextField.getText().trim();
        int length = Integer.parseInt(outputLengthField.getText().trim());
        ((PersonalPlan) model).makeApiCall(prompt, length);
        JOptionPane.showMessageDialog(null, "API call made for Personal Plan.");
      } else {
        JOptionPane.showMessageDialog(null, "This operation is only available for Personal Plan subscriptions.", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  private void addTeamMember() {
    int idx = getValidatedIndex();
    if (idx != -1) {
      AIModel model = models.get(idx);
      if (model instanceof ProPlan) {
        String memberName = memberNameField.getText().trim();
        ((ProPlan) model).addTeamMember(memberName);
        JOptionPane.showMessageDialog(null, "Team member added to Pro Plan.");
      } else {
        JOptionPane.showMessageDialog(null, "Team collaboration is only available for Pro Plan subscriptions.", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }
}

