package com.arunprashanna.miningsupervision1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NodesAdapter extends RecyclerView.Adapter<NodesAdapter.MyViewHolder> {

    ArrayList<Node> nodeArray;
    Context context;

    public NodesAdapter(Context context, ArrayList<Node> nodeArray) {
        this.context = context;
        this.nodeArray = nodeArray;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item_node, parent, false);
        return new NodesAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position ) {
        holder.id.setText(nodeArray.get(position).getId());
        holder.temperature.setText(nodeArray.get(position).getTemperature());
        holder.humidity.setText(nodeArray.get(position).getHumidity());
        holder.methane.setText(nodeArray.get(position).getMethane());
    }

    @Override
    public int getItemCount() {
        return nodeArray.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id, temperature, humidity, methane;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.list_item_nodeId);
            temperature = itemView.findViewById(R.id.list_item_nodeTemp);
            humidity = itemView.findViewById(R.id.list_item_nodeHumid);
            methane = itemView.findViewById(R.id.list_item_nodeMethane);
        }
    }
}
