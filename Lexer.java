import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class Lexer {
    public static class Token {
        public String type;
        public String value;
        public Token(String type, String value) {
            this.type = type;
            this.value = value;
        }
    }

    public static List<Token> tokenize(String input) {
        List<Token> tokens = new ArrayList<>();
        Pattern pattern = Pattern.compile("(<[^>]+>|[^<]+)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String part = matcher.group();
            if (part.startsWith("<")) {
                tokens.add(new Token("TAG", part));
            } else {
                tokens.add(new Token("TEXT", part.trim()));
            }
        }

        return tokens;
    }
}