package com.greennexus.views.dashboard.components;

import com.greennexus.components.ButtonFactory;
import com.greennexus.styles.FontLoader;

import com.greennexus.views.report.ReportView;
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
import javafx.stage.Stage;

public class DashboardTopBar {
    public static HBox build(Stage stage) {

        final Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        final HBox topBar = new HBox(15, buiidLogoBox(), spacer, buildReportBtn(stage), buildScheduleBtn());
        topBar.setPadding(new Insets(16));
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        topBar.setPrefHeight(50);
        return topBar;
    }

    /// --- BUTTONS SECTION ---

    // Logo Box
    private static HBox buiidLogoBox(){
        Image image = new Image(DashboardTopBar.class.getResource("/images/logo_white.png").toExternalForm(), 100, 100, true, true);
        ImageView logoView = new ImageView(image);

        Rectangle box = new Rectangle(64, 64);
        box.setFill(Color.rgb(22, 162, 73));
        box.setArcWidth(20); // Border radius X
        box.setArcHeight(20);

        logoView.setFitWidth(32);
        logoView.setFitHeight(32);
        logoView.setSmooth(true);
        logoView.setCache(true);

        StackPane logo = new StackPane(box, logoView);
        logo.setAlignment(Pos.CENTER);

        Rectangle clip = new Rectangle(32, 32);
        logoView.setClip(clip);

        Text logoLabel = new Text("GreenNexus");
        logoLabel.setFont(FontLoader.getFont(FontLoader.Weight.BOLD, 20));

        HBox logoBox = new HBox(16, logo, logoLabel);
        logoBox.setAlignment(Pos.CENTER_LEFT);
        return logoBox;
    }

    // Report Button
    private static Button buildReportBtn(Stage stage){
        Image image = new Image(DashboardTopBar.class.getResource("/images/triangle-alert.png").toExternalForm());
        ImageView alertView = new ImageView(image);


        alertView.setFitWidth(24);
        alertView.setSmooth(true);
        alertView.setPreserveRatio(true);
        alertView.setCache(true);
        final Button reportBtn = ButtonFactory.create( "Report Emergency", alertView, Color.WHITE, Color.web("#b91c1c"), () -> {
            final ReportView reportView = new ReportView(stage);
            reportView.show();
            stage.setFullScreen(true);
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
