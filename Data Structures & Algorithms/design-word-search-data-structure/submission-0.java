class WordDictionary {

    private static class TrieNode {
        TrieNode[] childrens = new TrieNode[26];
        boolean isWord;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;

        for (char ch : word.toCharArray()) {
            int idx = ch -'a';
            if (cur.childrens[idx] == null) {
                cur.childrens[idx] = new TrieNode();
            }

            cur = cur.childrens[idx];
        }

        cur.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int pos, TrieNode node) {
        if (node == null) {
            return false;
        }

        if (pos == word.length()) {
            return node.isWord;
        }

        char ch = word.charAt(pos);

        if (ch == '.') {
            for (TrieNode child : node.childrens) {
                if (child != null && dfs(word, pos + 1, child)) {
                    return true;
                }
            }
            return false;
        }
        return dfs(word, pos + 1, node.childrens[ch - 'a']);
    }
}
