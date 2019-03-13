package edu.cnm.deepdive.mathmurdermystery.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import edu.cnm.deepdive.mathmurdermystery.R;

public abstract class LinkedFragment extends Fragment {

  private Button mainMenuButton;


  protected void loadHomeFragment() {
    Fragment fragmentMainScreenFragment = new MainScreenFragment();

    FragmentManager manager = getFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentMainScreenFragment, "home");
    transaction.addToBackStack(null);
    transaction.commit();
  }

  protected View linkButton(View view) {
    mainMenuButton = (Button) view.findViewById(R.id.return_to_main_menu);
    mainMenuButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        loadHomeFragment();
      }

    });
    return view;
  }
}
