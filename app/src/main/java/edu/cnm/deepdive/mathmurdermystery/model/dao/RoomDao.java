package edu.cnm.deepdive.mathmurdermystery.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mathmurdermystery.model.RoomEntity;
import java.util.List;

@Dao
public interface RoomDao {

  @Insert
  public String insertRoom(RoomEntity room);

  @Query("SELECT * FROM RoomEntity")
  public List<RoomEntity> getRoomId();
}
