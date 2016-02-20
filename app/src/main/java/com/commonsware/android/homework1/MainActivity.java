package com.commonsware.android.homework1;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button startButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button)findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                PictureFragment picFrag = new PictureFragment();
                transaction.add(R.id.fragment_container, picFrag);
                transaction.commit();

                ChoiceFragment choiceFrag = new ChoiceFragment();
                transaction.replace(R.id.fragment_container, choiceFrag);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
    }

}
