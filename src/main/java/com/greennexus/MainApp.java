package com.greennexus;

import com.greennexus.styles.DefaultFont;
import com.greennexus.styles.FontLoader;
import com.greennexus.views.WelcomeView;
import com.greennexus.views.dashboard.DashboardView;
import com.greennexus.views.recyclingcompanies.RecyclingCoordinationView;
import com.greennexus.views.report.ReportView;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    // Font configuration constants
    private static final double BASE_FONT_SIZE = 14;

    @Override
    public void start(Stage stage) throws IOException {
        // Initialize fonts before creating any views
        // initializeFonts();
        FontLoader.initialize();

        // Create and show your view
//         DashboardView dashboardView = new DashboardView(stage);
//         dashboardView.show();

        // Alternative if you want to use WelcomeView first:
//         WelcomeView welcomeView = new WelcomeView(stage);
//         welcomeView.show();

       ReportView reportView = new ReportView(stage);
       reportView.show();

        // RecyclingCoordinationView.show(stage);

    }

    public static void main(String[] args) {
        launch();
    }
}