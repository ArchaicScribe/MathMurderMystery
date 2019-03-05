package edu.cnm.deepdive.mathmurdermystery.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity


public class UserInformation {

  @PrimaryKey
  @NonNull
  private String userId;
  @ColumnInfo
  @NonNull
  private String username;
  @ColumnInfo
  @NonNull
  private String userProgress;

  @NonNull
  public String getUserId() {
    return userId;
  }

  public void setUserId(@NonNull String userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUserProgress() {
    return userProgress;
  }

  public void setUserProgress(String userProgress) {
    this.userProgress = userProgress;
  }
}

