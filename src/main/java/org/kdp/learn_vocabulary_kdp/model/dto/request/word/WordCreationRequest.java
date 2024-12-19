/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/19 - 17:59 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.dto.request.word;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.jackson.TrimDeserializer;
import org.kdp.learn_vocabulary_kdp.message.GlobalMessage;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WordCreationRequest {
    @NotBlank(message = GlobalMessage.REQUIRED)
    @JsonDeserialize(using = TrimDeserializer.class)
    String name;

    @JsonDeserialize(using = TrimDeserializer.class)
    String pronounce;

    @NotBlank(message = GlobalMessage.REQUIRED)
    @JsonDeserialize(using = TrimDeserializer.class)
    String meaning;

    @JsonDeserialize(using = TrimDeserializer.class)
    String example;

    List<String> typeIds;
}
