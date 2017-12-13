package com.agdevelopers.gurtek.reclikedislike;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
/**
 * Created by Gurtek Singh on 23/9/17.
 * AaG Developers
 */
public class Recadapter extends RecyclerView.Adapter<Recadapter.VieHolder> {
    LayoutInflater layoutInflater;
    String []like;
    String []dislike;
    int []num;
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public Recadapter(String [] like,String [] dislike,int num[])
    {
        this.like=like;
        this.dislike=dislike;
        this.num=num;

        for (int i = 0; i < num.length; i++) {
            arrayList.add(0);
        }

    }
    @Override
    public VieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.from(parent.getContext()).inflate(R.layout.likerow,parent,false);
        VieHolder vieHolder=new VieHolder(view);
        return vieHolder;
    }
    @Override
    public void onBindViewHolder(final VieHolder holder, final int position) {
        holder.lik.setText(like[position]);
        holder.disl.setText(dislike[position]);
        holder.coun.setText(""+arrayList.get(position));
        holder.lik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=Integer.parseInt(holder.coun.getText().toString());
                i++;
                arrayList.add(position,i);
                holder.coun.setText(""+Integer.valueOf(i).toString());
                notifyItemChanged(position);
                }

        });
        holder.disl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int j=Integer.parseInt(holder.coun.getText().toString());
                j--;
                arrayList.add(position,j);
                holder.coun.setText(""+Integer.valueOf(j).toString());
                notifyItemChanged(position);
            }
        });

    }
    @Override
    public int getItemCount() {
        return like.length;
    }
    public  class VieHolder extends RecyclerView.ViewHolder {
        Button lik,disl;
        TextView coun;
        public VieHolder(View itemView) {
            super(itemView);
            lik=itemView.findViewById(R.id.like);
            disl=itemView.findViewById(R.id.dislike);
            coun=itemView.findViewById(R.id.count);
        }
    }
}
