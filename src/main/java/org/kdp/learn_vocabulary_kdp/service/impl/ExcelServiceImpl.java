/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/25 - 15:15 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.kdp.learn_vocabulary_kdp.model.dto.response.type.TypeResponse;
import org.kdp.learn_vocabulary_kdp.model.dto.response.word.WordResponse;
import org.kdp.learn_vocabulary_kdp.service.ExcelAbstract;
import org.kdp.learn_vocabulary_kdp.service.interfaces.ExcelService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExcelServiceImpl extends ExcelAbstract implements ExcelService {
    String[] headersTopicWord = {
        "STT", "Từ vựng", "Nghĩa", "Loại từ", "Phiên " + "âm", "Ví " + "dụ", "Đã thuộc", "TG tạo", " TG cập nhật"
    };

    @Override
    public void exportTopicWord(HttpServletResponse response, List<WordResponse> data, String topicTitle)
            throws IOException {
        super.newReportExcel();

        response = super.initResponseForExportExcel(response, topicTitle);
        ServletOutputStream outputStream = response.getOutputStream();

        writeTableHeaderExcel("Sheet Word", topicTitle, headersTopicWord);

        // write content row
        writeTableDataForTopicWord(data);

        getWorkbook().write(outputStream);
        getWorkbook().close();
        outputStream.close();
    }

    public void writeTableDataForTopicWord(List<WordResponse> data) {
        // font style content
        CellStyle style = getFontContentExcel();

        // starting write on row
        int startRow = 2;

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // write content
        for (WordResponse wordResponse : data) {
            Row row = getSheet().createRow(startRow++);
            int columnCount = 0;
            createCell(row, columnCount++, startRow - 2, style);
            createCell(row, columnCount++, wordResponse.getName(), style);
            createCell(row, columnCount++, wordResponse.getMeaning(), style);
            List<String> types = wordResponse.getTypes().stream()
                    .map(TypeResponse::getSymbol)
                    .toList();
            createCell(row, columnCount++, String.join(", ", types), style);
            createCell(row, columnCount++, wordResponse.getPronounce(), style);
            createCell(row, columnCount++, wordResponse.getExample(), style);
            createCell(row, columnCount++, wordResponse.getHasRemembered(), style);
            createCell(row, columnCount++, dateFormatter.format(wordResponse.getCreatedAt()), style);
            createCell(row, columnCount++, dateFormatter.format(wordResponse.getUpdatedAt()), style);
        }
    }
}
