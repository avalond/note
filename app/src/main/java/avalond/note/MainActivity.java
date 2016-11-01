package avalond.note;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import avalond.note.fragment.PhoneFragment;
import avalond.note.fragment.EmailFragment;
import avalond.note.fragment.UserFragment;

public class MainActivity extends AppCompatActivity {

  public static final String TAG = MainActivity.class.getSimpleName();

  private BottomNavigationView navigationView;

  private static final int BOTTOM_ITEM_TITLE_RESTRANT_INDEX = 0;
  private static final int BOTTOM_ITEM_TITLE_ORDER_INDEX = 1;
  private static final int BOTTOM_ITEM_TITLE_USER_INDEX = 2;

  private Fragment mRestrantFragment;
  private Fragment mOrderFragment;
  private Fragment mUserFragment;

  @SuppressLint("CommitTransaction")
  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    int types = getIntent().getIntExtra(ConstantType.CONSTANT_TYPE_NAME, 0);

    // mRecyclerView.addItemDecoration(new DividerItemDecoration(this, mLayoutManager.getOrientation()));
    navigationView = (BottomNavigationView) findViewById(R.id.navigationss);
    switchToFragment(BOTTOM_ITEM_TITLE_RESTRANT_INDEX);


    navigationView.setOnNavigationItemSelectedListener(item -> {

      switch (item.getItemId()) {
        case R.id.restrant:
          switchToFragment(BOTTOM_ITEM_TITLE_RESTRANT_INDEX);
          break;
        case R.id.order:
          switchToFragment(BOTTOM_ITEM_TITLE_ORDER_INDEX);
          break;
        case R.id.user:
          switchToFragment(BOTTOM_ITEM_TITLE_USER_INDEX);
          break;
        default:
          break;
      }
      return false;
    });

  }


  private void switchToFragment(int index) {
    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
    hideFragments(fragmentTransaction);
    switch (index) {
      case BOTTOM_ITEM_TITLE_RESTRANT_INDEX:
        if (mRestrantFragment == null) {
          mRestrantFragment = EmailFragment.newInstance();
          fragmentTransaction.add(R.id.fragmentContainer, mRestrantFragment);
        } else {
          fragmentTransaction.show(mRestrantFragment);
        }
        break;
      case BOTTOM_ITEM_TITLE_ORDER_INDEX:
        if (mOrderFragment == null) {
          mOrderFragment = PhoneFragment.newInstance();
          fragmentTransaction.add(R.id.fragmentContainer, mOrderFragment);
        } else {
          fragmentTransaction.show(mOrderFragment);
        }
        break;
      case BOTTOM_ITEM_TITLE_USER_INDEX:
        if (mUserFragment == null) {
          mUserFragment = UserFragment.newInstance();
          fragmentTransaction.add(R.id.fragmentContainer, mUserFragment);
        } else {
          fragmentTransaction.show(mUserFragment);
        }
        break;
      default:
        break;
    }
    fragmentTransaction.commit();
  }

  private void hideFragments(FragmentTransaction transaction) {
    if (mRestrantFragment != null) {
      transaction.hide(mRestrantFragment);
    }
    if (mOrderFragment != null) {
      transaction.hide(mOrderFragment);
    }
    if (mUserFragment != null) {
      transaction.hide(mUserFragment);
    }
  }
}
//
