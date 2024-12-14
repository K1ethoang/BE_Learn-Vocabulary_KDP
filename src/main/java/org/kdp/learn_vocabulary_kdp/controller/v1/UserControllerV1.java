/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/14 - 21:16 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.controller.v1;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.kdp.learn_vocabulary_kdp.message.GlobalMessage;
import org.kdp.learn_vocabulary_kdp.model.dto.request.user.UserUpdateRequest;
import org.kdp.learn_vocabulary_kdp.response.ApiResponse;
import org.kdp.learn_vocabulary_kdp.service.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserControllerV1 {
    UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("")
    public ResponseEntity<Object> getUsers() {
        return ApiResponse.responseBuilder(HttpStatus.OK, GlobalMessage.SUCCESSFULLY, userService.getUsers());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("{userId}")
    public ResponseEntity<Object> getUserById(@PathVariable("userId") String userId) {
        return ApiResponse.responseBuilder(HttpStatus.OK, GlobalMessage.SUCCESSFULLY, userService.getUserById(userId));
    }

    @PutMapping("{userId}")
    public ResponseEntity<Object> updateUser(@Valid @RequestBody UserUpdateRequest userUpdateRequest, @PathVariable("userId") String userId) {
        return ApiResponse.responseBuilder(HttpStatus.OK, GlobalMessage.SUCCESSFULLY, userService.updateUser(userUpdateRequest, userId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
        return ApiResponse.responseBuilder(HttpStatus.OK, GlobalMessage.SUCCESSFULLY, null);
    }

    @GetMapping("/my-info")
    public ResponseEntity<Object> getMyInfo() {
        return ApiResponse.responseBuilder(HttpStatus.OK, GlobalMessage.SUCCESSFULLY, userService.getMyInfo());
    }
}
