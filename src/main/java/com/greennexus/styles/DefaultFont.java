package com.greennexus.styles;

import javafx.scene.text.Font;
import javafx.scene.Parent;
import javafx.scene.control.Labeled;

public class DefaultFont {
    private static final String FONT_NAME = "ProductSansRegular.ttf";
    private static Font cachedFont;

    private static Font loadFont(double size) {
        if (cachedFont == null || cachedFont.getSize() != size) {
            cachedFont = Font.loadFont(
                    DefaultFont.class.getResourceAsStream("/fonts/" + FONT_NAME), size
            );
            if (cachedFont == null)
                System.err.println("Unable to load/find font => " + FONT_NAME);
        }
        return cachedFont;
    }

    public static void initDefaultFont(Parent root, double size) {
        Font customFont = loadFont(size);
        if (customFont != null)
            root.setStyle("-fx-font-family: '" + customFont.getName() + "';");
    }

    public static Font getDefaultFont(double size) {
        return loadFont(size);
    }
}
