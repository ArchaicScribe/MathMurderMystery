package edu.cnm.deepdive.mathmurdermystery.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(indices = @Index(value = {"scenario_id", "level_title"}, unique = true))
public class Level {


  @PrimaryKey
  @ColumnInfo(name = "level_id", index = true)
  private long levelId;
  @NonNull
  @ColumnInfo(name = "level_title", index = true)
  private String levelTitle;
  @ColumnInfo(name = "level_of_difficulty_of_problems", index = true)
  private long levelDifficultyOfProblems;
  @ColumnInfo(name = "scenario_id", index = true)
  private long scenrioId;


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
