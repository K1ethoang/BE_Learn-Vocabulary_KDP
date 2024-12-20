/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/20 - 22:49 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.dto.request.word;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.jackson.TrimDeserializer;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WordUpdateRequest {
    @JsonDeserialize(using = TrimDeserializer.class)
    String name;

    @JsonDeserialize(using = TrimDeserializer.class)
    String pronounce;

    @JsonDeserialize(using = TrimDeserializer.class)
    String meaning;

    @JsonDeserialize(using = TrimDeserializer.class)
    String example;

    Boolean hasRemembered;

    List<String> typeIds;
}
