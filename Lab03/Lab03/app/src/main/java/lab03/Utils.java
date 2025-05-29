package lab03;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    // funcao criada por IA
    public static List<String> parseCommaSeparatedWords(String input) {
        List<String> words = new ArrayList<>();
        if (input != null && !input.trim().isEmpty()) {
            String[] parts = input.split(",");
            for (String part : parts) {
                words.add(part.trim());
            }
        }
        return words;
    }
}