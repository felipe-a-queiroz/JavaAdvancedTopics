package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {

    }

    public static List<Integer> skipStream(List<Integer> numbers) {
        return numbers.stream()
                .skip(2)
                .collect(Collectors.toList());
    }

    public static List<Integer> limitStream(List<Integer> numbers) {
        return numbers.stream()
                .limit(3)
                .collect(Collectors.toList());
    }

    public static List<String> sortedStream(List<String> names) {
        return names.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Integer> distinctStream(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Integer> flatMapStream(List<List<Integer>> numbers) {
        return numbers.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public static List<Integer> mapStream(List<String> names) {
        return names.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

    public static List<Integer> filterStream(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

}
