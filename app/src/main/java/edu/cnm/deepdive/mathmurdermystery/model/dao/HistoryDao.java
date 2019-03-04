package edu.cnm.deepdive.mathmurdermystery.model.dao;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mathmurdermystery.model.History;

public interface HistoryDao {


  @Insert
  public long insertHistory (History history);
  @Query()
}
