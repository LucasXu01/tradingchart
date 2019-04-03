package com.example.lucas.shendutu2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 创建人: Fang.Mr
 * 创建时间:2018-01-23
 * 功能描述:
 */

public class item_view extends LinearLayout {




    private LinearLayout linearYanse;
    private LinearLayout linearWhite;

    private TextView tvZonge;
    private TextView tvJiage;


    private boolean is_buy=true;//买还是卖  true买  false卖


    public item_view(Context context) {
        this(context,null);
    }

    public item_view(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public item_view(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
       LayoutInflater.from(getContext()).inflate(R.layout.item_shendutu,this);
       /* LayoutInflater mInflater = LayoutInflater.from(context);
        View myView = mInflater.inflate(R.layout.item_view, null);
        addView(myView);*/
        TypedArray ta=context.obtainStyledAttributes(attrs,R.styleable.item_view);
        is_buy=ta.getBoolean(R.styleable.item_view_buy_or_sell,true);





        linearYanse = (LinearLayout) findViewById(R.id.linear_yanse);
        linearWhite = (LinearLayout) findViewById(R.id.linear_white);

        tvZonge = (TextView) findViewById(R.id.tv_zonge);
        tvJiage = (TextView) findViewById(R.id.tv_jiage);


        tvZonge.setText(ta.getString(R.styleable.item_view_text_zonge));
        tvJiage.setText(ta.getString(R.styleable.item_view_text_jiage));


        linearWhite.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, ta.getFloat(R.styleable.item_view_shendutu_weight,0.5f)
                )
        );
        linearYanse.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1 - ta.getFloat(R.styleable.item_view_shendutu_weight,0.5f)
                )
        );


        ta.recycle();
        initview();
    }

    private void initview() {
        if(is_buy){
            linearYanse.setBackgroundColor(Color.parseColor("#38E536"));
        }else{
            linearYanse.setBackgroundColor(Color.parseColor("#FE2851"));
        }



    }


    public void setpara(boolean is_buy,String zonge, String jiage, float proportion) {
        this.is_buy = is_buy;
        initview();

        tvZonge.setText(zonge);
        tvJiage.setText(jiage);


        linearWhite.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, proportion
                )
        );
        linearYanse.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1-proportion
                )
        );
    }


}
