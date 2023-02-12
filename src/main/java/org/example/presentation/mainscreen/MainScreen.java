package org.example.presentation.mainscreen;

import org.example.common.di.AppComponent;
import org.example.domain.entities.Weather;
import org.example.presentation.common.BaseScreen;
import org.example.presentation.common.LiveData;
import java.util.Scanner;

public class MainScreen extends BaseScreen {

    private final MainViewModel viewModel = AppComponent.getInstance().getMainViewModel();

    @Override
    public void onStart() {
        observers();
        showMenu();
    }

    @Override
    public void onFinish() {
        viewModel.onFinish();
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
                    onFinish();
                    System.exit(0);
                    break;
                }
                case "c": {
                    String place = scanner.nextLine();
                    viewModel.getCurrentWeather(place);
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

    private void observers() {
        viewModel.getPublisher().subscribe(new LiveData<>() {
            @Override
            public void onNext(Weather item) {
                super.onNext(item);
                System.out.println(item);
            }
        });
    }
}
