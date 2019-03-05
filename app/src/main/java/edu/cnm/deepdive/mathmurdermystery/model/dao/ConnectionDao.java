package edu.cnm.deepdive.mathmurdermystery.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mathmurdermystery.model.Connection;
import java.util.List;

@Dao
public interface ConnectionDao {

  @Insert
  public Long insertConnection(Connection connection);

  @Query("SELECT * FROM Connection")
  public List<Connection> getConnection();
}
