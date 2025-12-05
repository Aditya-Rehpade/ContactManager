import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        // Make sure GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowUI();
            }
        });
    }

    private static void createAndShowUI() {
        // Create main window (frame)
        JFrame frame = new JFrame("Simple Java UI App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Create a panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Label
        JLabel label = new JLabel("Enter your name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(label, gbc);

        // Text field
        JTextField nameField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(nameField, gbc);

        // Button
        JButton button = new JButton("Say Hello");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(button, gbc);

        // Result label
        JLabel resultLabel = new JLabel(" ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(resultLabel, gbc);

        // Button click action
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                if (name.isEmpty()) {
                    resultLabel.setText("Please enter your name.");
                } else {
                    resultLabel.setText("Hello, " + name + "!");
                }
            }
        });

        // Add panel to frame and show
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
