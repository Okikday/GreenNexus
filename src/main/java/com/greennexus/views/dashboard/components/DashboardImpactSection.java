package com.greennexus.views.dashboard.components;

import com.greennexus.components.ButtonFactory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DashboardImpactSection {
    public static HBox build() {
        HBox root = new HBox(20);
        root.setAlignment(Pos.TOP_LEFT);
        root.setPadding(new Insets(10));

        // Left side: Pickup Locations
        VBox pickupBox = new VBox(10);
        pickupBox.setPadding(new Insets(4, 15, 4, 15));
        pickupBox.setBackground(new Background(new BackgroundFill(Color.web("#f9fcff"), new CornerRadii(10), Insets.EMPTY)));
        pickupBox.setPrefWidth(700);
        pickupBox.setMinHeight(250);
        pickupBox.setAlignment(Pos.TOP_LEFT);

        Label pickupTitle = new Label("📍 Pickup Locations");
        pickupTitle.setFont(Font.font("System", FontWeight.BOLD, 16));

        VBox mapMock = new VBox();
        mapMock.setPrefHeight(200);
        mapMock.setAlignment(Pos.CENTER);
        mapMock.setBackground(new Background(new BackgroundFill(Color.web("#f5f7fa"), new CornerRadii(10), Insets.EMPTY)));
        mapMock.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));

        Label comingSoon = new Label("Interactive Map View (Coming Soon)");
        comingSoon.setTextFill(Color.GRAY);

        mapMock.getChildren().add(comingSoon);
        pickupBox.getChildren().addAll(pickupTitle, mapMock);

        // Right side: Environmental Impact
        VBox impactBox = new VBox(15);
        impactBox.setPadding(new Insets(15));
        impactBox.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY)));
        impactBox.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));
        impactBox.setPrefWidth(300);
        impactBox.setMinHeight(250);

        Label impactTitle = new Label("♻ Environmental Impact");
        impactTitle.setFont(Font.font("System", FontWeight.BOLD, 16));

        VBox metric1 = buildMetric("CO₂ Emissions Saved", "245 kg", Color.GREEN);
        VBox metric2 = buildMetric("Waste Recycled", "1.2 tons", Color.BLUE);
        VBox metric3 = buildMetric("Trees Saved", "32", Color.ORANGE);

        Button reportButton = ButtonFactory.create("View Full Impact Report", () -> {});
        reportButton.setStyle("-fx-background-color: transparent; -fx-border-color: #d1d5db; -fx-border-radius: 6;");
        reportButton.setMaxWidth(Double.MAX_VALUE);

        impactBox.getChildren().addAll(impactTitle, metric1, metric2, metric3, reportButton);

        root.getChildren().addAll(pickupBox, impactBox);
        for(Node child: root.getChildren()){
            HBox.setHgrow(child, Priority.ALWAYS);
        }
        return root;
    }

    private static VBox buildMetric(String labelText, String valueText, Color barColor) {
        VBox box = new VBox(5);

        Label label = new Label(labelText);
        label.setTextFill(Color.GRAY);

        Label value = new Label(valueText);
        value.setFont(Font.font("System", FontWeight.BOLD, 18));

        StackPane barContainer = new StackPane();
        barContainer.setPrefHeight(6);
        barContainer.setBackground(new Background(new BackgroundFill(Color.web("#eef1f5"), new CornerRadii(5), Insets.EMPTY)));

        Rectangle progress = new Rectangle();
        progress.setHeight(6);
        progress.setArcHeight(5);
        progress.setArcWidth(5);
        progress.setFill(barColor);

        // Fake width ratios
        if (labelText.contains("CO₂")) progress.setWidth(140);
        else if (labelText.contains("Waste")) progress.setWidth(180);
        else progress.setWidth(120);

        barContainer.getChildren().add(progress);
        barContainer.setAlignment(Pos.CENTER_LEFT);

        box.getChildren().addAll(value, label, barContainer);
        return box;
    }
}
