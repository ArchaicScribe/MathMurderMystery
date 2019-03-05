package edu.cnm.deepdive.mathmurdermystery.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mathmurdermystery.model.MathProblems;


@Dao
public interface MathProblemsDao {

  @Insert(MathProblems)


  @Query("SELECT * FROM mathproblems ORDER BY poolOfProblems DESC")
  public MathProblems
}
