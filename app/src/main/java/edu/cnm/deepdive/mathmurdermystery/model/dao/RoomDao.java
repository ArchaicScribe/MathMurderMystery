package edu.cnm.deepdive.mathmurdermystery.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mathmurdermystery.model.Room;
import java.util.List;

@Dao
public interface RoomDao {

  @Insert
  public String insertRoom(Room room);

  @Query("SELECT * FROM Room")
  public List<Room> getRoomId();
}
