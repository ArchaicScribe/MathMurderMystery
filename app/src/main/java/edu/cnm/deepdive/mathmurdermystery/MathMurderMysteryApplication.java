package edu.cnm.deepdive.mathmurdermystery;
/**
 *  @author Alex Rauenzahn
 *  @version 1.0
 */

import android.app.Application;
import com.facebook.stetho.Stetho;

public class MathMurderMysteryApplication extends Application {

  private static MathMurderMysteryApplication instance = null;

  /**
   * This will initialize an instance of Stethos for the Goolge developer tools to see if the
   * database is performing as it is suppose to.
   */
  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
    Stetho.initializeWithDefaults(this);
  }

  public static MathMurderMysteryApplication getInstance() {
    return instance;
  }
}
