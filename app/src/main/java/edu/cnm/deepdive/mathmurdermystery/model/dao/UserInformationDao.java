package edu.cnm.deepdive.mathmurdermystery.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mathmurdermystery.model.entity.UserInformation;
import java.util.List;

/**
 * This DAO will store all of the user's info, from a list form {@link UserInformation}. It will
 * return the user's info.
 */
@Dao
public interface UserInformationDao {

  @Insert
  Long insertUser(UserInformation userInformation);

  @Query("SELECT * FROM UserInformation")
  List<UserInformation> getUserInfo();
}
