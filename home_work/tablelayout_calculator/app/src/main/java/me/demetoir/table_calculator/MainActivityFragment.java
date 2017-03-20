package me.demetoir.table_calculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import me.hoyuo.calculatorengine.CalculatorEngine;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private final String LOG_TAG = MainActivity.class.getSimpleName();

    //엔진사용해서..
    private CalculatorEngine mCalculatorEngine;
    private TextView mTextView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        setAllBtnClickListener(rootView);

        mTextView = (TextView) rootView.findViewById(R.id.text_view);

        mCalculatorEngine = new CalculatorEngine();
        mCalculatorEngine.initialize();

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    View.OnClickListener btnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            String clickedBtnText = btn.getText().toString();
            mCalculatorEngine.Enter(clickedBtnText);

            int btnId = btn.getId();
            if (btnId == R.id.button_equal) {
                double dResult = mCalculatorEngine.numberToDisplay();
                updateCalculator(dResult);
            } else if (btnId == R.id.button_clear) {
                mTextView.setText("");
            }
        }
    };

    View.OnClickListener numberBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            String clickedBtnText = btn.getText().toString();
            mCalculatorEngine.Enter(clickedBtnText);
            mTextView.append(clickedBtnText);
        }
    };

    View.OnClickListener operatorBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            String clickedBtnText = btn.getText().toString();
            mCalculatorEngine.Enter(clickedBtnText);
            mTextView.append(clickedBtnText);
        }
    };

    View.OnClickListener clearBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            String clickedBtnText = btn.getText().toString();
            mCalculatorEngine.Enter(clickedBtnText);
            mTextView.setText("");
        }
    };

    View.OnClickListener eqaulBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            String clickedBtnText = btn.getText().toString();
            mCalculatorEngine.Enter(clickedBtnText);
            double dResult = mCalculatorEngine.numberToDisplay();
            updateCalculator(dResult);
        }
    };

    private void setAllBtnClickListener(View rootView) {
        Button btn;
        //버튼 별로 리스너를 따로만들어서 처리
        //this 말고 리스너로

        // 숫자 0 ~ 9
        btn = (Button) rootView.findViewById(R.id.button_0);
        btn.setOnClickListener(numberBtnClickListener);
        btn = (Button) rootView.findViewById(R.id.button_1);
        btn.setOnClickListener(numberBtnClickListener);
        btn = (Button) rootView.findViewById(R.id.button_2);
        btn.setOnClickListener(numberBtnClickListener);
        btn = (Button) rootView.findViewById(R.id.button_3);
        btn.setOnClickListener(numberBtnClickListener);
        btn = (Button) rootView.findViewById(R.id.button_4);
        btn.setOnClickListener(numberBtnClickListener);
        btn = (Button) rootView.findViewById(R.id.button_5);
        btn.setOnClickListener(numberBtnClickListener);
        btn = (Button) rootView.findViewById(R.id.button_6);
        btn.setOnClickListener(numberBtnClickListener);
        btn = (Button) rootView.findViewById(R.id.button_7);
        btn.setOnClickListener(numberBtnClickListener);
        btn = (Button) rootView.findViewById(R.id.button_8);
        btn.setOnClickListener(numberBtnClickListener);
        btn = (Button) rootView.findViewById(R.id.button_9);
        btn.setOnClickListener(numberBtnClickListener);

        // 연산 기호 + - * /
        btn = (Button) rootView.findViewById(R.id.button_plus);
        btn.setOnClickListener(operatorBtnClickListener);
        btn = (Button) rootView.findViewById(R.id.button_minus);
        btn.setOnClickListener(operatorBtnClickListener);
        btn = (Button) rootView.findViewById(R.id.button_multiple);
        btn.setOnClickListener(operatorBtnClickListener);
        btn = (Button) rootView.findViewById(R.id.button_divide);
        btn.setOnClickListener(operatorBtnClickListener);

        // =
        btn = (Button) rootView.findViewById(R.id.button_equal);
        btn.setOnClickListener(eqaulBtnClickListener);

        // c 지우기
        btn = (Button) rootView.findViewById(R.id.button_clear);
        btn.setOnClickListener(clearBtnClickListener);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mCalculatorEngine.Enter(getResources().getString(R.string.button_equal));
        double result = mCalculatorEngine.numberToDisplay();

        int id = item.getItemId();
        if (id == R.id.action_pi) {
            updateCalculator(Math.PI);
            return true;
        } else if (id == R.id.action_sin) {
            updateCalculator(Math.sin(result));
            return true;
        } else if (id == R.id.action_cos) {
            updateCalculator(Math.cos(result));
            return true;
        } else if (id == R.id.action_tan) {
            updateCalculator(Math.tan(result));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void updateCalculator(double value) {
        mCalculatorEngine.setDisplay(value);

        String strTanValue = Double.toString(value);
        mTextView.setText(strTanValue);
    }
}
