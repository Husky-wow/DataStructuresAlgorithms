package kmp;

/**
 * 求一个短字符串在长字符串中第一次出现位置的索引
 *
 * 暴力匹配
 */
public class ViolentMatch {

    public static void main(String[] args) {
        String str1 = "qwertyuiop";
        String str2 = "a";
        int i = violentMatch(str1, str2);
        System.out.println(i);


    }

    /**
     * 求小字符串在大字符串中第一次出现位置的索引
     * @param str1  大字符串
     * @param str2  小字符串
     * @return 返回索引位置，没有找到返回-1
     */
    public static int violentMatch(String str1, String str2) {
        // 大字符串遍历位置索引
        int i = 0;
        // 小字符串遍历位置索引
        int j = 0;
        /*
        将String转换为char[]
         */
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        while (i < c1.length && j < c2.length) {
            if (c1[i] == c2[j]) {
                // 匹配相等
                i++;
                j++;
            } else {
                // 匹配不相等
                i = i - j + 1;
                j = 0;
            }
        }

        // 判断是否匹配成功：如果匹配成功，那么 j == c2.length,
        // 不是j == c2.length - 1的原因是：因为匹配成功后j++，然后再去判断while条件
        if (j == c2.length) {
            return i - j;
        } else {
            return -1;
        }

    }

}
