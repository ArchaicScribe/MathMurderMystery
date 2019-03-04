package edu.cnm.deepdive.mathmurdermystery.model;

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
  private String username;
  @ColumnInfo
  private String userProgress;

}

