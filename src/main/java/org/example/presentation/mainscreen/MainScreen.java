package org.example.presentation.mainscreen;

import org.example.common.di.AppComponent;
import org.example.domain.entities.Weather;
import org.example.presentation.common.BaseScreen;

import java.util.Scanner;

public class MainScreen extends BaseScreen {

    private final MainViewModel viewModel = AppComponent.getInstance().getMainViewModel();

    @Override
    public void onStart() {
        showMenu();
    }

    private void showMenuText() {
        System.out.println("=========== [MENU] ===========");
        System.out.println("q = Exit");
        System.out.println("c = GetCurrentWeather");
        System.out.println("s = NavigateToSportsScreen");
    }

    private void showMenu() {
        Scanner scanner = new Scanner(System.in);
        do {
            showMenuText();
            switch (scanner.nextLine()) {
                case "q": {
                    System.out.println("Exit");
                    System.exit(0);
                    break;
                }
                case "c": {
                    Weather weather = viewModel.getCurrentWeather("London");
                    System.out.println(weather);
                    break;
                }
                case "s": {
                    break;
                }
                default: {
                    System.out.println("Invalid command");
                }
            }
        } while (true);
    }
}
