package me.demetoir.quiz_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class gradeActivityFragment extends Fragment {

    public gradeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_grade, container, false);

        //get value from intent
        Intent i = getActivity().getIntent();
        int result = i.getExtras().getInt(Intent.EXTRA_TEXT);

        //set text in test view
        TextView textView = (TextView) rootView.findViewById(R.id.fragment_grade_text_view);
        textView.setText(Integer.toString(result));

        return rootView;
    }
}
