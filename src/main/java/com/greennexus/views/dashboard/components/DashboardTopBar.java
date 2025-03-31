package com.greennexus.views.dashboard.components;

import com.greennexus.components.ButtonFactory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class DashboardTopBar {
    public static HBox build() {

        final Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        final HBox topBar = new HBox(15, buiidLogoBox(), spacer, buildReportBtn(), buildScheduleBtn());
        topBar.setPadding(new Insets(10, 20, 10, 0));
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        topBar.setPrefHeight(50);
        return topBar;
    }

    /// --- BUTTONS SECTION ---

    // Logo Box
    private static HBox buiidLogoBox(){
        Image image = new Image("images/logo_no_bg.png", 100, 100, true, true);
        ImageView logoView = new ImageView(image);
        logoView.setFitWidth(64);
        logoView.setFitHeight(64);
        logoView.setSmooth(true);
        logoView.setCache(true);

        Rectangle clip = new Rectangle(64, 64);
        logoView.setClip(clip);

        Text logoLabel = new Text("GreenNexus");
        logoLabel.setFont(Font.font( 20));

        HBox logoBox = new HBox(0, logoView, logoLabel);
        logoBox.setAlignment(Pos.CENTER_LEFT);
        return logoBox;
    }

    // Report Button
    private static Button buildReportBtn(){
        final Button reportBtn = ButtonFactory.create("Report Emergency", Color.WHITE, Color.web("#b91c1c"), () -> {

        });
        reportBtn.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 14));
        reportBtn.setPadding( new Insets(8, 36, 8, 36));
        reportBtn.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(4),  null)));
        reportBtn.setBorder(new Border(new BorderStroke(
                Color.web("#b91c1c"),
                BorderStrokeStyle.SOLID,
                new CornerRadii(4),
                new BorderWidths(1)
        )));
        reportBtn.setPrefHeight(32);
        return reportBtn;
    }

    // Schedule Pickup Button
    private static Button buildScheduleBtn(){
        final Button scheduleBtn = ButtonFactory.create("Schedule Pickup", Color.web("2DAA5B"), Color.BLACK, () -> {

        });
        scheduleBtn.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 14));
        scheduleBtn.setTextFill(Color.WHITE);
        scheduleBtn.setBackground(new Background(new BackgroundFill(Color.web("2DAA5B"), new CornerRadii(4),  null)));
        return scheduleBtn;
    }
}
