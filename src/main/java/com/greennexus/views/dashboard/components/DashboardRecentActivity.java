package com.greennexus.views.dashboard.components;

import com.greennexus.styles.DefaultFont;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DashboardRecentActivity {
    public static VBox build() {
        VBox root = new VBox(20);
        root.setPadding(new Insets(0));
        root.setAlignment(Pos.TOP_LEFT);

        Label title = new Label("Recent Activity");
        title.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 20));

        VBox activities = new VBox(0);
        activities.getChildren().addAll(
                buildActivity("Paper Waste Pickup", "Mar 25, 2025 at 10:30 AM", "23 Broad Street, Lagos Island", Color.GREEN),
                buildActivity("Glass Waste Pickup", "Mar 23, 2025 at 2:15 PM", "18 Bourdillon Road, Ikoyi, Lagos", Color.GREEN),
                buildActivity("Household Waste Pickup", "Mar 20, 2025 at 9:45 AM", "5 Akin Adesola Street, Victoria Island", Color.GREEN)
        );

        root.getChildren().addAll(title, activities);
        DefaultFont.initDefaultFont(root, 14);
        return root;
    }

    private static HBox buildActivity(String title, String dateTime, String location, Color innerCircleColor) {
        HBox hBox = new HBox(10); // Space between timeline & activity content
        hBox.setAlignment(Pos.TOP_LEFT);

        // Timeline indicator
        Canvas timelineCanvas = new Canvas(30, 100); // Small canvas for each activity
        drawTimeline(timelineCanvas.getGraphicsContext2D(), timelineCanvas.getWidth(), timelineCanvas.getHeight(), innerCircleColor);

        // Activity details
        VBox activityBox = new VBox(5);
        activityBox.setPadding(new Insets(10));
        activityBox.setBorder(new Border(new BorderStroke(Color.web("f9fcff"), BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        activityBox.setPadding(new Insets(10));
        activityBox.setMaxWidth(Double.MAX_VALUE); // Allow expansion

        Label activityTitle = new Label(title);
        activityTitle.setFont(Font.font(Font.getDefault().getName(), 16));

        Label activityTime = new Label(dateTime);
        activityTime.setTextFill(Color.DARKGRAY);

        Label activityLocation = new Label(location);
        activityLocation.setTextFill(Color.DARKGRAY);

        activityBox.getChildren().addAll(activityTitle, activityTime, activityLocation);

        // Allow activityBox to expand
        HBox.setHgrow(activityBox, Priority.ALWAYS);

        // Add timeline indicator and activity details to HBox
        hBox.getChildren().addAll(timelineCanvas, activityBox);

        return hBox;
    }

    private static void drawTimeline(GraphicsContext gc, double width, double height, Color innerCircleColor) {
        double centerX = width / 2;
        double circleRadius = 8;
        double circleY = circleRadius + 5; // A bit of padding from top

        // Draw vertical line starting below the circle
        gc.setStroke(Color.LIGHTGRAY);
        gc.setLineWidth(2);
        gc.strokeLine(centerX, circleY + circleRadius, centerX, height);

        // Draw inner circle (changed color from orange to blue)
        double circleX = centerX - circleRadius;
        gc.setFill(innerCircleColor);
        gc.fillOval(circleX, circleY - circleRadius, circleRadius * 2, circleRadius * 2);

        // Draw outer ring (can keep it green or change as you like)
        gc.setStroke(Color.GREEN);
        gc.setLineWidth(3);
        gc.strokeOval(circleX, circleY - circleRadius, circleRadius * 2, circleRadius * 2);
    }

}
