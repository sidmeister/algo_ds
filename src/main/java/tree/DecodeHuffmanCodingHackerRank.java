package tree;


/**
 * Created by Siddharth on 8/27/2016.
 */

class HuffmanNode {

    public int freq;
    public char data;
    public HuffmanNode leftChild; //leftchild
    public HuffmanNode rightChild; //rightChild
}

public class DecodeHuffmanCodingHackerRank {

    HuffmanNode root; //Tree class only nends to know about the root

    public DecodeHuffmanCodingHackerRank() {
        this.root = null;
    }

    public DecodeHuffmanCodingHackerRank(HuffmanNode root) {
        this.root = root;
    }

    public void decode_huff(HuffmanNode root, String s)
    {
        HuffmanNode temp = root;
        for (int i=0; i <s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch){
                case '0':
                    root = root.leftChild;
                    if (root.leftChild == null && root.rightChild == null) {
                        System.out.print(root.data);
                        root = temp;
                    }
                    break;
                case '1':
                    root = root.rightChild;
                    if (root.leftChild == null && root.rightChild == null) {
                        System.out.print(root.data);
                        root = temp;
                    }
                    break;
            }

        }
    }


    public static void main(String[] args) {
        HuffmanNode n1 = new HuffmanNode();
        n1.freq = 5;
        n1.data = '*';
        DecodeHuffmanCodingHackerRank huffmanTree = new DecodeHuffmanCodingHackerRank(n1);
        HuffmanNode n2 = new HuffmanNode();
        n2.freq = 2;
        n2.data = '*';
        n1.leftChild = n2;
        HuffmanNode n3 = new HuffmanNode();
        n3.freq = 3;
        n3.data = 'A';
        n1.rightChild = n3;
        HuffmanNode n4 = new HuffmanNode();
        n4.freq = 1;
        n4.data = 'B';
        n2.leftChild = n4;
        HuffmanNode n5 = new HuffmanNode();
        n5.freq = 3;
        n5.data = 'C';
        n2.rightChild = n5;
        String input = "1001011";
        huffmanTree.decode_huff(n1, input);


    }


}
