package edu.cnm.deepdive.mathmurdermystery.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import edu.cnm.deepdive.mathmurdermystery.R;
import edu.cnm.deepdive.mathmurdermystery.model.entity.UserInformation;
import java.text.DateFormat;
import java.util.List;

public class HistoryAdapter extends ArrayAdapter<UserInformation> {

  DateFormat dateFormat;
  String scoreFormat;

  public HistoryAdapter(@NonNull Context context, List<UserInformation> items) {
    super(context, R.layout.scoreboard_fragment, items);
    dateFormat = android.text.format.DateFormat.getDateFormat(context);
    scoreFormat = context.getString(R.string.scoreboard_welcome);
  }


  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    View view = (convertView != null) ? convertView
        : LayoutInflater.from(getContext()).inflate(R.layout.scoreboard_fragment, parent, false);
    UserInformation userInformation = getItem(position);
    TextView date = view.findViewById(R.id.date);
    TextView score = view.findViewById(R.id.score);
    date.setText(dateFormat.format(userInformation.getTime().getTime()));
    score.setText(String.format(scoreFormat, userInformation.getScore()));

    return view;
  }

}