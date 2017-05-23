package avalond.note


import android.annotation.SuppressLint
import android.app.Fragment
import android.app.FragmentTransaction
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import avalond.note.fragment.PhoneFragment
import avalond.note.fragment.EmailFragment
import avalond.note.fragment.UserFragment

class MainActivity : AppCompatActivity() {

    private var navigationView: BottomNavigationView? = null

    private var mRestrantFragment: Fragment? = null
    private var mOrderFragment: Fragment? = null
    private var mUserFragment: Fragment? = null

    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val types = intent.getIntExtra(ConstantType.CONSTANT_TYPE_NAME, 0)

        // mRecyclerView.addItemDecoration(new DividerItemDecoration(this, mLayoutManager.getOrientation()));
        navigationView = findViewById(R.id.navigationss) as BottomNavigationView
        switchToFragment(BOTTOM_ITEM_TITLE_RESTRANT_INDEX)


        navigationView!!.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.restrant -> switchToFragment(BOTTOM_ITEM_TITLE_RESTRANT_INDEX)
                R.id.order -> switchToFragment(BOTTOM_ITEM_TITLE_ORDER_INDEX)
                R.id.user -> switchToFragment(BOTTOM_ITEM_TITLE_USER_INDEX)
                else -> {
                }
            }
            false
        }

    }


    private fun switchToFragment(index: Int) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        hideFragments(fragmentTransaction)
        when (index) {
            BOTTOM_ITEM_TITLE_RESTRANT_INDEX -> if (mRestrantFragment == null) {
                mRestrantFragment = EmailFragment.newInstance()
                fragmentTransaction.add(R.id.fragmentContainer, mRestrantFragment)
            } else {
                fragmentTransaction.show(mRestrantFragment)
            }
            BOTTOM_ITEM_TITLE_ORDER_INDEX -> if (mOrderFragment == null) {
                mOrderFragment = PhoneFragment.newInstance()
                fragmentTransaction.add(R.id.fragmentContainer, mOrderFragment)
            } else {
                fragmentTransaction.show(mOrderFragment)
            }
            BOTTOM_ITEM_TITLE_USER_INDEX -> if (mUserFragment == null) {
                mUserFragment = UserFragment.newInstance()
                fragmentTransaction.add(R.id.fragmentContainer, mUserFragment)
            } else {
                fragmentTransaction.show(mUserFragment)
            }
            else -> {
            }
        }
        fragmentTransaction.commit()
    }

    private fun hideFragments(transaction: FragmentTransaction) {
        if (mRestrantFragment != null) {
            transaction.hide(mRestrantFragment)
        }
        if (mOrderFragment != null) {
            transaction.hide(mOrderFragment)
        }
        if (mUserFragment != null) {
            transaction.hide(mUserFragment)
        }
    }

    companion object {

        val TAG = MainActivity::class.java.simpleName

        private val BOTTOM_ITEM_TITLE_RESTRANT_INDEX = 0
        private val BOTTOM_ITEM_TITLE_ORDER_INDEX = 1
        private val BOTTOM_ITEM_TITLE_USER_INDEX = 2
    }
}
//
