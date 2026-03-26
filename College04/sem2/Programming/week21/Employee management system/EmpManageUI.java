import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class EmpManageUI extends JFrame {

  // Form controls
  private final JTextField fullNameField = new JTextField(20);
  private final JTextField salaryField   = new JTextField(10);

  private final JRadioButton rbFullTime  = new JRadioButton("Full - Time");
  private final JRadioButton rbPartTime  = new JRadioButton("Part - Time");
  private final JRadioButton rbContract  = new JRadioButton("Contract");

  private final JCheckBox cbHealth       = new JCheckBox("Health Insurance");
  private final JCheckBox cbDental       = new JCheckBox("Dental Insurance");
  private final JCheckBox cbRetirement   = new JCheckBox("Retirement Plan");

  private final JComboBox<String> deptCombo =
    new JComboBox<>(new String[]{"IT", "HR", "Finance", "Sales", "Operations"});

  private final JLabel statusLabel = new JLabel("Status: Ready");
  private final JLabel infoLabel = new JLabel("Chars: 0 | Mouse: (0, 0)");

  public EmpManageUI() {
    super("Employee Management System");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(980, 560);
    setLocationRelativeTo(null);

    addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseMoved(MouseEvent e) {
        updateInfoLabel(e.getX(), e.getY());
      }
      @Override
      public void mouseDragged(MouseEvent e) {
        updateInfoLabel(e.getX(), e.getY());
      }
    });

    JPanel root = new JPanel(new BorderLayout());
    setContentPane(root);

    root.add(buildHeader(), BorderLayout.NORTH);
    root.add(buildLeftMenu(), BorderLayout.WEST);
    root.add(buildCenterForm(), BorderLayout.CENTER);
    root.add(buildStatusBar(), BorderLayout.SOUTH);

    // Focus listener (Full Name)
    fullNameField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        statusLabel.setText("Status: Full Name focused");
        fullNameField.setBackground(new Color(255, 255, 220));
      }

      @Override
      public void focusLost(FocusEvent e) {
        statusLabel.setText("Status: Full Name focus lost");
        fullNameField.setBackground(Color.WHITE);
      }
    });

    // Key listener (Full Name + Salary)
    KeyListener keyListener = new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
        // optional
      }

      @Override
      public void keyPressed(KeyEvent e) {
        // optional
      }

      @Override
      public void keyReleased(KeyEvent e) {
        Object src = e.getSource();
        if (src == fullNameField) {
          statusLabel.setText("Status: Typing name (" + fullNameField.getText() + ")");
        } else if (src == salaryField) {
          statusLabel.setText("Status: Typing salary (" + salaryField.getText() + ")");
        }
        updateInfoLabel(-1, -1);
      }
    };

    fullNameField.addKeyListener(keyListener);
    salaryField.addKeyListener(keyListener);
  }

  // Update info label with char count and mouse position
  private void updateInfoLabel(int mouseX, int mouseY) {
    int chars = fullNameField.getText().length() + salaryField.getText().length();
    String mouseStr = (mouseX >= 0 && mouseY >= 0) ? "Mouse: (" + mouseX + ", " + mouseY + ")" : "";
    infoLabel.setText("Chars: " + chars + (mouseStr.isEmpty() ? "" : " | " + mouseStr));
  }

  private JComponent buildHeader() {
    JPanel header = new JPanel(new BorderLayout());
    header.setBackground(new Color(70, 130, 200));
    header.setBorder(new EmptyBorder(10, 14, 10, 14));

    JLabel title = new JLabel("Employee Management System");
    title.setForeground(Color.WHITE);
    title.setFont(title.getFont().deriveFont(Font.BOLD, 18f));
    header.add(title, BorderLayout.WEST);

    // Mouse listener in header
    header.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        statusLabel.setText("Status: Header clicked at (" + e.getX() + ", " + e.getY() + ")");
      }

      @Override
      public void mousePressed(MouseEvent e) {
        statusLabel.setText("Status: Header pressed");
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        statusLabel.setText("Status: Header released");
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        statusLabel.setText("Status: Mouse entered header");
        header.setBackground(new Color(60, 120, 190));
      }

      @Override
      public void mouseExited(MouseEvent e) {
        statusLabel.setText("Status: Mouse exited header");
        header.setBackground(new Color(70, 130, 200));
      }
    });

    return header;
  }
  private JComponent buildLeftMenu() {
    JPanel menu = new JPanel();
    menu.setPreferredSize(new Dimension(170, 0));
    menu.setBackground(new Color(245, 245, 245));
    menu.setBorder(new EmptyBorder(12, 12, 12, 12));
    menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));

    JButton btnAdd    = makeMenuButton("Add Employee", new Color(240, 240, 240));
    JButton btnView   = makeMenuButton("View Employees", new Color(240, 240, 240));
    JButton btnUpdate = makeMenuButton("Update Employee", new Color(240, 240, 240));
    JButton btnDelete = makeMenuButton("Delete Employee", new Color(240, 240, 240));
    JButton btnSearch = makeMenuButton("Search Employee", new Color(240, 240, 240));

    btnAdd.addActionListener(e -> statusLabel.setText("Status: Add Employee clicked"));
    btnView.addActionListener(e -> statusLabel.setText("Status: View Employees clicked"));
    btnUpdate.addActionListener(e -> statusLabel.setText("Status: Update Employee clicked"));
    btnDelete.addActionListener(e -> statusLabel.setText("Status: Delete Employee clicked"));
    btnSearch.addActionListener(e -> statusLabel.setText("Status: Search Employee clicked"));

    menu.add(btnAdd);
    menu.add(Box.createVerticalStrut(8));
    menu.add(btnView);
    menu.add(Box.createVerticalStrut(8));
    menu.add(btnUpdate);
    menu.add(Box.createVerticalStrut(8));
    menu.add(btnDelete);
    menu.add(Box.createVerticalStrut(8));
    menu.add(btnSearch);
    menu.add(Box.createVerticalGlue());

    return menu;
  }
  private JButton makeMenuButton(String text, Color bg) {
    JButton b = new JButton(text);
    b.setAlignmentX(Component.LEFT_ALIGNMENT);
    b.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
    b.setFocusPainted(false);
    b.setBackground(bg);
    b.setBorder(new LineBorder(new Color(210, 210, 210)));

    Color hoverColor = new Color(200, 230, 200);
    Color greenColor = new Color(62, 193, 79);
    Color defaultColor = bg;

    b.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        if (!b.getModel().isPressed()) {
          b.setBackground(hoverColor);
        }
      }
      @Override
      public void mouseExited(MouseEvent e) {
        if (!b.getModel().isPressed()) {
          b.setBackground(defaultColor);
        }
      }
      @Override
      public void mousePressed(MouseEvent e) {
        b.setBackground(greenColor);
      }
      @Override
      public void mouseReleased(MouseEvent e) {
        if (b.getBounds().contains(e.getPoint())) {
          b.setBackground(greenColor);
        } else {
          b.setBackground(defaultColor);
        }
      }
    });

    return b;
  }


  private JComponent buildCenterForm() {
    JPanel center = new JPanel(new GridBagLayout());
    center.setBackground(Color.WHITE);
    center.setBorder(new EmptyBorder(20, 20, 20, 20));

    JPanel formCard = new JPanel(new GridBagLayout());
    formCard.setBackground(new Color(250, 250, 250));
    formCard.setBorder(BorderFactory.createCompoundBorder(
          new LineBorder(new Color(220, 220, 220)),
          new EmptyBorder(18, 18, 18, 18)
          ));

    // Mouse motion listener in form panel
    formCard.addMouseMotionListener(new MouseMotionListener() {
      @Override
      public void mouseDragged(MouseEvent e) {
        statusLabel.setText("Status: Dragging in form (" + e.getX() + ", " + e.getY() + ")");
      }

      @Override
      public void mouseMoved(MouseEvent e) {
        statusLabel.setText("Status: Mouse moved in form (" + e.getX() + ", " + e.getY() + ")");
      }
    });

    GridBagConstraints gc = new GridBagConstraints();
    gc.insets = new Insets(8, 8, 8, 8);
    gc.fill = GridBagConstraints.HORIZONTAL;
    gc.anchor = GridBagConstraints.WEST;

    int r = 0;

    // Full name
    gc.gridx = 0; gc.gridy = r; gc.weightx = 0;
    formCard.add(new JLabel("Full Name:"), gc);

    gc.gridx = 1; gc.gridy = r; gc.weightx = 1;
    formCard.add(fullNameField, gc);
    r++;

    // Salary
    gc.gridx = 0; gc.gridy = r; gc.weightx = 0;
    formCard.add(new JLabel("Salary:"), gc);

    gc.gridx = 1; gc.gridy = r; gc.weightx = 1;
    formCard.add(salaryField, gc);
    r++;

    // Employment type
    gc.gridx = 0; gc.gridy = r; gc.weightx = 0;
    formCard.add(new JLabel("Employment Type:"), gc);

    ButtonGroup group = new ButtonGroup();
    group.add(rbFullTime);
    group.add(rbPartTime);
    group.add(rbContract);
    rbFullTime.setSelected(true);

    JPanel empTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
    empTypePanel.setOpaque(false);
    empTypePanel.add(rbFullTime);
    empTypePanel.add(rbPartTime);
    empTypePanel.add(rbContract);

    gc.gridx = 1; gc.gridy = r; gc.weightx = 1;
    formCard.add(empTypePanel, gc);
    r++;

    // Benefits
    gc.gridx = 0; gc.gridy = r; gc.weightx = 0;
    formCard.add(new JLabel("Benefits:"), gc);

    JPanel benefitsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
    benefitsPanel.setOpaque(false);
    benefitsPanel.add(cbHealth);
    benefitsPanel.add(cbDental);
    benefitsPanel.add(cbRetirement);

    gc.gridx = 1; gc.gridy = r; gc.weightx = 1;
    formCard.add(benefitsPanel, gc);
    r++;

    // Department
    gc.gridx = 0; gc.gridy = r; gc.weightx = 0;
    formCard.add(new JLabel("Department:"), gc);

    gc.gridx = 1; gc.gridy = r; gc.weightx = 1;
    formCard.add(deptCombo, gc);
    r++;

    // Buttons
    JPanel actions = new JPanel(new FlowLayout(FlowLayout.CENTER, 14, 0));
    actions.setOpaque(false);

    JButton btnRegister = new JButton("Register Employee");
    JButton btnClear    = new JButton("Clear Form");
    JButton btnClearAll = new JButton("Clear All Records");

    btnRegister.addActionListener(e -> statusLabel.setText("Status: Registered (demo)"));
    btnClear.addActionListener(e -> {
      fullNameField.setText("");
      salaryField.setText("");
      rbFullTime.setSelected(true);
      cbHealth.setSelected(false);
      cbDental.setSelected(false);
      cbRetirement.setSelected(false);
      deptCombo.setSelectedIndex(0);
      statusLabel.setText("Status: Form cleared");
      updateInfoLabel(-1, -1);
    });
    btnClearAll.addActionListener(e -> statusLabel.setText("Status: Clear All Records (demo)"));

    actions.add(btnRegister);
    actions.add(btnClear);
    actions.add(btnClearAll);

    gc.gridx = 0; gc.gridy = r; gc.gridwidth = 2; gc.weightx = 1;
    gc.fill = GridBagConstraints.NONE;
    gc.anchor = GridBagConstraints.CENTER;
    formCard.add(actions, gc);

    GridBagConstraints rootGc = new GridBagConstraints();
    rootGc.gridx = 0; rootGc.gridy = 0;
    rootGc.weightx = 1; rootGc.weighty = 1;
    rootGc.anchor = GridBagConstraints.NORTHWEST;
    rootGc.fill = GridBagConstraints.NONE;

    center.add(formCard, rootGc);
    return center;
  }

  private JComponent buildStatusBar() {
    JPanel status = new JPanel(new BorderLayout());
    status.setBorder(new EmptyBorder(6, 10, 6, 10));
    status.setBackground(new Color(240, 240, 240));
    status.add(infoLabel, BorderLayout.WEST);
    status.add(statusLabel, BorderLayout.EAST);
    return status;
  }

  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception ignored) {}

    SwingUtilities.invokeLater(() -> new EmpManageUI().setVisible(true));
  }
}

