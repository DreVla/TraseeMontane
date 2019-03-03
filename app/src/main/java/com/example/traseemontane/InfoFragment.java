package com.example.traseemontane;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class InfoFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info,null);
        TextView title = (TextView)getActivity().findViewById(R.id.toolbar_title);
        title.setText(getString(R.string.info_toolbar));
        CardView cardMarcaje = (CardView) view.findViewById(R.id.card_marcaje);
        CardView cardEchipament = (CardView) view.findViewById(R.id.card_echipament);
        CardView cardUrgenta = (CardView) view.findViewById(R.id.card_urgenta);

        cardMarcaje.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), MarcajeActivity.class);
                startActivity(intent);
            }
        });

        cardEchipament.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), EchipamentActivity.class);
                startActivity(intent);
            }
        });

        cardUrgenta.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), UrgenteActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }


}
