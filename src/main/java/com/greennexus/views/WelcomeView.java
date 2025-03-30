package com.greennexus.views;

import com.greennexus.styles.DefaultFont;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
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
       Image image = new Image("images/greenNexus.png");
       ImageView imageView = new ImageView(image);
       imageView.setFitHeight(250);
       imageView.setFitWidth(250);

       Rectangle clip = new Rectangle(250, 250);
       clip.setArcWidth(50);
       clip.setArcHeight(50);

       imageView.setClip(clip);

       final Text title = new Text("GreenNexus");
       title.setFont(Font.font(40));
       title.setFill(Color.GREEN);

       final Text subtitle = new Text("Revolutionizing Waste Management for a Greener Future");
       subtitle.setFont(Font.font(14));
       subtitle.setFill(Color.GRAY);


       Button continueBtn = getContinueBtn();


       final VBox vBox = new VBox(10, imageView, title, subtitle, continueBtn);
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
       stage.setMinWidth(700);
       stage.setMinHeight(600);
       stage.setMaximized(true);
    }


    private static Button getContinueBtn() {
        Button continueBtn = new Button("Continue");
        continueBtn.setTextFill(Color.WHITE);
        continueBtn.setPrefWidth(250);
        updateBtnBgColor(continueBtn, Color.GREEN);
        continueBtn.setPadding(new Insets(16, 48, 16, 48));
        continueBtn.setOnMouseMoved(e -> {
            updateBtnBgColor(continueBtn, Color.GRAY);
        });
        continueBtn.setOnMousePressed(e -> {
            updateBtnBgColor(continueBtn, Color.LIGHTGRAY);
        });
        continueBtn.setOnMouseReleased(e -> {
            updateBtnBgColor(continueBtn, Color.GREEN);
        });
        continueBtn.setOnMouseExited(e -> {
            updateBtnBgColor(continueBtn, Color.GREEN);
        });
        continueBtn.setOnAction(e -> {
            System.out.println("Button Clicked!");
        });

        return continueBtn;
    }

    private static void updateBtnBgColor(Button continueBtn, Color color){
        continueBtn.setBackground(new Background(new BackgroundFill(
                color, new CornerRadii(36), Insets.EMPTY
        )));
    }

    public void show(){
        build();
        stage.show();
    }

}
