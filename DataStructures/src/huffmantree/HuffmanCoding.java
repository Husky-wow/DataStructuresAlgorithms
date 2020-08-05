package huffmantree;

import java.util.*;

/**
 * @author admin
 * @ClassName HuffmanCoding.java
 * @Description Huffman 编码
 * @createTime 2020年08月05日 23:51:00
 */
public class HuffmanCoding {

    /**
     * Huffman 编码表
     */
    private Map<Character, String> huffmanCodeTable = new HashMap<>();

    /**
     * 统计字符串中每个字符出现的个数
     * @param str
     * @return
     */
    private Map<Character, Integer> countChar(String str) {
        Map<Character, Integer> resultMap = new HashMap<>();
        // 遍历str中的每一个字符，并统计字符出现的个数
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (resultMap.containsKey(c)) {
                int count = resultMap.get(c);
                count++;
                resultMap.put(c, count);
            } else {
                resultMap.put(c, 1);
            }
        }

        return resultMap;
    }

    /**
     * 将统计结果转换为Huffman节点
     * @param charMap
     * @return
     */
    private List<HuffmanNode> covertHuffmanNode(Map<Character, Integer> charMap) {
        List<HuffmanNode> resultList = new ArrayList<>();

        Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            char code = entry.getKey();
            int value = entry.getValue();
            HuffmanNode node = new HuffmanNode(value, code);
            resultList.add(node);
        }

        return resultList;
    }

    /**
     * 生成Huffman 编码表
     * @param nodeList
     */
    private void getHuffmanCodeTable(List<HuffmanNode> nodeList) {
        // 根据nodeList生成HuffmanTree
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.generateHuffmanTree(nodeList);
        getHuffmanCodeTable(huffmanTree.root, "", new StringBuilder());
    }

    /**
     * 生成叶子节点的Huffman编码表
     * @param node 需要编码的节点
     * @param code 该节点应该添加的码值 0 or 1
     * @param parentCode 该节点的父节点的编码值
     */
    private void getHuffmanCodeTable(HuffmanNode node, String code, StringBuilder parentCode) {
        if (node != null) {
            // 新建StringBuilder存储该节点的编码
            StringBuilder nodeCode = new StringBuilder(parentCode);
            // 该节点编码为 父节点编码 + 该节点的码值
            nodeCode.append(code);
            // 如果是叶子节点，就得到该node的编码
            if (node.code != null) {
                huffmanCodeTable.put(node.code, nodeCode.toString());
            } else {
                // 向左递归编码
                getHuffmanCodeTable(node.leftChild, "0", nodeCode);
                // 向右递归编码
                getHuffmanCodeTable(node.rightChild, "1", nodeCode);
            }
        }
    }

    /**
     * 生成Huffman 编码
     * @param str
     * @return
     */
    public byte[] huffmanCoding(String str) {
        // 1. 统计字符串中字符出现个数
        Map<Character, Integer> countMap = countChar(str);
        // 2. 根据统计结果生成Huffman节点
        List<HuffmanNode> nodeList = covertHuffmanNode(countMap);
        // 3. 生成Huffman编码表
        getHuffmanCodeTable(nodeList);

        StringBuilder codeStringBuilder = new StringBuilder();
        // 4. 根据Huffman编码表将字符串转换成Huffman编码
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            codeStringBuilder.append(huffmanCodeTable.get(c));
        }

        // 5. 将编码字符串转换为字节数组

        // 字节数组长度(8位为一个字节)
        int len = (codeStringBuilder.length() + 7) / 8;
        byte[] huffmanCodeBytes = new byte[len];
        int byteIndex = 0;
        for (int i = 0; i < codeStringBuilder.length(); i = i + 8) {
            byte byteCode;
            if (i + 8 > codeStringBuilder.length()) {
                // 防止越界
                byteCode = (byte) Integer.parseInt(codeStringBuilder.substring(i), 2);
            } else {
                byteCode = (byte) Integer.parseInt(codeStringBuilder.substring(i, i + 8), 2);
            }

            huffmanCodeBytes[byteIndex++] = byteCode;
        }

        System.out.println(Arrays.toString(huffmanCodeBytes));
        return huffmanCodeBytes;
    }


}
