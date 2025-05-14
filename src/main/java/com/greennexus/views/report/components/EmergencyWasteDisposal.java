package com.greennexus.views.report.components;

import com.greennexus.styles.FontLoader;
import com.greennexus.views.dashboard.components.DashboardTopBar;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class EmergencyWasteDisposal {
  public static VBox build() {
    VBox vbox = new VBox(0);
    vbox.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
    vbox.setBorder(new Border(new BorderStroke(Color.rgb(254, 202, 202), BorderStrokeStyle.SOLID, new CornerRadii(16), new BorderWidths(1))));  
    
    // Add your components to the VBox here
    // For example:
    Image image = new Image(DashboardTopBar.class.getResource("/images/triangle-alert.png").toExternalForm());
    ImageView alertView = new ImageView(image);
    
    
    alertView.setFitWidth(24);
    alertView.setSmooth(true);
    alertView.setPreserveRatio(true);
    alertView.setCache(true);
    
    Rectangle clip = new Rectangle(32, 32);
    alertView.setClip(clip);
    Text title = new Text("Emergency Waste Disposal");
    title.setFont(FontLoader.getFont(FontLoader.Weight.SEMIBOLD, 24));
    
    HBox header = new HBox(8, alertView, title);
    header.setPadding(new Insets(24, 16, 8, 16));
    header.setBackground(new Background(new BackgroundFill(Color.rgb(254, 242, 242), new CornerRadii(16, 16, 0, 0, false), Insets.EMPTY)));
    header.setAlignment(Pos.CENTER_LEFT);
    
    vbox.getChildren().addAll(header, form());
    
    return vbox;
  }

  private static VBox form() {
    VBox form = new VBox(20);
    form.setPadding(new Insets(20));
    // form.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
    
    // Add your components to the VBox here
    // For example:


    VBox vbox1 = new VBox(12);

    Text label1 = new Text("Emergency Type");
    label1.setFont(FontLoader.getFont(FontLoader.Weight.MEDIUM, 16));

    ComboBox<String> selectEmergency = new ComboBox<>();
    selectEmergency.getItems().addAll("Hazardous Material Spill", "Chemical Leak", "Biohazard", "Other Emergency");
    selectEmergency.setPromptText("Select emergency type");
    selectEmergency.setMaxWidth(Double.MAX_VALUE);   

    vbox1.getChildren().addAll(label1, selectEmergency);


    VBox vbox2 = new VBox(12);

    Text label2 = new Text("Location");
    label2.setFont(FontLoader.getFont(FontLoader.Weight.MEDIUM, 16));

    TextField location = new TextField();
    location.setPromptText("Enter the location of the emergency");
    location.setMaxWidth(Double.MAX_VALUE);   

    vbox2.getChildren().addAll(label2, location);


    VBox vbox3 = new VBox(12);

    Text label3 = new Text("State");
    label3.setFont(FontLoader.getFont(FontLoader.Weight.MEDIUM, 16));

    ComboBox<String> selectState = new ComboBox<>();
    selectState.getItems().addAll("Lagos", "Federal Capital Territory (Abuja)", "Rivers", "Kano", "Oyo", "Edo", "Delta", "Enugu", "Kaduna", "Kwara", "Ekiti", "Osun", "Abia", "Benue", "Borno", "Yobe", "Adamawa", "Taraba", "Nasarawa", "Kogi", "Zamfara", "Sokoto", "Katsina", "Gombe", "Bauchi", "Plateau", "Niger", "Ogun", "Ondo", "Other");
    selectState.setPromptText("Select state");
    selectState.setMaxWidth(Double.MAX_VALUE);   

    vbox3.getChildren().addAll(label3, selectState);
    
    form.getChildren().addAll(vbox1, vbox2, vbox3);
    
    return form;
  }
}
