package kmp;

/**
 * KMP 算法
 *  在写的过程中，不加入注释，如果有看不懂，就去B站看 正月点灯笼 的KMP算法视频
 */
public class KMP {

    public static void main(String[] args) {
        KMP kmp = new KMP();

        String text = "BBC ABCDAB ABCDABCDABDE";
        String pattern = "ABCDABD";

        int i = kmp.kmpSearch(text, pattern);
        System.out.println(i);


    }

    /**
     * kmp算法匹配小字符串在大字符串中第一次出现的置位
     * @param text 大字符串
     * @param pattern 小字符串
     * @return
     */
    public int kmpSearch(String text, String pattern) {
        // 1. 获取前缀表（部分匹配表）
        int[] prefixTable = getPrefixTable(pattern);
        // 2. 根据前缀表获取next表
        int[] next = getNext(prefixTable);

        // text 字符串的循环索引
        int i = 0;
        // pattern 字符串的循环索引
        int j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
                if (j == -1) {
                    // pattern第一个字符都无法匹配
                    i++;
                    j++;
                }
            }
            // j == pattern.length() 说明已经配置至pattern末尾，说明已经找到了
            if (j == pattern.length()) {
                return i - j;
            }
        }

        return -1;
    }

    /**
     * 获取模式字符串的前缀表（部分匹配表）
     * @param pattern
     * @return
     */
    public int[] getPrefixTable(String pattern) {
        // 为方便匹配，将字符串转为字符数组
        char[] p = pattern.toCharArray();

        int[] prefixTable = new int[pattern.length()];
        // 部分匹配表第一个值为0
        prefixTable[0] = 0;
        // 遍历pattern中的每个字符索引,因为已经知道第一个字符其最大前后缀为0，所以从1开始
        int i = 1;
        // 索引为i的字符，其前边的所有字符组成的子串的最大相同前缀后缀字符串长度
        int len = 0;

        while (i < pattern.length()) {
            if (p[i] == p[len]) {
                len++;
                prefixTable[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = prefixTable[len - 1];
                } else {
                    prefixTable[i] = 0;
                    i++;
                }
            }
        }

        return prefixTable;
    }

    /**
     * 根据前缀表（部分匹配表）得到next表
     * @param prefixTable
     * @return
     */
    public int[] getNext(int[] prefixTable) {
        int[] next = new int[prefixTable.length];

        for (int i = prefixTable.length - 1; i > 0 ; i--) {
            next[i] = prefixTable[i - 1];
        }
        next[0] = -1;

        return next;
    }


}
