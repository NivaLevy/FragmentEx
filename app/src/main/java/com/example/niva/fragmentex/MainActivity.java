package com.example.niva.fragmentex;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity{

    private Button b1;
    private FrameLayout fragmentContainer;
    private boolean first = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentContainer = (FrameLayout) findViewById(R.id.fragmentContainer);

        b1 = (Button) findViewById(R.id.cmdPress);
        switchFragment(new BlankFragment2());

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (first)
                    switchFragment(new BlankFragment());
                else
                    switchFragment(new BlankFragment2());
                first = !first;

            }
        });



    }

    public void switchFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
                .replace(fragmentContainer.getId(), fragment, "TAG")
                .addToBackStack(null)
                .commit();
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
