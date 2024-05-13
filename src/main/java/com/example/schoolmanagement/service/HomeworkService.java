package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.Homework;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HomeworkService {
    private final List<Homework> homeworks;

    public HomeworkService() {
        homeworks = new ArrayList<>();
        // Örnek verileri ekleme
        homeworks.add(new Homework(1L, "Math homework", "2024-05-10", "Math"));
        homeworks.add(new Homework(2L, "History essay", "2024-05-15", "History"));
    }

    public List<Homework> getAllHomeworks() {
        return homeworks;
    }

    public Homework getHomeworkById(Long id) {
        Optional<Homework> optionalHomework = homeworks.stream()
                .filter(homework -> homework.getId().equals(id))
                .findFirst();
        return optionalHomework.orElse(null);
    }

    public void addHomework(Homework homework) {
        homeworks.add(homework);
    }

    public void updateHomework(Homework updatedHomework) {
        Optional<Homework> optionalHomework = homeworks.stream()
                .filter(homework -> homework.getId().equals(updatedHomework.getId()))
                .findFirst();
        optionalHomework.ifPresent(homework -> {
            homework.setDescription(updatedHomework.getDescription());
            homework.setDeadline(updatedHomework.getDeadline());
            homework.setSubject(updatedHomework.getSubject());
            // Diğer alanları da güncelleyebilirsiniz
        });
    }

    public void deleteHomework(Long id) {
        homeworks.removeIf(homework -> homework.getId().equals(id));
    }
}
