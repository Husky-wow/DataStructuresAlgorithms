package huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 哈夫曼树
 */
public class HuffmanTree {

    /**
     * HuffmanTree root node
     */
    public HuffmanNode root;

    /**
     * 根据数组生成HuffmanTree
     * @param oriArray
     */
    public void generateHuffmanTree(int[] oriArray) {
        /*
        首先遍历数据，将其中的每一个数转化成节点,并将这些节点加入一个List
         */
        List<HuffmanNode> nodeList = new ArrayList<>();
        for (int i = 0; i < oriArray.length; i++) {
            int value = oriArray[i];
            HuffmanNode node = new HuffmanNode(value);
            nodeList.add(node);
        }

        // 重复下述3个步骤，直至集合中只剩一个元素停止，该元素就为HuffmanTree的根节点
        while (nodeList.size() > 1) {
            // 1. 集合升序排序
            Collections.sort(nodeList);

            // 2. 取出升序排序后第一和第二个节点，并生成一个新子树
            HuffmanNode leftNode = nodeList.get(0);
            HuffmanNode rightNode = nodeList.get(1);
            HuffmanNode newNode = new HuffmanNode(leftNode.value + rightNode.value);
            newNode.leftChild = leftNode;
            newNode.rightChild = rightNode;

            // 3. 从集合中移除第一个和第二个节点，并将新节点放入集合
            nodeList.remove(leftNode);
            nodeList.remove(rightNode);
            nodeList.add(newNode);
        }

        // 最后，将根节点指向集合中的最后一个元素
        root = nodeList.get(0);
    }

    public void generateHuffmanTree(List<HuffmanNode> nodeList) {

        // 重复下述3个步骤，直至集合中只剩一个元素停止，该元素就为HuffmanTree的根节点
        while (nodeList.size() > 1) {
            // 1. 集合升序排序
            Collections.sort(nodeList);

            // 2. 取出升序排序后第一和第二个节点，并生成一个新子树
            HuffmanNode leftNode = nodeList.get(0);
            HuffmanNode rightNode = nodeList.get(1);
            HuffmanNode newNode = new HuffmanNode(leftNode.value + rightNode.value);
            newNode.leftChild = leftNode;
            newNode.rightChild = rightNode;

            // 3. 从集合中移除第一个和第二个节点，并将新节点放入集合
            nodeList.remove(leftNode);
            nodeList.remove(rightNode);
            nodeList.add(newNode);
        }

        // 最后，将根节点指向集合中的最后一个元素
        root = nodeList.get(0);
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历，从节点开始
     * @param node
     */
    private void preOrder(HuffmanNode node) {
        if (node != null) {
            System.out.println(node);
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }
}
