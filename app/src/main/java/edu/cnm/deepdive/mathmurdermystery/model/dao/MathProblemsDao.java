package edu.cnm.deepdive.mathmurdermystery.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import edu.cnm.deepdive.mathmurdermystery.model.MathProblem;
import java.util.List;


@Dao
public interface MathProblemsDao {

  @Insert
  List<Long> insert (List<MathProblem> mathProblems);

  @Update
  Void update (MathProblem mathProblems);

  @Query("SELECT * FROM MathProblem ORDER BY poolOfProblems DESC")
  public List<MathProblem> getAll();
}
