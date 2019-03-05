package edu.cnm.deepdive.mathmurdermystery.model;

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
  private long levelDifficultyOfPRoblems;

  public long getLevelId() {
    return levelId;
  }

  public void setLevelId(int levelId) {
    this.levelId = levelId;
  }

  public String getLevelTitle() {
    return levelTitle;
  }

  public void setLevelTitle(String levelTitle) {
    this.levelTitle = levelTitle;
  }

  public long getLevelDifficultyOfPRoblems() {
    return levelDifficultyOfPRoblems;
  }

  public void setLevelDifficultyOfPRoblems(int levelDifficultyOfPRoblems) {
    this.levelDifficultyOfPRoblems = levelDifficultyOfPRoblems;
  }
}
