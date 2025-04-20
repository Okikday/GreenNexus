package com.greennexus.views.auth;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

public class Login extends Application {

    @Override
    public void start(Stage stage) {
        ImageView logo = new ImageView(getClass().getResource("/images/logo_no_bg_cropped.png").toExternalForm());
        logo.setFitWidth(80);
        logo.setPreserveRatio(true);

        Label title = new Label("GreenNexus");
        title.setFont(Font.font("System", FontWeight.BOLD, 22));

        Label subtitle = new Label("Login to your account to manage waste collection");
        subtitle.setFont(Font.font("System", FontWeight.NORMAL, 14));

        VBox headerBox = new VBox(8, logo, title, subtitle);
        headerBox.setAlignment(Pos.CENTER);

        // === Email ===
        Label emailLabel = new Label("Email");
        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");

        // === Password ===
        Label passwordLabel = new Label("Password");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");

        // === Role Dropdown ===
        Label roleLabel = new Label("Login As");
        ComboBox<String> roleComboBox = new ComboBox<>();
        roleComboBox.getItems().addAll("User", "Waste Collector", "Administrator");
        roleComboBox.setPromptText("Select your role");

        // === Input Style ===
        String inputStyle = "-fx-background-color: #f8f9fa; -fx-border-color: #ced4da; -fx-border-radius: 4; -fx-background-radius: 4;";
        emailField.setStyle(inputStyle);
        passwordField.setStyle(inputStyle);
        roleComboBox.setStyle(inputStyle);

        // === Login Button ===
        Button loginButton = new Button("Login");
        loginButton.setMaxWidth(Double.MAX_VALUE);
        loginButton.setOnAction(e -> {
            String role = roleComboBox.getValue();
            if (role != null) {
                System.out.println("Logging in as: " + role);
            } else {
                System.out.println("Please select a role");
            }
        });
        loginButton.setStyle("-fx-background-color: #28a745; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 4;");

        // === Links ===
        Hyperlink forgotPassword = new Hyperlink("Forgot password?");
        forgotPassword.setStyle("-fx-text-fill: #28a745; -fx-font-size: 12;");

        Hyperlink register = new Hyperlink("Register");
        register.setStyle("-fx-text-fill: #28a745; -fx-font-size: 12;");

        VBox form = new VBox(10,
                emailLabel, emailField,
                passwordLabel, passwordField,
                roleLabel, roleComboBox,
                loginButton
        );
        form.setPadding(new Insets(10, 0, 0, 0));

        HBox registerBox = new HBox(new Label("Don't have an account? "), register);
        registerBox.setAlignment(Pos.CENTER);

        VBox footer = new VBox(6,
                forgotPassword,
                registerBox
        );
        footer.setAlignment(Pos.CENTER);

        VBox card = new VBox(20, headerBox, form, footer);
        card.setPadding(new Insets(20));
        card.setStyle("-fx-background-color: white; -fx-border-color: #ccc; -fx-border-radius: 10px; -fx-background-radius: 10px;");
        card.setAlignment(Pos.CENTER);
        card.setMaxWidth(400);

        StackPane root = new StackPane(card);
        root.setStyle("-fx-background-color: #f4f4f4;");
        Scene scene = new Scene(root, 500, 600);

        stage.setTitle("GreenNexus Login");
        stage.setScene(scene);
        stage.show();
    }
}