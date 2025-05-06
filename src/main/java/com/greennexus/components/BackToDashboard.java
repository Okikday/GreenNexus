package com.greennexus.components;

import com.greennexus.styles.FontLoader;
import com.greennexus.views.dashboard.components.DashboardTopBar;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class BackToDashboard {
  public static HBox build() {

        final Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        final HBox topBar = new HBox(15, buildbutton());
        topBar.setPadding(new Insets(16));
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setPrefHeight(50);
        return topBar;
    }

    /// --- BUTTONS SECTION ---

    // Logo Box
    private static HBox buildbutton(){
        Image image = new Image(DashboardTopBar.class.getResource("/images/arrow-left.png").toExternalForm());
        ImageView logoView = new ImageView(image);


        logoView.setFitWidth(24);
        // logoView.setFitHeight(32);
        logoView.setSmooth(true);
        logoView.setPreserveRatio(true);
        logoView.setCache(true);

        Rectangle clip = new Rectangle(32, 32);
        logoView.setClip(clip);

        Color originalColor = Color.rgb(100, 116, 139);
        Color hoverColor = Color.rgb(2, 8, 23);

        Text logoLabel = new Text("Back to Dashboard");
        logoLabel.setFont(FontLoader.getFont(FontLoader.Weight.REGULAR, 16));
        logoLabel.setFill(originalColor);

        HBox logoBox = new HBox(8, logoView, logoLabel);
        logoBox.setAlignment(Pos.CENTER_LEFT);


        logoBox.setOnMouseEntered(e -> {
            // Animate to hover color
            new Timeline(new KeyFrame(Duration.millis(200),
                new KeyValue(logoLabel.fillProperty(), 
                    hoverColor)
            )).play();
        });

        logoBox.setOnMouseExited(e -> {
            // Animate back to original color
            new Timeline(new KeyFrame(Duration.millis(200),
                new KeyValue(logoLabel.fillProperty(), 
                    originalColor)
            )).play();
        });
        return logoBox;
    }

}
