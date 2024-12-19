/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/19 - 22:46 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.dto.response.word;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.model.dto.response.type.TypeResponse;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WordResponse {
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd")
    Date updatedAt;
    String id;
    String name;
    String pronounce;
    String meaning;
    String example;
    Boolean hasRemembered;
    List<TypeResponse> types;
}
