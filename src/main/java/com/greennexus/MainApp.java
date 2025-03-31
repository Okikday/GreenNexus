package com.greennexus;

import com.greennexus.styles.DefaultFont;
import com.greennexus.views.WelcomeView;
import com.greennexus.views.dashboard.DashboardView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {

//        WelcomeView welcomeView = new WelcomeView(stage);
//        welcomeView.show();
        DashboardView dashboardView = new DashboardView(stage);
        dashboardView.show();
    }


    public static void main(String[] args) {
        launch();
    }
}