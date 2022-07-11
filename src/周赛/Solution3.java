package 周赛;

class Solution3 {
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        String s1 = "_R";
        String s2 = "L_";
        s.canChange(s1, s2);
    }

    public boolean canChange(String str, String tar) {
        char[] s = str.toCharArray();
        char[] t = tar.toCharArray();
        int n = s.length;
        for (int i = 0, j = 0; i < n && j < n; ) {
            while (i < n - 1 && s[i] == '_') i++;
            while (j < n - 1 && t[i] == '_') j++;
            if (s[i] != t[j]) return false;
            if (s[i] == 'L' && i < j) return false;
            if (s[i] == 'R' && i > j) return false;
            i++;
            j++;
        }
        return true;
    }


}