package com.example.lucas.shendutu2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 创建人: Fang.Mr
 * 创建时间:2018-01-23
 * 功能描述:
 */

public class item_view2 extends LinearLayout {




    private LinearLayout linearYanse;
    private LinearLayout linearWhite;

    private TextView tvChengjiaoliang;
    private TextView tvJiageHis;
    private TextView tvJiageTime;


    private boolean is_buy=true;//买还是卖  true买  false卖


    public item_view2(Context context) {
        this(context,null);
    }

    public item_view2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public item_view2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
       LayoutInflater.from(getContext()).inflate(R.layout.item_shendutu2,this);
       /* LayoutInflater mInflater = LayoutInflater.from(context);
        View myView = mInflater.inflate(R.layout.item_view, null);
        addView(myView);*/
        TypedArray ta=context.obtainStyledAttributes(attrs,R.styleable.item_view2);
        is_buy=ta.getBoolean(R.styleable.item_view2_buy_or_sell2,true);





        linearYanse = (LinearLayout) findViewById(R.id.linear_yanse);
        linearWhite = (LinearLayout) findViewById(R.id.linear_white);




        tvJiageTime = (TextView) findViewById(R.id.tv_jiage_time);
        tvJiageHis = (TextView) findViewById(R.id.tv_jiage_his);
        tvChengjiaoliang = (TextView) findViewById(R.id.tv_chengjiaoliang);




        tvJiageTime.setText(ta.getString(R.styleable.item_view2_text_time2));
        tvJiageHis.setText(ta.getString(R.styleable.item_view2_text_jiage2));
        tvChengjiaoliang.setText(ta.getString(R.styleable.item_view2_text_chengjiaoliang2));



        linearWhite.setLayoutParams(
                new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, ta.getFloat(R.styleable.item_view2_shendutu_weight2,0.5f)
                )
        );
        linearYanse.setLayoutParams(
                new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1 - ta.getFloat(R.styleable.item_view2_shendutu_weight2,0.5f)
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


    public void setpara(boolean is_buy,String time, String jiage, String jiaoyiliang, float proportion) {
        this.is_buy = is_buy;
        initview();

        tvJiageTime.setText(time);
        tvJiageHis.setText(jiage);
        tvChengjiaoliang.setText(jiaoyiliang);


        linearWhite.setLayoutParams(
                new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, proportion
                )
        );
        linearYanse.setLayoutParams(
                new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1-proportion
                )
        );
    }


}
