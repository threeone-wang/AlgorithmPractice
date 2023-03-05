package cn.sanyi.algorithm.leetcode.q1500;

/**
 * q1599
 * 1599. 经营摩天轮的最大利润
 * https://leetcode.cn/problems/maximum-profit-of-operating-a-centennial-wheel/
 * medium
 *
 * @author sanyi
 * @date 2023/03/05
 */
public class Q1599 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int minOperationsMaxProfit = solution.minOperationsMaxProfit(new int[]{2, 16, 22, 15, 46, 10, 23, 0, 13, 23, 33, 14, 21, 19, 47, 6, 13, 28, 37, 18, 7, 44, 25, 11, 35, 10, 12, 37, 27, 16, 18, 48, 41, 23, 22, 14, 50, 39, 14, 15, 26, 9, 6, 13, 24, 18, 36, 50, 16, 33, 13, 27, 11, 37, 25, 18, 21, 39, 41, 1, 47, 44, 39, 8, 40, 40, 8, 0, 5, 25, 44, 24, 0, 27, 15, 1}, 88, 6);
        System.out.println(minOperationsMaxProfit);
    }

    static
    class Solution {
        public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
            int profit = 0, customerCount = 0, operationCnt = 0;
            int maxProfit = Integer.MIN_VALUE, minOperations = Integer.MAX_VALUE;
            do {
                operationCnt++;
                if (operationCnt <= customers.length) {
                    customerCount += customers[operationCnt - 1];
                }
                if (customerCount > 4) {
                    customerCount -= 4;
                    profit += 4 * boardingCost - runningCost;
                } else {
                    profit += customerCount * boardingCost - runningCost;
                    customerCount = 0;
                }
                if (profit > maxProfit) {
                    maxProfit = profit;
                    minOperations = operationCnt;
                }
            } while (customerCount > 0 || operationCnt <= customers.length);
            if (maxProfit <= 0) {
                return -1;
            }
            return minOperations;
        }
    }

}
