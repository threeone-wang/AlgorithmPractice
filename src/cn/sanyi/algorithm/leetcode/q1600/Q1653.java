package cn.sanyi.algorithm.leetcode.q1600;

/**
 * q1653
 * 1653. 使字符串平衡的最少删除次数
 * https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/
 * medium
 *
 * @author sanyi
 * @date 2023/03/06
 */
public class Q1653 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int minimumDeletions = solution.minimumDeletions("a");
        System.out.println(minimumDeletions);
    }

    static
    class Solution {
        public int minimumDeletions(String s) {
            int aCount = 0, bCount = 0;
            int[] bLeftCnt = new int[s.length()];
            int[] aRightCnt = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                bLeftCnt[i] = bCount;
                if (s.charAt(i) == 'b') {
                    bCount++;
                }
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                aRightCnt[i] = aCount;
                if (s.charAt(i) == 'a') {
                    aCount++;
                }
            }
            int minOperationCnt = Math.min(aCount, bCount);
            for (int i = 0; i < s.length(); i++) {
                if (bLeftCnt[i] + aRightCnt[i] < minOperationCnt) {
                    minOperationCnt = bLeftCnt[i] + aRightCnt[i];
                }
            }
            return minOperationCnt;
        }
    }

}
