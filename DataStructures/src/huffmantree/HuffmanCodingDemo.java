package huffmantree;

import java.util.Arrays;

/**
 * @author admin
 * @ClassName HuffmanCodingDemo.java
 * @Description TODO
 * @createTime 2020年08月06日 00:05:00
 */
public class HuffmanCodingDemo {
    public static void main(String[] args) {
        HuffmanCoding huffmanCoding = new HuffmanCoding();
        String str = "i like like like java do you like a java";
        byte[] data = str.getBytes();
        System.out.println("原始数据~~~");
        System.out.println(Arrays.toString(data));

        // 编码
        byte[] coding = huffmanCoding.huffmanCoding(data);

        // 解码
        byte[] decoding = huffmanCoding.huffmanDecoding(coding);

        // 解码后
        System.out.println("解码后");
        System.out.println(Arrays.toString(decoding));


    }
}
