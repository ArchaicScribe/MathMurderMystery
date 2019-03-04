package edu.cnm.deepdive.mathmurdermystery.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity (foreignKeys = @ForeignKey(entity = Levels.class,
    parentColumns = "level_id", childColumns = "level_id"))
public class Room {

  @PrimaryKey
  private int roomId;
  @ColumnInfo
  private int levelId;
}
