package com.example.traseemontane;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<Integer> mImages = new ArrayList<>();
    private Context mContext;


    public RecyclerViewAdapter(Context mContext, ArrayList<String> mImageNames, ArrayList<Integer> mImages) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {
        String title = mImageNames.get(i);
        holder.imageName.setText(title);
        int imagePath = mImages.get(i);
        holder.image.setImageResource(imagePath);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity appCompatActivity = (AppCompatActivity) v.getContext();
                TraseuFragmentDinamic traseuFragment= new TraseuFragmentDinamic();
                FragmentManager fragmentManager= appCompatActivity.getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                        transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                        transaction.replace(R.id.fragment_container,traseuFragment,"tagOccidentali");
                        transaction.addToBackStack(null);
                        transaction.commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView imageName;
        private ImageView image;
        RelativeLayout parentLayout;
        public ViewHolder(View itemView){
            super(itemView);
            imageName = (TextView) itemView.findViewById(R.id.titlu_traseu_montan);
            image = (ImageView) itemView.findViewById(R.id.marcaj_poza);
            parentLayout = (RelativeLayout) itemView.findViewById(R.id.parent_layout);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){

        }

        public void onClick(View view){

        }
    }
}
