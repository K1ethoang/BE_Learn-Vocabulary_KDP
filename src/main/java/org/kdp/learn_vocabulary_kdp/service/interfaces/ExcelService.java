/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/25 - 13:25 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.interfaces;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import org.kdp.learn_vocabulary_kdp.model.dto.response.word.WordResponse;

public interface ExcelService {
    void exportTopicWord(HttpServletResponse response, List<WordResponse> data, String topicTitle) throws IOException;
}
