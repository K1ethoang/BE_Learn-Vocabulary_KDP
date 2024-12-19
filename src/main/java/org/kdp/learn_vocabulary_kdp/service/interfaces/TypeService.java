/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/19 - 15:59 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.interfaces;

import java.util.List;

import org.kdp.learn_vocabulary_kdp.model.dto.response.type.TypeResponse;

public interface TypeService {
    List<TypeResponse> getTypes();
}
