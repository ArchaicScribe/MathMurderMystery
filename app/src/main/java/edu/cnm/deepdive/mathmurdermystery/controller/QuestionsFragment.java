package edu.cnm.deepdive.mathmurdermystery.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import edu.cnm.deepdive.android.BaseFluentAsyncTask.ResultListener;
import edu.cnm.deepdive.mathmurdermystery.R;
import edu.cnm.deepdive.mathmurdermystery.model.MathMurderMysteryDB.GetQuestionTask;
import edu.cnm.deepdive.mathmurdermystery.model.MathMurderMysteryDB.LoadQuestionTask;
import edu.cnm.deepdive.mathmurdermystery.model.entity.MathProblem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionsFragment extends LinkedFragment {

  /**
   * This will create four new buttons for the multiple choice questions.
   */
  private Button buttonAnswer1;
  private Button buttonAnswer2;
  private Button buttonAnswer3;
  private Button buttonAnswer4;


  /**
   * Creates a new view, loads the questionFragment but will also add a new Task.
   * @param inflater
   * @param container
   * @param savedInstanceState
   * @return
   */
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.questions_fragment, container, false);

    /**
     * This Task will give a new mathProblem.
     */
    new LoadQuestionTask().setSuccessListener(new ResultListener<MathProblem>() {
      @Override
      public void handle(MathProblem mathProblem) {
        String value = "true";
        String value1 = "12";
        String value2 = "15.3";

        Boolean val = Boolean.valueOf(value);

        //if (mathProblem.getIncorrectAnswers().size())
      }
    });

    /**
     * Adds a new button, will load the RoomFragment for each one of the buttons.
     */
    buttonAnswer1 = (Button) view.findViewById(R.id.button_answer_1);
    buttonAnswer1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        loadRoomFragment();
      }

    });
    buttonAnswer2 = (Button) view.findViewById(R.id.button_answer_2);
    buttonAnswer2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        loadRoomFragment();
      }

    });
    buttonAnswer3 = (Button) view.findViewById(R.id.button_answer_3);
    buttonAnswer3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        loadRoomFragment();
      }

    });
    buttonAnswer4 = (Button) view.findViewById(R.id.button_answer_4);
    buttonAnswer4.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        loadRoomFragment();
      }

    });
    return view;
  }


}


