package interface_adapter.main_menu;

import use_case.main_menu_switch.MainMenuSwitchInputBoundary;
import use_case.main_menu_switch.MainMenuSwitchInputData;
import use_case.start_game.StartGameInputData;

public class MainMenuSwitchController {
    private final MainMenuSwitchInputBoundary mainMenuSwitchUseCaseInteractor;

    MainMenuSwitchController(MainMenuSwitchInputBoundary mainMenuSwitchUseCaseInteractor){
        this.mainMenuSwitchUseCaseInteractor = mainMenuSwitchUseCaseInteractor;
    }

    /**
     * Executes the Main Menu Switch use case.
     */
    public void execute(String nextScreen) {
        final MainMenuSwitchInputData mainMenuSwitchInputData = new MainMenuSwitchInputData(nextScreen);
        mainMenuSwitchUseCaseInteractor.execute(mainMenuSwitchInputData);
    }
}
