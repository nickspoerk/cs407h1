package com.commonsware.android.homework1;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChoiceFragment extends Fragment {

    private int score;

    public ChoiceFragment() {
        // Required empty public constructor
    }

    public static ChoiceFragment newInstance(int score) {
        ChoiceFragment frag = new ChoiceFragment();

        Bundle args = new Bundle();
        args.putInt("score", score);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.choice_fragment_layout, container, false);

        final RadioButton choice1 = (RadioButton) view.findViewById(R.id.choice1);
        final RadioButton choice2 = (RadioButton) view.findViewById(R.id.choice2);
        final RadioButton choice3 = (RadioButton) view.findViewById(R.id.choice3);
        final RadioButton choice4 = (RadioButton) view.findViewById(R.id.choice4);
        final RadioButton choice5 = (RadioButton) view.findViewById(R.id.choice5);

        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        choice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        choice5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        Button next = (Button) view.findViewById(R.id.submitChoice);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choice1.isChecked() && !choice2.isChecked() && !choice3.isChecked()
                        && !choice4.isChecked() && !choice5.isChecked()) {
                    score++;
                }
                ((MainActivity)getActivity()).doQuiz(3, score);
            }
        });

        return view;
    }

}
