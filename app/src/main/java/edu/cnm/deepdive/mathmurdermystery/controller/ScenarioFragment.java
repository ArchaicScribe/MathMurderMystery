package edu.cnm.deepdive.mathmurdermystery.controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import edu.cnm.deepdive.mathmurdermystery.R;

/**
 * @author Alex Rauenzahn
 * @version 1.0
 */
public class ScenarioFragment extends LinkedFragment {

  /**
   * New level button.
   */
  private Button levelButton;

  /**
   * This view will inflate the scenario fragment, which will take the user to the level fragment.
   */
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.scenario_fragment, container, false);
    return levelButton(view);
  }

  /**
   * The level button will inflate, then progressing the user to the level fragment. This is in the
   * order of the game flow. Levels, scenarios, and finally rooms.
   * @return Returns the view.
   */
  protected View levelButton(View view) {
    levelButton = (Button) view.findViewById(R.id.new_go_to_scenario_button);
    levelButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        loadLevelFragment();
      }

    });
    return view;
  }
}
