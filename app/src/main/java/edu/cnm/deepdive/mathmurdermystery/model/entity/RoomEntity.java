package edu.cnm.deepdive.mathmurdermystery.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * This entity will keep a relation between itself and the {@link Level} class. This is designed to
 * keep track of the specific room and its corresponding level. Certain rooms will only be
 * obtainable through progressing onto higher levels. It will gather the info from the level and
 * room ids and ensure that they go to the corresponding ones.
 */
@Entity(foreignKeys = @ForeignKey(entity = Level.class,
    parentColumns = "level_id", childColumns = "level_id"))
public class RoomEntity {

  @PrimaryKey
  @ColumnInfo(name = "room_id", index = true)
  private long roomId;
  @ColumnInfo(name = "level_id", index = true)
  private long levelId;

  public long getRoomId() {
    return roomId;
  }

  public void setRoomId(long roomId) {
    this.roomId = roomId;
  }

  public long getLevelId() {
    return levelId;
  }

  public void setLevelId(long levelId) {
    this.levelId = levelId;
  }
}
