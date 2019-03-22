package edu.cnm.deepdive.mathmurdermystery.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import edu.cnm.deepdive.mathmurdermystery.R;

public abstract class LinkedFragment extends Fragment {


  protected void loadHomeFragment() {
    Fragment fragmentMainScreenFragment = new MainScreenFragment();

    FragmentManager manager = getFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentMainScreenFragment,
        fragmentMainScreenFragment.getClass().getSimpleName());
    transaction.addToBackStack("Main Menu");
    transaction.commit();
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


  protected void loadLevelFragment() {
    Fragment fragmentLevelFragment = new LevelFragment();

    FragmentManager manager = getFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentLevelFragment,
        fragmentLevelFragment.getClass().getSimpleName());
    transaction.addToBackStack("Level");
    transaction.commit();
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


  protected void loadProblemFragment() {
    Fragment fragmentProblemFragment = new ProblemFragment();

    FragmentManager manager = getFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentProblemFragment,
        fragmentProblemFragment.getClass().getSimpleName());
    transaction.addToBackStack("Problems");
    transaction.commit();
  }
}

