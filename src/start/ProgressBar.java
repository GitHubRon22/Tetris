package start;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressBar {
    private static JFrame frame;
    private static JProgressBar progressBar;
    private static JLabel percentageLabel;
    private static JButton startButton; // Declare the start button as a class-level variable

    public static void main(String[] args) {
        frame = new JFrame("GUI Example");
        frame.setSize(900, 490);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create a JLabel with an ImageIcon as the background
        ImageIcon backgroundIcon = new ImageIcon(ProgressBar.class.getResource("/resources/frame3.gif"));        
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        frame.setContentPane(backgroundLabel);

        JPanel photoPanel = new JPanel();
        photoPanel.setBounds(300, 100, 300, 100);
        photoPanel.setOpaque(false); // Make the panel transparent

        // Create the progress bar
        progressBar = new JProgressBar(SwingConstants.HORIZONTAL);
        progressBar.setBounds(300, 200, 300, 20);
        progressBar.setBackground(Color.BLACK);
        progressBar.setForeground(new Color (252, 133, 182));

        frame.add(progressBar);

        frame.add(photoPanel);

        // Create the percentage label
        percentageLabel = new JLabel("0%");
        percentageLabel.setBounds(425, 225, 50, 20);
        percentageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        percentageLabel.setFont(new Font("Poppins", Font.BOLD, 12));
        percentageLabel.setForeground(Color.BLACK);

        frame.add(percentageLabel);

        // Create the start button
        startButton = new JButton("Start");
        startButton.setBounds(355, 250, 180, 30);
        startButton.setBorderPainted(false); // Remove the border around the button
        startButton.setFocusPainted(false); // Remove the focus border
        startButton.setContentAreaFilled(false); // Remove the default button background
        startButton.setBackground(new Color(245, 245, 220));
        startButton.setRolloverEnabled(false);
        startButton.setFont(new Font("Poppins", Font.BOLD, 14));

        // Set hover color to green
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startButton.setBackground(Color.BLACK);
                startButton.setForeground(new Color(252, 133, 182));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                startButton.setBackground(new Color(245, 245, 220));
                startButton.setForeground(Color.BLACK);
            }
        });

        // Add ActionListener to the start button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startProgressBar();
            }
        });

        frame.add(startButton);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private static void startProgressBar() {
        int delay = 45;
        Timer timer = new Timer(delay, new ActionListener() {
            int progress = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (progress <= 100) {
                    progressBar.setValue(progress);
                    percentageLabel.setText(progress + "%");
                    progress++;
                } else {
                    ((Timer) e.getSource()).stop();

                    // Open the new class here
                    openNewClass();
                }
            }
        });

        // Disable the start button
        startButton.setEnabled(false);
        startButton.setText("Starting...");

        timer.start();
    }

    private static void openNewClass() {
        // Dispose the current JFrame
        frame.dispose();

        // Code to open the new class goes here
        // Replace "NewClass" with the actual name of your new class
        LoginForm newClass = new LoginForm();
        newClass.setVisible(true);
    }
}
