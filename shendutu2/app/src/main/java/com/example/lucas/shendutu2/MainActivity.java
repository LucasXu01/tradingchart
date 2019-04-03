package com.example.lucas.shendutu2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private LinearLayout notifyzong;
    private LinearLayout linearYanse;
    private LinearLayout linearWhite;


    private item_view item1;
    private item_view item2;
    private item_view item3;


    private List<shendutu_model> shendutu_list_true = new ArrayList<>();
    private List<shendutu_model> shendutu_list_false = new ArrayList<>();
    private List<shendutu_model2> shendutu_list_his = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView_shendutu= (RecyclerView) findViewById(R.id.shendutu_recycleview);
        RecyclerView recyclerView_shendutu2= (RecyclerView) findViewById(R.id.shendutu_recycleview2);
        RecyclerView recyclerView_shendutu2his= (RecyclerView) findViewById(R.id.shendutu2_recycleview);


        shendutu_list_true.add(new shendutu_model(true,"0.99","0.9459",0.1f));
        shendutu_list_true.add(new shendutu_model(true,"0.299","0.9459",0.7f));
        shendutu_list_true.add(new shendutu_model(true,"0.299","0.954359",0.3f));
        shendutu_list_true.add(new shendutu_model(true,"0.299","0.99",0.9f));
        shendutu_list_true.add(new shendutu_model(true,"0.99","0.9459",0.5f));
        shendutu_list_true.add(new shendutu_model(true,"0.549","0.599",0.2f));
        shendutu_list_true.add(new shendutu_model(true,"0.49","0.9459",0.7f));
        shendutu_list_true.add(new shendutu_model(true,"0.99","0.959",0.8f));


        shendutu_list_false.add(new shendutu_model(false,"0.99","0.9459",0.1f));
        shendutu_list_false.add(new shendutu_model(false,"0.299","0.9459",0.7f));
        shendutu_list_false.add(new shendutu_model(false,"0.299","0.954359",0.3f));
        shendutu_list_false.add(new shendutu_model(false,"0.299","0.99",0.9f));
        shendutu_list_false.add(new shendutu_model(false,"0.99","0.9459",0.5f));
        shendutu_list_false.add(new shendutu_model(false,"0.549","0.599",0.2f));
        shendutu_list_false.add(new shendutu_model(false,"0.49","0.9459",0.7f));
        shendutu_list_false.add(new shendutu_model(false,"0.99","0.959",0.8f));


        shendutu_list_his.add(new shendutu_model2(true,"5s","0.44000","0.0230000", 0.3f));
        shendutu_list_his.add(new shendutu_model2(true,"5s","0.44000","0.0230000", 0.2f));
        shendutu_list_his.add(new shendutu_model2(false,"5h","0.44000","0.0230000", 0.5f));
        shendutu_list_his.add(new shendutu_model2(true,"34min","0.44000","0.0230000", 0.6f));
        shendutu_list_his.add(new shendutu_model2(true,"6s","0.44000","0.0230000", 0.7f));

        //--------------------------适配器--------------------------
        //Adapter适配器初始化
        recyclerView_shendutu.setLayoutManager(new LinearLayoutManager(this));
        //设置列表默认动画效果
        recyclerView_shendutu.setItemAnimator(new DefaultItemAnimator());
        //绑定适配器
        ShendutuAdapter shendutuAdapter = new ShendutuAdapter(shendutu_list_true, this);
        recyclerView_shendutu.setAdapter(shendutuAdapter);

        //--------------------------适配器--------------------------


        //--------------------------适配器--------------------------
        //Adapter适配器初始化
        recyclerView_shendutu2.setLayoutManager(new LinearLayoutManager(this));
        //设置列表默认动画效果
        recyclerView_shendutu2.setItemAnimator(new DefaultItemAnimator());
        //绑定适配器
        ShendutuAdapter shendutuAdapter2 = new ShendutuAdapter(shendutu_list_false, this);
        recyclerView_shendutu2.setAdapter(shendutuAdapter2);

        //--------------------------适配器--------------------------

        //--------------------------适配器--------------------------
        //Adapter适配器初始化
        recyclerView_shendutu2his.setLayoutManager(new LinearLayoutManager(this));
        //设置列表默认动画效果
        recyclerView_shendutu2his.setItemAnimator(new DefaultItemAnimator());
        //绑定适配器
        Shendutu2Adapter shendutu2Adapter = new Shendutu2Adapter(shendutu_list_his, this);
        recyclerView_shendutu2his.setAdapter(shendutu2Adapter);

        //--------------------------适配器--------------------------





//
//        notifyzong = (LinearLayout) findViewById(R.id.notifyzong);
//        linearYanse = (LinearLayout) findViewById(R.id.linear_yanse);
//        linearWhite = (LinearLayout) findViewById(R.id.linear_white);
//
//        linearWhite.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.5f));
//        linearYanse.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.5f));


    }
}
