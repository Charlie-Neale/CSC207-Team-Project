package view;

import interface_adapter.create_teams.CreateTeamViewModelListener;
import interface_adapter.create_teams.StartGameController;
import interface_adapter.main_menu.MainMenuSwitchController;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.main_menu.MainMenuViewModelListener;

import javax.swing.*;
import java.awt.*;

public class MainMenuView extends JPanel implements MainMenuViewModelListener {
    private final MainMenuViewModel mainMenuViewModel;
    private MainMenuSwitchController mainMenuSwitchController = null;

    public MainMenuView(MainMenuViewModel mainMenuViewModel) {
        this.mainMenuViewModel = mainMenuViewModel;

        this.setUpDisplay();
    }

    private void setUpDisplay() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Main Title
        final JLabel title = new JLabel("Family Feud");
        title.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 48));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Menu Buttons
        Font buttonFont = new Font("Bernard MT Condesned", Font.PLAIN, 36);
        final JButton startGameButton = createMenuButton("Start Game", buttonFont);
        startGameButton.addActionListener(
                evt -> {
                    this.mainMenuSwitchController.execute("create teams");
                }
        );

        this.add(Box.createVerticalStrut(20));
        this.add(title);
        this.add(Box.createVerticalStrut(20));
        this.add(startGameButton);

    }

    private JButton createMenuButton(String buttonText, Font labelFont) {
        final JButton button = new JButton();
        button.setLayout(new BoxLayout(button, BoxLayout.Y_AXIS));
        button.setLayout(new BoxLayout(button, BoxLayout.X_AXIS));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.setFont(labelFont);
        button.setText(buttonText);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        return button;
    }

    @Override
    public void stateChanged() {
        // Not Implemented Yet
    }

    public void setMainMenuSwitchController(MainMenuSwitchController mainMenuSwitchController) {
        this.mainMenuSwitchController = mainMenuSwitchController;
    }
}
