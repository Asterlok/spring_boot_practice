package com.example.springdata.services;

import com.example.springdata.models.Achievement;
import com.example.springdata.models.Dog;
import com.example.springdata.repositories.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Service
@Primary
public class AchievementServiceImpl implements AchievementService {

    private final AchievementRepository achievementRepository;

    // Просим фреймворк инжектнуть сгенерированную реализацию интерфейса AchievementRepository
    @Autowired
    public AchievementServiceImpl(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

    public Long registerAccountForAchievement(Dog dog, int medals, String progress, String skill) {
        Achievement achievement = new Achievement(medals, progress, skill);
        achievement.setDog(dog);
        this.achievementRepository.save(achievement);
        return achievement.getId();
    }

    @Override
    public Achievement getInfoAboutAchievementById(Long id) {
        return this.achievementRepository.findAchievementById(id);
    }

    private void addToProgress(String progress, Long id) {
        Achievement achievement = this.achievementRepository.findById(id).orElseThrow();
        achievement.setProgress(achievement.getProgress() + " " + progress);
        this.achievementRepository.save(achievement);
    }

    @Override
    public void plusProgress(String progress, Long id) {
        addToProgress(progress, id);
    }

}
