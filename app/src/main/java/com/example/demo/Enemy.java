package com.example.demo;

import java.util.List;

public class Enemy {

    String name;

    Integer pictureId;

    List<String> enemyLines;

    boolean isDiscovered;

    public Enemy(String name, Integer pictureId, List<String> enemyLines, boolean isDiscovered) {
        this.name = name;
        this.pictureId = pictureId;
        this.enemyLines = enemyLines;
        this.isDiscovered = isDiscovered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public List<String> getEnemyLines() {
        return enemyLines;
    }

    public void setEnemyLines(List<String> enemyLines) {
        this.enemyLines = enemyLines;
    }

    public boolean isDiscovered() {
        return isDiscovered;
    }

    public void setDiscovered(boolean discovered) {
        isDiscovered = discovered;
    }
}
