package puzzler.interview;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.google.common.collect.ImmutableList.of;
import static org.testng.Assert.assertEquals;

/**
 * @author Sergey Kuptsov
 * @since 10/10/2016
 * <p>
 * Find subsequence which sum is maximum in sequence like
 * [1, 2, 0, -1, 10, 20, 20, -5, 1, 3]
 */
public class MaxSubSequence {

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {of(1, 2, 0, -1, 10, 20, 20, -5, 1, 3), 52},
                {of(1, 2, -1, 2), 4},
                {of(1, 1, 1, -1, 2, 1, 2), 1 + 1 + 1 - 1 + 2 + 1 + 2},
                {of(-1, 0, 3, 4, 0), 3 + 4},
                {of(100, 200, -1000, 1, 2), 100 + 200},
        };
    }

    @Test(dataProvider = "testData")
    public void test(List<Integer> sequence, int sum) {
        assertEquals(getMaxSubsequenceSum(sequence), sum);
    }

    private int getMaxSubsequenceSum(List<Integer> sequence) {
        int maxSum = 0;
        int currSum = 0;

        for (Integer next : sequence) {
            currSum = Math.max(0, currSum + next);
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }
}
