package com.example.traseemontane;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OrientaliFragment extends Fragment {

    DownloadManager downloadManager = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_orientali,null);
        TextView titleTextView = (TextView)getActivity().findViewById(R.id.toolbar_title);
        titleTextView.setText(getString(R.string.searchOrientaliTitlu));
        CardView cardHarta = (CardView) view.findViewById(R.id.card_orientali_harta);
        CardView cardIncepatori = (CardView) view.findViewById(R.id.card_orientali_incepatori);
        CardView cardExperimentati = (CardView) view.findViewById(R.id.card_orientali_experimentati);

        downloadManager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);

        cardHarta.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Start downloading map
                Uri Download_Uri = Uri.parse("http://www.profudegeogra.eu/wp-content/uploads/2011/10/Carpa%C5%A3ii_Orientali1.gif");

                DownloadManager.Request request = new DownloadManager.Request(Download_Uri);
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                request.setAllowedOverRoaming(false);
                //request.setTitle("Map Download " + "Sample" + ".png");
                //request.setDescription("Downloading " + "Sample" + ".png");
                request.setVisibleInDownloadsUi(true);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "/Maps/" + getString(R.string.searchOrientaliTitlu) + ".png");
                Toast.makeText(getContext(),"Hartă descărcată",Toast.LENGTH_LONG).show();
                long refid = downloadManager.enqueue(request);
            }
        });

        cardIncepatori.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        cardExperimentati.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // do something
            }
        });

        return view;
    }


}
