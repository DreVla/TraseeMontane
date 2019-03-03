package com.example.traseemontane;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MapFragment2 extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map,null);
        TextView title = (TextView)getActivity().findViewById(R.id.toolbar_title);
        title.setText(getString(R.string.map_toolbar));
        return view;
    }


}
