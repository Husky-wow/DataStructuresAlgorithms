package huffmantree;

public class HuffmanNode implements Comparable<HuffmanNode> {

    public int value;

    /**
     * 用于记录Huffman编码的符号
     */
    public Character code;

    public HuffmanNode leftChild;

    public HuffmanNode rightChild;

    public HuffmanNode(int value) {
        this.value = value;
    }

    public HuffmanNode(int value, char code) {
        this.value = value;
        this.code = code;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        // 升序排列
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "value=" + value +
                ", code=" + code +
                '}';
    }
}
