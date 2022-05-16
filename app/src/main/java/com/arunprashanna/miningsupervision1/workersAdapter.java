package com.arunprashanna.miningsupervision1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class workersAdapter extends RecyclerView.Adapter<workersAdapter.MyViewHolder> {

    ArrayList<Worker> workerArray;
    Context context;

    public workersAdapter(Context context, ArrayList<Worker> workerArray) {
        this.context = context;
        this.workerArray = workerArray;
    }

    @NonNull
    @Override
    public workersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull workersAdapter.MyViewHolder holder, int position) {
        Worker worker = workerArray.get(position);
        holder.curNode.setText(worker.getCurNode());
        holder.uid.setText(worker.getUid());
    }

    @Override
    public int getItemCount() {
        return workerArray.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView curNode, uid;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            curNode = itemView.findViewById(R.id.list_item_curNode);
            uid = itemView.findViewById(R.id.list_item_uid);
        }
    }
}