package BaseTest;

import java.util.*;

/**
 * 通用模板
 */
class Solution {
    public static void main(String[] args) {
        System.out.println("hello");
    }

    public int findCircleNum(int[][] isConnected) {
        /**
         * DFS
         */
        // 顶点数量
        int n =  isConnected.length;
        // 判断一个顶点是否访问
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                cnt++;
                // 遍历与i相邻的顶点
                dfs(i,isConnected,visited);
            }        
        }
        return cnt;
    }

    private void dfs(int i ,int[][] isConnected, boolean[] visited) {
        // 对节点进行标记--访问过了
        visited[i] = true;
        

        for (int j = 0; j < isConnected.length; j++) {
            if(isConnected[i][j] == 1 && !visited[j] ) {
                // 继续遍历与i相邻的顶点
                dfs(j, isConnected, visited);
            }
        }

    }
}