package view;

import data_access.InMemoryDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_question.*;
import use_case.add_question.AddQuestionInputBoundary;
import use_case.add_question.AddQuestionInteractor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AddQuestionView extends JPanel implements AddQuestionViewModelListener {
    private final AddQuestionViewModel addQuestionViewModel;
    private AddQuestionController addQuestionController = null;

    private final JTextField questionInput = new JTextField(30);
    private final int MAX_ANSWERS = 10;
    private final int MAX_QUESTIONS = 8;
    private int questionsAdded = 0;

    private final JLabel countLabel = new JLabel("Questions Added: 0 / " + MAX_QUESTIONS);
    private final JTextField[] answerFields = new JTextField[MAX_ANSWERS];
    private final JTextField[] scoreFields = new JTextField[MAX_ANSWERS];
    private final JTextField[] variantFields = new JTextField[MAX_ANSWERS];
    private final JButton saveButton = new JButton("Save Question");

    public AddQuestionView(AddQuestionViewModel addQuestionViewModel) {
        this.addQuestionViewModel = addQuestionViewModel;
        this.addQuestionViewModel.addListener(this);
        this.setUpDisplay();
    }

    private void setUpDisplay() {
        this.setSize(1000, 600);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        final JLabel title = new JLabel("Add Question");
        title.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 48));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        countLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 16));
        countLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel questionPanel = new JPanel();
        final JLabel questionLabel = new JLabel("Question: ");
        questionLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 18));
        questionPanel.add(questionLabel);
        questionPanel.add(questionInput);
        questionPanel.setMaximumSize(new Dimension(1000, 50));

        final JPanel answersPanel = new JPanel();
        answersPanel.setLayout(new GridLayout(MAX_ANSWERS + 1, 3, 15, 10));
        answersPanel.setMaximumSize(new Dimension(850, 260));

        answersPanel.add(new JLabel("Primary Answer", SwingConstants.CENTER));
        answersPanel.add(new JLabel("Score (Points)", SwingConstants.CENTER));
        answersPanel.add(new JLabel("Variants (comma-separated)", SwingConstants.CENTER));

        for (int i = 0; i < MAX_ANSWERS; i++) {
            answerFields[i] = new JTextField(15);
            scoreFields[i] = new JTextField(5);
            variantFields[i] = new JTextField(20);

            answersPanel.add(answerFields[i]);
            answersPanel.add(scoreFields[i]);
            answersPanel.add(variantFields[i]);
        }

        final JScrollPane scrollPane = new JScrollPane(answersPanel);
        scrollPane.setMaximumSize(new Dimension(880, 300));

        final JPanel buttonPanel = new JPanel();
        saveButton.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 18));
        saveButton.addActionListener(evt -> handleSubmit());
        buttonPanel.add(saveButton);

        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(countLabel);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(questionPanel);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(scrollPane);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(buttonPanel);
    }
    private void handleSubmit() {
        if (addQuestionController == null) {
            return;
        }

        String questionText = questionInput.getText();
        List<String> primaryAnswers = new ArrayList<>();
        List<Integer> scores = new ArrayList<>();
        List<List<String>> acceptedVariants = new ArrayList<>();

        for (int i = 0; i < MAX_ANSWERS; i++) {
            String ansText = answerFields[i].getText().trim();
            String scoreText = scoreFields[i].getText().trim();
            String varText = variantFields[i].getText().trim();

            if (!ansText.isEmpty() || !scoreText.isEmpty()) {
                primaryAnswers.add(ansText);

                try {
                    scores.add(Integer.parseInt(scoreText));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this,
                            "Score on row " + (i + 1) + " must be a valid integer!",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (varText.isEmpty()) {
                    acceptedVariants.add(new ArrayList<>());
                } else {
                    List<String> vars = new ArrayList<>();
                    for (String v : varText.split(",")) {
                        if (!v.trim().isEmpty()) {
                            vars.add(v.trim());
                        }
                    }
                    acceptedVariants.add(vars);
                }
            }
        }
        addQuestionController.execute(questionText, primaryAnswers, scores, acceptedVariants);
    }

    @Override
    public void stateChanged() {
        AddQuestionState state = addQuestionViewModel.getState();

        if (state.getErrorMessage() != null) {
            JOptionPane.showMessageDialog(this, state.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } else if (state.getSuccessMessage() != null) {
            questionsAdded++;
            countLabel.setText("Questions Added: " + questionsAdded + " / " + MAX_QUESTIONS);

            if (questionsAdded >= MAX_QUESTIONS) {
                JOptionPane.showMessageDialog(this,
                        "All " + MAX_QUESTIONS + " questions have been added for this game!",
                        "Completed", JOptionPane.INFORMATION_MESSAGE);
                saveButton.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, state.getSuccessMessage(), "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            clearFields();
        }
    }
    private void clearFields() {
        questionInput.setText("");
        for (int i = 0; i < MAX_ANSWERS; i++) {
            answerFields[i].setText("");
            scoreFields[i].setText("");
            variantFields[i].setText("");
        }
    }
    public void setAddQuestionController(AddQuestionController controller) {
        this.addQuestionController = controller;
    }
}
