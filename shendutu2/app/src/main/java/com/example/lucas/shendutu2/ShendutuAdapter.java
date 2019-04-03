package com.example.lucas.shendutu2;

/**
 *
 * @author lucas
 * created at 2019/2/18 12:00 AM
 */


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;


import java.util.List;



public class ShendutuAdapter extends RecyclerView.Adapter<ShendutuAdapter.ViewHolder>{
    private List<shendutu_model> list;
    private Context mcontext;
    private OnItemClickLitener   mOnItemClickLitener;


    //设置回调接口
    public interface OnItemClickLitener{
        void onItemClick(View view, int position);
    }
    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener){
        this.mOnItemClickLitener = mOnItemClickLitener;
    }


    public ShendutuAdapter(List<shendutu_model> list, Context context) {
        this.list = list;
        this.mcontext = context;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {


        private item_view itemItem;

        public ViewHolder(View view) {
            super(view);
            itemItem = (item_view) view.findViewById(R.id.item_item);
        }
    }


    /**
     * 初始化布局视图
     * 局部点击事件写在这里
     */
    @Override
    public ShendutuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shendutu_recycleview, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /**
     * 绑定视图组件数据
     */
    public void onBindViewHolder(final ShendutuAdapter.ViewHolder holder, final int position) {
        holder.itemItem.setpara(list.get(position).is_buy, list.get(position).zonge, list.get(position).jiage, list.get(position).scale);


//        //通过为条目设置点击事件触发回调
//        if (mOnItemClickLitener != null) {
//            holder.tvContent.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    mOnItemClickLitener.onItemClick(view, position);
//                }
//            });
//        }



    }


    @Override
    public int getItemCount() {
        return list.size();
    }



}
