package com.greennexus.views.dashboard.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DashboardOverviewSection {

    public static VBox build() {
        // Title Label
        Label overviewTitle = new Label("📈 Waste Management Overview");
        overviewTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        overviewTitle.setTextFill(Color.web("#222"));



        // Cards Layout (Spacing Only, No Fixed Width)
        HBox cards = new HBox(15,
                buildCard("Monthly Recycling Goal", "78%", getDetailWithProgress()),
                buildCard("Pending Pickups", "3",  getDefaultDetailLabel("🕒 Next pickup in 2 days")),
                buildCard("Completed Pickups", "12", getDefaultDetailLabel("✅ All pickups completed")),
                buildCard("Scheduled Pickups", "5",  getDefaultDetailLabel("📅 Next: Mar 30, 2025"))
        );
        cards.setAlignment(Pos.CENTER_LEFT);
        for (Node card : cards.getChildren()) {
            HBox.setHgrow(card, Priority.ALWAYS);
        }


        // Overview Container
        VBox overviewBox = new VBox(10, overviewTitle, cards);
        overviewBox.setPadding(new Insets(20, 0, 0, 0));
        return overviewBox;
    }

    private static Node getDefaultDetailLabel(String detail){

        final Label detailLabel = new Label(detail);
        detailLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.NORMAL, 14));
        detailLabel.setTextFill(Color.web("#222"));
        final Rectangle spacing = new Rectangle(0, 12);
        return new VBox(0, spacing, detailLabel);
    }

    private static Node getDetailWithProgress() {
        final Label detailLabel = new Label("78kg of 100kg target");
        detailLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.NORMAL, 14));
        detailLabel.setTextFill(Color.web("#222"));
        final Rectangle spacing = new Rectangle(0, 12);
        ProgressBar progressBar = new ProgressBar(0.78);
        progressBar.setPrefWidth(300);
        progressBar.setBackground(new Background(new BackgroundFill(Color.web("2DAA5B"), new CornerRadii(48), null)));

        return new VBox(12, progressBar, detailLabel);
    }

    private static VBox buildCard(String title, String count, Node detailLabel) {
        // Title Label
        Label titleLabel = new Label(title);
        titleLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 14));
        titleLabel.setTextFill(Color.web("#7f8e9f"));

        Label countLabel = new Label(count);
        countLabel.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 28));
        countLabel.setTextFill(Color.web("#000000"));

        // Card Box (No Fixed Width)
        VBox box = new VBox(5, titleLabel, countLabel, detailLabel);
        box.setAlignment(Pos.TOP_LEFT);
        box.setPadding(new Insets(15));
        box.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));

        // Border with Rounded Corners
        box.setBorder(new Border(new BorderStroke(
                Color.web("#e2e8f0"),
                BorderStrokeStyle.SOLID,
                new CornerRadii(16),
                new BorderWidths(1)
        )));
        // Soft Shadow for Floating Effect
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(6);
        dropShadow.setOffsetY(3);
        dropShadow.setColor(Color.rgb(0, 0, 0, 0.1));
        box.setEffect(dropShadow);

        return box;
    }
}
