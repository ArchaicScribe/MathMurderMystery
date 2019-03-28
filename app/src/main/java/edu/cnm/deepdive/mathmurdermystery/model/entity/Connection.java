package edu.cnm.deepdive.mathmurdermystery.model.entity;
/**
 *  @author Alex Rauenzahn
 *  @version 1.0
 */

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

/**
 * This entity will create the {@link RoomEntity} entities, with room_id for the parent columns, and
 * for the child columns will be room_id2. This is for the use of multiple rooms in case the *
 * developer wanted to add more rooms for the user to access.
 */
@Entity(
    primaryKeys = {"room_id1", "room_id2"},
    foreignKeys = {
        @ForeignKey(entity = RoomEntity.class, parentColumns = "room_id", childColumns = "room_id1"),
        @ForeignKey(entity = RoomEntity.class, parentColumns = "room_id", childColumns = "room_id2")
    }
)
/**
 * This class will be the connection between all of the {@link RoomEntity}, with accessors and mutators. It will grab the RoomId and set them within the SQL table.
 */
public class Connection {


  @ColumnInfo(name = "room_id1", index = true)
  private long roomId1;

  @ColumnInfo(name = "room_id2", index = true)
  private long roomId2;

  public long getRoomId1() {
    return roomId1;
  }

  public void setRoomId1(long roomId1) {
    this.roomId1 = roomId1;
  }

  public long getRoomId2() {
    return roomId2;
  }

  public void setRoomId2(long roomId2) {
    this.roomId2 = roomId2;
  }
}
