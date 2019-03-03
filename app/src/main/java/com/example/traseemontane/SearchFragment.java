package com.example.traseemontane;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SearchFragment extends Fragment {

    Bundle bundle = new Bundle();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search,null);
        TextView title = (TextView)getActivity().findViewById(R.id.toolbar_title);
        title.setText(getString(R.string.search_toolbar));
        CardView cardMeridionali = (CardView) view.findViewById(R.id.card_meridionali);
        CardView cardOccidentali = (CardView) view.findViewById(R.id.card_occidentali);
        CardView cardOrientali = (CardView) view.findViewById(R.id.card_orientali);

        cardMeridionali.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                MeridionaliFragment meridionaliFragment=new MeridionaliFragment();
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.replace(R.id.fragment_container,meridionaliFragment,"tagOrinetali");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        cardOccidentali.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                OccidentaliFragment occidentaliFragment=new OccidentaliFragment();
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.replace(R.id.fragment_container,occidentaliFragment,"tagOrinetali");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        cardOrientali.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bundle.putString("Title",getString(R.string.searchOrientaliTitlu));
                bundle.putString("id","orientali");
                bundle.putString("DescriereHarta",getString(R.string.orientaliHartaDescriere));
                bundle.putString("NumeHarta","harta_orientali");
                bundle.putString("DescriereRegiune",getString(R.string.orientaliDescriereFragment));
                bundle.putString("LinkHarta",getString(R.string.linkHartaOrientali));
                RegiuniFragmentDynamic orientaliFragment=new RegiuniFragmentDynamic();
                orientaliFragment.setArguments(bundle);
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.replace(R.id.fragment_container,orientaliFragment,"tagOrinetali");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }


}
