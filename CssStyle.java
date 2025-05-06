import javax.swing.*;
import java.awt.*;

public class CssStyle {
    public Color color = Color.BLACK;
    public int fontSize = 12;

    public static CssStyle from(String style) {
        CssStyle css = new CssStyle();
        String[] rules = style.split(";");
        for (String rule : rules) {
            String[] parts = rule.split(":");
            if (parts.length != 2) continue;
            String key = parts[0].trim();
            String value = parts[1].trim();

            if (key.equals("color")) {
                switch (value) {
                    case "blue": css.color = Color.BLUE; break;
                    case "green": css.color = Color.GREEN; break;
                    case "red": css.color = Color.RED; break;
                }
            } else if (key.equals("font-size")) {
                try {
                    css.fontSize = Integer.parseInt(value.replace("px", ""));
                } catch (NumberFormatException e) {
                    css.fontSize = 12;
                }
            }
        }
        return css;
    }

    public void applyTo(JLabel label) {
        label.setForeground(color);
        label.setFont(new Font("Arial", Font.PLAIN, fontSize));
    }
}