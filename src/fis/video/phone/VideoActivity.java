package fis.video.phone;

import info.androidhive.slidingmenu.R;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import fis.video.domain.Library;
import fis.video.domain.Video;
import fis.video.task.GetYouTubeUserVideosTask;
import fis.video.ui.VideoClickListener;
import fis.video.widget.VideosListView;

/**
 * The Activity can retrieve Videos for a specific username from YouTube</br>
 * It then displays them into a list including the Thumbnail preview and the title</br>
 * There is a reference to each video on YouTube as well but this isn't used in this tutorial</br>
 * </br>
 * <b>Note<b/> orientation change isn't covered in this tutorial, you will want to override
 * onSaveInstanceState() and onRestoreInstanceState() when you come to this
 * </br>
 * @author paul.blundell
 */
public class VideoActivity extends Fragment implements VideoClickListener {
    // A reference to our list that will hold the video details
	private VideosListView listView;

	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.video_main, container, false);
         
        getUserYouTubeFeed();
        listView = (VideosListView) rootView.findViewById(R.id.videosListView);
        // Here we are adding this activity as a listener for when any row in the List is 'clicked'
        // The activity will be sent back the video that has been pressed to do whatever it wants with
        // in this case we will retrieve the URL of the video and fire off an intent to view it
        listView.setOnVideoClickListener(this);
        
        return rootView;
    }
	

    public void getUserYouTubeFeed(){
    	new Thread(new GetYouTubeUserVideosTask(responseHandler, "blundellp")).start();
    }
   
	Handler responseHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			populateListWithVideos(msg);
		};
	};

	private void populateListWithVideos(Message msg) {
		Library lib = (Library) msg.getData().get(GetYouTubeUserVideosTask.LIBRARY);
		listView.setVideos(lib.getVideos());
	}
	
	@Override
	public void onStop() {
		responseHandler = null;
		super.onStop();
	}

	// This is the interface method that is called when a video in the listview is clicked!
	// The interface is a contract between this activity and the listview
	@Override
	public void onVideoClicked(Video video) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(video.getUrl()));
		startActivity(intent);
	}
}