package com.greennexus.views.recyclingcompanies;

import com.greennexus.components.BackToDashboard;
import com.greennexus.views.dashboard.components.DashboardRecyclingCompanies;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RecyclingCoordinationView {

    public static void show(Stage stage) {
        // Create root container with padding and spacing
        HBox root = new HBox(30);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #f9fafb;");

        // Left: available recycling companies
        VBox companiesSection = new DashboardRecyclingCompanies(stage).build(false);
        companiesSection.setPrefWidth(600);

        // Right: materials request form
        VBox formSection = buildRequestForm();
        formSection.setPrefWidth(400);

        root.getChildren().addAll(companiesSection, formSection);
        BorderPane borderPane = new BorderPane(root);
        borderPane.setTop(BackToDashboard.build(stage));
        borderPane.getStyleClass().add("root");

        Scene scene = new Scene(borderPane);

        stage.setScene(scene);
        stage.setTitle("Recycling Coordination");
        stage.show();
    }

    private static VBox buildRequestForm() {
        VBox form = new VBox(15);
        form.setPadding(new Insets(20));
        form.setStyle("-fx-background-color: white; -fx-border-color: #e5e7eb; -fx-border-radius: 6; -fx-background-radius: 6;");

        Label header = new Label("Send Materials Request");
        header.setFont(javafx.scene.text.Font.font(javafx.scene.text.Font.getDefault().getName(), javafx.scene.text.FontWeight.BOLD, 18));

        // Company selector
        ComboBox<String> companyCombo = new ComboBox<>();
        companyCombo.getItems().addAll(
                "EcoNigeria Recyclers",
                "Green Lagos Solutions",
                "Abuja Waste Management"
        );
        companyCombo.setPromptText("Select company");
        companyCombo.setMaxWidth(Double.MAX_VALUE);

        // Material type
        ComboBox<String> materialCombo = new ComboBox<>();
        materialCombo.getItems().addAll(
                "Plastic",
                "Paper",
                "Glass",
                "Metal",
                "Electronic",
                "Organic",
                "Hazardous"
        );
        materialCombo.setPromptText("Select material type");
        materialCombo.setMaxWidth(Double.MAX_VALUE);

        // Quantity
        TextField quantityField = new TextField();
        quantityField.setPromptText("Enter quantity");
        quantityField.setMaxWidth(Double.MAX_VALUE);

        // Pickup date
        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Pickup Date");
        datePicker.setMaxWidth(Double.MAX_VALUE);

        // Notes
        TextArea notesArea = new TextArea();
        notesArea.setPromptText("Any special instructions or details about your materials");
        notesArea.setPrefRowCount(4);
        notesArea.setWrapText(true);
        notesArea.setMaxWidth(Double.MAX_VALUE);

        // Submit button
        Button submitBtn = new Button("Submit Request");
        submitBtn.setPrefWidth(Double.MAX_VALUE);
        submitBtn.setTextFill(Color.WHITE);
        submitBtn.setStyle("-fx-background-color: #22c55e; -fx-background-radius: 6;");
        submitBtn.setOnAction(e -> {
            // TODO: handle form submission
            System.out.println("Request submitted:");
            System.out.println("Company: " + companyCombo.getValue());
            System.out.println("Material: " + materialCombo.getValue());
            System.out.println("Quantity: " + quantityField.getText());
            System.out.println("Pickup Date: " + datePicker.getValue());
            System.out.println("Notes: " + notesArea.getText());
        });

        // Layout form fields with labels
        form.getChildren().addAll(
                header,
                new Label("Recycling Company"), companyCombo,
                new Label("Material Type"), materialCombo,
                new Label("Quantity (kg)"), quantityField,
                new Label("Pickup Date"), datePicker,
                new Label("Additional Notes"), notesArea,
                submitBtn
        );

        VBox.setVgrow(notesArea, Priority.ALWAYS);
        return form;
    }
}
