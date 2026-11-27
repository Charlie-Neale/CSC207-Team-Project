package interface_adapter.add_question;

import java.util.ArrayList;
import java.util.List;

public class AddQuestionViewModel {
    public static final String VIEW_NAME = "add question";

    private final List<AddQuestionViewModelListener> listeners = new ArrayList<>();
    private AddQuestionState state = new AddQuestionState();

    public AddQuestionState getState() {
        return state;
    }

    public void setState(AddQuestionState state) {
        this.state = state;
    }

    public void addListener(AddQuestionViewModelListener listener) {
        listeners.add(listener);
    }

    public void notifyStateChanged() {
        for(AddQuestionViewModelListener listener : listeners) {
            listener.stateChanged();
        }
    }
}
