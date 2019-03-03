package com.example.traseemontane;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TraseuFragmentDinamic extends Fragment {

    private String title;
    private Bundle bundle = new Bundle();

    private DownloadManager downloadManager = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_traseu, null);

//        Ia argumente puse in bundle pentru a crea fragmentul dinamic
        title = "Traseu";
        TextView titleTextView = (TextView) getActivity().findViewById(R.id.toolbar_title);
        titleTextView.setText(title);

        CardView cardHarta = (CardView) view.findViewById(R.id.card_harta_traseu);
        downloadManager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
        cardHarta.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Start downloading map
                Uri Download_Uri = Uri.parse("https://i2.wp.com/www.traseepemunte.ro/wp-content/uploads/2014/06/Harta-Muntii-Fagaras_traseu-Cabana-Suru.jpg");

                DownloadManager.Request request = new DownloadManager.Request(Download_Uri);
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                request.setAllowedOverRoaming(false);
//                request.setTitle("harta_" + title + ".png");
//                request.setDescription("Downloading " + "Sample" + ".png");
                request.setVisibleInDownloadsUi(true);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title + ".png");
                Toast.makeText(getContext(),"Hartă descărcată",Toast.LENGTH_LONG).show();
                downloadManager.enqueue(request);
            }
        });

        return view;
    }

}
