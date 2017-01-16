package me.demetoir.gridlayout_calindar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import java.util.Calendar;

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
        GridLayout gridLayout = (GridLayout) rootView.findViewById(R.id.fragment_grid_layout);

        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_MONTH);

//        for (int i = 1; i <= maxNumDay; i++) {
//            TextView textView = new TextView(getActivity());
//            textView.setText(Integer.toString(i));
//            textView.setGravity(Gravity.FILL);
//
//            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) textView.getLayoutParams();
//
//            params.weight = 1;
//            textView.setLayoutParams(params);
//            if (i == day) {
//                textView.setBackgroundColor(Color.RED);
//            }
//            gridLayout.addView(textView);
//        }
        return rootView;
    }


}
