package com.example.traseemontane;

import android.app.DownloadManager;
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
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import at.blogc.android.views.ExpandableTextView;

import static android.content.Context.DOWNLOAD_SERVICE;

public class RegiuniFragmentDynamic extends Fragment {

    private DownloadManager downloadManager = null;
    private String title,linkHarta;
    private Bundle bundle = new Bundle();
    private ArrayList<String> mTraseeIncepatori = new ArrayList<>();
    private ArrayList<Integer> mImaginiIncepatori = new ArrayList<>();
    private ArrayList<String> mTraseeExperimentati = new ArrayList<>();
    private ArrayList<Integer> mImaginiExperimentati = new ArrayList<>();
    private long enq;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dynamic,null);

//        Ia argumente puse in bundle pentru a crea fragmentul dinamic
        final Bundle bundle=getArguments();
        title = bundle.getString("Title");
        TextView titleTextView = (TextView)getActivity().findViewById(R.id.toolbar_title);
        titleTextView.setText(title);

//        Genereaza textul pentru descriere hartii dinamic
        String descriereHarta = bundle.getString("DescriereHarta");
        TextView descriereHartaTextView = (TextView) view.findViewById(R.id.descriere_harta_dinamic);
        descriereHartaTextView.setText(descriereHarta);

//        Genereaza poza cu harta pentru primul card view
        String numeHarta = bundle.getString("NumeHarta");
        int idImagineHarta = getResources().getIdentifier("com.example.traseemontane:drawable/" + numeHarta, null, null);
        ImageView pozaHartaImageView = (ImageView) view.findViewById(R.id.poza_harta_dinamic);
        pozaHartaImageView.setImageResource(idImagineHarta);

//        Genereaza descrierea regiunii in al doilea card view
        TextView descriereFragment = (TextView) view.findViewById(R.id.text_view_dinamic);
        descriereFragment.setText(bundle.getString("DescriereRegiune"));

//        Genereaza linkul de descarcare al hartii
        linkHarta = bundle.getString("LinkHarta");


        CardView cardHarta = (CardView) view.findViewById(R.id.card_harta_dinamic);
        CardView cardIncepatori = (CardView) view.findViewById(R.id.card_incepatori_dinamic);
        CardView cardExperimentati = (CardView) view.findViewById(R.id.card_experimentati_dinamic);

        downloadManager = (DownloadManager) getContext().getSystemService(DOWNLOAD_SERVICE);



        cardHarta.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Uri Download_Uri = Uri.parse(linkHarta);

                DownloadManager.Request request = new DownloadManager.Request(Download_Uri);
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                request.setAllowedOverRoaming(false);
//                request.setTitle("harta_" + title + ".png");
//                request.setDescription("Downloading " + "Sample" + ".png");
                request.setVisibleInDownloadsUi(true);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title + ".png");
                Toast.makeText(getContext(),"Hartă descărcată",Toast.LENGTH_LONG).show();
                enq = downloadManager.enqueue(request);

//                BroadcastReceiver receiver = new BroadcastReceiver() {
//                    @Override
//                    public void onReceive(Context context, Intent intent) {
//                        String action = intent.getAction();
//                        if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action)) {
//                            long downloadId = intent.getLongExtra(
//                                    DownloadManager.EXTRA_DOWNLOAD_ID, 0);
//                            DownloadManager.Query query = new DownloadManager.Query();
//                            query.setFilterById(enq);
//                            Cursor c = downloadManager.query(query);
//                            if (c.moveToFirst()) {
//                                int columnIndex = c
//                                        .getColumnIndex(DownloadManager.COLUMN_STATUS);
//                                if (DownloadManager.STATUS_SUCCESSFUL == c
//                                        .getInt(columnIndex)) {
//                                    String uriString = c
//                                            .getString(c
//                                                    .getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
//                                    Intent openImage = new Intent(Intent.ACTION_VIEW, Uri.parse(uriString));
//
//                                    startActivity(openImage);
//                                }
//                            }
//                        }
//                    }
//                };

//                registerReceiver(receiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

//                Uri uri = Uri.parse(linkHarta); // missing 'http://' will cause crashed
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(intent);

            }
        });

        cardIncepatori.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mTraseeIncepatori.size()==0) initIncepatori();
                bundle.putString("Title",getString(R.string.traseeIncepatoriTitlu));
                bundle.putString("Pentru","incepatori");
                bundle.putString("Muntii",title);
                bundle.putIntegerArrayList("Poze",mImaginiIncepatori);
                bundle.putStringArrayList("Trasee",mTraseeIncepatori);
                ListFragment incepatoriFragment= new ListFragment();
                incepatoriFragment.setArguments(bundle);
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.replace(R.id.fragment_container,incepatoriFragment,"tagOccidentali");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        cardExperimentati.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mTraseeExperimentati.size()==0) initExperimentati();
                bundle.putString("Title",getString(R.string.traseeExperimentatiTitlu));
                bundle.putString("Pentru","experimentati");
                bundle.putString("Muntii",title);
                bundle.putIntegerArrayList("Poze",mImaginiExperimentati);
                bundle.putStringArrayList("Trasee",mTraseeExperimentati);
                ListFragment experimentatiFragment = new ListFragment();
                experimentatiFragment.setArguments(bundle);
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.replace(R.id.fragment_container,experimentatiFragment,"tagOccidentali");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }

    private void initIncepatori(){

        mImaginiIncepatori.add(getResources().getIdentifier("com.example.traseemontane:drawable/bulina_rosie", null, null));
        mTraseeIncepatori.add("Sebeşu de Sus - V. Moaşei - Cabana Suru");

        mImaginiIncepatori.add(getResources().getIdentifier("com.example.traseemontane:drawable/cruce_rosie", null, null));
        mTraseeIncepatori.add("Avrig - Poiana Neamtului (auto) - Cabana Barcaciu");

        mImaginiIncepatori.add(getResources().getIdentifier("com.example.traseemontane:drawable/triunghi_rosu", null, null));
        mTraseeIncepatori.add("Statiunea climaterica Sambata - Cabana Valea Sambetei ");

        mImaginiIncepatori.add(getResources().getIdentifier("com.example.traseemontane:drawable/cruce_albastra", null, null));
        mTraseeIncepatori.add("Cabana Balea Lac - saua Capra - lacul Capra");
    }

    private void initExperimentati(){

        mImaginiExperimentati.add(getResources().getIdentifier("com.example.traseemontane:drawable/triunghi_rosu", null, null));
        mTraseeExperimentati.add("Stana din Valea Rea - Valea Rea - Varful Moldoveanu");

        mImaginiExperimentati.add(getResources().getIdentifier("com.example.traseemontane:drawable/triunghi_rosu", null, null));
        mTraseeExperimentati.add("Piscul Negru - Lacul Caltun - Varful Negoiu");

        mImaginiExperimentati.add(getResources().getIdentifier("com.example.traseemontane:drawable/triunghi_rosu", null, null));
        mTraseeExperimentati.add("Breaza - Valea Pojortei - poiana fostei cabane Urlea  - saua Mosuleata  - Varful Urlea");

    }



}
