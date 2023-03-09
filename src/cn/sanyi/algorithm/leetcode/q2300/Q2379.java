package cn.sanyi.algorithm.leetcode.q2300;

/**
 * q2379
 * 2379. 得到 K 个黑块的最少涂色次数
 * https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
 * easy
 *
 * @author sanyi
 * @date 2023/03/09
 */
public class Q2379 {

    class Solution {
        public int minimumRecolors(String blocks, int k) {
            int bCnt = 0, wCnt = 0;
            for (int i = 0; i < k; i++) {
                if (blocks.charAt(i) == 'B') {
                    bCnt++;
                } else if (blocks.charAt(i) == 'W') {
                    wCnt++;
                }
            }
            int currentMinOperations = k - bCnt, minOperations = k - bCnt;
            for (int i = k; i < blocks.length(); i++) {
                if (blocks.charAt(i) == 'B' && blocks.charAt(i - k) == 'W') {
                    currentMinOperations--;
                    minOperations = Math.min(minOperations, currentMinOperations);
                } else if (blocks.charAt(i) == 'W' && blocks.charAt(i - k) == 'B') {
                    currentMinOperations++;
                }
            }
            return minOperations;
        }
    }

}
