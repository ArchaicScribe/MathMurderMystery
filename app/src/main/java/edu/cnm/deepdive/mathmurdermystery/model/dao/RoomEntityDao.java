package edu.cnm.deepdive.mathmurdermystery.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mathmurdermystery.model.entity.RoomEntity;
import java.util.List;

/**
 * @author Alex Rauenzahn
 * @version 1.0 The RoomEntity DAO will insert a List of rooms. These rooms will be used to allow
 * the end-user to select which room they want to go into.
 */
@Dao
public interface RoomEntityDao {

  @Insert
  List<Long> insert(RoomEntity... roomEntities);

  @Insert
  List<Long> insert(List<RoomEntity> roomEntities);

  @Insert
  Long insertRoom(RoomEntity room);

  @Query("SELECT * FROM RoomEntity")
  List<RoomEntity> getRoomId();
}
