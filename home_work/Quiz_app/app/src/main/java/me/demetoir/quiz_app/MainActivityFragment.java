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
        Button bntO = (Button) rootView.findViewById(R.id.fragment_quiz_answer_O);
        Button bntX = (Button) rootView.findViewById(R.id.fragment_quiz_answer_X);
        Button bntPrev = (Button) rootView.findViewById(R.id.fragment_button_prev_quiz);
        Button bntNext = (Button) rootView.findViewById(R.id.fragment_button_next_quiz);


        bntO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),R.string.button_correct, Toast.LENGTH_SHORT).show();
            }
        });
        bntX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),R.string.button_wrong, Toast.LENGTH_SHORT).show();
            }
        });

        //// 버튼 감추기
        //bnt_O.setVisibility(View.GONE);
        //1번째일때는 나타나지 않아야한다
        bntPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
//        10번째에서는 누르면 다음페이지로 넘어가야함
        bntNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return rootView;
    }

    //string 리소스를 접근,관리해야한다??
    //mvc모델?
    //http://bsnippet.tistory.com/13

    public class Quiz{
        Quiz(){

        }

    }
}
