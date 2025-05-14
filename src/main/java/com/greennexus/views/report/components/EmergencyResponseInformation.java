package com.greennexus.views.report.components;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextFlow;

public class EmergencyResponseInformation {
    public static VBox build() {
    VBox vbox = new VBox(10);
    vbox.setPadding(new Insets(20));
    vbox.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
    vbox.setBorder(new Border(new BorderStroke(Color.rgb(150, 150, 150), BorderStrokeStyle.SOLID, new CornerRadii(16), new BorderWidths(1))));  
    
    Label infoTitle = new Label("Emergency Response Information");
    infoTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

    Label responseTime = new Label("Response Time: ");
    responseTime.setStyle("-fx-font-weight: bold;");
    Label responseTimeText = new Label("Emergency waste disposal teams typically respond within 30–60 minutes of alert submission in urban areas of Lagos and Abuja. Other locations may take 1–2 hours.");
    TextFlow responseTimeFlow = new TextFlow(responseTime, responseTimeText);

    Label whatToDo = new Label("What to Do: ");
    whatToDo.setStyle("-fx-font-weight: bold;");
    Label whatToDoText = new Label("Secure the area if safe to do so. Keep people away from the hazardous material. Do not attempt to clean up hazardous materials without proper equipment.");
    TextFlow whatToDoFlow = new TextFlow(whatToDo, whatToDoText);

    Label contact = new Label("Contact: ");
    contact.setStyle("-fx-font-weight: bold;");
    Label contactText = new Label("For immediate assistance, call our emergency hotline at ");
    Label hotline1 = new Label("0800-GREEN-HELP");
    hotline1.setStyle("-fx-font-weight: bold;");
    Label hotline2 = new Label(" or ");
    Label hotline3 = new Label("0800-473-3643");
    hotline3.setStyle("-fx-font-weight: bold;");
    TextFlow contactFlow = new TextFlow(contact, contactText, hotline1, hotline2, hotline3);
    
    
    vbox.getChildren().addAll(infoTitle, responseTimeFlow, whatToDoFlow, contactFlow);
    
    return vbox;
  }

}
