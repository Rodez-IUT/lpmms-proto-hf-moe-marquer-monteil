package com.iutrodez.apy1000.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.iutrodez.apy1000.R;
import com.iutrodez.apy1000.commande.CommanderActivity;

public class HomeFragment extends Fragment {

    private ViewFlipper slider;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        slider = root.findViewById(R.id.slider);
        int[] images = {R.drawable.slider_1,R.drawable.slider_2,R.drawable.slider_3};

        for (int image : images){
            sliderImages(image);
        }

        Button commander = root.findViewById(R.id.btn_commander);
        commander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CommanderActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }

    /**
     * Rajoute les images dans le slider
     * @param image L'id de l'image a ajouter
     */
    public void sliderImages(int image){
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(image);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        slider.addView(imageView);
        slider.setFlipInterval(4000); // 4 secondes
        slider.setAutoStart(true);

        // Animations
        slider.setInAnimation(getActivity(),android.R.anim.slide_in_left);
        slider.setOutAnimation(getActivity(),android.R.anim.slide_out_right);
    }
}
