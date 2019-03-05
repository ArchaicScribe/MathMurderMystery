package edu.cnm.deepdive.mathmurdermystery.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Level {


  @PrimaryKey
  private long levelId;
  @ColumnInfo
  private String levelTitle;
  @ColumnInfo
  private long levelDifficultyOfProblems;

  public long getLevelId() {
    return levelId;
  }

  public void setLevelId(long levelId) {
    this.levelId = levelId;
  }

  public String getLevelTitle() {
    return levelTitle;
  }

  public void setLevelTitle(String levelTitle) {
    this.levelTitle = levelTitle;
  }

  public long getLevelDifficultyOfProblems() {
    return levelDifficultyOfProblems;
  }

  public void setLevelDifficultyOfProblems(long levelDifficultyOfProblems) {
    this.levelDifficultyOfProblems = levelDifficultyOfProblems;
  }
}
