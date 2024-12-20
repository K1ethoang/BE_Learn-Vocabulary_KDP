/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/20 - 23:27 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.controller.v1;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.kdp.learn_vocabulary_kdp.message.GlobalMessage;
import org.kdp.learn_vocabulary_kdp.model.dto.request.user.UserUpdateRequest;
import org.kdp.learn_vocabulary_kdp.response.ApiResponse;
import org.kdp.learn_vocabulary_kdp.service.interfaces.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserControllerV1 {
    final String DEFAULT_PAGE_SIZE = "5";
    final String DEFAULT_PAGE_NO = "0";
    final String DEFAULT_TOPIC_SORT_BY = "fullName";
    UserService userService;

    @Operation(summary = "Admin")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("")
    public ResponseEntity<Object> getUsers(
            @RequestParam(defaultValue = DEFAULT_PAGE_NO) int pageNo,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize,
            @RequestParam(defaultValue = DEFAULT_TOPIC_SORT_BY) String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        return ApiResponse.createSuccessResponse(
                HttpStatus.OK, GlobalMessage.SUCCESSFULLY, userService.getUsers(pageable));
    }

    @Operation(summary = "Admin")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUserById(@PathVariable("userId") String userId) {
        return ApiResponse.createSuccessResponse(
                HttpStatus.OK, GlobalMessage.SUCCESSFULLY, userService.getUserById(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Object> updateUser(
            @RequestBody UserUpdateRequest userUpdateRequest, @PathVariable("userId") String userId) {
        return ApiResponse.createSuccessResponse(
                HttpStatus.OK, GlobalMessage.SUCCESSFULLY, userService.updateUser(userUpdateRequest, userId));
    }

    @Operation(summary = "Admin")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
        return ApiResponse.createSuccessResponse(HttpStatus.OK, GlobalMessage.SUCCESSFULLY, null);
    }

    @Operation(summary = "Admin")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{userId}/toggle-block")
    public ResponseEntity<Object> toggleBlockUser(
            @PathVariable("userId") String userId, @RequestParam(required = true) boolean isBlocked) {
        return ApiResponse.createSuccessResponse(
                HttpStatus.OK, GlobalMessage.SUCCESSFULLY, userService.toggleBlockUser(userId, isBlocked));
    }

    @GetMapping("/my-info")
    public ResponseEntity<Object> getMyInfo() {
        return ApiResponse.createSuccessResponse(HttpStatus.OK, GlobalMessage.SUCCESSFULLY, userService.getMyInfo());
    }
}
