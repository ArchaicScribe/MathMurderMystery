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
  private Button selectNewGameButton;


  protected void loadHomeFragment() {
    Fragment fragmentMainScreenFragment = new MainScreenFragment();

    FragmentManager manager = getFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentMainScreenFragment, "home");
    transaction.addToBackStack(null);
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
    transaction.add(R.id.fragment_container, fragmentScenarioScreenFragment, "scenario");
    transaction.addToBackStack(null);
    transaction.commit();
  }

  protected View scenarioButton(View view) {
    selectLevelButton = (Button) view.findViewById(R.id.new_level_button);
    selectLevelButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        loadScenarioFragment();
      }

    });
    return view;
  }
}

//  protected void loadLevelFragment() {
//    Fragment fragmentScenarioScreenFragment = new ScenarioFragment();
//
//    FragmentManager manager = getFragmentManager();
//    FragmentTransaction transaction = manager.beginTransaction();
//    transaction.add(R.id.fragment_container, fragmentRoomFragment, "room");
//    transaction.addToBackStack(null);
//    transaction.commit();
//  }
//
//  @Override
//  public void onClick(View view) {
//    loadRoomFragment();
//  }
//
//});
//    return view;
//    }
//
//protected View levelButton(View view){
//    selectLevelButton=(Button)view.findViewById(R.id.new_level_button);
//    selectLevelButton.setOnClickListener(new View.OnClickListener(){
//
//@Override
//public void onClick(View view){
//    loadHomeFragment();
//    }
//
//    });
//    return view;
//    }
//
//protected View roomButton(View view){
//    selectRoomButton=(Button)view.findViewById(R.id.new_room_button);
//    selectRoomButton.setOnClickListener(new View.OnClickListener(){
//
//@Override
//public void onClick(View view){
//    loadHomeFragment();
//    }
//
//    });
//    return view;
//    }
//
//protected View gameButton(View view){
//    selectGameFragButton=(Button)view.findViewById(R.id.new_game_button);
//    selectGameFragButton.setOnClickListener(new View.OnClickListener(){
//
//@Override
//public void onClick(View view){
//    loadHomeFragment();
//    }
//
//    });
//    return view;
//    }
//    }
