package avalond.note.fragment


import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import avalond.note.R

/**
 * @author by kevin.
 */

class EmailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.email, null)
        return rootView
    }

    companion object {

        fun newInstance(): EmailFragment {
            return EmailFragment()
        }
    }
}
