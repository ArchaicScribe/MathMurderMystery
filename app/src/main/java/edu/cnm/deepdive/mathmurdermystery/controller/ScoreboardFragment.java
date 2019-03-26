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


  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.scoreboard_fragment, container, false);
    return (view);
  }

  private Button backButton;

  private List<UserInformation> scores;

  private HistoryAdapter adapter;


  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,

      @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.scoreboard_fragment, container, false);

    ListView listView = view.findViewById(R.id.list_history);
    //listView.setOnItemClickListener(this);

    scores = new LinkedList<>();

    adapter = new HistoryAdapter(getContext(), scores);
    listView.setAdapter(adapter);

    new ScoreQueryTask().execute();
    return view;
  }

  private class ScoreQueryTask extends AsyncTask<Void, Void, List<UserInformation>> {

    @Override
    protected void onPostExecute(List<UserInformation> consumptions) {
      scores.clear();
      scores.addAll(consumptions);
      adapter.notifyDataSetChanged();
    }

    @Override
    protected List<UserInformation> doInBackground(Void... voids) {
      return MathMurderMysteryDB.getInstance().getUserInformation();
    }
  }
}
