package edu.cnm.deepdive.mathmurdermystery.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import edu.cnm.deepdive.mathmurdermystery.R;

public class RoomEntityFragment extends LinkedFragment {


  private Button startNewGameButton;


  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.room_fragment, container, false);
    return selectGameButton(view);
  }
  protected View selectGameButton(View view) {
    startNewGameButton = (Button) view.findViewById(R.id.new_go_to_problems);
    startNewGameButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        loadProblemFragment();
      }
    });
    return view;
  }
}
