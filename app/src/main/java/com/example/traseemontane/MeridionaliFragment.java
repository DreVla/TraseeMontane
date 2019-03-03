package com.example.traseemontane;

import android.app.DownloadManager;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MeridionaliFragment extends Fragment {

    private DownloadManager downloadManager = null;
    private Bundle bundle = new Bundle();

    private Context mContext;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meridionali,null);
        TextView title = (TextView)getActivity().findViewById(R.id.toolbar_title);
        title.setText(getString(R.string.searchMeridionaliTitlu));


        CardView cardHarta = (CardView) view.findViewById(R.id.card_meridionali_harta);
        CardView cardFagaras = (CardView) view.findViewById(R.id.card_fagars);
        CardView cardBucegi = (CardView) view.findViewById(R.id.card_bucegi);
        CardView cardRetezat = (CardView) view.findViewById(R.id.card_retezat);
        CardView cardPiatra = (CardView) view.findViewById(R.id.card_piatra);
        downloadManager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);


        cardHarta.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Start downloading map
                Uri Download_Uri = Uri.parse("http://www.profudegeogra.eu/wp-content/uploads/2011/10/Meridionali1.gif");

                DownloadManager.Request request = new DownloadManager.Request(Download_Uri);
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                request.setAllowedOverRoaming(false);
                //request.setTitle("Map Download " + "Sample" + ".png");
                //request.setDescription("Downloading " + "Sample" + ".png");
                request.setVisibleInDownloadsUi(true);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "/Maps/" + getString(R.string.searchMeridionaliTitlu) + ".png");
                Toast.makeText(getContext(),"Hartă descărcată",Toast.LENGTH_LONG).show();
                long refid = downloadManager.enqueue(request);
            }
        });



        cardFagaras.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bundle.putString("Title",getString(R.string.meridionaliFagarasTitlu));
                bundle.putString("id","fagarasi");
                bundle.putString("DescriereHarta",getString(R.string.fagarasiHartaDescriere));
                bundle.putString("NumeHarta","harta_fagarasi");
                bundle.putString("DescriereRegiune",getString(R.string.fagarasDescriereFragment));
                bundle.putString("LinkHarta",getString(R.string.linkHartaFagarasi));
                RegiuniFragmentDynamic fagarasFragment= new RegiuniFragmentDynamic();
                fagarasFragment.setArguments(bundle);
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.replace(R.id.fragment_container,fagarasFragment,"tagOrinetali");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        cardBucegi.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bundle.putString("Title",getString(R.string.meridionaliBucegiTitlu));
                bundle.putString("id","bucegi");
                bundle.putString("DescriereHarta",getString(R.string.bucegiHartaDescriere));
                bundle.putString("NumeHarta","harta_bucegi");
                bundle.putString("DescriereRegiune",getString(R.string.bucegiDescriereFragment));
                bundle.putString("LinkHarta",getString(R.string.linkHartaBucegi));
                RegiuniFragmentDynamic bucegiFragment= new RegiuniFragmentDynamic();
                bucegiFragment.setArguments(bundle);
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.replace(R.id.fragment_container,bucegiFragment,"tagOrinetali");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        cardRetezat.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bundle.putString("Title",getString(R.string.meridionaliRetezatTitlu));
                bundle.putString("id","retezat");
                bundle.putString("DescriereHarta",getString(R.string.retezatHartaDescriere));
                bundle.putString("NumeHarta","harta_retezat");
                bundle.putString("DescriereRegiune",getString(R.string.retezatDescriereFragment));
                bundle.putString("LinkHarta",getString(R.string.linkHartaRetezat));
                RegiuniFragmentDynamic retezatFragment= new RegiuniFragmentDynamic();
                retezatFragment.setArguments(bundle);
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.replace(R.id.fragment_container,retezatFragment,"tagOrinetali");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        cardPiatra.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bundle.putString("Title",getString(R.string.meridionaliPiatraTitlu));
                bundle.putString("id","piatra");
                bundle.putString("DescriereHarta",getString(R.string.piatraHartaDescriere));
                bundle.putString("NumeHarta","harta_piatra");
                bundle.putString("DescriereRegiune",getString(R.string.piatraDescriereFragment));
                bundle.putString("LinkHarta",getString(R.string.linkHartaPiatra));
                RegiuniFragmentDynamic piatraFragment= new RegiuniFragmentDynamic();
                piatraFragment.setArguments(bundle);
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.replace(R.id.fragment_container,piatraFragment,"tagOrinetali");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }


}
