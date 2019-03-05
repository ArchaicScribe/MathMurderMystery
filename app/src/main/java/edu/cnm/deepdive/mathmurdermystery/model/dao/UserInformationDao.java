package edu.cnm.deepdive.mathmurdermystery.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mathmurdermystery.model.UserInformation;
import java.util.List;

@Dao
public interface UserInformationDao {

  @Insert
  public String insertUser(UserInformation userInformation);

  @Query("SELECT * FROM UserInformation")
  public List<UserInformation> getUserInfo();
}
