package edu.cnm.deepdive.mathmurdermystery.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Levels {


  @PrimaryKey
  private int levelId;
  @ColumnInfo
  private String levelTitle;
  @ColumnInfo
  private int levelDifficultyOfPRoblems;


}
