package edu.cnm.deepdive.mathmurdermystery.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import edu.cnm.deepdive.mathmurdermystery.R;

public class LevelFragment extends LinkedFragment {


  private Button roomEntityButton;

  /**
   * Will inflate the {@link LevelFragment} and then allow the user to select a {@link
   * edu.cnm.deepdive.mathmurdermystery.model.entity.RoomEntity}.
   */
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.level_fragment, container, false);
    return selectRoomButton(view);
  }

  /**
   * This allows the user to select a room on their own choosing.
   */
  protected View selectRoomButton(View view) {
    roomEntityButton = (Button) view.findViewById(R.id.new_room_button);
    roomEntityButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        loadRoomFragment();
      }
    });
    return view;
  }
}
