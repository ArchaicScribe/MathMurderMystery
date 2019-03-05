package edu.cnm.deepdive.mathmurdermystery.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mathmurdermystery.model.entity.Level;
import java.util.List;

@Dao
public interface LevelDao {

  @Insert
  Long insertLevel(Level level);

  @Query("SELECT * FROM Level")
  List<Level> getAllLevels();
}
