package com.example.bietjhansiapp.ui.faculty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.bietjhansiapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FacultyFragment extends Fragment {

    private RecyclerView csDepartment,itDepartment,eceDepartment,eeDepartment,meDepartment,ceDepartment,cheDepartment,
            asDepartment,mbaDepartment;
    private LinearLayout csNoData,itNoData,eceNoData,eeNoData,meNoData,ceNoData,cheNoData,asNoData,mbaNoData;
    private ProgressBar progressBar;
    private ArrayList<FacultyData> list1,list2,list3,list4,list5,list6,list7,list8,list9;

    private DatabaseReference dbcs,dbit,dbece,dbee,dbme,dbce,dbche,dbas,dbmba;

    private FacultyAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        progressBar=view.findViewById(R.id.facultyProgressBar);

        csDepartment=view.findViewById(R.id.csDepartment);
        itDepartment=view.findViewById(R.id.itDepartment);
        eceDepartment=view.findViewById(R.id.eceDepartment);
        eeDepartment=view.findViewById(R.id.eeDepartment);
        meDepartment=view.findViewById(R.id.meDepartment);
        ceDepartment=view.findViewById(R.id.ceDepartment);
        cheDepartment=view.findViewById(R.id.cheDepartment);
        asDepartment=view.findViewById(R.id.asDepartment);
        mbaDepartment=view.findViewById(R.id.mbaDepartment);

        csNoData=view.findViewById(R.id.csNoData);
        itNoData=view.findViewById(R.id.itNoData);
        eceNoData=view.findViewById(R.id.eceNoData);
        eeNoData=view.findViewById(R.id.eeNoData);
        meNoData=view.findViewById(R.id.meNoData);
        ceNoData=view.findViewById(R.id.ceNoData);
        cheNoData=view.findViewById(R.id.cheNoData);
        asNoData=view.findViewById(R.id.asNoData);
        mbaNoData=view.findViewById(R.id.mbaNoData);

        dbcs= FirebaseDatabase.getInstance().getReference().child("faculty");
        dbit= FirebaseDatabase.getInstance().getReference().child("faculty");
        dbece= FirebaseDatabase.getInstance().getReference().child("faculty");
        dbee= FirebaseDatabase.getInstance().getReference().child("faculty");
        dbme= FirebaseDatabase.getInstance().getReference().child("faculty");
        dbce= FirebaseDatabase.getInstance().getReference().child("faculty");
        dbche= FirebaseDatabase.getInstance().getReference().child("faculty");
        dbas= FirebaseDatabase.getInstance().getReference().child("faculty");
        dbmba= FirebaseDatabase.getInstance().getReference().child("faculty");

        csDepartment();
        itDepartment();
        eceDepartment();
        eeDepartment();
        meDepartment();
        ceDepartment();
        cheDepartment();
        asDepartment();
        mbaDepartment();


        return view;
    }

    private void csDepartment() {
        dbcs=dbcs.child("Computer Science & Engineering");
        dbcs.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1=new ArrayList<>();
                if(!snapshot.exists())
                {
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                    progressBar.setVisibility(View.GONE);
                }
                else{
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                    for (DataSnapshot ds:snapshot.getChildren()) {
                        FacultyData data=ds.getValue(FacultyData.class);
                        list1.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new FacultyAdapter(list1,getContext());
                    csDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void itDepartment() {
        dbit=dbit.child("Information Technology");
        dbit.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if (!snapshot.exists()) {
                    itNoData.setVisibility(View.VISIBLE);
                    itDepartment.setVisibility(View.GONE);
                    progressBar.setVisibility(View.GONE);
                } else {
                    itNoData.setVisibility(View.GONE);
                    itDepartment.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                    for (DataSnapshot ss : snapshot.getChildren()) {
                        FacultyData data = ss.getValue(FacultyData.class);
                        list2.add(data);
                    }
                    itDepartment.setHasFixedSize(true);
                    itDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new FacultyAdapter(list2, getContext());
                    itDepartment.setAdapter(adapter);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void eceDepartment() {
        dbece=dbece.child("Electronics & Communication Engineering");
        dbece.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3=new ArrayList<>();
                if(!snapshot.exists()){
                    eceNoData.setVisibility(View.VISIBLE);
                    eceDepartment.setVisibility(View.GONE);
                }
                else{
                    eceNoData.setVisibility(View.GONE);
                    eceDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot ss:snapshot.getChildren()) {
                        FacultyData data=ss.getValue(FacultyData.class);
                        list3.add(data);
                    }
                    eceDepartment.setHasFixedSize(true);
                    eceDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new FacultyAdapter(list3,getContext());
                    eceDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void eeDepartment() {
        dbee=dbee.child("Electrical Engineering");
        dbee.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4=new ArrayList<>();
                if(!snapshot.exists()){
                    eeNoData.setVisibility(View.VISIBLE);
                    eeDepartment.setVisibility(View.GONE);
                }
                else{
                    eeNoData.setVisibility(View.GONE);
                    eeDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot ss:snapshot.getChildren()) {
                        FacultyData data=ss.getValue(FacultyData.class);
                        list4.add(data);
                    }
                    eeDepartment.setHasFixedSize(true);
                    eeDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new FacultyAdapter(list4,getContext());
                    eeDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void meDepartment() {
        dbme=dbme.child("Mechanical Engineering");
        dbme.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list5=new ArrayList<>();
                if(!snapshot.exists()){
                    meNoData.setVisibility(View.VISIBLE);
                    meDepartment.setVisibility(View.GONE);
                }
                else{
                    meNoData.setVisibility(View.GONE);
                    meDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot ss:snapshot.getChildren()) {
                        FacultyData data=ss.getValue(FacultyData.class);
                        list5.add(data);
                    }
                    meDepartment.setHasFixedSize(true);
                    meDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new FacultyAdapter(list5,getContext());
                    meDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ceDepartment() {
        dbce=dbce.child("Civil Enigineering");
        dbce.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list6=new ArrayList<>();
                if(!snapshot.exists()){
                    ceNoData.setVisibility(View.VISIBLE);
                    ceDepartment.setVisibility(View.GONE);
                }
                else{
                    ceNoData.setVisibility(View.GONE);
                    ceDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot ss:snapshot.getChildren()) {
                        FacultyData data=ss.getValue(FacultyData.class);
                        list6.add(data);
                    }
                    ceDepartment.setHasFixedSize(true);
                    ceDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new FacultyAdapter(list6,getContext());
                    ceDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cheDepartment() {
        dbche=dbche.child("Chemical Engineering");
        dbche.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list7=new ArrayList<>();
                if(!snapshot.exists()){
                    cheNoData.setVisibility(View.VISIBLE);
                    cheDepartment.setVisibility(View.GONE);
                }
                else{
                    cheNoData.setVisibility(View.GONE);
                    cheDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot ss:snapshot.getChildren()) {
                        FacultyData data=ss.getValue(FacultyData.class);
                        list7.add(data);
                    }
                    cheDepartment.setHasFixedSize(true);
                    cheDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new FacultyAdapter(list7,getContext());
                    cheDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void asDepartment() {
        dbas=dbas.child("Applied Science");
        dbas.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list8=new ArrayList<>();
                if(!snapshot.exists()){
                    asNoData.setVisibility(View.VISIBLE);
                    asDepartment.setVisibility(View.GONE);
                }
                else{
                    asNoData.setVisibility(View.GONE);
                    asDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot ss:snapshot.getChildren()) {
                        FacultyData data=ss.getValue(FacultyData.class);
                        list8.add(data);
                    }
                    asDepartment.setHasFixedSize(true);
                    asDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new FacultyAdapter(list8,getContext());
                    asDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mbaDepartment() {
        dbmba=dbmba.child("Master of Business Administration");
        dbmba.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list9=new ArrayList<>();
                if(!snapshot.exists()){
                    mbaNoData.setVisibility(View.VISIBLE);
                    mbaDepartment.setVisibility(View.GONE);
                }
                else{
                    mbaNoData.setVisibility(View.GONE);
                    mbaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot ss:snapshot.getChildren()) {
                        FacultyData data=ss.getValue(FacultyData.class);
                        list9.add(data);
                    }
                    mbaDepartment.setHasFixedSize(true);
                    mbaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new FacultyAdapter(list9,getContext());
                    mbaDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}