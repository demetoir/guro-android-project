package me.demetoir.quiz_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    ArrayList<Quiz> quizList;
    TextView problemTextView;
    Button btn_next;
    Button btn_prev;
    int problemIndex;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ProblemAdd();

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        problemTextView = (TextView) rootView.findViewById(R.id.fragment_quiz_text_view);
        problemIndex = 0;
        ProblemUpdate();

        btn_next = (Button) rootView.findViewById(R.id.fragment_button_next_quiz);
        btn_next.setOnClickListener(onClick);

        btn_prev = (Button) rootView.findViewById(R.id.fragment_button_prev_quiz);
        btn_prev.setOnClickListener(onClick);
        return rootView;
    }

    void ProblemAdd() {
        quizList = new ArrayList<>();
        quizList.add(new Quiz(R.string.quiz_text1, true));
        quizList.add(new Quiz(R.string.quiz_text2, true));
        quizList.add(new Quiz(R.string.quiz_text3, true));
        quizList.add(new Quiz(R.string.quiz_text4, true));
        quizList.add(new Quiz(R.string.quiz_text5, true));
        quizList.add(new Quiz(R.string.quiz_text6, true));
        quizList.add(new Quiz(R.string.quiz_text7, true));
        quizList.add(new Quiz(R.string.quiz_text8, true));
        quizList.add(new Quiz(R.string.quiz_text9, true));
        quizList.add(new Quiz(R.string.quiz_text10, true));
    }


    //화면 내용을 변경
    void ProblemUpdate() {
        //새로운 내용의 text의 id를 전달해서 화면 내용 갱신
        problemTextView.setText(quizList.get(problemIndex).getProblemResId());
    }


    //string 리소스를 접근,관리해야한다??
    //mvc 모델?
    View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int viewId = view.getId();
            //Toast.makeText(getActivity(), ((Button) view).getText(), Toast.LENGTH_SHORT).show();
            switch (viewId){
                case R.id.fragment_button_next_quiz:
                    break;
                case R.id.fragment_button_prev_quiz:
                    break;
            }
        }
    };

}
