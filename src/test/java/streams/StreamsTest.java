package streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StreamsTest {

    @Test
    public void testSkipStream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> skippedNumbers = Streams.skipStream(numbers);

        Assert.assertEquals(3, skippedNumbers.size());
        Assert.assertEquals(Integer.valueOf(3), skippedNumbers.get(0));
        Assert.assertEquals(Integer.valueOf(4), skippedNumbers.get(1));
        Assert.assertEquals(Integer.valueOf(5), skippedNumbers.get(2));
    }

    @Test
    public void testLimitStream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> limitedNumbers = Streams.limitStream(numbers);

        Assert.assertEquals(3, limitedNumbers.size());
        Assert.assertEquals(Integer.valueOf(1), limitedNumbers.get(0));
        Assert.assertEquals(Integer.valueOf(2), limitedNumbers.get(1));
        Assert.assertEquals(Integer.valueOf(3), limitedNumbers.get(2));
    }

    @Test
    public void testSortedStream() {
        List<String> names = Arrays.asList("John", "Jane", "Bob");
        List<String> sortedNames = Streams.sortedStream(names);

        Assert.assertEquals(3, sortedNames.size());
        Assert.assertEquals("Bob", sortedNames.get(0));
        Assert.assertEquals("Jane", sortedNames.get(1));
        Assert.assertEquals("John", sortedNames.get(2));
    }

    @Test
    public void testDistinctStream() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3);
        List<Integer> distinctNumbers = Streams.distinctStream(numbers);

        Assert.assertEquals(3, distinctNumbers.size());
        Assert.assertEquals(Integer.valueOf(1), distinctNumbers.get(0));
        Assert.assertEquals(Integer.valueOf(2), distinctNumbers.get(1));
        Assert.assertEquals(Integer.valueOf(3), distinctNumbers.get(2));
    }

    @Test
    public void testFlatMapStream() {
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
        List<Integer> flattenedNumbers = Streams.flatMapStream(numbers);

        Assert.assertEquals(9, flattenedNumbers.size());
        Assert.assertEquals(Integer.valueOf(1), flattenedNumbers.get(0));
        Assert.assertEquals(Integer.valueOf(2), flattenedNumbers.get(1));
        Assert.assertEquals(Integer.valueOf(3), flattenedNumbers.get(2));
        Assert.assertEquals(Integer.valueOf(4), flattenedNumbers.get(3));
        Assert.assertEquals(Integer.valueOf(5), flattenedNumbers.get(4));
        Assert.assertEquals(Integer.valueOf(6), flattenedNumbers.get(5));
        Assert.assertEquals(Integer.valueOf(7), flattenedNumbers.get(6));
        Assert.assertEquals(Integer.valueOf(8), flattenedNumbers.get(7));
        Assert.assertEquals(Integer.valueOf(9), flattenedNumbers.get(8));
    }

    @Test
    public void testMapStream() {
        List<String> names = Arrays.asList("John", "Jane", "Bob");
        List<Integer> nameLengths = Streams.mapStream(names);

        Assert.assertEquals(3, nameLengths.size());
        Assert.assertEquals(Integer.valueOf(4), nameLengths.get(0));
        Assert.assertEquals(Integer.valueOf(4), nameLengths.get(1));
        Assert.assertEquals(Integer.valueOf(3), nameLengths.get(2));
    }

    @Test
    public void testFilterStream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evenNumbers = Streams.filterStream(numbers);

        Assert.assertEquals(2, evenNumbers.size());
        Assert.assertEquals(Integer.valueOf(2), evenNumbers.get(0));
        Assert.assertEquals(Integer.valueOf(4), evenNumbers.get(1));
    }
}
