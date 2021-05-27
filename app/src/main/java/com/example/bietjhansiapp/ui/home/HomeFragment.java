package com.example.bietjhansiapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.support.v4.os.IResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.bietjhansiapp.R;

import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;



public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;
    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        sliderLayout=view.findViewById(R.id.slider);
        setSliderImage();
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SWAP);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(2);

        map=view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        return view;
    }

    private void openMap() {
        Uri uri=Uri.parse("geo:0, 0?q=Bundelkhand Insitute of Engineering and technology jhansi");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);

    }

    private void setSliderImage() {
        for(int i=1;i<=6;i++)
        {
            DefaultSliderView sliderView=new DefaultSliderView(getContext());
            switch (i){
                case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-baba1.appspot.com/o/slider%2F1.jpg?alt=media&token=9bf89a28-f778-433a-8df9-2fb4879941f2");
                    break;
                case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-baba1.appspot.com/o/slider%2F2.jpg?alt=media&token=6655db7b-ce31-4efe-a3a1-44186971ed6b");
                    break;
                case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-baba1.appspot.com/o/slider%2F3.jpg?alt=media&token=b01781c5-1084-4d8d-a96c-4960c87af7bb");
                    break;
                case 4:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-baba1.appspot.com/o/slider%2F4.jpg?alt=media&token=a962b7f5-bbd2-45f7-9e39-7158a45b16c4");
                    break;
                case 5:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-baba1.appspot.com/o/slider%2F5.jpg?alt=media&token=7b30caa0-2fca-4f0f-a3a3-eb8e9b697b7d");
                    break;
                case 6:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-baba1.appspot.com/o/slider%2F6.jpg?alt=media&token=03d69e14-a2f9-43d4-8948-d09cd9f7ed96");
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.FIT_XY);
            sliderLayout.addSliderView(sliderView);
        }
    }
}