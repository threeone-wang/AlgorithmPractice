package cn.sanyi.algorithm.leetcode.q1400;

import java.util.HashMap;
import java.util.Map;

/**
 * q1487
 * 1487. 保证文件名唯一
 * https://leetcode.cn/problems/making-file-names-unique/
 * medium
 *
 * @author sanyi
 * @date 2023/03/03
 */
public class Q1487 {

    class Solution {
        public String[] getFolderNames(String[] names) {
            String[] ansNames = new String[names.length];
            Map<String, Integer> existsNameCnt = new HashMap<String, Integer>();
            for (int i = 0; i < names.length; i++) {
                if (!existsNameCnt.containsKey(names[i])) {
                    existsNameCnt.put(names[i], 1);
                    ansNames[i] = names[i];
                    continue;
                }
                for (int j = existsNameCnt.get(names[i]); j <= names.length; j++) {
                    String name = names[i] + "(" + j + ")";
                    if (!existsNameCnt.containsKey(name)) {
                        existsNameCnt.put(names[i], j + 1);
                        existsNameCnt.put(name, 1);
                        ansNames[i] = name;
                        break;
                    }
                }
            }
            return ansNames;
        }
    }

}
