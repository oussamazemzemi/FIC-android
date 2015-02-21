package com.theopentutorials.android.adapters;
 
import info.androidhive.slidingmenu.R;

import java.util.List;

import com.theopentutorials.android.beans.RowItem;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class CustomImageListViewAdapter extends ArrayAdapter<RowItem> {
 
    Context context;
 
    public CustomImageListViewAdapter(Context context, int resourceId,
            List<RowItem> items) {
        super(context, resourceId, items);
        this.context = context;
    }
     
    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView txtTitle;
        TextView txtDesc;
    }
     
    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        RowItem rowItem = getItem(position);
         
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.historique, null);
            holder = new ViewHolder();
            holder.txtDesc = (TextView) convertView.findViewById(R.id.desc);
            holder.txtTitle = (TextView) convertView.findViewById(R.id.title);
            holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
                 
        holder.txtDesc.setText(rowItem.getDesc());
        holder.txtTitle.setText(rowItem.getTitle());
        
			/*ImageLoader imgLoader = new ImageLoader(getContext());
			imgLoader.DisplayImage(rowItem.getImageUrl(), R.drawable.ic, holder.imageView);*/
        
     // Create an object for subclass of AsyncTask
	    GetXMLTask task = new GetXMLTask(holder.imageView);
	    // Execute the task
	    task.execute(new String[] { rowItem.getImageUrl() });
			
			
        return convertView;
    }
}