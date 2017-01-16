package me.demetoir.table_calculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {
    final int[] bntIdList = {
            R.id.button_0,
            R.id.button_1,
            R.id.button_2,
            R.id.button_3,
            R.id.button_4,
            R.id.button_5,
            R.id.button_6,
            R.id.button_7,
            R.id.button_8,
            R.id.button_9,
            R.id.button_plus,
            R.id.button_minus,
            R.id.button_multiple,
            R.id.button_divide,
            R.id.button_equal};

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        for (int i = 0; i < bntIdList.length; i++) {
            Button bnt = (Button) rootView.findViewById(bntIdList[i]);
            bnt.setOnClickListener(this);
        }

        return rootView;
    }

    @Override
    public void onClick(View v) {
        TextView textView = (TextView) getView().findViewById(R.id.text_view);
        String strTextView = (String) textView.getText();
        switch (v.getId()) {
            case R.id.button_0:
                strTextView += "0";
                break;
            case R.id.button_1:
                strTextView += "1";
                break;
            case R.id.button_2:
                strTextView += "2";
                break;
            case R.id.button_3:
                strTextView += "3";
                break;
            case R.id.button_4:
                strTextView += "4";
                break;
            case R.id.button_5:
                strTextView += "5";
                break;
            case R.id.button_6:
                strTextView += "6";
                break;
            case R.id.button_7:
                strTextView += "7";
                break;
            case R.id.button_8:
                strTextView += "8";
                break;
            case R.id.button_9:
                strTextView += "9";
                break;
            case R.id.button_plus:
                strTextView += "+";
                break;
            case R.id.button_minus:
                strTextView += "-";
                break;
            case R.id.button_multiple:
                strTextView += "*";
                break;
            case R.id.button_divide:
                strTextView += "/";
                break;
            case R.id.button_equal:
                strTextView += "=";
                break;
        }
        textView.setText(strTextView);
    }
}
