package edu.cnm.deepdive.mathmurdermystery.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mathmurdermystery.model.entity.RoomEntity;
import java.util.List;

@Dao
public interface RoomEntityDao {

  @Insert
  Long insertRoom(RoomEntity room);

  @Query("SELECT * FROM RoomEntity")
  List<RoomEntity> getRoomId();
}
