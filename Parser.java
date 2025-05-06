import java.util.List;
import java.util.Stack;

public class Parser {
    public static List<String> parse(List<Lexer.Token> tokens) {
        Stack<String> tagStack = new Stack<>();
        List<String> errors = new java.util.ArrayList<>();

        for (Lexer.Token token : tokens) {
            if (token.type.equals("TAG")) {
                if (token.value.matches("</\\w+>")) {
                    String tag = token.value.replaceAll("</|>", "");
                    if (tagStack.isEmpty() || !tagStack.peek().equals(tag)) {
                        errors.add("Etiqueta de cierre inesperada: " + token.value);
                    } else {
                        tagStack.pop();
                    }
                } else if (token.value.matches("<\\w+(\\s+[^>]*)?>")) {
                    String tag = token.value.replaceAll("<|\\s.*|>", "");
                    tagStack.push(tag);

                    if (!token.value.contains("style=")) {
                        errors.add("Falta atributo 'style' en: " + token.value);
                    }
                } else {
                    errors.add("Etiqueta inválida: " + token.value);
                }
            }
        }

        while (!tagStack.isEmpty()) {
            errors.add("Falta etiqueta de cierre para: <" + tagStack.pop() + ">");
        }

        return errors;
    }
}