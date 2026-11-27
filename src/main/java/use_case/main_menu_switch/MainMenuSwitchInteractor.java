package use_case.main_menu_switch;

public class MainMenuSwitchInteractor implements MainMenuSwitchInputBoundary{
    private final MainMenuSwitchOutputBoundary mainMenuSwitchPresenter;

    public MainMenuSwitchInteractor(MainMenuSwitchOutputBoundary mainMenuSwitchPresenter) {
        this.mainMenuSwitchPresenter = mainMenuSwitchPresenter;
    }

    @Override
    public void execute(MainMenuSwitchInputData mainMenuSwitchInputData) {
        MainMenuSwitchOutputData mainMenuSwitchOutputData = new MainMenuSwitchOutputData(
                mainMenuSwitchInputData.getNextScreen()
        );
        this.mainMenuSwitchPresenter.prepareSuccessView(mainMenuSwitchOutputData);
    }
}
