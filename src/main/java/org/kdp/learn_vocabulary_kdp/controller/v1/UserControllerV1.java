/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/08 - 01:36 AM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.controller.v1;

import lombok.AllArgsConstructor;
import org.kdp.learn_vocabulary_kdp.message.GlobalMessage;
import org.kdp.learn_vocabulary_kdp.response.ApiResponse;
import org.kdp.learn_vocabulary_kdp.service.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserControllerV1 {
    UserService userService;

    @GetMapping("")
    public ResponseEntity<Object> getUsers() {
        return ApiResponse.responseBuilder(HttpStatus.OK, GlobalMessage.SUCCESSFULLY, userService.getUsers());
    }
}
