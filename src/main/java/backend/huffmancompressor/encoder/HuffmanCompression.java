package backend.huffmancompressor.encoder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class HuffmanCompression {

    private HashMap<Character, String> huffmanCodes = new HashMap<>();
    private HashMap<Character, Integer> frequencyMap = new HashMap<>();
    private PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(Node::getF));

    private Node huffRoot = null;
    private final String text;

    public HuffmanCompression(String text) {
        this.text = text;
    }

    /**
     * Compresses the input file using Huffman coding.
     */
    public void compress() {
        countCharacterFrequencies();
        populatePriorityQueue();
        buildHuffmanTree();
    }

    public HashMap<Character, Integer> getFrequencyMap() {
        return frequencyMap;
    }

    public Node getHuffmanTree() {
        return huffRoot;
    }

    public HashMap<Character, String> getHuffmanCodes() {
        return huffmanCodes;
    }

    /**
     * Counts the frequencies of characters in the input text.
     *
     * @param map empty frequency map
     */
    private void countCharacterFrequencies() {
        for (int i = 0; i < this.text.length(); i++) {
            char c = text.charAt(i);
            if (this.frequencyMap.containsKey(c)) {
                int freq = this.frequencyMap.get(c);
                this.frequencyMap.put(c, freq + 1);
            } else {
                this.frequencyMap.put(c, 1);
            }
        }
    }


    /**
     * Builds the Huffman tree from character frequencies.
     *
     * @param minHeap priority queue containing the characters
     */
    private void buildHuffmanTree() {
        while (this.minHeap.size() >= 2) {
            Node left = this.minHeap.poll();
            Node right = this.minHeap.poll();
            assert right != null;
            Node node = new Node(Character.MIN_VALUE, left.getF() + right.getF(), left, right);
            this.minHeap.add(node);
        }
        Node root = this.minHeap.poll();
        this.huffRoot = root;
        generateHuffmanCodes(root, new StringBuilder());
    }

    /**
     * Generates Huffman codes for characters in the Huffman tree.
     *
     * @param node root node of the huffman tree
     * @param code huffman code corresponding to a character
     */
    private void generateHuffmanCodes(Node node, StringBuilder code) {
        if (node == null) {
            return;
        }
        if (node.getC() != Character.MIN_VALUE) {
            huffmanCodes.put(node.getC(), code.toString());
        } else {
            generateHuffmanCodes(node.getLeft(), code.append('1'));
            code.deleteCharAt(code.length() - 1);
            generateHuffmanCodes(node.getRight(), code.append('0'));
            code.deleteCharAt(code.length() - 1);
        }
    }


    /**
     * Counts the total number of bits needed to represent the compressed file.
     *
     * @param map frequency map
     * @return total length of the bits
     */
    private char[] countTotalBits() {
        int bitCount = 0;
        for (Map.Entry<Character, Integer> e : this.frequencyMap.entrySet()) {
            bitCount = bitCount + huffmanCodes.get(e.getKey()).length() * e.getValue();
        }
        String binaryString = String.format("%32s", Integer.toBinaryString(bitCount)).replace(' ', '0');
        return binaryString.toCharArray();
    }

    /**
     * Populates the priority queue with nodes from the character frequencies map.
     *
     * @param map     frequency map
     * @param minHeap priority queue to be populated
     */
    private void populatePriorityQueue() {
        frequencyMap.forEach((key, value) -> this.minHeap.add(new Node(key, value)));
    }

}
