package use_case.main_menu_switch;

public interface MainMenuSwitchOutputBoundary {
    /**
     * Prepares the success view for the Start Game Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(MainMenuSwitchOutputData outputData);
}
