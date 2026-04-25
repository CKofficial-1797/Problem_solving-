class Solution {

    public int[] kthRemainingInteger(int[] nums, int[][] queries) {

        int arrLen = nums.length;

        int[] evenPref = new int[arrLen + 1];
        int buildIdx = 0;

        while (buildIdx < arrLen) {
            int valNow = nums[buildIdx];

            if ((valNow & 1) == 0) {
                evenPref[buildIdx + 1] = evenPref[buildIdx] + 1;
            } else {
                evenPref[buildIdx + 1] = evenPref[buildIdx];
            }

            buildIdx++;
        }

        int queryCount = queries.length;
        int[] answers = new int[queryCount];

        int queryIdx = 0;

        while (queryIdx < queryCount) {

            int leftBound = queries[queryIdx][0];
            int rightBound = queries[queryIdx][1];
            int kthNeed = queries[queryIdx][2];

            long lowGuess = kthNeed;
            long highGuess = kthNeed + (rightBound - leftBound + 1L);

            long chosen = highGuess;

            while (lowGuess <= highGuess) {

                long midGuess = (lowGuess + highGuess) >>> 1;

                long valueCheck = midGuess * 2;

                int lastIndex = locateIndex(nums, leftBound, rightBound, valueCheck);

                int evenCount;

                if (lastIndex >= leftBound) {
                    evenCount = evenPref[lastIndex + 1] - evenPref[leftBound];
                } else {
                    evenCount = 0;
                }

                long remaining = midGuess - evenCount;

                if (remaining >= kthNeed) {
                    chosen = midGuess;
                    highGuess = midGuess - 1;
                } else {
                    lowGuess = midGuess + 1;
                }
            }

            answers[queryIdx] = (int) (chosen * 2);

            queryIdx++;
        }

        return answers;
    }

    private int locateIndex(int[] nums, int startIdx, int endIdx, long limitVal) {

        int answerPos = startIdx - 1;

        int leftPtr = startIdx;
        int rightPtr = endIdx;

        while (leftPtr <= rightPtr) {

            int midIdx = leftPtr + (rightPtr - leftPtr) / 2;

            if (nums[midIdx] <= limitVal) {
                answerPos = midIdx;
                leftPtr = midIdx + 1;
            } else {
                rightPtr = midIdx - 1;
            }
        }

        return answerPos;
    }
}