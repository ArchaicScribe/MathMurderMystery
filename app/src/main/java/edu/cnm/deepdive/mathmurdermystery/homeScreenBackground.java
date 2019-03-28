package edu.cnm.deepdive.mathmurdermystery;
/**
 *  @author Alex Rauenzahn
 *  @version 1.0
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class homeScreenBackground extends Fragment {

  /**
   * This inflates the {@link HomeScreenActivity} fragment. This does not extend to the superclass
   * {@link edu.cnm.deepdive.mathmurdermystery.controller.LinkedFragment}.
   */
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.home_screen_background_fragment, container, false);

  }
}
