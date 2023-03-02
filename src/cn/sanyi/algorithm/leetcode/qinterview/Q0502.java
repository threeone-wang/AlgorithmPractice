package cn.sanyi.algorithm.leetcode.qinterview;

/**
 * q0502
 * 面试题 05.02. 二进制数转字符串
 * https://leetcode.cn/problems/bianry-number-to-string-lcci/
 * medium
 * @author sanyi
 * @date 2023/03/02
 */
public class Q0502 {

    class Solution {
        public String printBin(double num) {
            StringBuilder result = new StringBuilder("0.");
            for (int i = 0; i < 30; i++) {
                num = num * 2;
                if (num > 1) {
                    result.append("1");
                    num -= 1;
                } else if (num == 1) {
                    result.append("1");
                    break;
                } else if (num < 1) {
                    result.append("0");
                }
            }
            if (num != 1) {
                return "ERROR";
            }
            return result.toString();
        }
    }

}
