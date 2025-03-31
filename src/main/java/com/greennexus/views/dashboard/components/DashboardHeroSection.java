package com.greennexus.views.dashboard.components;

import com.greennexus.components.ButtonFactory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DashboardHeroSection {
    public static VBox build() {
        Label welcomeLabel = new Label("Welcome to GreenNexus");
        welcomeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        welcomeLabel.setTextFill(Color.web("#1C1C1C"));


        Label subLabel1 = new Label("Your sustainable waste management platform. Track pickups, schedule collections, and");
        subLabel1.setFont(Font.font("Arial", 16));
        subLabel1.setTextFill(Color.web("#7f8e9f"));
        subLabel1.setWrapText(true);


        Label subLabel2 = new Label("contribute to a cleaner Nigeria.");
        subLabel2.setFont(Font.font("Arial", 16));
        subLabel2.setTextFill(Color.web("#7f8e9f"));
        subLabel2.setWrapText(true);

        final VBox labelBox = new VBox(0, subLabel1, subLabel2);


        final Button viewImpactBtn = ButtonFactory.create("View Impact", Color.web("2DAA5B"), Color.WHITE, () -> {

        });
        Button learnMoreBtn = ButtonFactory.create("Learn More", Color.WHITE, Color.BLACK, () -> {

        });
        learnMoreBtn.setBorder(new Border(new BorderStroke(
                Color.web("#e2e8f0"),
                BorderStrokeStyle.SOLID,
                new CornerRadii(4),
                new BorderWidths(1)
        )));


        HBox buttonsBox = new HBox(10, viewImpactBtn, learnMoreBtn);
        buttonsBox.setAlignment(Pos.CENTER_LEFT);

        VBox heroBox = new VBox(15, welcomeLabel, labelBox, buttonsBox);
        heroBox.setPadding(new Insets(20));
        heroBox.setBackground(new Background(new BackgroundFill(Color.web("#e8f6ee"), new CornerRadii(16), Insets.EMPTY)));
        heroBox.setBorder(new Border(new BorderStroke(
                Color.web("#e2e8f0"),
                BorderStrokeStyle.SOLID,
                new CornerRadii(16),
                new BorderWidths(1)
        )));
        heroBox.setPrefHeight(200);
        heroBox.setAlignment(Pos.CENTER_LEFT);
        return heroBox;
    }
}
