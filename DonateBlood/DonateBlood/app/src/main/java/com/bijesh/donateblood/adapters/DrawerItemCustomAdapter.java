package com.bijesh.donateblood.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bijesh.donateblood.R;
import com.bijesh.donateblood.models.ui.NavigationModel;


/**
 * Created by Bijesh on 8/25/2017.
 */

public class DrawerItemCustomAdapter extends ArrayAdapter<NavigationModel> {

    Context mContext;
    int layoutResourceId;
    NavigationModel data[] = null;

    public DrawerItemCustomAdapter(Context mContext, int layoutResourceId, NavigationModel[] data) {

        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId, parent, false);

        ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIcon);
        TextView textViewName = (TextView) listItem.findViewById(R.id.textViewName);

        NavigationModel folder = data[position];


        imageViewIcon.setImageResource(folder.icon);
        textViewName.setText(folder.name);

        return listItem;
    }
}
