package com.demo.app4.fragment;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.app4.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LM_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(
                R.layout.fragment_landscape_mode,
                container,
                false);
    }


}
