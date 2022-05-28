package BaseTest;

public class Test014 {
    public static void main(String[] args) {
        String[] strs = new String[] {"flow","floooo","flwww"};
        Test014 test014 = new Test014();
        String s = test014.longestCommonPrefix(strs);
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {
        String preNum = strs[0];
        for (int i = 1; i < strs.length; i++) {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (sb.length() < Math.min(preNum.length(), strs[i].length())) {
                if (preNum.charAt(j) == strs[i].charAt(j)) {
                    sb.append(preNum.charAt(j));
                    ++j;
                } else {
                    break;
                }
            }
            preNum = sb.toString();
            if (preNum.length() == 0) {
                return "";
            }
        }
        return preNum;
    }
}
