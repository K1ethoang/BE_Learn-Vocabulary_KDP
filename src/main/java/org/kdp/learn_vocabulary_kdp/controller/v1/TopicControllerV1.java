/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/25 - 15:21 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.controller.v1;

import java.io.IOException;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.message.GlobalMessage;
import org.kdp.learn_vocabulary_kdp.model.dto.request.topic.TopicCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.topic.TopicUpdateRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.word.WordCreationRequest;
import org.kdp.learn_vocabulary_kdp.model.dto.request.word.WordUpdateRequest;
import org.kdp.learn_vocabulary_kdp.response.ApiResponse;
import org.kdp.learn_vocabulary_kdp.service.interfaces.TopicService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/topics")
@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TopicControllerV1 {
    final String DEFAULT_PAGE_SIZE = "5";
    final String DEFAULT_PAGE_NO = "0";
    final String DEFAULT_TOPIC_SORT_BY = "updatedAt";
    TopicService topicService;

    @GetMapping("")
    public ResponseEntity<Object> getTopics(
            @RequestParam(defaultValue = DEFAULT_PAGE_NO) int pageNo,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize,
            @RequestParam(defaultValue = DEFAULT_TOPIC_SORT_BY) String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, sortBy));

        return ApiResponse.createSuccessResponse(
                HttpStatus.OK, GlobalMessage.SUCCESSFULLY, topicService.getTopicsByUserId(pageable));
    }

    @PostMapping("")
    public ResponseEntity<Object> createTopic(@Valid @RequestBody TopicCreationRequest topicCreationRequest) {
        return ApiResponse.createSuccessResponse(
                HttpStatus.CREATED, GlobalMessage.SUCCESSFULLY, topicService.createTopic(topicCreationRequest));
    }

    @PutMapping("/{topicId}")
    public ResponseEntity<Object> updateTopic(
            @RequestBody TopicUpdateRequest topicUpdateRequest, @PathVariable String topicId) {
        return ApiResponse.createSuccessResponse(
                HttpStatus.OK, GlobalMessage.SUCCESSFULLY, topicService.updateTopic(topicUpdateRequest, topicId));
    }

    @DeleteMapping("/{topicId}")
    public ResponseEntity<Object> deleteTopic(@PathVariable String topicId) {
        topicService.deleteTopic(topicId);
        return ApiResponse.createSuccessResponse(HttpStatus.OK, GlobalMessage.SUCCESSFULLY, null);
    }

    @GetMapping("/{topicId}/words")
    public ResponseEntity<Object> getWords(@PathVariable String topicId) {
        return ApiResponse.createSuccessResponse(
                HttpStatus.OK, GlobalMessage.SUCCESSFULLY, topicService.getWords(topicId));
    }

    @PostMapping("/{topicId}/words")
    public ResponseEntity<Object> addWord(
            @PathVariable String topicId, @Valid @RequestBody WordCreationRequest request) {
        return ApiResponse.createSuccessResponse(
                HttpStatus.CREATED, GlobalMessage.SUCCESSFULLY, topicService.addWord(topicId, request));
    }

    @PutMapping("/{topicId}/words/{wordId}")
    public ResponseEntity<Object> updateWord(
            @PathVariable String topicId, @PathVariable String wordId, @RequestBody WordUpdateRequest request) {
        return ApiResponse.createSuccessResponse(
                HttpStatus.OK, GlobalMessage.SUCCESSFULLY, topicService.updateWord(topicId, wordId, request));
    }

    @DeleteMapping("/{topicId}/words/{wordId}")
    public ResponseEntity<Object> deleteWord(@PathVariable String topicId, @PathVariable String wordId) {
        topicService.deleteWord(topicId, wordId);
        return ApiResponse.createSuccessResponse(HttpStatus.OK, GlobalMessage.SUCCESSFULLY, null);
    }

    @GetMapping("/{topicId}/exams")
    public ResponseEntity<Object> getExams(
            @RequestParam(defaultValue = DEFAULT_PAGE_NO) int pageNo,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize,
            @RequestParam(defaultValue = "completedAt") String sortBy,
            @PathVariable String topicId) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, sortBy));

        return ApiResponse.createSuccessResponse(
                HttpStatus.OK, GlobalMessage.SUCCESSFULLY, topicService.getExams(pageable, topicId));
    }

    @GetMapping(value = "/excel/{topicId}")
    public void downloadExcel(HttpServletResponse response, @PathVariable String topicId) throws IOException {
        topicService.exportExcel(response, topicId);
    }
}
