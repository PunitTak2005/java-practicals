//PRACTICAL 1

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// MODEL
class UserModel {
    private String username;
    public void setUsername(String name) { this.username = name; }
    public String getUsername() { return username; }
}

// VIEW
class UserView extends JFrame {
    JTextField txtName;
    JButton btnSubmit;
    JToggleButton toggleDarkMode;
    JCheckBox chkAgree;
    JRadioButton rbMale, rbFemale;
    ButtonGroup genderGroup;
    JLabel lblOutput;

    public UserView() {
        setTitle("Swing MVC Demo");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        txtName = new JTextField(20);
        btnSubmit = new JButton("Submit");
        toggleDarkMode = new JToggleButton("Dark Mode");
        chkAgree = new JCheckBox("Accept Terms");
        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");

        genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);

        lblOutput = new JLabel("Output will appear here");

        add(new JLabel("Enter Name:"));
        add(txtName);
        add(rbMale);
        add(rbFemale);
        add(chkAgree);
        add(toggleDarkMode);
        add(btnSubmit);
        add(lblOutput);
    }
}

// CONTROLLER
class UserController {
    private UserModel model;
    private UserView view;

    public UserController(UserModel m, UserView v) {
        model = m;
        view = v;

        view.btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setUsername(view.txtName.getText());
                String gender = view.rbMale.isSelected() ? "Male" :
                        view.rbFemale.isSelected() ? "Female" : "Not Selected";

                if(!view.chkAgree.isSelected()) {
                    view.lblOutput.setText("Please accept the terms!");
                    return;
                }

                view.lblOutput.setText("Hello, " + model.getUsername()
                        + "! Gender: " + gender);
            }
        });

        view.toggleDarkMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(view.toggleDarkMode.isSelected()) {
                    view.getContentPane().setBackground(Color.DARK_GRAY);
                } else {
                    view.getContentPane().setBackground(null);
                }
            }
        });
    }
}

// MAIN APPLICATION + Look & Feel
public class MainApp {
    public static void main(String[] args) {
        try {
            // Pluggable Look & Feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        UserModel model = new UserModel();
        UserView view = new UserView();
        new UserController(model, view);
        view.setVisible(true);
    }
}

