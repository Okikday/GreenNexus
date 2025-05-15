package com.greennexus.views.dashboard.components;

import com.greennexus.components.ButtonFactory;
import com.greennexus.styles.DefaultFont;
import com.greennexus.views.recyclingcompanies.RecyclingCoordinationView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DashboardRecyclingCompanies {
    final Stage stage;
    public DashboardRecyclingCompanies(Stage stage){
        this.stage = stage;
    }
    public VBox build(boolean isHBox) {
        VBox root = new VBox(20);
        root.setPadding(new Insets(12));
        root.setAlignment(Pos.TOP_LEFT);

        Label title = new Label("Recycling Companies");
        title.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 20));


        Button viewAllBtn = ButtonFactory.create("View All Companies →", () -> {
            RecyclingCoordinationView.show(this.stage);
            stage.setFullScreen(true);
        });
        viewAllBtn.setFont(Font.font(Font.getDefault().getName(), FontWeight.NORMAL, 13));
        viewAllBtn.setTextFill(Color.web("#0f172a"));
        viewAllBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #d1d5db; -fx-border-radius: 6;");
        viewAllBtn.setPadding(new Insets(8, 12, 8, 12));

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox header = new HBox(5, title, spacer, viewAllBtn);
        if(isHBox){
            HBox companiesContainer = new HBox(20);
            companiesContainer.getChildren().addAll(
                    buildCompanyCard(
                            "EcoNigeria Recyclers",
                            "Plastic, Paper, Glass",
                            "Lekki Phase 1, Lagos",
                            "contact@econigeria.com"
                    ),
                    buildCompanyCard(
                            "Green Lagos Solutions",
                            "Metal, Electronic",
                            "Ikeja, Lagos",
                            "info@greenlagos.com"
                    ),
                    buildCompanyCard(
                            "Abuja Waste Management",
                            "Organic, Hazardous",
                            "Central Business District, Abuja",
                            "support@abujawaste.com"
                    )
            );

            for (Node card : companiesContainer.getChildren()) {
                HBox.setHgrow(card, Priority.ALWAYS);
            }
            root.getChildren().addAll(header, companiesContainer);
        }else{
            VBox companiesContainer = new VBox(20);
            companiesContainer.getChildren().addAll(
                    buildCompanyCard(
                            "EcoNigeria Recyclers",
                            "Plastic, Paper, Glass",
                            "Lekki Phase 1, Lagos",
                            "contact@econigeria.com"
                    ),
                    buildCompanyCard(
                            "Green Lagos Solutions",
                            "Metal, Electronic",
                            "Ikeja, Lagos",
                            "info@greenlagos.com"
                    ),
                    buildCompanyCard(
                            "Abuja Waste Management",
                            "Organic, Hazardous",
                            "Central Business District, Abuja",
                            "support@abujawaste.com"
                    )
            );

            for (Node card : companiesContainer.getChildren()) {
                VBox.setVgrow(card, Priority.ALWAYS);
            }
            root.getChildren().addAll(header, companiesContainer);
        }
        return root;


    }

    private static VBox buildCompanyCard(String name, String materials, String location, String contact) {
        VBox card = new VBox(10);
        card.setPadding(new Insets(15));
        card.setPrefWidth(250);
        card.setStyle("-fx-background-color: white; -fx-border-color: #e5e7eb; -fx-border-radius: 6; -fx-background-radius: 6;");

        Label companyName = new Label(name);
        companyName.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 16));

        HBox materialsLabel = createField("Materials:", materials);
        HBox locationLabel = createField("Location:", location);
        HBox contactLabel = createField("Contact:", contact);

        Button viewDetailsBtn = ButtonFactory.create("→ View Details", () -> {});
        viewDetailsBtn.setFont(Font.font(Font.getDefault().getName(), FontWeight.NORMAL, 14));
        viewDetailsBtn.setTextFill(Color.web("#0f172a"));
        viewDetailsBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #d1d5db; -fx-border-radius: 6;");
        viewDetailsBtn.setPrefWidth(Double.MAX_VALUE);

        card.getChildren().addAll(companyName, materialsLabel, locationLabel, contactLabel, viewDetailsBtn);
        return card;
    }

    private static HBox createField(String label, String value) {
        Label title = new Label(label);
        Label subtitle = new Label(value);
        title.setFont(Font.font(Font.getDefault().getName(), 13));
        title.setTextFill(Color.GRAY);
        return new HBox(title, subtitle);
    }
}
