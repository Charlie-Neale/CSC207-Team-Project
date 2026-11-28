package interface_adapter.track_score;

import java.util.ArrayList;
import java.util.List;

/**
 * the view model for the team scores.
 */

public class TrackScoreViewModel {

    private final List<TrackScoreViewModelListener> listeners = new ArrayList<>();

    private TrackScoreState state = new TrackScoreState();

    public TrackScoreState getState() {
        return state;
    }

    public void setState(TrackScoreState state) {
        this.state = state;
    }

    public void addListener(TrackScoreViewModelListener listener) {
        listeners.add(listener);
    }

    public void notifyStateChanged() {
        for (TrackScoreViewModelListener listener : listeners) {
            listener.stateChanged();
        }
    }






}
