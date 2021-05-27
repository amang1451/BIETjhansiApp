package com.example.bietjhansiapp.ebook;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bietjhansiapp.R;

import java.util.List;

public class EbookAdapter extends RecyclerView.Adapter<EbookAdapter.EbookViewAdapter> {

    public EbookAdapter(Context context, List<EbookData> list) {
        this.context = context;
        this.list = list;
    }

    private Context context;
    private List<EbookData> list;

    @NonNull
    @Override
    public EbookViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ebook_item,parent,false);
        return new EbookViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EbookViewAdapter holder, int position) {
        holder.ebookTitle.setText(list.get(position).getEbookTitle());
        holder.ebookDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getEbookUrl()));
                context.startActivity(intent);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,pdfViewerActivity.class);
                intent.putExtra("ebookUrl",list.get(position).getEbookUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EbookViewAdapter extends RecyclerView.ViewHolder {

        private TextView ebookTitle;
        private ImageView ebookDownload;

        public EbookViewAdapter(@NonNull View itemView) {
            super(itemView);
            ebookTitle=itemView.findViewById(R.id.ebookTitle);
            ebookDownload=itemView.findViewById(R.id.ebookDownload);

        }
    }
}
