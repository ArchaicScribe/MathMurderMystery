package edu.cnm.deepdive.mathmurdermystery.controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import edu.cnm.deepdive.mathmurdermystery.R;

public class ScenarioFragment extends LinkedFragment {

  private Button levelButton;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.scenario_fragment, container, false);
    return levelButton(view);
  }
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
