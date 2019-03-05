package edu.cnm.deepdive.mathmurdermystery.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mathmurdermystery.model.Level;
import java.util.List;

@Dao
public interface LevelDao {

  @Insert
  public long insertLevel(Level level);

  @Query("SELECT * FROM Level")
  public List<Level> getAllLevels();
}
