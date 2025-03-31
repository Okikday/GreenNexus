package com.greennexus.components;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ButtonFactory {
    // Full version (All parameters)
    public static Button create(
            String text,
            Node graphic,
            Color backgroundColor,
            Color textColor,
            Double width,
            Runnable onClick
    ) {
        Button button = new Button(text != null ? text : "Button");

        // Set font to bold
        button.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, 14));

        // Set text fill color
        button.setTextFill(textColor != null ? textColor : Color.BLACK);

        // Set optional graphic (like an icon)
        if (graphic != null) {
            button.setGraphic(graphic);
        }

        // Set button width (or default)
        if (width != null) {
            button.setPrefWidth(width);
        }

        // Set background color (default to white)
        button.setBackground(new Background(new BackgroundFill(
                backgroundColor != null ? backgroundColor : Color.WHITE,
                new CornerRadii(8),
                null
        )));

        // Add padding
        button.setPadding(new Insets(8, 36, 8, 36));

        // Click event
        if (onClick != null) {
            button.setOnAction(e -> onClick.run());
        }

        // Natural button press effect (no shrinking)
        button.setOnMousePressed(e -> {
            button.setScaleX(0.98);
            button.setScaleY(0.98);
        });

        button.setOnMouseReleased(e -> {
            button.setScaleX(1);
            button.setScaleY(1);
        });

        return button;
    }

    // Version without width
    public static Button create(
            String text,
            Node graphic,
            Color backgroundColor,
            Color textColor,
            Runnable onClick
    ) {
        return create(text, graphic, backgroundColor, textColor, null, onClick);
    }

    // Version without Node (graphic)
    public static Button create(
            String text,
            Color backgroundColor,
            Color textColor,
            Double width,
            Runnable onClick
    ) {
        return create(text, null, backgroundColor, textColor, width, onClick);
    }

    // Version without Node & width
    public static Button create(
            String text,
            Color backgroundColor,
            Color textColor,
            Runnable onClick
    ) {
        return create(text, null, backgroundColor, textColor, null, onClick);
    }

    // Version with only text and click event
    public static Button create(
            String text,
            Runnable onClick
    ) {
        return create(text, null, Color.WHITE, Color.BLACK, null, onClick);
    }
}
