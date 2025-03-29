package com.greennexus.views;

import com.greennexus.styles.DefaultFont;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public class WelcomeView {
    private final Stage stage;
    public WelcomeView(Stage _stage){
        stage = _stage;
    }

   private void build(){
       final Text title = new Text("GreenNexus");
       title.setFont(Font.font(40));
       title.setFill(Color.GREEN);

       final Text subtitle = new Text("Revolutionizing Waste Management for a Greener Future");
       subtitle.setFont(Font.font(14));
       subtitle.setFill(Color.GRAY);


       Button continueBtn = getContinueBtn();

       final VBox vBox = new VBox(10, title, subtitle, continueBtn);
       vBox.setAlignment(Pos.CENTER);
       vBox.setSpacing(24);

       StackPane root = new StackPane(vBox);

       Paint paint = new Color(
               0.1, 0.1, 0.1, 1
       );

       root.setBackground(new Background(new BackgroundFill(paint, null, null)));
       DefaultFont.initDefaultFont(root, 14);

       final Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.setTitle("Welcome to GreenNexus");
       stage.setMaximized(true);
    }


    private static Button getContinueBtn() {
        Button continueBtn = new Button("Continue");
        continueBtn.setTextFill(Color.WHITE);
        continueBtn.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
        continueBtn.setPadding(new Insets(8, 24, 8, 24));
        continueBtn.setOnMouseMoved(e -> {
            continueBtn.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        });
        continueBtn.setOnMousePressed(e -> {
            continueBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
        });
        continueBtn.setOnMouseReleased(e -> {
            continueBtn.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
        });
        continueBtn.setOnMouseExited(e -> {
            continueBtn.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
        });
        continueBtn.setOnAction(e -> {
            System.out.println("Button Clicked!");
        });
        return continueBtn;
    }

    public void show(){
        build();
        stage.show();
    }

}
