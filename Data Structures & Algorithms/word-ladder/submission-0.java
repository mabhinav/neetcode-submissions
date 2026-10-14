class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        int level = 1;

        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevel = new HashSet<>();

            for(String word : beginSet) {
                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String newWord = new String(chars);

                        if (endSet.contains(newWord)) {
                            return level + 1;
                        }

                        if (dict.remove(newWord)) {
                            nextLevel.add(newWord);
                        }
                    }
                    chars[i] = original;
                }

            }
            beginSet = nextLevel;
            level++;
        }

        return 0;
    }
}
