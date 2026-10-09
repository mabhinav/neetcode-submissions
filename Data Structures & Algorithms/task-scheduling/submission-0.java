class Solution {
    public int leastInterval(char[] tasks, int n) {
        // A,A,A,B,C n=3
        // A _ _ _ A _ _ _ A
        // A B C _ A _ _ _ A
        // 9
        // Math.max(5, ((3 - 1) * (3 + 1)) + 1) = Math.max(5, 9)

        // X,X,Y,Y n=2
        // X _ _ X
        // X Y _ X Y
        // 5
        // Math.max(4, ((2 - 1) * (2 + 1) + 2)) = Math.max(4, 5)

        // A,A,A,B,B,B,C,C,C,D,D n=2
        // A _ _ A _ _ A
        // B _ _ B _ _ B
        // C _ _ C _ _ C
        // D _ _ D
        // A B C A B C D A B C D
        // 11
        // Math.max(11, ((3 - 1) * (2 + 1)) + 3) = Math.max(11, 9)

        // leastInterval = Math.max(tasks.length, ((maxFreq - 1) * (n + 1) + maxCount))

        int maxFreq = 0;
        int maxFreqCount = 0;

        int[] count = new int[26];

        for (char task : tasks) {
            count[task - 'A']++;
            maxFreq = Math.max(maxFreq, count[task - 'A']);
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] == maxFreq) {
                ++maxFreqCount;
            }
        }

        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + maxFreqCount);
    }
}
