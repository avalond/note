package avalond.note.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import avalond.note.R;

/**
 * @author by kevin.
 */

public class EmailFragment extends Fragment {
  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.email,null);
    return rootView;
  }

  public static EmailFragment newInstance() {
    return new EmailFragment();
  }
}
