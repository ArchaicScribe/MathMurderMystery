package edu.cnm.deepdive.mathmurdermystery.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(foreignKeys = @ForeignKey(entity = UserInformation.class,
    parentColumns = "userId", childColumns = "userId"))
public class History {

  @PrimaryKey
  @NonNull
  private String problemId;
  @ColumnInfo
  private String userId;

  @NonNull
  public String getProblemId() {
    return problemId;
  }

  public void setProblemId(@NonNull String problemId) {
    this.problemId = problemId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}
