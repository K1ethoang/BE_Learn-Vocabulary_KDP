/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/13 - 22:58 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.controller.v1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.kdp.learn_vocabulary_kdp.message.GlobalMessage;
import org.kdp.learn_vocabulary_kdp.model.dto.topic.TopicDto;
import org.kdp.learn_vocabulary_kdp.response.ApiResponse;
import org.kdp.learn_vocabulary_kdp.service.interfaces.JwtService;
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
public class TopicControllerV1 {
    private static final String DEFAULT_PAGE_SIZE = "10";
    private static final String DEFAULT_PAGE_NO = "0";
    private static final String DEFAULT_SORT_BY = "updatedAt";
    TopicService topicService;
    JwtService jwtService;

    @GetMapping("")
    public ResponseEntity<Object> getTopics(@RequestParam(defaultValue = DEFAULT_PAGE_NO) int pageNo, @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, @RequestParam(defaultValue = DEFAULT_SORT_BY) String sortBy, HttpServletRequest request) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, sortBy));
        String userId = jwtService.getUserIdFromRequest(request);

        return ApiResponse.responseBuilder(HttpStatus.OK, GlobalMessage.SUCCESSFULLY, topicService.getTopicsByUserId(pageable, userId));
    }

    @PostMapping("")
    public ResponseEntity<Object> createTopic(@Valid @RequestBody TopicDto topicDto, HttpServletRequest request) {
        String userId = jwtService.getUserIdFromRequest(request);

        return ApiResponse.responseBuilder(HttpStatus.CREATED, GlobalMessage.SUCCESSFULLY, topicService.createTopic(topicDto, userId));
    }
}
