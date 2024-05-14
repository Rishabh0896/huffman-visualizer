package backend.huffmancompressor.dto;
import backend.huffmancompressor.encoder.Node;
import java.util.*;

public class CompressResponseDTO {
    private final Node huffRoot;
    private final HashMap<Character, String> huffmanCode;
    private final HashMap<Character, Integer> frequencyMap;

    public CompressResponseDTO(Node huffRoot, HashMap<Character, String> huffmanCode, HashMap<Character, Integer> frequencyMap) {
        this.huffRoot = huffRoot;
        this.huffmanCode = huffmanCode;
        this.frequencyMap = frequencyMap;
    }

    public Node getHuffRoot() {
        return huffRoot;
    }

    public HashMap<Character, String> getHuffmanCode() {
        return huffmanCode;
    }

    public HashMap<Character, Integer> getFrequencyMap() {
        return frequencyMap;
    }
}