package com.greennexus.views.dashboard.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DashboardRecentActivity {
    public static VBox build() {
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_LEFT);

        Label title = new Label("Recent Activity");
        title.setFont(new Font("Arial", 20));

        VBox activities = new VBox(10);
        activities.getChildren().addAll(
                createActivity("Paper Waste Pickup", "Mar 25, 2025 at 10:30 AM", "23 Broad Street, Lagos Island"),
                createActivity("Glass Waste Pickup", "Mar 23, 2025 at 2:15 PM", "18 Bourdillon Road, Ikoyi, Lagos"),
                createActivity("Household Waste Pickup", "Mar 20, 2025 at 9:45 AM", "5 Akin Adesola Street, Victoria Island")
        );

        root.getChildren().addAll(title, activities);
        return root;
    }

    private static VBox createActivity(String title, String dateTime, String location) {
        VBox activityBox = new VBox(5);
        activityBox.setPadding(new Insets(10));
        activityBox.setStyle("-fx-border-color: lightgray; -fx-border-radius: 5; -fx-padding: 10;");

        Label activityTitle = new Label(title);
        activityTitle.setFont(new Font("Arial", 16));

        Label activityTime = new Label(dateTime);
        activityTime.setTextFill(Color.DARKGRAY);

        Label activityLocation = new Label(location);
        activityLocation.setTextFill(Color.DARKGRAY);

        activityBox.getChildren().addAll(activityTitle, activityTime, activityLocation);
        return activityBox;
    }
}
