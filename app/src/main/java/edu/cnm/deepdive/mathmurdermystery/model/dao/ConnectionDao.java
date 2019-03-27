package edu.cnm.deepdive.mathmurdermystery.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mathmurdermystery.model.entity.Connection;
import java.util.List;

/**
 * This is the connection that will act as a chain between the {@link
 * edu.cnm.deepdive.mathmurdermystery.model.entity.RoomEntity} so that the user could have the
 * potential to go in between different rooms.
 */
@Dao
public interface ConnectionDao {

  @Insert
  Long insertConnection(Connection connection);

  @Query("SELECT * FROM Connection")
  List<Connection> getConnection();
}
