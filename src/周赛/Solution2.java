package 周赛;

import java.util.*;

class Solution2 {
    public static void main(String[] args) {

    }

    public PriorityQueue<Integer> pq;

    public Solution2() {
        pq = new PriorityQueue<>();
        for (int i = 1; i < 10001; i++) {
            pq.add(i);
        }
    }

    public void addBack(int num) {
        if (!pq.contains(num))
            pq.add(num);
    }
}