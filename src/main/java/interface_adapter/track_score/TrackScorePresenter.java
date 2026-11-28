package interface_adapter.track_score;

import use_case.track_score.TrackScoreOutputBoundary;
import use_case.track_score.TrackScoreOutputData;

/**
 * The Presenter for the Track Score use case.
 */

public class TrackScorePresenter implements TrackScoreOutputBoundary {
    private final TrackScoreViewModel trackScoreViewModel;

    public TrackScorePresenter(TrackScoreViewModel trackScoreViewModel) {
        this.trackScoreViewModel = trackScoreViewModel;
    }

    @Override
    public void prepareSuccessView(TrackScoreOutputData outputData) {
        final TrackScoreState state = trackScoreViewModel.getState();
        state.setTeamOneName(outputData.getTeamOneName());
        state.setTeamOneScore(outputData.getTeamOneScore());
        state.setTeamTwoName(outputData.getTeamTwoName());
        state.setTeamTwoScore(outputData.getTeamTwoScore());
        state.setGameEnded(outputData.isGameEnded());
        state.setError(null);
        trackScoreViewModel.notifyStateChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        final TrackScoreState state = trackScoreViewModel.getState();
        state.setError(errorMessage);
        trackScoreViewModel.notifyStateChanged();
    }
}
