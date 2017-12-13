package com.agdevelopers.gurtek.reclikedislike;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import static android.R.id.text1;
import static com.agdevelopers.gurtek.reclikedislike.R.attr.layoutManager;

public class MainActivity extends AppCompatActivity {
RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    Recadapter adapter;
    String []like={"like","like","like","like","like","like","like","like"};
    String []dislike={"dislike","dislike","dislike","dislike","dislike","dislike","dislike","dislike"};
    int []num={0,0,0,0,0,0,0,0};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutManager=new LinearLayoutManager(this);
        recyclerView= (RecyclerView) findViewById(R.id.recid);
        adapter=new Recadapter(like,dislike,num);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

    }
}
