package huffmantree;

public class HuffmanNode implements Comparable<HuffmanNode> {

    public int value;

    public HuffmanNode leftChild;

    public HuffmanNode rightChild;

    public HuffmanNode(int value) {
        this.value = value;
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
                '}';
    }
}
