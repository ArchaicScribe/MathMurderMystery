package edu.cnm.deepdive.mathmurdermystery.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import edu.cnm.deepdive.mathmurdermystery.R;

public class ProblemFragment extends LinkedFragment {

  /**
   * Creates a new button for problem selection.
   */
  private Button problemSelection;

  /**
   * Method will inflate the problemFragment, returns a menuButton. This will be saved to a Bundle.
   */
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.problem_fragment, container, false);
    return menuButton(view);
  }

  /**
   * This button will go to the new problems and wait for the OnClickListener.
   */
  protected View menuButton(View view) {

    problemSelection = (Button) view.findViewById(R.id.new_go_to_problems);
    problemSelection.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        loadGameFragment();
      }
    });
    return view;
  }


}
