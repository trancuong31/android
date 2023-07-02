package com.example.gridviewnangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class hinhanhadapter extends BaseAdapter {

    Context context;
    int layout;
    List<hinhAnh> listHinhAnh=new ArrayList<>();

    public hinhanhadapter(Context context, int layout, List<hinhAnh> listHinhAnh) {
        this.context = context;
        this.layout = layout;
        this.listHinhAnh = listHinhAnh;
    }

    @Override
    public int getCount() {
        return listHinhAnh.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class hoderView{
        ImageView img;
        TextView name;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        hoderView hoder;
        if(convertView==null){
            hoder =new hoderView();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layout,null);
            hoder.img=(ImageView) convertView.findViewById(R.id.img);
            hoder.name=convertView.findViewById(R.id.name);
            convertView.setTag(hoder);
        }
        else{
            hoder= (hoderView) convertView.getTag();
        }
        hinhAnh hinhAnh=listHinhAnh.get(position);
        hoder.img.setImageResource(hinhAnh.getImg());
        hoder.name.setText(hinhAnh.getTen());
        return convertView;
    }
}
