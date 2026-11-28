package use_case.track_score;

import entity.Team;

public class TrackScoreInteractor implements TrackScoreInputBoundary {

    private final TrackScoreDataAccessInterface dataAccess;
    private final TrackScoreOutputBoundary presenter;

    public TrackScoreInteractor(TrackScoreDataAccessInterface dataAccess,
                                TrackScoreOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(TrackScoreInputData inputData) {
        final Team teamOne = dataAccess.getTeam(inputData.getTeamOneName());
        final Team teamTwo = dataAccess.getTeam(inputData.getTeamTwoName());

        if (teamOne == null || teamTwo == null) {
            presenter.prepareFailView("team could not be found");
            return;
        }

        if (inputData.isGameEnded()) {
            try {
                dataAccess.saveTeam(teamOne);
                dataAccess.saveTeam(teamTwo);
            }
            catch (RuntimeException e) {
                presenter.prepareFailView("final scores fail to saved");
                return;
            }
        }

        final TrackScoreOutputData outputData = new TrackScoreOutputData(
                teamOne.getName(), teamOne.getScore(),
                teamTwo.getName(), teamTwo.getScore(),
                inputData.isGameEnded());

        presenter.prepareSuccessView(outputData);
    }
}