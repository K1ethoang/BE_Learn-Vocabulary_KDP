package org.kdp.learn_vocabulary_kdp.model.dto.word;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WordDto {
    @JsonIgnore
    private LocalDateTime createdAt;

    @JsonIgnore
    private LocalDateTime updatedAt;

    @JsonIgnore
    private Boolean isDeleted;

    @JsonIgnore
    private String id;

    private String word;
    private String pronounce;
}
