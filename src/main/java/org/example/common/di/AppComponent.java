package org.example.common.di;

import org.example.data.datasources.remote.WeatherRemoteDataSource;
import org.example.data.datasources.remote.WeatherRemoteDataSourceImpl;
import org.example.data.datasources.remote.api.ApiService;
import org.example.data.datasources.remote.api.RetrofitClient;
import org.example.data.mappers.WeatherMapper;
import org.example.data.repositories.WeatherRepository;
import org.example.domain.gateways.WeatherGateway;
import org.example.domain.usecases.GetCurrentWeatherUseCase;
import org.example.domain.usecases.GetCurrentWeatherUseCaseImpl;
import org.example.presentation.mainscreen.MainViewModel;

public class AppComponent {

    private AppComponent() {}

    private static AppComponent INSTANCE = null;

    private final ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
    private final WeatherRemoteDataSource weatherRemoteDataSource = new WeatherRemoteDataSourceImpl(apiService);
    private final WeatherMapper weatherMapper = WeatherMapper.getInstance();
    private final WeatherGateway weatherGateway = new WeatherRepository(weatherRemoteDataSource, weatherMapper);
    private final GetCurrentWeatherUseCase getCurrentWeatherUseCase = new GetCurrentWeatherUseCaseImpl(weatherGateway);
    private final MainViewModel mainViewModel = new MainViewModel(getCurrentWeatherUseCase);

    public static synchronized AppComponent getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppComponent();
        }
        return INSTANCE;
    }

    public MainViewModel getMainViewModel() {
        return mainViewModel;
    }
}
