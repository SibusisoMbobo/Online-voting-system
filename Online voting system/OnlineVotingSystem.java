import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OnlineVotingSystem extends JFrame {
    private JTextField nameField, phoneField, idField;
    private JRadioButton genZButton, millennialsButton, genAlphaButton;
    private JButton submitButton, checkResultsButton;
    private ButtonGroup partyGroup;
    private int g1 = 0, g2 = 0, g3 = 0;
    private boolean hasVoted = false;

    public OnlineVotingSystem() {
        setTitle("Online Voting System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Phone Number:"));
        phoneField = new JTextField();
        add(phoneField);

        add(new JLabel("ID Number:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Select Party:"));
        partyGroup = new ButtonGroup();
        genZButton = new JRadioButton("Generation Z");
        millennialsButton = new JRadioButton("Millennials");
        genAlphaButton = new JRadioButton("Generation Alpha");

        partyGroup.add(genZButton);
        partyGroup.add(millennialsButton);
        partyGroup.add(genAlphaButton);

        JPanel partyPanel = new JPanel();
        partyPanel.add(genZButton);
        partyPanel.add(millennialsButton);
        partyPanel.add(genAlphaButton);
        add(partyPanel);

        submitButton = new JButton("Submit Your Vote");
        add(submitButton);

        checkResultsButton = new JButton("Check Results");
        add(checkResultsButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!hasVoted) {
                    if (genZButton.isSelected() || millennialsButton.isSelected() || genAlphaButton.isSelected()) {
                        if (genZButton.isSelected()) g1++;
                        else if (millennialsButton.isSelected()) g2++;
                        else g3++;
                        JOptionPane.showMessageDialog(null, "Vote submitted successfully!");
                        hasVoted = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Select a Party", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You have already voted!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        checkResultsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String results = "Generation Z: " + g1 + " votes\n" +
                                 "Millennials: " + g2 + " votes\n" +
                                 "Generation Alpha: " + g3 + " votes\n\n";
                
                int maxVotes = Math.max(g1, Math.max(g2, g3));
                if (maxVotes == g1) {
                    results += "Generation Z has the maximum votes.";
                } else if (maxVotes == g2) {
                    results += "Millennials has the maximum votes.";
                } else {
                    results += "Generation Alpha has the maximum votes.";
                }
                
                JOptionPane.showMessageDialog(null, results, "Voting Results", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new OnlineVotingSystem().setVisible(true);
            }
        });
    }
}
