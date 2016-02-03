package com.demo.app4.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.demo.app4.R;
import com.demo.app4.fragment.LM_Fragment;
import com.demo.app4.fragment.PM_Fragment;


public class StoryBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storybook);

        Configuration config = getResources().getConfiguration();

        FragmentManager fragmentManager = getFragmentManager();

        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();

        Fragment fragment = null;

        /**
         * Check the device orientation and act accordingly
         */
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            /**
             * Landscape mode of the device
             */
            fragment = new LM_Fragment();
        }
        else
        {
            /**
             * Portrait mode of the device
             */
            fragment = new PM_Fragment();
        }

        updateFragment(fragment);
    }


    protected void updateFragment(Fragment fragment)
    {
        //    FragmentManager     fm          = getSupportFragmentManager();
        //    FragmentTransaction transaction = fm.beginTransaction();
        //    transaction.replace(R.id.fragment_container, fragment);
        //    transaction.commit();

        replaceFragmentWithAnimation(fragment, "some tag");
    }

    public void replaceFragmentWithAnimation(Fragment fragment, String tag){

        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);

        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(tag);
        transaction.commit();
    }
}
