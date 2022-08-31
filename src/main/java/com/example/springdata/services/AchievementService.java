package com.example.springdata.services;

import com.example.springdata.models.Achievement;
import com.example.springdata.models.Dog;

public interface AchievementService {
    Long registerAccountForAchievement(Dog dog, int medals, String progress, String skill);

    Achievement getInfoAboutAchievementById(Long id);
    void plusProgress(String progress, Long id); // баллы начисляют
}

