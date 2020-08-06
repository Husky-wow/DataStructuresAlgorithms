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
    private Map<Byte, String> huffmanCodeTable = new HashMap<>();

    /**
     * 统计字符串中每个字符出现的个数
     * @param oriData
     * @return
     */
    private Map<Byte, Integer> countChar(byte[] oriData) {
        Map<Byte, Integer> resultMap = new HashMap<>();
        // 遍历str中的每一个字符，并统计字符出现的个数
        for (int i = 0; i < oriData.length; i++) {
            byte c = oriData[i];
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
     * @param byteMap
     * @return
     */
    private List<HuffmanNode> covertHuffmanNode(Map<Byte, Integer> byteMap) {
        List<HuffmanNode> resultList = new ArrayList<>();

        Set<Map.Entry<Byte, Integer>> entrySet = byteMap.entrySet();
        Iterator<Map.Entry<Byte, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Byte, Integer> entry = iterator.next();
            byte code = entry.getKey();
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
     * 重载方法，根据byte[]生成
     * @param oriData
     * @return
     */
    public byte[] huffmanCoding(byte[] oriData) {
        // 1. 统计字符串中字符出现个数
        Map<Byte, Integer> countMap = countChar(oriData);
        // 2. 根据统计结果生成Huffman节点
        List<HuffmanNode> nodeList = covertHuffmanNode(countMap);
        // 3. 生成Huffman编码表
        getHuffmanCodeTable(nodeList);

        StringBuilder codeStringBuilder = new StringBuilder();
        // 4. 根据Huffman编码表将字符串转换成Huffman编码
        for (int i = 0; i < oriData.length; i++) {
            byte c = oriData[i];
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
                // 注：这里使用Integer.parseInt生成int 然后强转byte是为了使8位二进制为带符号二进制
                // 虽然Byte.parseByte底层使用Integer.parseInt，但是Integer.parseInt转化时是不带符号的，Byte.parseByte内部有一个判断，因此会有错误
                byteCode = (byte) Integer.parseInt(codeStringBuilder.substring(i, i + 8), 2);
            }

            huffmanCodeBytes[byteIndex++] = byteCode;
        }

        System.out.println(Arrays.toString(huffmanCodeBytes));
        return huffmanCodeBytes;
    }


}
