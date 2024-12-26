/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/26 - 21:33 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.controller.v1;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.message.GlobalMessage;
import org.kdp.learn_vocabulary_kdp.response.ApiResponse;
import org.kdp.learn_vocabulary_kdp.service.interfaces.ExamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/exams")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExamControllerV1 {
    ExamService examService;

    @GetMapping("")
    public ResponseEntity<Object> getExamByTopicId(@RequestParam String topicId) {
        return ApiResponse.createSuccessResponse(
                HttpStatus.OK, GlobalMessage.SUCCESSFULLY, examService.getExamByTopicId(topicId));
    }

    @PostMapping("")
    public ResponseEntity<Object> createExam(@RequestParam String topicId) {
        return ApiResponse.createSuccessResponse(
                HttpStatus.CREATED, GlobalMessage.SUCCESSFULLY, examService.createExam(topicId));
    }

    @GetMapping("/{examId}")
    public ResponseEntity<Object> getExamById(@PathVariable("examId") String examId) {
        return ApiResponse.createSuccessResponse(
                HttpStatus.OK, GlobalMessage.SUCCESSFULLY, examService.getExam(examId));
    }
}
