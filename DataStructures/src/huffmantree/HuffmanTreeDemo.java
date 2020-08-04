package huffmantree;

public class HuffmanTreeDemo {
    public static void main(String[] args) {
        int[] array = {13, 7, 8, 3, 29, 6, 1};
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.generateHuffmanTree(array);
        huffmanTree.preOrder();
    }
}
