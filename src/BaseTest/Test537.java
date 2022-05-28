package BaseTest;

public class Test537 {
    public static void main(String[] args) {
        String num1 = "1+-1i";
        String[] s = num1.split("[+]");
        System.out.println(s[0]);
        System.out.println(s[1]);
        System.out.println("==============");
        String[] is = s[1].split("i");
        int i = Integer.parseInt(is[0]);
        System.out.println(i+2);

    }
}
