package interface_adapter.add_question;

import use_case.add_question.AddQuestionInputBoundary;
import use_case.add_question.AddQuestionInputData;

import java.util.List;

public class AddQuestionController {
    private final AddQuestionInputBoundary addQuestionInteractor;

    public AddQuestionController(AddQuestionInputBoundary addQuestionInteractor) {
        this.addQuestionInteractor = addQuestionInteractor;
    }

    /**
     * Excutes the Add Question use case
     */
    public void execute(String questionText,
                        List<String> primaryAnswers,
                        List<Integer> scores,
                        List<List<String>> acceptedVariants) {
        final AddQuestionInputData inputData = new AddQuestionInputData(questionText, primaryAnswers, scores, acceptedVariants);
        addQuestionInteractor.execute(inputData);
    }

}
