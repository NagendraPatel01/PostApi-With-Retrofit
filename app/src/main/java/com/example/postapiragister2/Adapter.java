package com.example.postapiragister2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    OneModel oneModel;

    public Adapter(Context context, OneModel oneModel) {
        this.context = context;
        this.oneModel = oneModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.datadesign,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text1.setText(oneModel.getData().get(position).getName());
        holder.text2.setText(oneModel.getData().get(position).getEmail());
        Glide.with(context).load("" +oneModel.getData().get(position).getProfilepicture()).into(holder.img);



    }

    @Override
    public int getItemCount() {
        return oneModel.getData().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView text1,text2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.img);
            text1=itemView.findViewById(R.id.text1);
            text2=itemView.findViewById(R.id.text2);



        }
    }
}
