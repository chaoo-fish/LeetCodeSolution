package leetcode.editor.cn;

/**
 * 通用模板
 */

public class Soultion {
    /**
     * 需要创建UnionFind类
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(isConnected);
        // 两个for
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i,j);
                }
            }
        }

        return n - uf.unionCount; // 返回合并的集合个数
    }

    // UnionFind 类
    class UnionFind {
        private int[] captical;
        int unionCount = 0; // 统计合并次数

        // 初始化方法
        public UnionFind(int[][] isConnected) {
            this.captical = new int[isConnected.length];
            for (int i = 0; i < captical.length; i++) {
                captical[i] = i;
            }
        }

        // union 方法
        public void union(int x, int y) {
            if (find(x) != find(y)) {
                captical[find(y)] = captical[x];
                unionCount++;
            }
        }

        // 查找根节点
        public int find(int x) {
            if (captical[x] == x) return x; // 只有根节点满足 captical[x] = x
            return find(captical[x]);
        }
    }

}

// UnionFind类,只写我们当前知道的.

