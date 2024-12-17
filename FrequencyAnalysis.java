import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequencyAnalysis {
    public void analyzeText() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = scanner.nextLine().toLowerCase();

        // Filter English alphabet characters
        text = text.replaceAll("[^a-z]", "");
        System.out.println("Filtered text: " + text);

        // Count frequency of each letter
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        System.out.println("Frequency map: " + frequencyMap);

        // Calculate percentage
        int totalLetters = text.length();
        Map<Character, Double> percentageMap = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            percentageMap.put(entry.getKey(), (entry.getValue() * 100.0) / totalLetters);
        }

        // Output results
        System.out.println("Frequency dictionary:");
        for (Map.Entry<Character, Double> entry : percentageMap.entrySet()) {
            System.out.printf("%c: %.2f%%\n", entry.getKey(), entry.getValue());
        }
    }
}
