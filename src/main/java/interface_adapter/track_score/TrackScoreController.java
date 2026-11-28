package interface_adapter.track_score;

import use_case.track_score.TrackScoreInputBoundary;
import use_case.track_score.TrackScoreInputData;

/**
 * The controller for the Track Score use case.
 */

public class TrackScoreController {

    private final TrackScoreInputBoundary trackScoreInteractor;

    public TrackScoreController(TrackScoreInputBoundary trackScoreInteractor) {
        this.trackScoreInteractor = trackScoreInteractor;
    }

    /**
     * Executes the Track Score use case.
     */
    public void execute(String teamOneName, String teamTwoName, boolean gameEnded) {
        trackScoreInteractor.execute(new TrackScoreInputData(teamOneName, teamTwoName, gameEnded));
    }



}
