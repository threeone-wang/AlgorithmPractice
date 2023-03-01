package cn.sanyi.algorithm.leetcode.q2000;

/**
 * q2023
 * 2373. 矩阵中的局部最大值
 * https://leetcode.cn/problems/largest-local-values-in-a-matrix/
 * easy
 *
 * @author sanyi
 * @date 2023/03/01
 */
public class Q2023 {

    class Solution {
        public int[][] largestLocal(int[][] grid) {
            int n = grid.length;
            int[][] maxLocal = new int[n - 2][n - 2];
            for (int i = 0; i < n - 2; i++) {
                for (int j = 0; j < n - 2; j++) {
                    maxLocal[i][j] = maxNineCell(i, j, grid);
                }
            }
            return maxLocal;
        }

        public int maxNineCell(int i, int j, int[][] grid) {
            int max = Integer.MIN_VALUE;
            for (int k = i; k <= i + 2; k++) {
                for (int l = j; l <= j + 2; l++) {
                    if (grid[k][l] > max) {
                        max = grid[k][l];
                    }
                }
            }
            return max;
        }
    }

}
