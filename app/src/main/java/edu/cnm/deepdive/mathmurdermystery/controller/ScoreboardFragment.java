package edu.cnm.deepdive.mathmurdermystery.controller;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import edu.cnm.deepdive.mathmurdermystery.R;
import edu.cnm.deepdive.mathmurdermystery.model.MathMurderMysteryDB;
import edu.cnm.deepdive.mathmurdermystery.model.entity.UserInformation;
import edu.cnm.deepdive.mathmurdermystery.view.HistoryAdapter;
import java.util.LinkedList;
import java.util.List;

public class ScoreboardFragment extends LinkedFragment {

  private Button backButton;

  private List<UserInformation> scores;

  private HistoryAdapter adapter;

  /**
   * This onCreateView that will inflate the {@link ScoreboardFragment}. Will also present the
   * ListView so that the user is able to see their score.
   *
   * @param inflater Will inflate the {@link ScoreboardFragment}
   * @param container Utilizes the {@link android.support.v4.app.FragmentContainer}
   * @param savedInstanceState Is the name of the Bundle used to keep the fragments in order.
   * @return This returns the view of the fragment.
   */
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,

      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.scoreboard_fragment, container, false);

    ListView listView = view.findViewById(R.id.list_history);

    scores = new LinkedList<>();

    adapter = new HistoryAdapter(getContext(), scores);
    listView.setAdapter(adapter);

    new ScoreQueryTask().execute();
    return view;
  }

  private class ScoreQueryTask extends AsyncTask<Void, Void, List<UserInformation>> {

    /**
     * OnPostExecute will maintain a list of the user's information, i.e. info, score, and progress
     * from the {@link UserInformation} class. It will add new scores and clear each time upon
     * postExecute.
     */
    @Override
    protected void onPostExecute(List<UserInformation> consumptions) {
      scores.clear();
      scores.addAll(consumptions);
      adapter.notifyDataSetChanged();
    }

    /**
     * This doInBackground method will utilize {@link edu.cnm.deepdive.android.BaseFluentAsyncTask}
     * and work on the backend of the thread.
     * @param voids Takes in voids as a return type.
     * @return returns voids.
     */
    @Override
    protected List<UserInformation> doInBackground(Void... voids) {
      return MathMurderMysteryDB.getInstance().getUserInformation().getUserInfo();
    }
  }
}
