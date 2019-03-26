package edu.cnm.deepdive.mathmurdermystery;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class HomeScreenActivityTest {

  @Rule
  public ActivityTestRule<HomeScreenActivity> homeScreenActivityActivityTestRule =
      new ActivityTestRule<>(HomeScreenActivity.class);

  @Test
  public void onNavigation() {
    //Clicking on navigation item.
    onView(withId(R.id.main_menu_button)).perform(click());
    onView(withId(R.id.play_button)).perform(click());
    onView(withId(R.id.scroreboard_button)).perform(click());



  }
}