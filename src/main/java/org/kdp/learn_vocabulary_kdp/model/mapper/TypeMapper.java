/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/19 - 16:01 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.mapper;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.entity.Type;
import org.kdp.learn_vocabulary_kdp.model.dto.response.type.TypeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TypeMapper {
    ModelMapper modelMapper;

    public TypeResponse toResponse(final Type type) {
        return modelMapper.map(type, TypeResponse.class);
    }
}
