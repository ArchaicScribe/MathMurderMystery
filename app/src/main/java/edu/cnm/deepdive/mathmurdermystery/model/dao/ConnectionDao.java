package edu.cnm.deepdive.mathmurdermystery.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mathmurdermystery.model.entity.Connection;
import java.util.List;

@Dao
public interface ConnectionDao {

  @Insert
  Long insertConnection(Connection connection);

  @Query("SELECT * FROM Connection")
  List<Connection> getConnection();
}
/* Create test, as usual, using JUNIT4, add setUp and tearDown methods. Put in AndroidTest folder.
Create fields, private for that specific Dao and DB. In ApodDao.
  public void setUp() throws Exception {

    Context context = InstrumentationRegistry.getTargetContext();
        apodDB = Room.inMemoryDatabaseBuilder(context, ApodDB.class).build();
    apodDao = apodDB.getApodDao();

}

@Test
  public void insertSelectDelete() {
    Apod apod = new Apod();
      Date date = Date.today();//instance of the date class for today's date, import from edu.cnm.deepdive.date;
    apod.setDate(date);
    String title = "Test APOD instance";
    apod.setTitle(title);
    //apodDao.insert(apod);inserting this into the DB.
    List<Long> ids = apodDao.insert(apod);
    assertEquals(1, ids.size());
  }



  public void tearDown() throws Exception {
  apodDB.close(); Start clean every time and avoid memory leaks.

Then run tests from testClass. Test select and insert methods.

 public void insert() {
    Apod apod = new Apod();
    Date date = Date.today();//instance of the date class for today's date
    apod.setDate(date);
    String title = "Test APOD instance";
    apod.setTitle(title);
    //apodDao.insert(apod);inserting this into the DB.
    List<Long> ids = apodDao.insert(apod);
    assertEquals(1, ids.size());
  }

@Test
  public void select() {
    Apod apod = new Apod();
    Date date = Date.today();//instance of the date class for today's date
    apod.setDate(date);
    String title = "Test APOD instance";
    apod.setTitle(title);
    //apodDao.insert(apod);inserting this into the DB.
    List<Long> ids = apodDao.insert(apod);
    Apod testApod = apodDao.findFirstByDate(date);
     assertEquals(date.toEpochDays(), testApod.getDate().toEpochDays());
    assertEquals(title, testApod.getTitle());
  }
 @Test
  public void delete() {
    Apod apod = new Apod();
    Date date = Date.today();//instance of the date class for today's date
    apod.setDate(date);
    String title = "Test APOD instance";
    apod.setTitle(title);
    //apodDao.insert(apod);inserting this into the DB.
    List<Long> ids = apodDao.insert(apod);
    Apod testApod = apodDao.findFirstByDate(date);
    int rowsDeleted = apodDao.delete(testApod);//we got this back from the DB
  assertEquals(1, rowsDeleted);//should only delete one row
    assertEquals(0,
        apodDao.findAll().size());//find all returns a list. or isEmpty() with assertTrue.
  }
 @Test
  public void selectAll() {
    Apod[] apods = new Apod[10];
    Random rng = new Random();
    for (int i = 0; i < apods.length; i++) {
      Apod apod = new Apod();
      Date date = Date.fromEpochDays(rng.nextInt(20_000));
      apod.setDate(date);
      apod.setTitle("Test APOD instance " + i);
      apods[i] = apod;
    }
    apodDao.insert(apods);
    Apod[] testApods = apodDao.findAll().toArray(new Apod[0]);
    Arrays.sort(apods, (apod1, apod2) ->
        -Integer.compare(apod1.getDate().toEpochDays(),
            apod2.getDate().toEpochDays()));//sorting the original array, comparator
    assertArrayEquals(apods, testApods);
  }

  @After
  public void tearDown() throws Exception {
    apodDB.close();
  }
}


 This is in Apod.java:
     Apod other = (Apod) obj;//comparing every detail of each object to one another
    return date.toEpochDays() == other.date.toEpochDays()
        && Objects.equals(title, other.title)
        && Objects.equals(explanation, other.explanation)
        && Objects.equals(url, other.url)
        && Objects.equals(hdUrl, other.hdUrl)
        && Objects.equals(mediaType, other.mediaType)
        && Objects.equals(copyright, other.copyright);
  }


 */