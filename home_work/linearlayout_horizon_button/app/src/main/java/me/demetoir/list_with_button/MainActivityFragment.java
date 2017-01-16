package me.demetoir.list_with_button;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

//    public void buttonClicked(View view){
//        TextView textView = (TextView) view;
//        String strBntNumber = (String) textView.getText();
//        Toast.makeText(getActivity(), strBntNumber, Toast.LENGTH_SHORT).show();
//    }
}
