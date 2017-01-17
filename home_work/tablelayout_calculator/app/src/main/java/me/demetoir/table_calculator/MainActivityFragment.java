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
    //버튼을 저장하고 id는 관리라지마

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Button bnt = null;

        //숫자
        bnt = (Button) rootView.findViewById(R.id.button_0);
        bnt.setOnClickListener(this);
        bnt = (Button) rootView.findViewById(R.id.button_1);
        bnt.setOnClickListener(this);
        bnt = (Button) rootView.findViewById(R.id.button_2);
        bnt.setOnClickListener(this);
        bnt = (Button) rootView.findViewById(R.id.button_3);
        bnt.setOnClickListener(this);
        bnt = (Button) rootView.findViewById(R.id.button_4);
        bnt.setOnClickListener(this);
        bnt = (Button) rootView.findViewById(R.id.button_5);
        bnt.setOnClickListener(this);
        bnt = (Button) rootView.findViewById(R.id.button_6);
        bnt.setOnClickListener(this);
        bnt = (Button) rootView.findViewById(R.id.button_7);
        bnt.setOnClickListener(this);
        bnt = (Button) rootView.findViewById(R.id.button_8);
        bnt.setOnClickListener(this);
        bnt = (Button) rootView.findViewById(R.id.button_9);
        bnt.setOnClickListener(this);

        //연산기호
        bnt = (Button) rootView.findViewById(R.id.button_plus);
        bnt.setOnClickListener(this);
        bnt = (Button) rootView.findViewById(R.id.button_minus);
        bnt.setOnClickListener(this);
        bnt = (Button) rootView.findViewById(R.id.button_multiple);
        bnt.setOnClickListener(this);
        bnt = (Button) rootView.findViewById(R.id.button_divide);
        bnt.setOnClickListener(this);

        //=
        bnt = (Button) rootView.findViewById(R.id.button_equal);
        bnt.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        //add형으로
        TextView textView = (TextView) getView().findViewById(R.id.text_view);
        //toString 으로
        //강제형변환은 지양하기
        //이미 있는 형으로 해야함
        String strTextView = textView.getText().toString();
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
