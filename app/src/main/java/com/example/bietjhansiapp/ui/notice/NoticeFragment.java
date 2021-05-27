package com.example.bietjhansiapp.ui.notice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.bietjhansiapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class NoticeFragment extends Fragment {
    private RecyclerView noticeRV;
    private ProgressBar progressBar;
    private ArrayList<NoticeData> list;
    private NoticeAdapter adapter;

    private DatabaseReference databaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_notice, container, false);

        noticeRV=view.findViewById(R.id.NoticeRV);
        progressBar=view.findViewById(R.id.noticeProgressBar);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Notice");

        noticeRV.setLayoutManager(new LinearLayoutManager(getContext()));
        noticeRV.setHasFixedSize(true);

        getNotice();

        return view;
    }

    private void getNotice() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list=new ArrayList<>();
                for(DataSnapshot ds:snapshot.getChildren())
                {
                    NoticeData data=ds.getValue(NoticeData.class);
                    // sorted data by time
                    list.add(0,data);
                }

                adapter=new NoticeAdapter(getContext(),list);
                adapter.notifyDataSetChanged();

                progressBar.setVisibility(View.GONE);

                noticeRV.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}