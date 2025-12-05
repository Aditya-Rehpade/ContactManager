import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ContactManager extends JFrame {
    private JTextField nameField, phoneField, emailField;
    private JTextArea contactsArea;
    private List<Contact> contacts;

    public ContactManager() {
        contacts = new ArrayList<>();
        initUI();
    }

    private void initUI() {
        setTitle("Simple Contact Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add Contact"));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        inputPanel.add(phoneField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        JButton addButton = new JButton("Add Contact");
        inputPanel.add(addButton);

        JButton clearButton = new JButton("Clear");
        inputPanel.add(clearButton);

        // Contacts display
        contactsArea = new JTextArea();
        contactsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(contactsArea);

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        JButton deleteButton = new JButton("Delete Selected");
        JButton refreshButton = new JButton("Refresh");
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Action listeners
        addButton.addActionListener(e -> addContact());
        clearButton.addActionListener(e -> clearFields());
        deleteButton.addActionListener(e -> deleteContact());
        refreshButton.addActionListener(e -> refreshContacts());

        add(mainPanel);
    }

    private void addContact() {
        String name = nameField.getText().trim();
        String phone = phoneField.getText().trim();
        String email = emailField.getText().trim();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name is required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        contacts.add(new Contact(name, phone, email));
        refreshContacts();
        clearFields();
        JOptionPane.showMessageDialog(this, "Contact added!");
    }

    private void deleteContact() {
        String text = contactsArea.getSelectedText();
        if (text != null && !text.isEmpty()) {
            String[] lines = contactsArea.getText().split("\n");
            for (int i = 0; i < lines.length; i++) {
                if (lines[i].contains(text.trim())) {
                    contacts.remove(i);
                    refreshContacts();
                    JOptionPane.showMessageDialog(this, "Contact deleted!");
                    return;
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a contact to delete!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void refreshContacts() {
        contactsArea.setText("");
        for (Contact c : contacts) {
            contactsArea.append(c.toString() + "\n");
        }
    }

    private void clearFields() {
        nameField.setText("");
        phoneField.setText("");
        emailField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ContactManager().setVisible(true));
    }

    static class Contact {
        String name, phone, email;

        Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        @Override
        public String toString() {
            return name + " | " + phone + " | " + email;
        }
    }
}
