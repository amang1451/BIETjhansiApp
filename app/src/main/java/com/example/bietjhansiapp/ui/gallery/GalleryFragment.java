package com.example.bietjhansiapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bietjhansiapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {

    private RecyclerView convocationRV,independenceRV,otherRV;

    private GalleryAdapter adapter;

    private DatabaseReference databaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        convocationRV=view.findViewById(R.id.convocationRecycler);
        independenceRV=view.findViewById(R.id.independenceRecycler);
        otherRV=view.findViewById(R.id.otherRecycler);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("gallery");

        getConvocationImages();
        getIndependenceImages();
        getOtherImages();
        

        return view;
    }

    private void getOtherImages() {
        databaseReference.child("Other Events").addValueEventListener(new ValueEventListener() {

                List<String> imagesList= new ArrayList<>();

                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot ds:snapshot.getChildren())
                    {
                        String data= (String) ds.getValue();
                        imagesList.add(data);
                    }
                    adapter=new GalleryAdapter(getContext(),imagesList);
                    otherRV.setLayoutManager(new GridLayoutManager(getContext(),3));
                    otherRV.setAdapter(adapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
    }

    private void getIndependenceImages() {
        databaseReference.child("Independence Day").addValueEventListener(new ValueEventListener() {

                List<String> imagesList= new ArrayList<>();

                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot ds:snapshot.getChildren())
                    {
                        String data= (String) ds.getValue();
                        imagesList.add(data);
                    }
                    adapter=new GalleryAdapter(getContext(),imagesList);
                    independenceRV.setLayoutManager(new GridLayoutManager(getContext(),3));
                    independenceRV.setAdapter(adapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
    }

    private void getConvocationImages() {
        databaseReference.child("Convocation").addValueEventListener(new ValueEventListener() {

             List<String> imagesList= new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren())
                {
                    String data= (String) ds.getValue();
                    imagesList.add(data);
                }
                adapter=new GalleryAdapter(getContext(),imagesList);
                convocationRV.setLayoutManager(new GridLayoutManager(getContext(),3));
                convocationRV.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}