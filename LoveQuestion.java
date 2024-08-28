 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class LoveQuestion extends JFrame {

    private JButton yesButton, noButton;
    private JLabel questionLabel;
    private Random random;

    public LoveQuestion() {
        setTitle("Love Question");
        setLayout(new BorderLayout());

        questionLabel = new JLabel("Jyothika, do you love Aswin?");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 24));
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        add(questionLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null); // Use null layout to manually position components
        add(buttonPanel, BorderLayout.CENTER);

        yesButton = new JButton("Yes");
        yesButton.addActionListener(new YesButtonListener());
        yesButton.setBounds(100, 150, 80, 30); // Position "Yes" button
        buttonPanel.add(yesButton);

        noButton = new JButton("No");
        noButton.addActionListener(new NoButtonListener());
        noButton.setBounds(200, 150, 80, 30); // Initial position of "No" button
        buttonPanel.add(noButton);

        random = new Random(); // Initialize random for moving "No" button
    }

    private class YesButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Print message with love emoji
            System.out.println("I knew it, Jyothi! ❤️");
            JOptionPane.showMessageDialog(null, "I knew it, Jyothi! ❤️");
            System.exit(0);
        }
    }

    private class NoButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Move "No" button to a random new location within the panel bounds
            int x = random.nextInt(getWidth() - noButton.getWidth());
            int y = random.nextInt(getHeight() - noButton.getHeight() - 50); // Offset to stay in view
            noButton.setLocation(x, y);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoveQuestion loveQuestion = new LoveQuestion();
            loveQuestion.setSize(400, 300);
            loveQuestion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loveQuestion.setVisible(true);
        });
    }
}
