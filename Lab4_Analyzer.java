import java.util.*;
import java.util.stream.Collectors;

public class Lab4 {

    public static class Analyzer {
        private final List<String> reservedWords;
        private final List<String> words;

        public Analyzer(String input, List<String> reservedWords) {
            this.reservedWords = reservedWords.stream().map(String::toLowerCase).collect(Collectors.toList());
            // Clean and tokenize input
            this.words = Arrays.stream(input.toLowerCase().replaceAll("[.,;:'\"-]", "").split(" "))
                    .collect(Collectors.toList());
        }

        public List<String> getUniqueWordsInOrder() {
            return words.stream().distinct().collect(Collectors.toList());
        }

        public List<String> getUniqueWordsAlphabetically() {
            return words.stream().distinct().sorted().collect(Collectors.toList());
        }

        public List<String> getUniqueWordsBySize() {
            return words.stream()
                    .distinct()
                    .sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
                    .collect(Collectors.toList());
        }

        public List<String> getUniqueWordsByFrequency() {
            Map<String, Long> frequencyMap = words.stream()
                    .collect(Collectors.groupingBy(word -> word, LinkedHashMap::new, Collectors.counting()));
            return frequencyMap.entrySet().stream()
                    .sorted((entry1, entry2) -> {
                        int freqCompare = entry1.getValue().compareTo(entry2.getValue());
                        if (freqCompare != 0) {
                            return freqCompare;
                        } else {
                            return Integer.compare(words.indexOf(entry1.getKey()), words.indexOf(entry2.getKey()));
                        }
                    })
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }

        public Map<Character, Long> getWordCountByStartingLetter() {
            return words.stream()
                    .collect(Collectors.groupingBy(word -> word.charAt(0), TreeMap::new, Collectors.counting()));
        }

        public List<String> getReservedWordsInOrder() {
            return words.stream()
                    .filter(reservedWords::contains)
                    .distinct()
                    .collect(Collectors.toList());
        }

        public List<String> getReservedWordsByFrequency() {
            Map<String, Long> frequencyMap = words.stream()
                    .filter(reservedWords::contains)
                    .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
            return frequencyMap.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        // Sample input and reserved words
        List<String> reservedWords = Arrays.asList("groups", "collections", "elements");
        String inputText = "A collection — sometimes called a container — is simply an object that groups multiple elements into a single unit. A collections framework helps manipulate collections, creating sets of elements etc.";

        Analyzer analyzer = new Analyzer(inputText, reservedWords);

        System.out.println("1a: " + analyzer.getUniqueWordsInOrder());
        System.out.println("1b: " + analyzer.getUniqueWordsAlphabetically());
        System.out.println("1c: " + analyzer.getUniqueWordsBySize());
        System.out.println("1d: " + analyzer.getUniqueWordsByFrequency());
        System.out.println("2a: " + analyzer.getWordCountByStartingLetter());
        System.out.println("3a: " + analyzer.getReservedWordsInOrder());
        System.out.println("3b: " + analyzer.getReservedWordsByFrequency());
    }
}
