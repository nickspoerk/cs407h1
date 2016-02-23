package com.commonsware.android.homework1;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragment extends Fragment {

    private int score;

    public PictureFragment() {
        // Required empty public constructor
    }

    public static PictureFragment newInstance(int score) {
        PictureFragment frag = new PictureFragment();

        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.picture_fragement_layout, container, false);

        TextView text = (TextView) view.findViewById(R.id.picQuestion);
        final EditText mascot = (EditText) view.findViewById(R.id.editText);
        Button next = (Button) view.findViewById(R.id.submitPic);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = mascot.getText().toString();
                boolean correct;
                correct = (answer.equalsIgnoreCase("Bucky"));
                int score = 0;
                if (correct) {
                    score++;
                }
                ((MainActivity)getActivity()).doQuiz(2, score);
            }
        });
        return view;
    }

}
