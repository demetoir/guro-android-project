package me.demetoir.quiz_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Button bnt_O = (Button) rootView.findViewById(R.id.fragment_quiz_answer_O);
        Button bnt_X = (Button) rootView.findViewById(R.id.fragment_quiz_answer_X);
//string 제대로 다 R에서 가져와야함

        bnt_O.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),R.string., Toast.LENGTH_SHORT).show();
            }
        });
        bnt_X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "wrong", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}
