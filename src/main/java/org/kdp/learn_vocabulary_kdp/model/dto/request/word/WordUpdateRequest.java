/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/20 - 00:13 AM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.model.dto.request.word;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kdp.learn_vocabulary_kdp.jackson.TrimDeserializer;
import org.kdp.learn_vocabulary_kdp.message.GlobalMessage;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WordUpdateRequest {
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

    Boolean hasRemembered;

    List<String> typeIds;
}
