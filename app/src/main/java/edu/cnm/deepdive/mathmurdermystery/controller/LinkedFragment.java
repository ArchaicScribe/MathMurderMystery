package edu.cnm.deepdive.mathmurdermystery.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import edu.cnm.deepdive.mathmurdermystery.R;

public abstract class LinkedFragment extends Fragment {

  private Button mainMenuButton;
  private Button selectLevelButton;
  private Button selectGameFragButton;
  private Button selectRoomButton;



  protected void loadHomeFragment() {
    Fragment fragmentMainScreenFragment = new MainScreenFragment();

    FragmentManager manager = getFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentMainScreenFragment,
        fragmentMainScreenFragment.getClass().getSimpleName());
    transaction.addToBackStack("Main Menu");
    transaction.commit();
  }

  protected View menuButton(View view) {
    mainMenuButton = (Button) view.findViewById(R.id.return_to_main_menu);
    mainMenuButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        loadHomeFragment();
      }

    });
    return view;
  }


  protected void loadScenarioFragment() {
    Fragment fragmentScenarioScreenFragment = new ScenarioFragment();

    FragmentManager manager = getFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentScenarioScreenFragment,
        fragmentScenarioScreenFragment.getClass().getSimpleName());
    transaction.addToBackStack("scenario");
    transaction.commit();
  }

  protected View selectLevelButton(View view) {
    selectLevelButton = (Button) view.findViewById(R.id.new_level_button);
    selectLevelButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        loadLevelFragment();
      }

    });
    return view;
  }


  protected void loadLevelFragment() {
    Fragment fragmentLevelFragment = new LevelFragment();

    FragmentManager manager = getFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentLevelFragment,
        fragmentLevelFragment.getClass().getSimpleName());
    transaction.addToBackStack("Level");
    transaction.commit();
  }

  protected View selectRoomButton(View view) {
    selectRoomButton = (Button) view.findViewById(R.id.new_room_button);
    selectRoomButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        loadRoomFragment();
      }
    });
    return view;
  }

  protected void loadRoomFragment() {
    Fragment fragmentRoomFragment = new RoomEntityFragment();

    FragmentManager manager = getFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentRoomFragment,
        fragmentRoomFragment.getClass().getSimpleName());
    transaction.addToBackStack("Room");
    transaction.commit();
  }

//  protected View selectGameFragButton(View view) {
//    selectGameFragButton = (Button) view.findViewById(R.id.new_game_button);
//    selectGameFragButton.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View view) {
//        loadPlayFragment;
//
//        @Override
//        public void onClick (View view){
//          loadPl;
//        }
//
//      });
//    return view;
//    }
//    protected void loadPlayFragment() {
//      Fragment fragmentPlayFragment = new PlayFragment();
//
//      FragmentManager manager = getFragmentManager();
//      FragmentTransaction transaction = manager.beginTransaction();
//      transaction.add(R.id.fragment_container, fragmentPlayFragment,
//          fragmentPlayFragment.getClass().getSimpleName());
//      transaction.addToBackStack("Play");
//      transaction.commit();
//    }
  }