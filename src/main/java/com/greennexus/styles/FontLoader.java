package com.greennexus.styles;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.HashMap;
import java.util.Map;

public class FontLoader {
    public enum Weight {
        LIGHT("Inter-Light", 300),
        REGULAR("Inter-Regular", 400),
        MEDIUM("Inter-Medium", 500),
        SEMIBOLD("Inter-SemiBold", 600),
        BOLD("Inter-Bold", 700),
        EXTRABOLD("Inter-ExtraBold", 800);

        public final String fontName;
        public final int weightValue;

        Weight(String fontName, int weightValue) {
            this.fontName = fontName;
            this.weightValue = weightValue;
        }
    }

    private static final Map<Weight, Font> fontCache = new HashMap<>();
    private static boolean initialized = false;

    public static void initialize() {
        if (initialized) return;
        
        for (Weight weight : Weight.values()) {
            loadFont(weight, "/fonts/inter/" + weight.fontName + ".ttf");
        }
        initialized = true;
    }

    private static void loadFont(Weight weight, String path) {
        try {
            Font font = Font.loadFont(FontLoader.class.getResourceAsStream(path), 12);
            if (font != null) {
                fontCache.put(weight, font);
            }
        } catch (Exception e) {
            System.err.println("Error loading font " + path + ": " + e.getMessage());
        }
    }

    public static Font getFont(Weight weight, double size) {
        if (!initialized) initialize();
        
        // Get the specific font instance we loaded
        Font specificFont = fontCache.get(weight);
        if (specificFont != null) {
            return Font.font(specificFont.getFamily(), 
                           javafx.scene.text.FontWeight.findByWeight(weight.weightValue), 
                           size);
        }
        
        // Fallback to system font if loading failed
        return Font.font("System", 
                        javafx.scene.text.FontWeight.findByWeight(weight.weightValue), 
                        size);
    }
}