package edu.cnm.deepdive.mathmurdermystery.controller;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import edu.cnm.deepdive.mathmurdermystery.R;
import edu.cnm.deepdive.mathmurdermystery.model.MathMurderMysteryDB;
import edu.cnm.deepdive.mathmurdermystery.model.entity.UserInformation;
import edu.cnm.deepdive.mathmurdermystery.view.HistoryAdapter;
import edu.cnm.deepdive.mathmurdermystery.model.dao.UserInformationDao;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *  @author Alex Rauenzahn
 *  @version 1.0
 */



public abstract class LinkedFragment extends Fragment {

  private List<UserInformation> scores;
  private HistoryAdapter adapter;

  /**
   * This will load the Home Fragment. From the {@link android.support.v4.app.FragmentContainer}.
   * This will be the super class for all of my other fragments. Even though this will be the super
   * and call upon the other fragments, it does not alter the others in any way.
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

  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,

      @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.scoreboard_history_fragment, container, false);

    ListView listView = view.findViewById(R.id.list_history);
//    ViewGroup header = (ViewGroup) inflater.inflate(R.layout.header, listView,
//        false);
//    ViewGroup categories = (ViewGroup) inflater.inflate(R.layout.categories, listView,
//        false);
//    listView.addHeaderView(header, null, false);
//    listView.addHeaderView(categories, null, false);

    scores = new LinkedList<>();

    adapter = new HistoryAdapter(Objects.requireNonNull(getContext()), scores);
    listView.setAdapter(adapter);

    new ScoreQueryTask().execute();
    return view;
  }


  @SuppressLint("StaticFieldLeak")
  private class ScoreQueryTask extends AsyncTask<Void, Void, List<UserInformation>> {

    @Override
    protected void onPostExecute(List<UserInformation> consumptions) {
      scores.clear();
      scores.addAll(consumptions);
      adapter.notifyDataSetChanged();
    }

    @Override
    protected List<UserInformation> doInBackground(Void... voids) {
      return MathMurderMysteryDB.getInstance().getUserInformationDao().getUserInfo();
    }


  }

}
