package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class HomeFragment extends Fragment {
	
	public HomeFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        //View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		View rootView = inflater.inflate(R.layout.flip_main, container, false);
		
		//change images oriantation
		WindowManager wm = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		
		int rotation = display.getRotation();
		Log.e("rotation", String.valueOf(rotation));
		if(rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_180)
		{
			ImageView im1 = (ImageView) rootView.findViewById(R.id.star);
			im1.setBackgroundResource(R.drawable.star1);
			ImageView im2 = (ImageView) rootView.findViewById(R.id.star2);
			im2.setBackgroundResource(R.drawable.star3);
		}
		else
		{
			ImageView im1 = (ImageView) rootView.findViewById(R.id.star);
			im1.setBackgroundResource(R.drawable.star);
			ImageView im2 = (ImageView) rootView.findViewById(R.id.star2);
			im2.setBackgroundResource(R.drawable.star2);
			
		}
		
		ViewFlipper flipper = (ViewFlipper) rootView.findViewById(R.id.flipper1);
            /** Start Flipping */
            flipper.startFlipping();
		
        return rootView;
    }
}
