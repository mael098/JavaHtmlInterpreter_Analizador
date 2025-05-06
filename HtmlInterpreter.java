import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.regex.*;

public class HtmlInterpreter {
    public static JPanel parseHtml(String html) {
        List<Lexer.Token> tokens = Lexer.tokenize(html);
        List<String> errors = Parser.parse(tokens);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setOpaque(true);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panel.setPreferredSize(new Dimension(500, 300)); // Tamaño mínimo

        if (!errors.isEmpty()) {
            for (String error : errors) {
                JLabel label = new JLabel("❌ Error: " + error);
                label.setForeground(Color.RED);
                panel.add(label);
            }
            return panel;
        }

        Pattern pattern = Pattern.compile("<(h1|p)\s*style=\"([^\"]*)\">(.*?)</\1>");
        Matcher matcher = pattern.matcher(html);

        while (matcher.find()) {
            String tag = matcher.group(1);
            String style = matcher.group(2);
            String content = matcher.group(3);

            CssStyle css = CssStyle.from(style);
            JLabel label = new JLabel(content);
            label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Espaciado interno
            css.applyTo(label);

            if (tag.equals("h1")) {
                label.setFont(new Font("Arial", Font.BOLD, 24));
            }

            panel.add(label);
        }

        return panel;
    }
}