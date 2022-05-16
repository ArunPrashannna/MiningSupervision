package com.arunprashanna.miningsupervision1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NodesFragment extends Fragment {

    RecyclerView myRecyclerView;
    ArrayList<Node> nodeArray;
    DatabaseReference databaseReference;
    NodesAdapter adapter;

    public NodesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View NodesView = inflater.inflate(R.layout.fragment_nodes, container, false);

        nodeArray = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("/Mining_Center_1/nodes");
        myRecyclerView = NodesView.findViewById(R.id.nodes_recyclerView);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NodesAdapter(getContext(), nodeArray);
        myRecyclerView.setAdapter(adapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Node node = dataSnapshot.getValue(Node.class);
                    System.out.println("Node --->>> "+node);
                    nodeArray.add(node);
                }
                System.out.println("<-------------------------NodesArray ------------------------>"+nodeArray);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return NodesView;
    }
}