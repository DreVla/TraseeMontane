package com.example.traseemontane;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    private String title;
    private ArrayList<String> trasee;
    private ArrayList<Integer> poze;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_lista_marcaje, container, false);
        final Bundle bundle=getArguments();
        title = bundle.getString("Title");
        TextView titleTextView = (TextView)getActivity().findViewById(R.id.toolbar_title);
        titleTextView.setText(title);

        poze = bundle.getIntegerArrayList("Poze");
        trasee = bundle.getStringArrayList("Trasee");

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.lista_marcaje);

        RecyclerViewAdapter listAdapter = new RecyclerViewAdapter(getContext(),trasee,poze);
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        return view;
    }
}
