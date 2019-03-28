package edu.cnm.deepdive.mathmurdermystery.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.cnm.deepdive.mathmurdermystery.R;

/**
 *  @author Alex Rauenzahn
 *  @version 1.0
 */
public class MainScreenFragment extends LinkedFragment {

  /**
   * This onCreateView will inflate the homescreen background fragment, directs it to the container,
   * known as ViewGroup.
   */
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.home_screen_background_fragment, container, false);
  }
}

