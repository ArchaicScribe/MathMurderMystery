package edu.cnm.deepdive.mathmurdermystery.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import edu.cnm.deepdive.mathmurdermystery.R;

public abstract class LinkedFragment extends Fragment {

  /**
   * This will load the Home Fragment. From the fragment container.
   */
  protected void loadHomeFragment() {
    Fragment fragmentMainScreenFragment = new MainScreenFragment();

    FragmentManager manager = getFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentMainScreenFragment,
        fragmentMainScreenFragment.getClass().getSimpleName());
    transaction.addToBackStack("Main Menu");
    transaction.commit();
  }

  /**
   * This will load the scenario fragment. From the fragment container.Then add it to the backstack.
   * This allows the end-user to use the back button to revert.
   */
  protected void loadScenarioFragment() {
    Fragment fragmentScenarioScreenFragment = new ScenarioFragment();

    FragmentManager manager = getFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentScenarioScreenFragment,
        fragmentScenarioScreenFragment.getClass().getSimpleName());
    transaction.addToBackStack("scenario");
    transaction.commit();
  }

  /**
   * This will load the level fragment. From the fragment container. Then add it to the backstack.
   * This allows the end-user to use the back button to revert.
   */
  protected void loadLevelFragment() {
    Fragment fragmentLevelFragment = new LevelFragment();

    FragmentManager manager = getFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentLevelFragment,
        fragmentLevelFragment.getClass().getSimpleName());
    transaction.addToBackStack("Level");
    transaction.commit();
  }


  /**
   * This will load the Room Fragment, From the fragment container.Then add it to the backstack.
   * This allows the end-user to use the back button to revert.
   */
  protected void loadRoomFragment() {
    Fragment fragmentRoomFragment = new RoomEntityFragment();

    FragmentManager manager = getFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentRoomFragment,
        fragmentRoomFragment.getClass().getSimpleName());
    transaction.addToBackStack("Room");
    transaction.commit();
  }


  /**
   * This will load the problem fragment from the fragment container, add to the backstack and
   * commit it to the backstack.
   */
  protected void loadProblemFragment() {
    Fragment fragmentProblemFragment = new ProblemFragment();

    FragmentManager manager = getFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentProblemFragment,
        fragmentProblemFragment.getClass().getSimpleName());
    transaction.addToBackStack("Problems");
    transaction.commit();
  }

  /**
   * Loads the game fragment, from the fragment container, adds to the backstack, and commits it.
   */
  protected void loadGameFragment() {
    Fragment fragmentGameFragment = new GameFragment();

    FragmentManager manager = getFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentGameFragment,
        fragmentGameFragment.getClass().getSimpleName());
    transaction.addToBackStack("Questions");
    transaction.commit();
  }
}
