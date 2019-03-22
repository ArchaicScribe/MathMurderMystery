package edu.cnm.deepdive.mathmurdermystery.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import edu.cnm.deepdive.android.BaseFluentAsyncTask.ResultListener;
import edu.cnm.deepdive.mathmurdermystery.R;
import edu.cnm.deepdive.mathmurdermystery.model.MathMurderMysteryDB.LoadQuestionTask;
import edu.cnm.deepdive.mathmurdermystery.model.entity.MathProblem;

public class QuestionsFragment extends LinkedFragment {

  private Button buttonAnswer1;
  private Button buttonAnswer2;
  private Button buttonAnswer3;
  private Button buttonAnswer4;





  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.questions_fragment, container, false);

    new LoadQuestionTask().setSuccessListener(new ResultListener<MathProblem>() {
      @Override
      public void handle(MathProblem mathProblem) {
        //if (mathProblem.getIncorrectAnswers().size())
      }
    });

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


