package com.commonsware.android.homework1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
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

                v.setVisibility(View.INVISIBLE);
                doQuiz(1,0);

            }
        });
    }

    public void doQuiz(int option, int correct) {

        Fragment nextFragment;
        int score;

        if (option == 1) {
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            PictureFragment picFrag = new PictureFragment();
            transaction.replace(R.id.fragment_container, picFrag.newInstance(0));
        } else if (option == 2) {
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            ChoiceFragment choiceFrag = new ChoiceFragment();
            transaction.replace(R.id.fragment_container, choiceFrag.newInstance(correct));
        } else if (option == 3) {
            new AlertDialog.Builder(this)
                    .setTitle("Score: " + correct + " out of 2")
                    .setMessage("Play again?")
                    .setPositiveButton("again", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            doQuiz(1, 0);
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            System.exit(0);
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

        }
    }

}
