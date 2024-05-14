package backend.huffmancompressor.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import backend.huffmancompressor.encoder.HuffmanCompression;
import backend.huffmancompressor.dto.CompressResponseDTO;
import org.springframework.http.ResponseEntity;

@RestController
public class HuffmanCompressorController {
    @PostMapping("/compress")
    public ResponseEntity<CompressResponseDTO> getTableData(@RequestBody String text) {
        HuffmanCompression compressor = new HuffmanCompression(text);
        compressor.compress();

        CompressResponseDTO responseDTO = new CompressResponseDTO(compressor.getHuffmanTree(), compressor.getHuffmanCodes(), compressor.getFrequencyMap());

        return ResponseEntity.ok(responseDTO);
    }
}
