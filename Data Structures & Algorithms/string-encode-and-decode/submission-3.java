class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int delimiterPos = str.indexOf("#", i);
            int length = Integer.parseInt(str.substring(i, delimiterPos));

            // move i past delimiter
            i = delimiterPos + 1;
            res.add(str.substring(i, i + length));
            i = i + length;
        }

        return res;
    }
}
