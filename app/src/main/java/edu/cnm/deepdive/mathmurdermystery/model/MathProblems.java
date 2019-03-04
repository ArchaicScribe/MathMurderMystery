package edu.cnm.deepdive.mathmurdermystery.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class MathProblems {

  @PrimaryKey
  private String problemId;
  @ColumnInfo
  @NonNull
  private String problemDifficulty;
  @ColumnInfo
  private int problemAnswer;
  @ColumnInfo
  private int numberOfAttemptsPermitted;
  @ColumnInfo
  private String poolOfProblems;
}
