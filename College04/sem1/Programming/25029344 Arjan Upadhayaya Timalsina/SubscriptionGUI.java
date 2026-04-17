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
  JTextField remainingPromptsinMonthField = new JTextField(20);
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
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());

    // Center panel for labels and text fields
    JPanel fieldsPanel = new JPanel();
    fieldsPanel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 2, 5, 2);
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.fill = GridBagConstraints. NONE;
    gbc.gridx = 0;
    gbc.gridy = 0;

    int textFieldWidth = 12;
    modelNameField = new JTextField(textFieldWidth);
    priceField = new JTextField(textFieldWidth);
    parameterCountField = new JTextField(textFieldWidth);
    contextWindowSizeField = new JTextField(textFieldWidth);
    remainingPromptsinMonthField = new JTextField(textFieldWidth);
    slotsAvailableField = new JTextField(textFieldWidth);
    promptTextField = new JTextField(textFieldWidth);
    outputLengthField = new JTextField(textFieldWidth);
    memberNameField = new JTextField(textFieldWidth);
    indexField = new JTextField(textFieldWidth);

    String[] labels = {
      "Name:", "Pricing:", "Parameter Count:", "Context Window:",
      "Prompt Quota:", "Initial Team Members:", "Prompt Text:",
      "Response Length:", "Name of Member:", "Index number:"
    };
    JTextField[] fields = {
      modelNameField, priceField, parameterCountField, contextWindowSizeField,
      remainingPromptsinMonthField, slotsAvailableField, promptTextField,
      outputLengthField, memberNameField, indexField
    };

   for (int i = 0; i < labels.length; i++) {
      gbc.gridx = 0;
      gbc.weightx = 0;
      gbc.anchor = GridBagConstraints.EAST;
      fieldsPanel.add(new JLabel(labels[i], SwingConstants.RIGHT), gbc);

      gbc.gridx = 1;
      gbc.weightx = 0;
      gbc.anchor = GridBagConstraints.WEST;
      fieldsPanel.add(Box.createHorizontalStrut(10), gbc); // '  ' space

      gbc.gridx = 2;
      gbc.weightx = 0;
      gbc.anchor = GridBagConstraints.WEST;
      fieldsPanel.add(fields[i], gbc);

      gbc.gridy++;
    }

    // Buttons in two rows
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridBagLayout());
    GridBagConstraints bgbc = new GridBagConstraints();
    bgbc.insets = new Insets(5, 10, 5, 10);
    bgbc.fill = GridBagConstraints.HORIZONTAL;
    bgbc.gridy = 0;

    JButton addPersonalBtn = new JButton("Add Personal Plan");
    JButton addProBtn = new JButton("Add Pro Plan");
    JButton displayAllBtn = new JButton("Display All");
    JButton clearBtn = new JButton("Clear");
    JButton givePromptBtn = new JButton("Give a Prompt");
    JButton addTeamMemberBtn = new JButton("Add Team Member");
    JButton removeTeamMemberBtn = new JButton("Remove Team Member");

    // First row
    bgbc.gridx = 0; bgbc.gridwidth=1;
    buttonsPanel.add(addPersonalBtn, bgbc);
    bgbc.gridx = 1;
    bgbc.gridwidth=2;
    buttonsPanel.add(displayAllBtn, bgbc);
    bgbc.gridx = 3; bgbc.gridwidth=1;
    buttonsPanel.add(addProBtn, bgbc);

    // Second row
    bgbc.gridy = 1; bgbc.gridwidth=1;
    bgbc.gridx = 0;
    buttonsPanel.add(clearBtn, bgbc);
    bgbc.gridx = 1;
    buttonsPanel.add(givePromptBtn, bgbc);
    bgbc.gridx = 2;
    buttonsPanel.add(addTeamMemberBtn, bgbc);
    bgbc.gridx = 3;
    buttonsPanel.add(removeTeamMemberBtn, bgbc);

    fieldsPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 10, 40));
    buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 20, 40));

    displayArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(displayArea);

    mainPanel.add(fieldsPanel, BorderLayout.NORTH);
    mainPanel.add(buttonsPanel, BorderLayout.CENTER);

    frame.add(mainPanel, BorderLayout.NORTH);
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
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
      String modelName = modelNameField.getText().trim();
      double price = Double.parseDouble(priceField.getText().trim());
      int parameterCount = Integer.parseInt(parameterCountField.getText().trim());
      String contextWindowSize = contextWindowSizeField.getText().trim();
      int remainingPromptsinMonth = Integer.parseInt(remainingPromptsinMonthField.getText().trim());
      PersonalPlan plan = new PersonalPlan(modelName, price, parameterCount,contextWindowSize,remainingPromptsinMonth );
      models.add(plan);
      JOptionPane.showMessageDialog(null, "Personal Plan added.");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Invalid input for Personal Plan.", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void addProPlan() {
    try {
      String modelName = modelNameField.getText().trim();
      double price = Double.parseDouble(priceField.getText().trim());
      int parameterCount = Integer.parseInt(parameterCountField.getText().trim());
      String contextWindowSize = contextWindowSizeField.getText().trim();
      int slotsAvailable = Integer.parseInt(slotsAvailableField.getText().trim());
      ProPlan plan = new ProPlan(slotsAvailable,modelName, price, parameterCount, contextWindowSize);
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
    remainingPromptsinMonthField.setText("");
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
        String length = outputLengthField.getText().trim();
        ((PersonalPlan) model).userPrompts(prompt, length);
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
        ((ProPlan) model).addMember(memberName);
        JOptionPane.showMessageDialog(null, "Team member added to Pro Plan.");
      } else {
        JOptionPane.showMessageDialog(null, "Team collaboration is only available for Pro Plan subscriptions.", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  private void removeTeamMember() {
    int idx = getValidatedIndex();
    if (idx == -1) return;

    AIModel model = models.get(idx);

    if (!(model instanceof ProPlan)) {
      JOptionPane.showMessageDialog(null,
          "Team collaboration is only available for Pro Plan subscriptions.",
          "Error", JOptionPane.ERROR_MESSAGE);
      return;
    }

    ProPlan proPlan = (ProPlan) model;

    String memberName = memberNameField.getText().trim();

    if (memberName.isEmpty()) {
      JOptionPane.showMessageDialog(null,
          "Please enter the name of the member to remove.",
          "Error", JOptionPane.ERROR_MESSAGE);
      return;
    }

    if (proPlan.slotsAvailable >= proPlan.initialSlots) {
      JOptionPane.showMessageDialog(null,
          "There are no team members to remove.",
          "Error", JOptionPane.ERROR_MESSAGE);
      return;
    }

    String result = proPlan.removeMember(memberName);
    JOptionPane.showMessageDialog(null, result);
  }
}

