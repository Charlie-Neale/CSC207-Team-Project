package interface_adapter.track_score;

/**
 * the state information for the team scores shown during a game.
 */

public class TrackScoreState {
    private String teamOneName = "";
    private int teamOneScore = 0;
    private String teamTwoName = "";
    private int teamTwoScore = 0;
    private boolean gameEnded = false;
    private String error = null;

    public String getTeamOneName() { return teamOneName; }

    public void setTeamOneName(String teamOneName) { this.teamOneName = teamOneName; }

    public int getTeamOneScore() { return teamOneScore; }

    public void setTeamOneScore(int teamOneScore) { this.teamOneScore = teamOneScore; }

    public String getTeamTwoName() { return teamTwoName; }

    public void setTeamTwoName(String teamTwoName) { this.teamTwoName = teamTwoName; }

    public int getTeamTwoScore() { return teamTwoScore; }

    public void setTeamTwoScore(int teamTwoScore) { this.teamTwoScore = teamTwoScore; }

    public boolean isGameEnded() { return gameEnded; }

    public void setGameEnded(boolean gameEnded) { this.gameEnded = gameEnded; }

    public String getError() { return error; }

    public void setError(String error) { this.error = error; }

}
