/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/26 - 18:26 PM (ICT)
 ************************************************/
package org.kdp.learn_vocabulary_kdp.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.kdp.learn_vocabulary_kdp.entity.Exam;
import org.kdp.learn_vocabulary_kdp.entity.Question;
import org.kdp.learn_vocabulary_kdp.model.dto.response.question.QuestionResponse;
import org.kdp.learn_vocabulary_kdp.model.dto.response.word.WordResponse;
import org.kdp.learn_vocabulary_kdp.model.mapper.QuestionMapper;
import org.kdp.learn_vocabulary_kdp.repository.QuestionRepository;
import org.kdp.learn_vocabulary_kdp.service.interfaces.QuestionService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class QuestionServiceImpl implements QuestionService {
    QuestionRepository questionRepository;
    QuestionMapper questionMapper;

    Random random = new Random();

    /**
     * @param wordList: Đáp án đúng
     * @param exam: Exam của question
     * @apiNote Hàm tạo danh sách câu hỏi ngẫu nhiên
     * @apiNote Câu hỏi: Tiếng Việt, Đáp án: Tiếng Anh
     * @hidden Độ phức tạp: 0(n^2)
     * */
    // Cần cải thiện hiệu suất
    @Override
    public List<QuestionResponse> generateRandomQuestions(List<WordResponse> wordList, Exam exam) {
        List<QuestionResponse> questionList = new ArrayList<>();

        // Trộn danh sách từ vựng
        Collections.shuffle(wordList);

        // Duyệt qua danh sách từ vựng và tạo câu hỏi
        for (WordResponse word : wordList) {
            // Tạo danh sách đáp án (đáp án đúng và các đáp án sai)
            String answer = word.getName(); // Đáp án đúng
            List<String> options = generateOptions(answer, wordList);

            // Tạo câu hỏi
            Question question = Question.builder()
                    .answer(answer)
                    .question(word.getMeaning())
                    .options(options)
                    .exam(exam)
                    .build();

            // Lưu câu hỏi vào CSDL
            questionRepository.save(question);
            questionList.add(questionMapper.toQuestionResponse(question));
        }

        return questionList;
    }

    /**
     * Hàm tạo các đáp án nhiễu (bao gồm đáp án đúng).
     * Câu hỏi: Tiếng Việt, Đáp án: Tiếng Anh
     * @param correctAnswer: Đáp án đúng
     * @param wordList: Danh sách từ vựng
     * */
    private List<String> generateOptions(String correctAnswer, List<WordResponse> wordList) {
        List<String> options = new ArrayList<>();
        options.add(correctAnswer); // Đáp án đúng

        // Lấy các đám án sai
        List<WordResponse> candidates = new ArrayList<>(wordList);
        candidates.removeIf(word -> word.getName().equals(correctAnswer)); // Bỏ đáp án đúng

        // Lấy ngẫu nhiên các đáp án sai
        // Có 4 đáp án (1 đúng + 3 sai)
        while (options.size() < 4 && !candidates.isEmpty()) {
            WordResponse randomWord = candidates.get(random.nextInt(candidates.size()));
            options.add(randomWord.getName());

            // Xoá đáp án đã được chọn
            candidates.remove(randomWord);
        }

        // Trộn thứ tự các đáp án
        Collections.shuffle(options);
        return options;
    }
}
