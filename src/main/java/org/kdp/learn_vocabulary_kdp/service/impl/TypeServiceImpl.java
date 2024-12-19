/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/19 - 16:02 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.impl;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.entity.Type;
import org.kdp.learn_vocabulary_kdp.model.dto.response.type.TypeResponse;
import org.kdp.learn_vocabulary_kdp.model.mapper.TypeMapper;
import org.kdp.learn_vocabulary_kdp.repository.TypeRepository;
import org.kdp.learn_vocabulary_kdp.service.interfaces.TypeService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TypeServiceImpl implements TypeService {
    TypeRepository typeRepository;
    TypeMapper typeMapper;

    @Override
    public List<TypeResponse> getTypes() {
        List<Type> types = typeRepository.findAll();

        return types.stream().map(typeMapper::toResponse).toList();
    }
}
