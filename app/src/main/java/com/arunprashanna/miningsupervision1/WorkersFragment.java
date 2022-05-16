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


public class WorkersFragment extends Fragment {
    RecyclerView myRecyclerView;
    ArrayList<Worker> workerArray;
    DatabaseReference databaseReference;
    workersAdapter adapter;

    public WorkersFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View WorkersView = inflater.inflate(R.layout.fragment_workers, container, false);

        // Workers Recycler View


        workerArray = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("/Mining_Center_1/wokers");
        myRecyclerView = WorkersView.findViewById(R.id.workers_recyclerView);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new workersAdapter(getContext(), workerArray);
        myRecyclerView.setAdapter(adapter);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Worker worker = dataSnapshot.getValue(Worker.class);
                    System.out.println("Worker --->>> "+worker);
                    workerArray.add(worker);
                }
                System.out.println("<-------------------------WorkersArray ------------------------>"+workerArray);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return WorkersView;
    }
}