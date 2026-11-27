package interface_adapter.add_question;

import interface_adapter.ViewManagerModel;
import use_case.add_question.AddQuestionOutputBoundary;
import use_case.add_question.AddQuestionOutputData;

/**
 * The Presenter for the Add Question Use Case
 */
public class AddQuestionPresenter implements AddQuestionOutputBoundary {
    private final AddQuestionViewModel addQuestionViewModel;
    private final ViewManagerModel viewManagerModel;

    public AddQuestionPresenter(AddQuestionViewModel addQuestionViewModel, ViewManagerModel viewManagerModel) {
        this.addQuestionViewModel = addQuestionViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(AddQuestionOutputData response) {
        final AddQuestionState state = addQuestionViewModel.getState();
        state.setErrorMessage(null);
        state.setSuccessMessage(response.getMessage());
        addQuestionViewModel.notifyStateChanged();
    }

    @Override
    public  void prepareFailView(String errorMessage) {
        final AddQuestionState state = addQuestionViewModel.getState();
        state.setSuccessMessage(null);
        state.setErrorMessage(errorMessage);
        addQuestionViewModel.notifyStateChanged();
    }

}
