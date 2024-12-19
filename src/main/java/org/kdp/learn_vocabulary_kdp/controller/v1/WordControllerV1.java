/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/19 - 15:05 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.controller.v1;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.kdp.learn_vocabulary_kdp.service.impl.WordServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/words")
@AllArgsConstructor
@Log4j2
public class WordControllerV1 {
    private static final String DEFAULT_PAGE_SIZE = "10";
    private static final String DEFAULT_PAGE_NO = "0";
    private static final String DEFAULT_SORT_BY = "updatedAt";
    private final WordServiceImpl wordService;

    //    @GetMapping("")
    //    public ResponseEntity<Object> getAllWords(@RequestParam(defaultValue = DEFAULT_PAGE_NO) int pageNo,
    // @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, @RequestParam(defaultValue = DEFAULT_SORT_BY)
    // String sortBy) {
    //        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, sortBy));
    //
    //        return ApiResponse.createSuccessResponse(HttpStatus.OK, GlobalMessage.SUCCESSFULLY,
    // wordService.getWordsByUserId(pageable));
    //    }
    //
    //    @GetMapping("/{userId}")
    //    public ResponseEntity<Object> getWordByUserId(@Valid @PathVariable String userId) {
    //        return ApiResponse.createSuccessResponse(HttpStatus.OK, GlobalMessage.SUCCESSFULLY,
    // wordService.getWordByUserId(userId));
    //    }
    //
    //    @PostMapping("")
    //    public ResponseEntity<Object> createWord(@RequestBody WordCreationRequest request) {
    //        return ApiResponse.createSuccessResponse(HttpStatus.CREATED, GlobalMessage.SUCCESSFULLY,
    // wordService.createWord(request));
    //    }
    //
    //    @PutMapping("/{wordId}")
    //    public ResponseEntity<Object> updateWord(@PathVariable String wordId, @RequestBody WordCreationRequest request
    // {
    //        return ApiResponse.createSuccessResponse(HttpStatus.OK, GlobalMessage.SUCCESSFULLY,
    // wordService.updateWord(wordId, request));
    //    }
    //
    //    @DeleteMapping("/{id}")
    //    public ResponseEntity<Object> deleteWord(@PathVariable String id) {
    //        wordService.deleteWord(id);
    //        return ApiResponse.createSuccessResponse(HttpStatus.OK, GlobalMessage.SUCCESSFULLY, null);
    //    }
}
