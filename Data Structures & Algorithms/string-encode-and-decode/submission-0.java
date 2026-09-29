class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); ++i) {
            sb.append(strs.get(i));
            sb.append((""+(char)257));
        }
        return sb.toString();

    }

    public List<String> decode(String str) {
        String[] strArr = str.split((""+(char)257), -1);
        return Arrays.stream(strArr, 0, strArr.length - 1).toList();
    }
}
