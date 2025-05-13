package com.greennexus.views.dashboard;

import com.greennexus.styles.DefaultFont;
import com.greennexus.views.dashboard.components.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DashboardView {
    private final Stage stage;

    public DashboardView(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        BorderPane root = new BorderPane();
        root.setTop(DashboardTopBar.build());
        root.setCenter(buildCenterContent());

        final Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Dashboard");
        // DefaultFont.initDefaultFont(root, 14);

        Image resizedImage = new Image(getClass().getResourceAsStream("/images/logo_no_bg_cropped.png"), 64, 64, true, true);

        stage.getIcons().add(resizedImage);
        stage.show();
        stage.setMaximized(true);
    }





    private ScrollPane buildCenterContent() {
        VBox centerLayout = new VBox(20);
        centerLayout.setPadding(new Insets(20));
        centerLayout.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        centerLayout.getChildren().addAll(
                DashboardHeroSection.build(),
                DashboardOverviewSection.build(),
                DashboardPickupManagement.build(),
                DashboardRecentActivity.build(),
                DashboardRecyclingCompanies.build(),
                DashboardImpactSection.build()
        );

        ScrollPane scrollPane = new ScrollPane(centerLayout);
        scrollPane.setFitToWidth(true);
        scrollPane.setPadding(new Insets(10));
        scrollPane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

        return scrollPane;
    }



}
