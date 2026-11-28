package use_case.main_menu_switch;

public class MainMenuSwitchInputData {
    private final String nextScreen;

    public MainMenuSwitchInputData(String nextScreen) {
        this.nextScreen = nextScreen;
    }

    public String getNextScreen() {return this.nextScreen; }
}
