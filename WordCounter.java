import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter extends JFrame {
    private JTextArea textArea;
    private JLabel characterCountLabel;
    private JLabel wordCountLabel;
    private JButton countButton;

    public WordCounter() {
        setTitle("Word Counter");
        setSize(400, 300); // Adjusted window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setRows(5); // Set the number of visible rows
        textArea.setColumns(20); // Set the number of visible columns
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });
        buttonPanel.add(countButton);
        add(buttonPanel, BorderLayout.SOUTH);

        JPanel countPanel = new JPanel(new GridLayout(2, 2, 10, 5));
        characterCountLabel = new JLabel("Characters: 0");
        wordCountLabel = new JLabel("Words: 0");
        countPanel.add(characterCountLabel);
        countPanel.add(wordCountLabel);
        add(countPanel, BorderLayout.NORTH);

        setVisible(true);
    }

    private void countWords() {
        String text = textArea.getText();
        int charCount = text.length();
        int wordCount = text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;
        characterCountLabel.setText("Characters: " + charCount);
        wordCountLabel.setText("Words: " + wordCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCounter();
            }
        });
    }
}
