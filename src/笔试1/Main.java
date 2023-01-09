package 笔试1;


/**
 * @Author chaoo
 * @Date: 2022/09/27/ 19:00
 */
public class Main {
    public static void main(String[] args) {
        String s = "hello world";

        int index = s.indexOf("el");
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0,index));
        sb.append(s.substring(index+2));
        System.out.println(sb.toString());
    }
}