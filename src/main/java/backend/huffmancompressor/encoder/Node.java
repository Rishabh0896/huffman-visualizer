package backend.huffmancompressor.encoder;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Node class represents a node used in Huffman coding.
 * Each node contains a character (c), its frequency (f), references to its left and right children,
 * and a StringBuilder to store the Huffman code associated with the character.
 */
@Getter @Setter
public class Node implements Serializable {
    private char c;                 // The character stored in this node
    private int f;                  // The frequency of the character
    private Node left;              // Reference to the left child node
    private Node right;             // Reference to the right child node
    private Node parent;    // Reference to the parent node (used in visualizer to account for tree size)
    private ArrayList<Node> children;

    /**
     * Constructs a Node with a character and its frequency.
     *
     * @param c The character to be stored in the node.
     * @param f The frequency of the character.
     */
    Node(char c, int f) {
        this(c, f, null, null);
    }

    /**
     * Constructs a Node with a character, its frequency, and references to its left and right children.
     *
     * @param c     The character to be stored in the node.
     * @param f     The frequency of the character.
     * @param left  The left child node.
     * @param right The right child node.
     */
    Node(char c, int f, Node left, Node right) {
        this.c = c;
        this.f = f;
        this.left = left;
        this.right = right;
        this.children = new ArrayList<>(2);
        if (left != null)
            this.children.add(left);
        if (right != null)
            this.children.add(right);
    }

    public Node() {

    }

    // Override equals and hashCode methods for object comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (c != node.c) return false;
        return f == node.f;
    }

    @Override
    public int hashCode() {
        int result = c;
        result = 31 * result + f;
        return result;
    }

    @Override
    public String toString() {
        ArrayList<Node> children = new ArrayList<Node>(2);
        children.add(left);
        children.add(right);
        return "Node{" +
                "character=" + c +
                ", frequency=" + f +
                ", children =" + children +
                ", leftChild=" + left +
                ", rightChild=" + right +
                ", parent=" + parent +
                '}';
    }
}
