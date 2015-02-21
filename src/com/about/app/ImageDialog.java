package com.about.app;

import info.androidhive.slidingmenu.R;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageDialog extends Dialog{

	private int imgurl;
	private String infourl;
	public ImageDialog(Context context) {
		super(context);
	}
	
	
	
	public ImageDialog(Context context, int imgurl, String infourl) {
		super(context);
		this.imgurl = imgurl;
		this.infourl = infourl;
	}



	/**
     * This is the standard Android on create method that gets called when the activity initialized.
     */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.image);
		
		TextView tv = (TextView)findViewById(R.id.infourl);
		ImageView img = (ImageView)findViewById(R.id.imurl);
		tv.setText(infourl);
		img.setBackgroundResource(imgurl);
		tv.setTextColor(Color.WHITE);
		tv.setLinkTextColor(Color.WHITE);
		Linkify.addLinks(tv, Linkify.ALL);
	}
	

}
