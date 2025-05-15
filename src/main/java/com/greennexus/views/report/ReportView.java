
package com.greennexus.views.report;

import com.greennexus.components.BackToDashboard;
import com.greennexus.styles.DefaultFont;
import com.greennexus.views.dashboard.components.*;
import com.greennexus.views.report.components.EmergencyResponseInformation;
import com.greennexus.views.report.components.EmergencyWasteDisposal;

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

public class ReportView {
    private final Stage stage;

    public ReportView(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        BorderPane root = new BorderPane();
        root.setBackground(Background.EMPTY);
        root.setTop(BackToDashboard.build(stage));
        root.setCenter(buildCenterContent());
        root.getStyleClass().add("root");

        final Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Report Emergency");
        // DefaultFont.initDefaultFont(root, 14);

        Image resizedImage = new Image(getClass().getResourceAsStream("/images/logo_no_bg_cropped.png"), 64, 64, true, true);

        stage.getIcons().add(resizedImage);
        scene.getStylesheets().add(
            getClass().getResource("/com/greennexus/styles/report.css").toExternalForm()
        );
        stage.show();
        stage.setMaximized(true);
        root.setPrefSize(scene.getWidth(), scene.getHeight());
    }


    private ScrollPane buildCenterContent() {
      VBox centerLayout = new VBox(20);
      centerLayout.setPadding(new Insets(16, 20, 16, 20));
      centerLayout.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
      centerLayout.getChildren().addAll(
              EmergencyWasteDisposal.build(),
              EmergencyResponseInformation.build()
              // DashboardHeroSection.build(),
              // DashboardOverviewSection.build(),
              // DashboardPickupManagement.build(),
              // DashboardRecentActivity.build(),
              // DashboardRecyclingCompanies.build(),
              // DashboardImpactSection.build()
      );

      // ScrollPane scrollPane = new ScrollPane(centerLayout);
      // scrollPane.setFitToWidth(true);
      // scrollPane.setPadding(new Insets(10));
      // scrollPane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
    
      ScrollPane scrollPane = new ScrollPane(centerLayout);
        scrollPane.setFitToWidth(true);  // Makes content fill width
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

      return scrollPane;
  }


//     private ScrollPane buildCenterContent() {
//         VBox centerLayout = new VBox(20);
//         centerLayout.setPadding(new Insets(20));
//         centerLayout.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
//         centerLayout.getChildren().addAll(
//                 EmergencyWasteDisposal.build()
//                 // DashboardHeroSection.build(),
//                 // DashboardOverviewSection.build(),
//                 // DashboardPickupManagement.build(),
//                 // DashboardRecentActivity.build(),
//                 // DashboardRecyclingCompanies.build(),
//                 // DashboardImpactSection.build()
//         );
//
//         ScrollPane scrollPane = new ScrollPane(centerLayout);
//         scrollPane.setFitToWidth(true);
//         scrollPane.setPadding(new Insets(10));
//         scrollPane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
//
//         return scrollPane;
//     }



}
