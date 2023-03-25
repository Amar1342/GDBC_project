import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Event2 implements ActionListener {
    private JLabel rollLabel, nameLabel, statusLabel, mainLabel, updatLabel;;
    private JTextField nameField, rollField;
    private JButton insertButton, addButton, deleteButton, deleteButton2, updateButton, updateButton2, updateButton1,
            exitButton, updaterollButton, updatenameButton, BackButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        Event2 Student_data = new Event2();
        JPanel panel = Student_data.createPanel();
        frame.add(panel);
        frame.setVisible(true);

    }

    private JPanel createPanel() {

        JPanel panel = new JPanel();
        panel.setSize(800, 800);
        panel.setBackground(new java.awt.Color(180, 228, 255));
        panel.setLayout(null);
        panel.setVisible(true);

        mainLabel = new JLabel("CRUD OPERATIONS");
        // mainLabel.setFont(new Font("Copperplate",Font.BOLD , 25));
        mainLabel.setBounds(240, -100, 500, 500);
        panel.add(mainLabel);
        mainLabel.setFont(new Font("Copperplate", Font.BOLD, 35));

        insertButton = new JButton("ADD");
        insertButton.setBounds(340, 280, 80, 60);
        panel.add(insertButton);
        insertButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        insertButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame2 = new JFrame("Insert Data");
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setSize(800, 800);
                frame2.setLayout(null);
                // Event2 Student_data = new Event2();
                // JPanel panel2= Student_data.createPanel();
                // frame2.add(panel2);
                frame2.setVisible(true);
                frame2.setBackground(new java.awt.Color(188, 228, 255));

                rollLabel = new JLabel("Roll No.: ");
                rollLabel.setBounds(320, 180, 80, 60);
                frame2.add(rollLabel);

                rollField = new JTextField(20);
                rollField.setBounds(400, 200, 100, 25);
                frame2.add(rollField);

                nameLabel = new JLabel("First Name:");
                nameLabel.setBounds(320, 280, 80, 60);
                frame2.add(nameLabel);

                nameField = new JTextField(20);
                nameField.setBounds(400, 300, 100, 25);
                frame2.add(nameField);

                addButton = new JButton("ADD");
                addButton.setBounds(340, 400, 80, 25);
                addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                frame2.add(addButton);

                BackButton = new JButton("BACK");
                BackButton.setBounds(340, 500, 80, 25);
                frame2.add(BackButton);
                BackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                BackButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame2.setVisible(false);
                    }
                });

                statusLabel = new JLabel("");
                statusLabel.setBounds(240, 500, 80, 25);
                frame2.add(statusLabel);
                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == addButton) {
                            if (rollField.getText().isEmpty() && nameField.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(frame2, "Please Enter Roll No. and Name", "WARNING",
                                        JOptionPane.WARNING_MESSAGE);
                            } else if (rollField.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(frame2, "Please Enter Roll No.", "WARNING",
                                        JOptionPane.WARNING_MESSAGE);
                            } else if (nameField.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(frame2, "Please enter Name", "WARNING",
                                        JOptionPane.WARNING_MESSAGE);
                            }

                            else {
                                try {
                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                    Connection c = DriverManager.getConnection(
                                            "jdbc:mysql://localhost:3306/Student_data",
                                            "root", "amar2003");
                                    Statement st = c.createStatement();
                                    String roll = rollField.getText();
                                    String name = nameField.getText();
                                    String url = "INSERT INTO Student_data VALUES ('" + roll + "', '" + name + "')";
                                    st.executeUpdate(url);
                                    JOptionPane
                                            .showMessageDialog(frame2,
                                                    "Student Data of Roll NO. " + roll + " and Name " + name
                                                            + " added successfully",
                                                    "Successful", JOptionPane.PLAIN_MESSAGE);
                                } catch (Exception ex) {
                                    System.out.println(ex);
                                }
                            }
                        }
                    }

                });

            }
        });

        updateButton = new JButton("Update");
        updateButton.setBounds(340, 380, 80, 60);
        updateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(updateButton);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame updatFrame = new JFrame("Update Data");
                updatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                updatFrame.setSize(800, 800);
                updatFrame.setLayout(null);
                updatFrame.setVisible(true);

                updatLabel = new JLabel("Select to Update");
                updatLabel.setBounds(280, -100, 500, 500);
                updatFrame.add(updatLabel);
                updatLabel.setFont(new Font("Copperplate", Font.BOLD, 35));

                updaterollButton = new JButton("Roll No.");
                updaterollButton.setBounds(340, 280, 80, 60);
                updaterollButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                updatFrame.add(updaterollButton);
                updaterollButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame updatFrame1 = new JFrame("Upadate Roll No");
                        updatFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        updatFrame1.setSize(800, 800);
                        updatFrame1.setLayout(null);
                        updatFrame1.setVisible(true);

                        nameLabel = new JLabel("Enter Name");
                        nameLabel.setBounds(320, 180, 80, 60);
                        updatFrame1.add(nameLabel);

                        nameField = new JTextField(20);
                        nameField.setBounds(400, 200, 100, 25);
                        updatFrame1.add(nameField);

                        rollLabel = new JLabel("New Roll No.");
                        rollLabel.setBounds(320, 280, 80, 60);
                        updatFrame1.add(rollLabel);

                        rollField = new JTextField(20);
                        rollField.setBounds(400, 300, 100, 25);
                        updatFrame1.add(rollField);

                        updateButton1 = new JButton("UPDATE");
                        updateButton1.setBounds(340, 400, 80, 25);
                        updatFrame1.add(updateButton1);
                        updateButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        updateButton1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (e.getSource() == updateButton1) {
                                    if (rollField.getText().isEmpty() && nameField.getText().isEmpty()) {
                                        JOptionPane.showMessageDialog(updatFrame1, "Please Enter Roll No. and Name",
                                                "WARNING", JOptionPane.WARNING_MESSAGE);
                                    } else if (rollField.getText().isEmpty()) {
                                        JOptionPane.showMessageDialog(updatFrame1, "Please Enter Roll No.", "WARNING",
                                                JOptionPane.WARNING_MESSAGE);
                                    } else if (nameField.getText().isEmpty()) {
                                        JOptionPane.showMessageDialog(updatFrame1, "Please enter Name", "WARNING",
                                                JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        try {
                                            Class.forName("com.mysql.cj.jdbc.Driver");
                                            Connection c = DriverManager.getConnection(
                                                    "jdbc:mysql://localhost:3306/Student_data", "root", "amar2003");
                                            Statement st = c.createStatement();
                                            String Roll = rollField.getText();
                                            String Name = nameField.getText();
                                            // String url = "INSERT INTO Student_data VALUES ('" + roll + "', '" + name
                                            // +
                                            // "')";
                                            String url = "Update Student_data Set roll ='" + Roll + "' Where name ='"
                                                    + Name + "'";
                                            JOptionPane.showMessageDialog(updatFrame1,
                                                    "Roll No. of Student " + Name + " Updated successfully",
                                                    "Successful", JOptionPane.PLAIN_MESSAGE);
                                            st.executeUpdate(url);
                                        } catch (Exception ex) {
                                            System.out.println(ex);
                                        }
                                    }
                                }
                            }
                        });

                        BackButton = new JButton("BACK");
                        BackButton.setBounds(340, 500, 80, 25);
                        updatFrame1.add(BackButton);
                        BackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        BackButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                updatFrame1.setVisible(false);
                            }
                        });

                    }
                });

                updatenameButton = new JButton("Name");
                updatenameButton.setBounds(340, 380, 80, 60);
                updatFrame.add(updatenameButton);
                updatenameButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                updatenameButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame updateFrame2 = new JFrame("Update Name");
                        updateFrame2.setSize(800, 800);
                        updateFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        updateFrame2.setLayout(null);
                        updateFrame2.setVisible(true);

                        rollLabel = new JLabel("Enter Roll No");
                        rollLabel.setBounds(320, 180, 80, 60);
                        updateFrame2.add(rollLabel);

                        rollField = new JTextField(20);
                        rollField.setBounds(400, 200, 100, 25);
                        updateFrame2.add(rollField);

                        nameLabel = new JLabel("New Name");
                        nameLabel.setBounds(320, 280, 80, 60);
                        updateFrame2.add(nameLabel);

                        nameField = new JTextField(20);
                        nameField.setBounds(400, 300, 100, 25);
                        updateFrame2.add(nameField);

                        updateButton2 = new JButton("UPDATE");
                        updateButton2.setBounds(340, 400, 80, 25);
                        updateFrame2.add(updateButton2);
                        updateButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        updateButton2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (e.getSource() == updateButton2) {
                                    if (rollField.getText().isEmpty() && nameField.getText().isEmpty()) {
                                        JOptionPane.showMessageDialog(updateFrame2, "Please Enter Roll No. and Name",
                                                "WARNING", JOptionPane.WARNING_MESSAGE);
                                    } else if (rollField.getText().isEmpty()) {
                                        JOptionPane.showMessageDialog(updateFrame2, "Please Enter Roll No.", "WARNING",
                                                JOptionPane.WARNING_MESSAGE);
                                    } else if (nameField.getText().isEmpty()) {
                                        JOptionPane.showMessageDialog(updateFrame2, "Please enter Name", "WARNING",
                                                JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        try {
                                            Class.forName("com.mysql.cj.jdbc.Driver");
                                            Connection c = DriverManager.getConnection(
                                                    "jdbc:mysql://localhost:3306/Student_data", "root", "amar2003");
                                            Statement st = c.createStatement();
                                            String Roll = rollField.getText();
                                            String Name = nameField.getText();
                                            // String url = "INSERT INTO Student_data VALUES ('" + roll + "', '" + name
                                            // +
                                            // "')";
                                            String url = "Update Student_data Set name ='" + Name + "' Where roll ='"
                                                    + Roll
                                                    + "'";
                                            JOptionPane.showMessageDialog(updateFrame2,
                                                    "Name of Student Roll No. " + Roll + " updated successfuly",
                                                    "Successful", JOptionPane.PLAIN_MESSAGE);
                                            st.executeUpdate(url);
                                        } catch (Exception ex) {
                                            System.out.println(ex);
                                        }
                                    }
                                }

                            }
                        });

                        BackButton = new JButton("BACK");
                        BackButton.setBounds(340, 500, 80, 25);
                        updateFrame2.add(BackButton);
                        BackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        BackButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                updateFrame2.setVisible(false);
                            }

                        });

                    }
                });

                BackButton = new JButton("BACK");
                BackButton.setBounds(340, 480, 80, 60);
                updatFrame.add(BackButton);
                BackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                BackButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updatFrame.setVisible(false);
                    }
                });
            }

        });

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(340, 480, 80, 60);
        panel.add(deleteButton);
        deleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame deletFrame = new JFrame("Delete Data");
                deletFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                deletFrame.setSize(800, 800);
                deletFrame.setLayout(null);
                deletFrame.setVisible(true);

                rollLabel = new JLabel("Roll No.: ");
                rollLabel.setBounds(320, 180, 80, 60);
                deletFrame.add(rollLabel);

                rollField = new JTextField(20);
                rollField.setBounds(400, 200, 100, 25);
                deletFrame.add(rollField);

                deleteButton2 = new JButton("DELETE");
                deleteButton2.setBounds(340, 280, 80, 25);
                deletFrame.add(deleteButton2);
                deleteButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                deleteButton2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (rollField.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(deletFrame, "Plese Enter Roll No.", "WARNING",
                                    JOptionPane.WARNING_MESSAGE);
                        } else {
                            try {
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_data",
                                        "root", "amar2003");
                                Statement st = c.createStatement();
                                String Roll = rollField.getText();
                                // String url = "INSERT INTO Student_data VALUES ('" + roll + "', '" + name +
                                // "')";
                                String url = "Delete from student_data where roll = '" + Roll + "'";
                                st.executeUpdate(url);
                                JOptionPane.showMessageDialog(deletFrame,
                                        "Data of Roll No. " + Roll + " Deleted Successfully", "Successful",
                                        JOptionPane.PLAIN_MESSAGE);

                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                        }
                    }
                });

                BackButton = new JButton("BACK");
                BackButton.setBounds(340, 380, 80, 25);
                deletFrame.add(BackButton);
                BackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                BackButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        deletFrame.setVisible(false);
                    }
                });
            }
        });

        exitButton = new JButton("Exit");
        exitButton.setBounds(340, 580, 80, 60);
        panel.add(exitButton);
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(panel, "confirm if you Want to Exit", "Want to Exit",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                    System.exit(0);
                // panel.setVisible(false);
            }
        });

        return panel;
    }

    public void actionPerformed(ActionEvent e) {

    }
}