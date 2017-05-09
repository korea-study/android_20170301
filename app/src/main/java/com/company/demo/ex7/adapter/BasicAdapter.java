package com.company.demo.ex7.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.company.demo.R;

/**
 * Created by dh on 2017-03-28.
 */

public class BasicAdapter extends BaseAdapter {
    private String TAG = "BasicAdapter";
    private ImageView best_imageView = null;
    private TextView best_textTitle = null;
    private TextView best_textSubTitle = null;
    private Button best_button = null;

    private Context mContext = null;
    private ArrayList<String> mArraylist = null;
    public BasicAdapter(Context context, ArrayList<String> arrayList){
        this.mContext = context;
        this.mArraylist = arrayList;
    }

    @Override
    public int getCount() {
        return mArraylist.size();
    }

    @Override
    public Object getItem(int position) {
        return mArraylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(R.layout.adapter_basic, null);
        }
        best_imageView = (ImageView) v.findViewById(R.id.best_image_view);
        best_textTitle = (TextView) v.findViewById(R.id.best_title);
        best_textSubTitle = (TextView) v.findViewById(R.id.best_subtitle);
        best_button = (Button) v.findViewById(R.id.best_button);



        best_imageView.setBackgroundResource(mContext.getResources().getIdentifier(getImageName(position), "drawable", mContext.getPackageName()));
        best_textTitle.setText(mArraylist.get(position));

        return v;
    }

    private String getImageName(int position){
        String adapterTitle = null;
        switch(position){
            case 0 :
                adapterTitle = "best_shirts_1";// mArraylist.get(0);
                break;
            case 1 :
                adapterTitle = "best_shirts_2"; // mArraylist.get(1);
                break;
            case 2 :
                adapterTitle = "best_slacks_1"; // mArraylist.get(2);
                break;
            case 3 :
                adapterTitle = "best_tong_1"; // mArraylist.get(3);
                break;
        }

        return adapterTitle;
    }


}
