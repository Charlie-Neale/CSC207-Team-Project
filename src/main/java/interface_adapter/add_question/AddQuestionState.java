package interface_adapter.add_question;

/**
 * The state information for the Add Question View
 */
public class AddQuestionState {
    private String successMessage = null;
    private String errorMessage = null;

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
