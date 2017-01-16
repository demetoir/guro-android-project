package me.demetoir.frame_with_picture;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    boolean pictureMode = false;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        final ImageView imageView = (ImageView) view.findViewById(R.id.happy_frog_image);
        final Drawable happy_frog  = getResources().getDrawable(R.drawable.happy_frog);
        final Drawable sad_frog = getResources().getDrawable(R.drawable.sad_frog);
        imageView.setImageDrawable(happy_frog);

        pictureMode = false;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pictureMode){
                    imageView.setImageDrawable(happy_frog);
                    pictureMode = false;
                }
                else{
                    imageView.setImageDrawable(sad_frog);
                    pictureMode = true;
                }
            }
        });


        return view;
    }

}
