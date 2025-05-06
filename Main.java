import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Intérprete HTML");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setMinimumSize(new Dimension(800, 400));
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);

        String html = "<html><body>"
                    + "<h1 style=\"color:blue;font-size:24px\">Hola Mundo</h1"
                    + "<p style=\"color:green;font-size:16px\">Esto es un párrafo</p>"
                    + "</body></html>";

        // Panel principal con el editor
        JEditorPane editorPane = new JEditorPane();
        editorPane.setText("Cargando...");
        editorPane.setContentType("text/html");
        editorPane.setText(html);
        editorPane.setEditable(true);

        // Panel para tokens
        JTextArea tokensArea = new JTextArea();
        tokensArea.setEditable(false);
        tokensArea.setBackground(Color.LIGHT_GRAY);
        tokensArea.setFont(new java.awt.Font("Monospaced", 0, 12));
        tokensArea.setLineWrap(true);
        tokensArea.setWrapStyleWord(true);
        // Panel para errores
        JTextArea errorsArea = new JTextArea();
        errorsArea.setEditable(false);
        errorsArea.setBackground(Color.PINK);
        errorsArea.setFont(new java.awt.Font("Monospaced", 0, 12));
        errorsArea.setLineWrap(true);
        errorsArea.setWrapStyleWord(true);
        // Dividir horizontalmente tokens y errores
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
            new JScrollPane(tokensArea),
            new JScrollPane(errorsArea));
        splitPane.setDividerLocation(500);
        splitPane.setResizeWeight(0.5);
        // Panel para dividir el editor y los paneles de tokens/errores
        JSplitPane mainSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
            new JScrollPane(editorPane),
            splitPane);
        mainSplitPane.setDividerLocation(400);
        mainSplitPane.setResizeWeight(0.6);

        // Agregar componentes a la ventana
        frame.getContentPane().add(mainSplitPane, BorderLayout.CENTER);

        // Analizar el HTML y mostrar tokens y errores
        List<Lexer.Token> tokens = Lexer.tokenize(html);
        List<String> errors = Parser.parse(tokens);

        // Mostrar tokens
        tokensArea.setText("Tokens analizados:\n");
        for (Lexer.Token token : tokens) {
            tokensArea.append(String.format("%s: %s\n", token.type, token.value));
        }

        // Mostrar errores
        errorsArea.setText("Errores encontrados:\n");
        if (errors.isEmpty()) {
            errorsArea.append("No se encontraron errores.\n");
        } else {
            for (String error : errors) {
                errorsArea.append(error + "\n");
            }
        }
        frame.setVisible(true);
    }
}