package use_case.main_menu_switch;

public class MainMenuSwitchOutputData {
    private final String nextScreen;

    public MainMenuSwitchOutputData(String nextScreen) {
        this.nextScreen = nextScreen;
    }

    public String getNextScreen() {return this.nextScreen; }
}
