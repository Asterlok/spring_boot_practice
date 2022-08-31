package com.example.springdata.models;

import javax.persistence.*;
import java.util.Arrays;

@Entity(name = "achievement")
public class Achievement {

    // Идентификатор
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int medals; //медали
    private String progress;  //прогресс
    private String skill; //кто по масти
    private int score; // итого баллов


    /**
     * 1 achievement ==> 1 dog
     * 1 dog ==> many achievements
     */
    @ManyToOne
    private Dog dog;

    public Achievement() {
    }

    public Achievement(int medals, String progress, String skill) {
        setMedals(medals);
        setProgress(progress);
        this.skill = skill;
        setScore(progress);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMedals(int medals) {
        this.medals = medals;
    }

    public int getMedals() {
        return medals;
    }

    public void setProgress(String progress) {
        this.progress = progress;
        setScore(progress); // при обновлении прогресса сразу обновим общую сумму баллов
    }

    public String getProgress() {
        return progress;
    }

    public Dog getDog() {
        return dog;
    }

    public void setScore(String progress) {
        String str_score[] = progress.split(" ");
        int arr_score[] = new int[str_score.length];
        for (int i = 0; i < str_score.length; i++) {
            arr_score[i] = Integer.parseInt(str_score[i]);
        }
        score = Arrays.stream(arr_score).sum();
        this.score = score;
    }

    public int getScore(int score) {
        return score;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
