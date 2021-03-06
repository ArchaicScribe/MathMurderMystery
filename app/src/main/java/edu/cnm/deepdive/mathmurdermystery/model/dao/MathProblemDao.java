package edu.cnm.deepdive.mathmurdermystery.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import edu.cnm.deepdive.mathmurdermystery.model.entity.MathProblem;
import java.util.List;

/**
 * @author Alex Rauenzahn
 * @version 1.0 This will obtain all of the {@link MathProblem} and gather them for a pool of
 * problems. Then, it will gather random problems.
 */
@Dao
public interface MathProblemDao {

  @Insert
  List<Long> insert(List<MathProblem> mathProblems);

  @Update
  void update(MathProblem mathProblems);

  @Query("SELECT * FROM MathProblem ORDER BY pool_of_problems DESC")
  List<MathProblem> getAll();

  @Query("SELECT * FROM MathProblem ORDER BY RANDOM() LIMIT 1")
  MathProblem getRandom();

}
