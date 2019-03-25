package edu.cnm.deepdive.mathmurdermystery.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import edu.cnm.deepdive.android.BaseFluentAsyncTask.ResultListener;
import edu.cnm.deepdive.mathmurdermystery.R;
import edu.cnm.deepdive.mathmurdermystery.model.MathMurderMysteryDB.GetQuestionTask;
import edu.cnm.deepdive.mathmurdermystery.model.entity.MathProblem;
import edu.cnm.deepdive.mathmurdermystery.model.entity.MathProblem.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameFragment extends LinkedFragment {

  private View view;

  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.game_fragment, container, false);
    randomQuestions();
    return view;

  }

  public void randomQuestions() {
    new GetQuestionTask().setSuccessListener(new ResultListener<MathProblem>() {
      @Override
      public void handle(MathProblem mathProblem) {
        final String correctAnswer;
        List<String> incorrectAnswer;
        TextView question = view.findViewById(R.id.question);
        question.setText(mathProblem.getQuestions());

        correctAnswer = mathProblem.getCorrectAnswer();
        incorrectAnswer = mathProblem.getIncorrectAnswers();

        final List<String> allAnswers = new ArrayList<>(incorrectAnswer);
        allAnswers.add(correctAnswer);
        Collections.shuffle(allAnswers);

        ViewStub stub;
        if (mathProblem.getType() == Type.BOOLEAN) {
          stub = view.findViewById(R.id.bool_question);
        } else {
          stub = view.findViewById(R.id.mc_question);
        }
        View inflated = stub.inflate();
        if (mathProblem.getType() == Type.MULTIPLE) {
          Button[] buttons = new Button[4];
          buttons[0] = inflated.findViewById(R.id.choice1);
          buttons[1] = inflated.findViewById(R.id.choice2);
          buttons[2] = inflated.findViewById(R.id.choice3);
          buttons[3] = inflated.findViewById(R.id.choice4);
          for (int i = 0; i < allAnswers.size(); i++) {
            buttons[i].setText(allAnswers.get(i));
            final int finalI = i;
            buttons[i].setOnClickListener(new OnClickListener() {
              @Override
              public void onClick(View view) {
                if (allAnswers.get(finalI).equals(correctAnswer)) {
                  Toast.makeText(getActivity(), "Correct Answer!", Toast.LENGTH_SHORT).show();
                } else {
                  Toast.makeText(getActivity(), "Incorrect Answer", Toast.LENGTH_SHORT).show();
                }
              }
            });
          }
        } else {
          Button buttonT = inflated.findViewById(R.id.true_button);
          Button buttonF = inflated.findViewById(R.id.false_button);
          Button correct = mathProblem.isOutcome() ? buttonT : buttonF;
          Button incorrect = mathProblem.isOutcome() ? buttonF : buttonT;
          correct.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
              Toast.makeText(getActivity(), "Correct Answer", Toast.LENGTH_SHORT).show();
            }
          });
          incorrect.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
              Toast.makeText(getActivity(), "Incorrect Answer", Toast.LENGTH_SHORT).show();
            }
          });
        }


      }

    }).execute();


  }


}

