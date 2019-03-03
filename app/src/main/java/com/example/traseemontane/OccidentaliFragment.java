package com.example.traseemontane;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OccidentaliFragment extends Fragment {

    private DownloadManager downloadManager = null;
    private Bundle bundle = new Bundle();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_occidentali,null);
        TextView title = (TextView)getActivity().findViewById(R.id.toolbar_title);
        title.setText(getString(R.string.searchOccidentaliTitlu));
        CardView cardHarta = (CardView) view.findViewById(R.id.card_occidentali_harta);
        CardView cardApuseni = (CardView) view.findViewById(R.id.card_apuseni);
        CardView cardBihorului = (CardView) view.findViewById(R.id.card_Bihorului);

        downloadManager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);

        cardHarta.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Start downloading map
                Uri Download_Uri = Uri.parse("http://www.profudegeogra.eu/wp-content/uploads/2011/10/Occidentali1.gif");

                DownloadManager.Request request = new DownloadManager.Request(Download_Uri);
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                request.setAllowedOverRoaming(false);
                //request.setTitle("Map Download " + "Sample" + ".png");
                //request.setDescription("Downloading " + "Sample" + ".png");
                request.setVisibleInDownloadsUi(true);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "/Maps/" + getString(R.string.searchOccidentaliTitlu) + ".png");
                Toast.makeText(getContext(),"Hartă descărcată",Toast.LENGTH_LONG).show();
                long refid = downloadManager.enqueue(request);
            }
        });

        cardApuseni.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bundle.putString("Title",getString(R.string.occidentaliApuseniTitlu));
                bundle.putString("id","apuseni");
                bundle.putString("DescriereHarta",getString(R.string.apuseniHartaDescriere));
                bundle.putString("NumeHarta","harta_apuseni");
                bundle.putString("DescriereRegiune",getString(R.string.apuseniDescriereFragment));
                bundle.putString("LinkHarta",getString(R.string.linkHartaApuseni));
                RegiuniFragmentDynamic apuseniFragment= new RegiuniFragmentDynamic();
                apuseniFragment.setArguments(bundle);
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.replace(R.id.fragment_container,apuseniFragment,"tagOccidentali");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        cardBihorului.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bundle.putString("Title",getString(R.string.occidentaliBihoruluiTitlu));
                bundle.putString("id","rusca");
                bundle.putString("DescriereHarta",getString(R.string.ruscaHartaDescriere));
                bundle.putString("NumeHarta","harta_rusca");
                bundle.putString("DescriereRegiune",getString(R.string.ruscaDescriereFragment));
                bundle.putString("LinkHarta",getString(R.string.linkHartaRusca));
                RegiuniFragmentDynamic ruscaFragment= new RegiuniFragmentDynamic();
                ruscaFragment.setArguments(bundle);
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.replace(R.id.fragment_container,ruscaFragment,"tagOccidentali");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }


}
