package edu.cnm.deepdive.mathmurdermystery.model.dao;
/**
 *  @author Alex Rauenzahn
 *  @version 1.0
 */

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mathmurdermystery.model.entity.History;
import java.util.List;

/**
 * This DAO will obtain the user's history, progress, and score.
 */
@Dao
public interface HistoryDao {


  @Insert
  Long insertHistory(History history);

  @Query("SELECT * FROM History")
  List<History> getHistory();

}
