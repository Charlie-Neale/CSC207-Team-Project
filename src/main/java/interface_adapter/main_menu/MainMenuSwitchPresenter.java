package interface_adapter.main_menu;

import interface_adapter.ViewManagerModel;
import interface_adapter.create_teams.CreateTeamState;
import interface_adapter.create_teams.CreateTeamViewModel;
import interface_adapter.game_running.GameRunningState;
import interface_adapter.game_running.GameRunningViewModel;
import use_case.main_menu_switch.MainMenuSwitchOutputBoundary;
import use_case.main_menu_switch.MainMenuSwitchOutputData;
import view.CreateTeamView;

public class MainMenuSwitchPresenter implements MainMenuSwitchOutputBoundary {
    private final CreateTeamViewModel createTeamViewModel;
    private final ViewManagerModel viewManagerModel;

    MainMenuSwitchPresenter(CreateTeamViewModel createTeamViewModel, ViewManagerModel viewManagerModel) {
        this.createTeamViewModel = createTeamViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(MainMenuSwitchOutputData mainMenuSwitchOutputData) {
        // Change the main board
        String nextScreen = mainMenuSwitchOutputData.getNextScreen();

        // HERE IS WHERE I WOULD ADD CASES TO SWITCH SCREENS USING THE OUTPUT DATA, CURRENTLY UNUSED

        viewManagerModel.setState(CreateTeamViewModel.VIEW_NAME);
        viewManagerModel.notifyViewChanged();
    }
}
