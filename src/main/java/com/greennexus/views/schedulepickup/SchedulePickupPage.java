package com.greennexus.views.schedulepickup;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SchedulePickupPage {

    private String userRole = "user";
    private ProgressBar progressBar;
    private ComboBox<String> roleComboBox;

    public void start(Stage primaryStage) {
        // Main layout
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: linear-gradient(to bottom right, #f8f9fa, #e9ecef);");

        // Top Navigation
        HBox topNav = createTopNav();
        root.setTop(topNav);

        // Main Content
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        VBox mainContent = new VBox(20);
        mainContent.setPadding(new Insets(20));
        mainContent.setStyle("-fx-background-color: transparent;");


        mainContent.getChildren().add(createWelcomeBanner());

        // Stats Overview
        mainContent.getChildren().add(createStatsOverview());

        // Pickup Management
        mainContent.getChildren().add(createPickupManagement());

        // Recent Activity
        mainContent.getChildren().add(createRecentActivity());

        // Recycling Companies
        mainContent.getChildren().add(createRecyclingCompanies());

        // Map and Environmental Impact
        mainContent.getChildren().add(createMapAndImpact());

        scrollPane.setContent(mainContent);
        root.setCenter(scrollPane);

        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setTitle("GreenNexus Dashboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox createTopNav() {
        HBox topNav = new HBox(10);
        topNav.setPadding(new Insets(15));
        topNav.setAlignment(Pos.CENTER_LEFT);
        topNav.setStyle("-fx-background-color: rgba(248, 249, 250, 0.8); -fx-border-color: #dee2e6; -fx-border-width: 0 0 1 0;");

        // Logo and Title
        HBox logoBox = new HBox(5);
        logoBox.setAlignment(Pos.CENTER_LEFT);
        Circle logoCircle = new Circle(15, Color.rgb(16, 185, 129));
        Label title = new Label("GreenNexus");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 18;");
        logoBox.getChildren().addAll(logoCircle, title);

        // Role Selector
        roleComboBox = new ComboBox<>();
        roleComboBox.getItems().addAll("User", "Collector", "Admin");
        roleComboBox.setValue("User");
        roleComboBox.setPrefWidth(120);
        roleComboBox.setOnAction(e -> {
            userRole = roleComboBox.getValue().toLowerCase();
            // In a real app, you would update the UI based on role
        });

        // Navigation Buttons
        Button manageBtn = new Button("Manage");
        manageBtn.getStyleClass().add("nav-button");

        Button emergencyBtn = new Button("Emergency");
        emergencyBtn.setStyle("-fx-text-fill: #dc2626; -fx-border-color: #fecaca;");
        emergencyBtn.getStyleClass().add("nav-button");

        Button pickupBtn = new Button("Schedule Pickup");
        pickupBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white;");
        pickupBtn.getStyleClass().add("nav-button");

        // User Menu
        MenuButton userMenu = new MenuButton();
        userMenu.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/user.png")))));
        userMenu.getStyleClass().add("user-menu");

        MenuItem settingsItem = new MenuItem("Settings");
        MenuItem logoutItem = new MenuItem("Logout");
        userMenu.getItems().addAll(settingsItem, logoutItem);

        // Add all to topNav
        HBox navButtons = new HBox(10);
        navButtons.setAlignment(Pos.CENTER_RIGHT);
        navButtons.getChildren().addAll(roleComboBox, manageBtn, emergencyBtn, pickupBtn, userMenu);

        topNav.getChildren().addAll(logoBox, new Region(), navButtons);
        HBox.setHgrow(navButtons, Priority.ALWAYS);

        return topNav;
    }

    private VBox createWelcomeBanner() {
        VBox banner = new VBox(10);
        banner.setPadding(new Insets(20));
        banner.setStyle("-fx-background-color: linear-gradient(to right, rgba(16, 185, 129, 0.1), rgba(16, 185, 129, 0.05), transparent); " +
                "-fx-background-radius: 10; -fx-border-radius: 10;");

        Label title = new Label("Welcome to GreenNexus");
        title.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");

        Label description = new Label("Your sustainable waste management platform. Track pickups, schedule collections, " +
                "and contribute to a cleaner environment.");
        description.setWrapText(true);
        description.setStyle("-fx-text-fill: #6b7280;");

        HBox buttons = new HBox(10);
        Button viewImpactBtn = new Button("View Impact");
        viewImpactBtn.setStyle("-fx-background-color: #10b981; -fx-text-fill: white;");

        Button learnMoreBtn = new Button("Learn More");
        learnMoreBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #d1d5db;");

        buttons.getChildren().addAll(viewImpactBtn, learnMoreBtn);

        banner.getChildren().addAll(title, description, buttons);
        return banner;
    }

    private VBox createStatsOverview() {
        VBox statsContainer = new VBox(15);

        Label sectionTitle = new Label("Waste Management Overview");
        sectionTitle.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        HBox titleBox = new HBox(5, new ImageView(new Image(getClass().getResourceAsStream("/trending.png"))), sectionTitle);
        titleBox.setAlignment(Pos.CENTER_LEFT);

        GridPane statsGrid = new GridPane();
        statsGrid.setHgap(15);
        statsGrid.setVgap(15);
        statsGrid.setAlignment(Pos.CENTER);

        // Recycling Goal Card
        VBox goalCard = createStatCard("Monthly Recycling Goal", "78%", "78kg of 100kg target");
        progressBar = new ProgressBar(0.78);
        progressBar.setStyle("-fx-accent: #10b981;");
        VBox.setMargin(progressBar, new Insets(5, 0, 0, 0));
        ((VBox) goalCard.getChildren().get(2)).getChildren().add(progressBar);
        statsGrid.add(goalCard, 0, 0);

        // Pending Pickups Card
        VBox pendingCard = createStatCard("Pending Pickups", "3", "Next pickup in 2 days");
        HBox statusBox = new HBox(5, new ImageView(new Image(getClass().getResourceAsStream("/clock.png"))),
                new Label("Next pickup in 2 days"));
        statusBox.setStyle("-fx-text-fill: #d97706;");
        ((VBox) pendingCard.getChildren().get(2)).getChildren().add(statusBox);
        statsGrid.add(pendingCard, 1, 0);

        // Completed Pickups Card
        VBox completedCard = createStatCard("Completed Pickups", "12", "All pickups completed");
        HBox completedStatus = new HBox(5, new ImageView(new Image(getClass().getResourceAsStream("/check.png"))),
                new Label("All pickups completed"));
        completedStatus.setStyle("-fx-text-fill: #059669;");
        ((VBox) completedCard.getChildren().get(2)).getChildren().add(completedStatus);
        statsGrid.add(completedCard, 2, 0);

        // Scheduled Pickups Card
        VBox scheduledCard = createStatCard("Scheduled Pickups", "5", "Next: Mar 30, 2025");
        HBox scheduledStatus = new HBox(5, new ImageView(new Image(getClass().getResourceAsStream("/calendar.png"))),
                new Label("Next: Mar 30, 2025"));
        scheduledStatus.setStyle("-fx-text-fill: #2563eb;");
        ((VBox) scheduledCard.getChildren().get(2)).getChildren().add(scheduledStatus);
        statsGrid.add(scheduledCard, 3, 0);

        statsContainer.getChildren().addAll(titleBox, statsGrid);
        return statsContainer;
    }

    private VBox createStatCard(String title, String value, String description) {
        VBox card = new VBox(8);
        card.setPadding(new Insets(15));
        card.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-border-radius: 10; " +
                "-fx-border-color: #e5e7eb; -fx-border-width: 1;");

        Label titleLabel = new Label(title);
        titleLabel.setStyle("-fx-font-size: 12; -fx-text-fill: #6b7280;");

        Label valueLabel = new Label(value);
        valueLabel.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");

        VBox bottomBox = new VBox(5);
        bottomBox.setStyle("-fx-padding: 5 0 0 0;");

        card.getChildren().addAll(titleLabel, valueLabel, bottomBox);
        return card;
    }

    private VBox createPickupManagement() {
        VBox pickupContainer = new VBox(15);

        Label sectionTitle = new Label("Pickup Management");
        sectionTitle.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        HBox titleBox = new HBox(5, new ImageView(new Image(getClass().getResourceAsStream("/calendar.png"))), sectionTitle);
        titleBox.setAlignment(Pos.CENTER_LEFT);

        // Upcoming Pickups
        GridPane upcomingGrid = new GridPane();
        upcomingGrid.setHgap(15);
        upcomingGrid.setVgap(15);
        upcomingGrid.setAlignment(Pos.CENTER);

        // Sample pickup data
        Map<String, String> pickup1 = new HashMap<>();
        pickup1.put("type", "Plastic");
        pickup1.put("location", "15 Awolowo Road, Ikoyi, Lagos");
        pickup1.put("date", "Mar 30, 2025");
        pickup1.put("status", "Pending");
        pickup1.put("statusColor", "yellow");

        Map<String, String> pickup2 = new HashMap<>();
        pickup2.put("type", "Household");
        pickup2.put("location", "42 Adeola Odeku Street, Victoria Island, Lagos");
        pickup2.put("date", "Mar 31, 2025");
        pickup2.put("status", "Scheduled");
        pickup2.put("statusColor", "blue");

        Map<String, String> pickup3 = new HashMap<>();
        pickup3.put("type", "Hazardous");
        pickup3.put("location", "7 Ahmadu Bello Way, Abuja");
        pickup3.put("date", "Apr 1, 2025");
        pickup3.put("status", "Scheduled");
        pickup3.put("statusColor", "blue");

        upcomingGrid.add(createPickupCard(pickup1), 0, 0);
        upcomingGrid.add(createPickupCard(pickup2), 1, 0);
        upcomingGrid.add(createPickupCard(pickup3), 2, 0);

        pickupContainer.getChildren().addAll(titleBox, upcomingGrid);
        return pickupContainer;
    }

    private VBox createPickupCard(Map<String, String> pickup) {
        VBox card = new VBox(10);
        card.setPadding(new Insets(15));
        card.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-border-radius: 10; " +
                "-fx-border-color: #e5e7eb; -fx-border-width: 1;");

        HBox header = new HBox(10);
        header.setAlignment(Pos.CENTER_LEFT);

        Circle typeIndicator = new Circle(5, getColorForType(pickup.get("type")));
        Label typeLabel = new Label(pickup.get("type"));
        typeLabel.setStyle("-fx-font-weight: bold;");

        Label dateLabel = new Label(pickup.get("date"));
        dateLabel.setStyle("-fx-font-size: 12; -fx-text-fill: #6b7280;");

        VBox headerLeft = new VBox(5, new HBox(5, typeIndicator, typeLabel), dateLabel);

        Label statusLabel = new Label(pickup.get("status"));
        statusLabel.setStyle("-fx-font-size: 12; -fx-padding: 3 8 3 8; -fx-background-radius: 10; " +
                "-fx-background-color: " + getStatusColor(pickup.get("statusColor")) + ";");

        header.getChildren().addAll(headerLeft, new Region(), statusLabel);
        HBox.setHgrow(header.getChildren().get(1), Priority.ALWAYS);

        HBox locationBox = new HBox(5);
        locationBox.setAlignment(Pos.CENTER_LEFT);
        locationBox.getChildren().addAll(new ImageView(new Image(getClass().getResourceAsStream("/map-pin.png"))),
                new Label(pickup.get("location")));

        Button detailsBtn = new Button("View Details");
        detailsBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #d1d5db; -fx-font-size: 12;");

        card.getChildren().addAll(header, locationBox, new Region(), detailsBtn);
        VBox.setVgrow(card.getChildren().get(2), Priority.ALWAYS);

        return card;
    }

    private VBox createRecentActivity() {
        VBox activityContainer = new VBox(15);

        Label sectionTitle = new Label("Recent Activity");
        sectionTitle.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        HBox titleBox = new HBox(5, new ImageView(new Image(getClass().getResourceAsStream("/check-circle.png"))), sectionTitle);
        titleBox.setAlignment(Pos.CENTER_LEFT);

        VBox timeline = new VBox(15);
        timeline.setPadding(new Insets(0, 0, 0, 30));
        timeline.setStyle("-fx-border-color: #e5e7eb; -fx-border-width: 0 0 0 2;");

        // Sample activity data
        Map<String, String> activity1 = new HashMap<>();
        activity1.put("type", "Paper Waste Pickup");
        activity1.put("location", "23 Broad Street, Lagos Island");
        activity1.put("date", "Mar 25, 2025 at 10:30 AM");
        activity1.put("status", "Completed");
        activity1.put("statusColor", "green");
        activity1.put("iconColor", "amber");

        Map<String, String> activity2 = new HashMap<>();
        activity2.put("type", "Glass Waste Pickup");
        activity2.put("location", "18 Bourdillon Road, Ikoyi, Lagos");
        activity2.put("date", "Mar 23, 2025 at 2:15 PM");
        activity2.put("status", "Completed");
        activity2.put("statusColor", "green");
        activity2.put("iconColor", "purple");

        timeline.getChildren().addAll(
                createTimelineItem(activity1),
                createTimelineItem(activity2)
        );

        activityContainer.getChildren().addAll(titleBox, timeline);
        return activityContainer;
    }

    private HBox createTimelineItem(Map<String, String> activity) {
        HBox item = new HBox(10);
        item.setAlignment(Pos.CENTER_LEFT);

        // Timeline dot
        StackPane dotContainer = new StackPane();
        dotContainer.setAlignment(Pos.CENTER_LEFT);
        dotContainer.setMinWidth(30);
        dotContainer.setMaxWidth(30);

        Circle outerDot = new Circle(10, Color.WHITE);
        outerDot.setStroke(Color.rgb(16, 185, 129));
        outerDot.setStrokeWidth(2);

        Circle innerDot = new Circle(5, getColorForIcon(activity.get("iconColor")));

        dotContainer.getChildren().addAll(outerDot, innerDot);

        // Activity card
        VBox card = new VBox(10);
        card.setPadding(new Insets(15));
        card.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-border-radius: 10; " +
                "-fx-border-color: #e5e7eb; -fx-border-width: 1;");

        HBox header = new HBox();
        header.setAlignment(Pos.CENTER_LEFT);

        Label typeLabel = new Label(activity.get("type"));
        typeLabel.setStyle("-fx-font-weight: bold;");

        Label dateLabel = new Label(activity.get("date"));
        dateLabel.setStyle("-fx-font-size: 12; -fx-text-fill: #6b7280;");

        Label statusLabel = new Label(activity.get("status"));
        statusLabel.setStyle("-fx-font-size: 12; -fx-padding: 3 8 3 8; -fx-background-radius: 10; " +
                "-fx-background-color: " + getStatusColor(activity.get("statusColor")) + ";");

        header.getChildren().addAll(new VBox(5, typeLabel, dateLabel), new Region(), statusLabel);
        HBox.setHgrow(header.getChildren().get(1), Priority.ALWAYS);

        HBox locationBox = new HBox(5);
        locationBox.setAlignment(Pos.CENTER_LEFT);
        locationBox.getChildren().addAll(new ImageView(new Image(getClass().getResourceAsStream("/map-pin.png"))),
                new Label(activity.get("location")));

        card.getChildren().addAll(header, locationBox);

        item.getChildren().addAll(dotContainer, card);
        return item;
    }

    private VBox createRecyclingCompanies() {
        VBox companiesContainer = new VBox(15);

        Label sectionTitle = new Label("Recycling Companies");
        sectionTitle.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        HBox titleBox = new HBox(5, new ImageView(new Image(getClass().getResourceAsStream("/recycle.png"))), sectionTitle);
        titleBox.setAlignment(Pos.CENTER_LEFT);

        Button viewAllBtn = new Button("View All Companies");
        viewAllBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #d1d5db;");

        HBox header = new HBox(titleBox, new Region(), viewAllBtn);
        HBox.setHgrow(header.getChildren().get(1), Priority.ALWAYS);

        GridPane companiesGrid = new GridPane();
        companiesGrid.setHgap(15);
        companiesGrid.setVgap(15);
        companiesGrid.setAlignment(Pos.CENTER);

        // Sample company data
        Map<String, String> company1 = new HashMap<>();
        company1.put("name", "EcoNigeria Recyclers");
        company1.put("materials", "Plastic, Paper, Glass");
        company1.put("location", "Lekki Phase 1, Lagos");
        company1.put("contact", "contact@econigeria.com");

        Map<String, String> company2 = new HashMap<>();
        company2.put("name", "Green Lagos Solutions");
        company2.put("materials", "Metal, Electronic");
        company2.put("location", "Ikeja, Lagos");
        company2.put("contact", "info@greenlagos.com");

        Map<String, String> company3 = new HashMap<>();
        company3.put("name", "Abuja Waste Management");
        company3.put("materials", "Organic, Hazardous");
        company3.put("location", "Central Business District, Abuja");
        company3.put("contact", "support@abujawaste.com");

        companiesGrid.add(createCompanyCard(company1), 0, 0);
        companiesGrid.add(createCompanyCard(company2), 1, 0);
        companiesGrid.add(createCompanyCard(company3), 2, 0);

        companiesContainer.getChildren().addAll(header, companiesGrid);
        return companiesContainer;
    }

    private VBox createCompanyCard(Map<String, String> company) {
        VBox card = new VBox(10);
        card.setPadding(new Insets(15));
        card.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-border-radius: 10; " +
                "-fx-border-color: #e5e7eb; -fx-border-width: 1;");

        Label nameLabel = new Label(company.get("name"));
        nameLabel.setStyle("-fx-font-weight: bold;");

        VBox details = new VBox(5);
        details.setStyle("-fx-padding: 10 0 10 0;");

        addDetailRow(details, "Materials:", company.get("materials"));
        addDetailRow(details, "Location:", company.get("location"));
        addDetailRow(details, "Contact:", company.get("contact"));

        Button viewDetailsBtn = new Button("View Details");
        viewDetailsBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #d1d5db; -fx-font-size: 12;");
        viewDetailsBtn.setMaxWidth(Double.MAX_VALUE);

        card.getChildren().addAll(nameLabel, details, viewDetailsBtn);
        return card;
    }

    private void addDetailRow(VBox container, String label, String value) {
        HBox row = new HBox();
        row.setAlignment(Pos.CENTER_LEFT);

        Label labelLbl = new Label(label);
        labelLbl.setStyle("-fx-font-size: 12; -fx-text-fill: #6b7280;");

        Label valueLbl = new Label(value);
        valueLbl.setStyle("-fx-font-size: 12;");

        row.getChildren().addAll(labelLbl, new Region(), valueLbl);
        HBox.setHgrow(row.getChildren().get(1), Priority.ALWAYS);

        container.getChildren().add(row);
    }

    private HBox createMapAndImpact() {
        HBox container = new HBox(15);

        // Map Section
        VBox mapSection = new VBox(10);
        mapSection.setStyle("-fx-padding: 0;");
        mapSection.setPrefWidth(600);

        Label mapTitle = new Label("Pickup Locations");
        mapTitle.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        HBox mapTitleBox = new HBox(5, new ImageView(new Image(getClass().getResourceAsStream("/map-pin.png"))), mapTitle);
        mapTitleBox.setAlignment(Pos.CENTER_LEFT);

        StackPane mapPlaceholder = new StackPane();
        mapPlaceholder.setStyle("-fx-background-color: #f3f4f6; -fx-background-radius: 10;");
        mapPlaceholder.setMinHeight(300);

        ImageView mapIcon = new ImageView(new Image(getClass().getResourceAsStream("/map.png")));
        mapIcon.setFitHeight(50);
        mapIcon.setFitWidth(50);

        Label mapText = new Label("Interactive Map View (Coming Soon)");
        mapText.setStyle("-fx-text-fill: #6b7280;");

        VBox mapContent = new VBox(10, mapIcon, mapText);
        mapContent.setAlignment(Pos.CENTER);
        mapPlaceholder.getChildren().add(mapContent);

        mapSection.getChildren().addAll(mapTitleBox, mapPlaceholder);

        // Impact Section
        VBox impactSection = new VBox(10);
        impactSection.setStyle("-fx-padding: 0;");

        Label impactTitle = new Label("Environmental Impact");
        impactTitle.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        HBox impactTitleBox = new HBox(5, new ImageView(new Image(getClass().getResourceAsStream("/recycle.png"))), impactTitle);
        impactTitleBox.setAlignment(Pos.CENTER_LEFT);

        VBox impactCard = new VBox(15);
        impactCard.setPadding(new Insets(20));
        impactCard.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-border-radius: 10; " +
                "-fx-border-color: #e5e7eb; -fx-border-width: 1;");

        // CO₂ Emissions Saved
        VBox co2Box = createImpactItem("CO₂ Emissions Saved", "245 kg", "65%", "#10b981");

        // Waste Recycled
        VBox wasteBox = createImpactItem("Waste Recycled", "1.2 tons", "78%", "#3b82f6");

        // Trees Saved
        VBox treesBox = createImpactItem("Trees Saved", "32", "45%", "#f59e0b");

        Button impactReportBtn = new Button("View Full Impact Report");
        impactReportBtn.setStyle("-fx-background-color: transparent; -fx-border-color: #d1d5db;");
        impactReportBtn.setMaxWidth(Double.MAX_VALUE);

        impactCard.getChildren().addAll(co2Box, wasteBox, treesBox, impactReportBtn);
        impactSection.getChildren().addAll(impactTitleBox, impactCard);

        container.getChildren().addAll(mapSection, impactSection);
        return container;
    }

    private VBox createImpactItem(String title, String value, String percent, String color) {
        VBox item = new VBox(5);

        Label titleLabel = new Label(title);
        titleLabel.setStyle("-fx-font-size: 12; -fx-text-fill: #6b7280;");

        Label valueLabel = new Label(value);
        valueLabel.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");

        ProgressBar progressBar = new ProgressBar(Double.parseDouble(percent.replace("%", "")) / 100);
        progressBar.setStyle("-fx-accent: " + color + "; -fx-pref-height: 8;");

        item.getChildren().addAll(titleLabel, valueLabel, progressBar);
        return item;
    }

    private Color getColorForType(String type) {
        switch (type.toLowerCase()) {
            case "plastic":
                return Color.BLUE;
            case "household":
                return Color.GREEN;
            case "hazardous":
                return Color.RED;
            case "paper":
                return Color.GREEN;
            case "glass":
                return Color.PURPLE;
            default:
                return Color.GRAY;
        }
    }

    private Color getColorForIcon(String colorName) {
        switch (colorName.toLowerCase()) {
            case "blue":
                return Color.BLUE;
            case "green":
                return Color.GREEN;
            case "red":
                return Color.RED;
            case "amber":
                return Color.ORANGE;
            case "purple":
                return Color.PURPLE;
            default:
                return Color.GRAY;
        }
    }

    private String getStatusColor(String colorName) {
        switch (colorName.toLowerCase()) {
            case "green":
                return "#d1fae5";
            case "yellow":
                return "#fef3c7";
            case "blue":
                return "#dbeafe";
            case "red":
                return "#fee2e2";
            default:
                return "#e5e7eb";
        }
    }


}