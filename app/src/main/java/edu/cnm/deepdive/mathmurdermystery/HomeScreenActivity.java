package edu.cnm.deepdive.mathmurdermystery;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import edu.cnm.deepdive.mathmurdermystery.controller.MainScreenFragment;
import edu.cnm.deepdive.mathmurdermystery.controller.PlayFragment;
import edu.cnm.deepdive.mathmurdermystery.controller.ScoreboardFragment;
import edu.cnm.deepdive.mathmurdermystery.model.MathMurderMysteryDB;
import edu.cnm.deepdive.mathmurdermystery.model.MathMurderMysteryDB.GetQuestionTask;

public class HomeScreenActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  private Button mainMenuButton;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home_screen);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    toolbar.setTitle("MathMurderMystery");

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);

    loadHomeFragment();
    new GetQuestionTask().execute();

  }

  private void loadHomeFragment() {
    Fragment fragmentMainScreenFragment = new MainScreenFragment();

    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentMainScreenFragment, "home");
    transaction.addToBackStack(null);
    transaction.commit();
  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.home_screen, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }


  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    Bundle args = new Bundle();
    switch (item.getItemId()) {
      case R.id.main_menu_button:
        loadFragment(new MainScreenFragment(), R.id.fragment_container, "mainMenuFragment",
            args);
        break;
      case R.id.play_button:
        loadFragment(new PlayFragment(), R.id.fragment_container, "playFragment", args);
        break;
      case R.id.scroreboard_button:
        loadFragment(new ScoreboardFragment(), R.id.fragment_container, "scoreboardFragment", args);
        break;
//      case R.id.help_button:
//        loadFragment(new HelpFragment(), R.id.fragment_container, "helpFragment", args);
//        break;
    }

    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  public void loadFragment(Fragment fragment, int container, String tag, Bundle args) {
    FragmentManager manager = getSupportFragmentManager();
    if (args != null) {
      fragment.setArguments(args);
    }
    manager.beginTransaction()
        .add(container, fragment, tag)
        .commit();
  }
}
