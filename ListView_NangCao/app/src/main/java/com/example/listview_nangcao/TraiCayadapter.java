package com.example.listview_nangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TraiCayadapter  extends BaseAdapter {
    private List<CaSi> caSiList=new ArrayList<>();
    private Context context;
    private int layout;

    public TraiCayadapter(List<CaSi> caSiList, Context context, int layout) {
        this.caSiList = caSiList;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return caSiList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class viewHoder{
        TextView ten,moTa;
        ImageView img;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHoder viewHoder;
       if(convertView==null){
           viewHoder=new viewHoder();
           LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
           convertView = inflater.inflate(layout, null);
           //ánh xạ
           viewHoder.ten=(TextView) convertView.findViewById(R.id.ten);
           viewHoder.moTa=(TextView) convertView.findViewById(R.id.mota);
           viewHoder.img=(ImageView) convertView.findViewById(R.id.img);
           convertView.setTag(viewHoder);
       }
       else{
           viewHoder= (TraiCayadapter.viewHoder) convertView.getTag();
       }
        //gán giá trị
        CaSi caSi=caSiList.get(position);
        viewHoder.ten.setText(caSi.getTen());
        viewHoder.moTa.setText(caSi.getMoTa());
        viewHoder.img.setImageResource(caSi.getHinh());
        return convertView;
    }
}
