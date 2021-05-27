package com.example.bietjhansiapp.ui.faculty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bietjhansiapp.R;

import java.util.ArrayList;

public class FacultyAdapter extends RecyclerView.Adapter<FacultyAdapter.FacultyViewAdapter> {

    private ArrayList<FacultyData> list;
    private Context context;
//    private String category;

    public FacultyAdapter(ArrayList<FacultyData> list, Context context) {
        this.list = list;
        this.context = context;
//        this.category = category;
    }

    @NonNull
    @Override
    public FacultyViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.faculty_data,parent,false);
        return new FacultyViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FacultyViewAdapter holder, int position) {
        FacultyData data=list.get(position);
        holder.name.setText(data.getName());
        holder.email.setText(data.getEmail());
        holder.post.setText(data.getPost());
        try {
            Glide.with(context).load(data.getImage()).placeholder(R.drawable.avatar).into(holder.image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FacultyViewAdapter extends RecyclerView.ViewHolder {

        private TextView name,email,post;
        private ImageView image;

        public FacultyViewAdapter(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.facultyName);
            email=itemView.findViewById(R.id.facultyEmail);
            post=itemView.findViewById(R.id.facultyPost);
            image=itemView.findViewById(R.id.facultyImage);
        }
    }
}
