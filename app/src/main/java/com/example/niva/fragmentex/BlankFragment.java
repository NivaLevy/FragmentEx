package com.example.niva.fragmentex;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class BlankFragment extends Fragment {
    private final String TAG = getClass().getSimpleName();

    private  View view;


    public BlankFragment() {
        // Required empty public constructor
    }


    private MainInterface mMainInterface;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG, "onAttach - Context");

        try {

            mMainInterface = (MainInterface) context;

        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement mMainInterface");
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_blank, container, false);

        Log.e(TAG, "onCreateView");

        mMainInterface.changeButtonTitle("New Button Title");

        return view;
    }

}
