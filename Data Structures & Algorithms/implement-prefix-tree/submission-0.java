class PrefixTree {

    private static class TrieNode {
        TrieNode[] childrens = new TrieNode[26];
        boolean isWord;
    }

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();         
    }

    public void insert(String word) {
        TrieNode cur = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (cur.childrens[idx] == null) {
                cur.childrens[idx] = new TrieNode();
            }

            cur = cur.childrens[idx];
        }

        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    private TrieNode findNode(String str) {
        TrieNode cur = root;

        for (char ch : str.toCharArray()) {
            int idx = ch - 'a';
            if (cur.childrens[idx] == null) {
                return null;
            }
            cur = cur.childrens[idx];
        }

        return cur;
    }
}
