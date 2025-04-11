package com.greennexus.views.dashboard.components;

import com.greennexus.styles.DefaultFont;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DashboardPickupManagement {

    public static VBox build() {
        Label titleLabel = new Label("\uD83D\uDCC5 Pickup Management");
        titleLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 18));
        titleLabel.setTextFill(Color.web("#222"));

        HBox cards = new HBox(15,
                buildCard("Plastic", "Mar 30, 2025", "15 Awolowo Road, Ikoyi, Lagos", "Pending", "#F5C940", "#0047FF"),
                buildCard("Household", "Mar 31, 2025", "42 Adeola Odeku Street, Victoria Island, Lagos", "Scheduled", "#A7C7FF", "#008000"),
                buildCard("Hazardous", "Apr 1, 2025", "7 Ahmadu Bello Way, Abuja", "Scheduled", "#A7C7FF", "#FF0000")
        );
        cards.setAlignment(Pos.CENTER_LEFT);
        for (Node card : cards.getChildren()) {
            HBox.setHgrow(card, Priority.ALWAYS);
        }

        VBox layout = new VBox(10, titleLabel, cards);
        layout.setPadding(new Insets(20, 0, 0, 0));
        DefaultFont.initDefaultFont(layout, 14);
        return layout;
    }

    private static VBox buildCard(String type, String date, String location, String status, String statusColor, String dotColor) {
        // Title with Dot Indicator
        HBox titleBox = new HBox(5);
        Circle dot = new Circle(5, Color.web(dotColor));
        Label typeLabel = new Label(type);
        typeLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 14));
        titleBox.getChildren().addAll(dot, typeLabel);

        Label dateLabel = new Label(date);
        dateLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.NORMAL, 12));
        dateLabel.setTextFill(Color.web("#7f8e9f"));

        Label locationLabel = new Label("\uD83D\uDCCD " + location);
        locationLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.NORMAL, 13));
        locationLabel.setTextFill(Color.web("#222"));

        Label statusLabel = new Label(status);
        statusLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 12));
        statusLabel.setTextFill(Color.web("#222"));
        statusLabel.setStyle("-fx-background-color: " + statusColor + "; -fx-padding: 4 8; -fx-background-radius: 12px;");

        Label viewDetails = new Label("View Details");
        viewDetails.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 12));
        viewDetails.setTextFill(Color.web("#7f8e9f"));

        VBox box = new VBox(12, titleBox, dateLabel, locationLabel, viewDetails);
        box.setPadding(new Insets(15));
        box.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
        box.setBorder(new Border(new BorderStroke(Color.web("#e2e8f0"), BorderStrokeStyle.SOLID, new CornerRadii(12), new BorderWidths(1))));
        box.setMinWidth(250);

        return box;
    }
}
