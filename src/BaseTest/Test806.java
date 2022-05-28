package BaseTest;

import java.util.PriorityQueue;

public class Test806 {
    public static void main(String[] args) {
        /*String s = "abcdefg";
        char[] chars = s.toCharArray();
//        for (char aChar : chars) {
//            System.out.println(aChar- 'a');
//        }
        System.out.println(Integer.MAX_VALUE);*/

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
        queue.add(3);
        queue.add(2);
        queue.add(1);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}
