package info.androidhive.slidingmenu;

import org.json.JSONException;
import org.json.JSONObject;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class HomeFragment extends Fragment {
	
	CallbackManager callbackManager;
    LoginButton loginFacebook;
    TextView greeting;
    
    
    
	public HomeFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		FacebookSdk.sdkInitialize(this.getActivity().getApplicationContext());
        //View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		View rootView = inflater.inflate(R.layout.flip_main, container, false);
		
		
		//authButton.setFragment(rootView);
		
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
		
         //facebook
            
            callbackManager = CallbackManager.Factory.create();
            loginFacebook = (LoginButton) rootView.findViewById(R.id.login_button);
            greeting = (TextView) rootView.findViewById(R.id.greeting);
            loginFacebook.setReadPermissions("public_profile email");
            
            loginFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            
                @Override
                public void onSuccess(LoginResult loginResult) {
                	//if(AccessToken.getCurrentAccessToken() != null){
                        updateUI();
                    //}
                }
 
                @Override
                public void onCancel() {
                    
                    //(Not executed)
                }

                @Override
                public void onError(FacebookException e)
                {
                    Log.e("LoginActivity","ERROR: "+e.getMessage());
                }
            });
            
        return rootView;
    }
	
	//facebook
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
	
	private void updateUI() {
        boolean enableButtons = AccessToken.getCurrentAccessToken() != null;

       

        Profile profile = Profile.getCurrentProfile();
        if (enableButtons && profile != null) {
         
            greeting.setText(getString(R.string.hello_user, profile.getFirstName()));
        } else {
         
            greeting.setText(null);
        }
    }
}
