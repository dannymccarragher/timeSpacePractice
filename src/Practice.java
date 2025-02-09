
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice {

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static List<Integer> findEvens(int[] array) {
        List<Integer> evens = new ArrayList<>();
        for (int num : array) {
            if (num % 2 == 0) {
                evens.add(num);
            }
        }
        return evens;
    }

    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static int sumDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // Does the 'T' look confusing? Consider refreshing on generic methods
    // We'll revisit generics as a class later
    public static <T> Map<T, Integer> countFrequencies(T[] array) {
        HashMap<T, Integer> frequencies = new HashMap<>();
        for (T val : array) {
            frequencies.put(val, frequencies.getOrDefault(val, 0) + 1);
        }
        return frequencies;
    }

    /**
     * Returns the integer that shows up most frequently in an array. If there
     * is a tie, any one of the most common can be returned arbitrarily.
     *
     * THIS METHOD MUST RUN IN O(n) TIME. n = nums.size()
     *
     * Once you finish, WRITE TESTS FOR IT in PracticeTest.java
     *
     * Time Complexity: O(n) Space Complexity: O(n)
     *
     * @param nums An array of integers
     * @return the integer that shows up most commonly
     */
    public static int mostCommonTimeEfficient(int[] nums) {
        // TODO: Complete this method with an implementation that runs
        // in O(n) time. n = nums.size()
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int mostCommon = nums[0];
        int maxCount = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommon = entry.getKey();
            }
        }

        return mostCommon;
    }

    /**
     * Returns the integer that shows up most frequently in an array. If there
     * is a tie, any one of the most common can be returned arbitrarily.
     *
     * THIS METHOD MUST USE ONLY O(1) SPACE.
     *
     * Once you finish, WRITE TESTS FOR IT in PracticeTest.java
     *
     * Time Complexity: Space Complexity:
     *
     * @param nums An array of integers
     * @return the integer that shows up most commonly
     */
    public static int mostCommonSpaceEfficient(int[] nums) {
        // TODO: Complete this method with an implementation that runs
        // in O(1) space.

        Arrays.sort(nums);

        int currentCount = 1;
        int maxCount = 1;
        int mostCommon = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                currentCount++;
            } else {
                currentCount = 1;
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostCommon = nums[i];
            }

        }
        return mostCommon;
    }

    public static void main(String[] args) {
        System.out.println(mostCommonSpaceEfficient(new int[]{1, 2, 3, 4, 5, 5,}));
    }
}
