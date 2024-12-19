/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/19 - 16:03 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.controller.v1;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.message.GlobalMessage;
import org.kdp.learn_vocabulary_kdp.response.ApiResponse;
import org.kdp.learn_vocabulary_kdp.service.interfaces.TypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/v1/types")
public class TypeControllerV1 {
    TypeService typeService;

    @GetMapping("")
    public ResponseEntity<Object> getTypes() {
        return ApiResponse.createSuccessResponse(HttpStatus.OK, GlobalMessage.SUCCESSFULLY, typeService.getTypes());
    }
}
