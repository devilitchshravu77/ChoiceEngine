package ui;

import dao.QuestionDAO;
import model.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class QuizGUI extends JFrame implements ActionListener {
    private ArrayList<Question> questions;
    private int currentIndex = 0, score = 0;
    private JLabel questionLabel;
    private JRadioButton optA, optB, optC, optD;
    private ButtonGroup optionsGroup;
    private JButton nextButton;

    public QuizGUI() {
        setTitle("Online Quiz System");
        setSize(600, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        questions = QuestionDAO.getAllQuestions();
        initComponents();
        displayQuestion();

        setVisible(true);
    }
private void initComponents() {
        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        optA = new JRadioButton();
        optB = new JRadioButton();
        optC = new JRadioButton();
        optD = new JRadioButton();
        optionsGroup = new ButtonGroup();
        optionsGroup.add(optA);
        optionsGroup.add(optB);
        optionsGroup.add(optC);
        optionsGroup.add(optD);
        optionsPanel.add(optA);
        optionsPanel.add(optB);
        optionsPanel.add(optC);
        optionsPanel.add(optD);
        add(optionsPanel, BorderLayout.CENTER);

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        add(nextButton, BorderLayout.SOUTH);
    }
 private void displayQuestion() {
        if (currentIndex < questions.size()) {
            Question q = questions.get(currentIndex);
            questionLabel.setText("Q" + (currentIndex + 1) + ": " + q.getQuestion());
            optA.setText(q.getOptionA());
            optB.setText(q.getOptionB());
            optC.setText(q.getOptionC());
            optD.setText(q.getOptionD());
            optionsGroup.clearSelection();
        } else {
            JOptionPane.showMessageDialog(this, "Quiz Over! Your score: " + score + "/" + questions.size());
            System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (questions.size() > currentIndex) {
            Question q = questions.get(currentIndex);
            char selected = ' ';
            if (optA.isSelected()) selected = 'A';
            else if (optB.isSelected()) selected = 'B';
            else if (optC.isSelected()) selected = 'C';
            else if (optD.isSelected()) selected = 'D';

            if (selected == q.getCorrectOption()) {
                score++;
            }

            currentIndex++;
            displayQuestion();
}
    }

    public static void main(String[] args) {
        new QuizGUI();
    }
}