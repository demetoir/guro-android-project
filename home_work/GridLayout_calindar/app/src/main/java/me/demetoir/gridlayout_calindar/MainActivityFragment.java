package me.demetoir.gridlayout_calindar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

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

        //그리디 레이아웃 다시
        //날짜 맞추어서 만들기
        //menu button 추가해서 다음월로 변경
        //intent 추가 이런걸...로
        int numRow = 5;
        int numCol = 7;
        final int maxNumDay = 31;
        for (int i = 1; i <= maxNumDay; i++) {
            TextView textView = new TextView(getActivity());
            textView.setText(Integer.toString(i));

            GridLayout.LayoutParams params = new GridLayout.LayoutParams(
                    GridLayout.spec(GridLayout.UNDEFINED, 1f),
                    GridLayout.spec(GridLayout.UNDEFINED, 1f));
            textView.setLayoutParams(params);

            if (i == day)
                textView.setBackgroundColor(Color.RED);

            gridLayout.addView(textView);

        }
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.next_month){
            //그리드 안의 내용 변경
            //원래는 frag 바꾸는거지만
            //일단은 안에 내용만
            //지워서 해보고 안되면 하나씩바꿔서
            GridLayout gridLayout = (GridLayout) getActivity().findViewById(R.id.fragment_grid_layout);

//            gridLayout.

        }
        return super.onOptionsItemSelected(item);
    }

//    String forecast = mForecast.getItem(position);
//    //수신발신정보 설정
//    Intent i = new Intent(getActivity(), DetailActivity.class);
//    //내용 추가 key:value
//    i.putExtra(Intent.EXTRA_TEXT, forecast);
//    //정보 보내기위해 새로운 화면 시작
//    startActivity(i);
}
