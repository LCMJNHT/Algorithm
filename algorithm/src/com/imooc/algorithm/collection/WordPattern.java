package com.imooc.algorithm.collection;

import java.util.HashMap;

/**
 * @Author: Louis
 * @Date: Create in 2019/10/11 23:02
 * @Description:
 */
public class WordPattern {
    /**
     * 290 Word Pattern
     * https://leetcode.com/problems/word-pattern/
     * 思路：Hash Map
     * 时间复杂度：O(nlogm)
     * 空间复杂度：O(n+m)
     */
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> record = new HashMap<Character, String>();
        char[] patterns = pattern.toCharArray();
        String[] strs = str.split(" ");

        if(patterns.length != strs.length) {
            return false;
        }

        for(int i=0; i<patterns.length; i++) {
            char c = patterns[i];
            if(record.containsKey(c)) {
                String value = record.get(c);
                if(!value.equals(strs[i])) {
                    return false;
                }
            }
            else {
                // 存在该value，但key不一样
                if(record.containsValue(strs[i])) {
                    return false;
                }
                record.put(c, strs[i]);
            }
        }
        return true;
    }
    /** main */
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat dog";
        // ==> true
        System.out.println((new WordPattern()).wordPattern(pattern, str));
    }
}