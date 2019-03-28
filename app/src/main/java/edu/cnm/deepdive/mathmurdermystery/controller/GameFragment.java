package edu.cnm.deepdive.mathmurdermystery.controller;
/**
 *  @author Alex Rauenzahn
 *  @version 1.0
 */

import android.os.AsyncTask;
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

/**
 * GameFragment extends {@link LinkedFragment}, which is the superclass for all of my fragments.
 */
public class GameFragment extends LinkedFragment {

  private View view;

  /**
   * This view will inflate the game_fragment, and bring up the randomQuestions() method.
   *
   * @param inflater Inflates the {@link GameFragment}
   * @return Returns view.
   */
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.game_fragment, container, false);
    randomQuestions();
    return view;

  }

  /**
   * This method will handle the random questions, correct and incorrect answers as well. Along with
   * randomizing the questions, it will decide what the type of question is, bool or multiple) and
   * that will dictate how many buttons will appear. The buttons will be added in as well and will
   * wait for the user to make their selection.
   */
  public void randomQuestions() {
    new GetQuestionTask().setSuccessListener(new ResultListener<MathProblem>() {
      @Override
      public void handle(MathProblem mathProblem) {
        final String correctAnswer;
        List<String> incorrectAnswer;
        TextView question = view.findViewById(R.id.question);
        question.setText(mathProblem.getQuestion());

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
              /**
               * This onClick method is for displaying a toast on whether the user answered the question
               * correctly or incorrectly. This is for the multiple choice questions portion.
               * @param view This view is returned, which is the toast.
               */
              @Override
              public void onClick(View view) {
                if (allAnswers.get(finalI).equals(correctAnswer)) {
                  Toast.makeText(getActivity(), "Correct Answer!", Toast.LENGTH_SHORT).show();
                  new ProceedAfterDelay().execute();
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
            /**
             * This onClick will display a toast, correct or incorrect, and then will have a {@link ProceedAfterDelay}
             * @param view This returns the view/toast to the user.
             */
            @Override
            public void onClick(View view) {
              Toast.makeText(getActivity(), "Correct Answer", Toast.LENGTH_SHORT).show();
              new ProceedAfterDelay().execute();
            }
          });
          incorrect.setOnClickListener(new OnClickListener() {
            /**
             * This displays the onClick toast for incorrect answers.
             * @param view
             */
            @Override
            public void onClick(View view) {
              Toast.makeText(getActivity(), "Incorrect Answer", Toast.LENGTH_SHORT).show();
            }
          });
        }


      }

    }).execute();


  }

  private class ProceedAfterDelay extends AsyncTask<Void, Void, Void> {

    /**
     * This will load the {@link ProblemFragment} which holds all of the problems.
     */
    @Override
    protected void onPostExecute(Void aVoid) {
      loadProblemFragment();
    }

    /**
     * The doInBackground will delay the thread from continuing and return the user back to the
     * {@link ProblemFragment}
     */
    @Override
    protected Void doInBackground(Void... voids) {
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        //DO NOTHING!
      }
      return null;
    }
  }

}

