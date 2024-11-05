package org.kdp.learn_vocabulary_kdp.controller.v1;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.kdp.learn_vocabulary_kdp.message.GlobalMessage;
import org.kdp.learn_vocabulary_kdp.model.DTO.word.WordDto;
import org.kdp.learn_vocabulary_kdp.response.ApiResponse;
import org.kdp.learn_vocabulary_kdp.service.interfaces.WordService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/words")
@AllArgsConstructor
@Log4j2
public class WordControllerV1 {
    private final WordService wordService;
    private final String DEFAULT_PAGE_NO = "0";
    private final String DEFAULT_PAGE_SIZE = "10";
    private final String DEFAULT_SORT_BY = "updatedAt";

    @GetMapping("")
    public ResponseEntity<Object> getAllWords(@RequestParam(defaultValue = DEFAULT_PAGE_NO) int pageNo, @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, @RequestParam(defaultValue = DEFAULT_SORT_BY) String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, sortBy));
        
        return ApiResponse.responseBuilder(HttpStatus.OK, GlobalMessage.SUCCESSFULLY, wordService.getAllWords(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getWordById(@PathVariable String id) {
        log.info("Received request to get word with id: {}", id);
        return ApiResponse.responseBuilder(HttpStatus.OK, GlobalMessage.SUCCESSFULLY, wordService.getWordById(id));
    }

    @PostMapping("")
    public ResponseEntity<Object> createWord(@RequestBody WordDto wordDto) {
        return ApiResponse.responseBuilder(HttpStatus.CREATED, GlobalMessage.SUCCESSFULLY, wordService.createWord(wordDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateWord(@PathVariable String id, @RequestBody WordDto wordDto) {
        return ApiResponse.responseBuilder(HttpStatus.OK, GlobalMessage.SUCCESSFULLY, wordService.updateWord(id, wordDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteWord(@PathVariable String id) {
        wordService.deleteWord(id);
        return ApiResponse.responseBuilder(HttpStatus.OK, GlobalMessage.SUCCESSFULLY, null);
    }
}
