/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/08 - 01:31 AM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.service.impl;

import lombok.AllArgsConstructor;
import org.kdp.learn_vocabulary_kdp.entity.User;
import org.kdp.learn_vocabulary_kdp.model.dto.user.UserDto;
import org.kdp.learn_vocabulary_kdp.model.mapper.EntityToDto;
import org.kdp.learn_vocabulary_kdp.repository.UserRepository;
import org.kdp.learn_vocabulary_kdp.service.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    EntityToDto entityToDto;

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();

        List<UserDto> userDtos = new ArrayList<>();

        users.forEach(user -> userDtos.add(entityToDto.userDto(user)));

        return userDtos;
    }
}
