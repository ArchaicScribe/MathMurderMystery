package edu.cnm.deepdive.mathmurdermystery.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import edu.cnm.deepdive.mathmurdermystery.R;

public class PlayFragment extends LinkedFragment {

  private Button startNewGameButton;

  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.game_fragment, container, false);
    return menuButton(view);
  }
  protected View menuButton(View view) {

    startNewGameButton = (Button) view.findViewById(R.id.start_new_game_button);
    startNewGameButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        loadScenarioFragment();
      }
    });
    return view;
  }

}

