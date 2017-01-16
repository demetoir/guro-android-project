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

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.happy_frog_image);
        Drawable drawable  = getResources().getDrawable(R.drawable.happy_frog);
        imageView.setImageDrawable(drawable);

        return view;
    }
}
