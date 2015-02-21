package fis.video.phone;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fis.video.util.StreamUtils;

public class VideoNumber implements Runnable {

	public String numberVideo;
	
	@Override
	public void run() {
		
		try {
			// Get a httpclient to talk to the internet
			HttpClient client = new DefaultHttpClient();
			// Perform a GET request to YouTube for a JSON list of all the videos by a specific user
			//HttpUriRequest request = new HttpGet("https://gdata.youtube.com/feeds/api/videos?q=festivaldecarthage&v=2&alt=jsonc");
			HttpUriRequest request = new HttpGet("https://gdata.youtube.com/feeds/api/videos?author=UCfsW1mwJSU7BUh6FvI5UWOg&v=2&alt=jsonc");
			
			// Get the response that YouTube sends back
			HttpResponse response = client.execute(request);
			// Convert this response into a readable string
			String jsonString = StreamUtils.convertToString(response.getEntity().getContent());
			// Create a JSON object that we can use from the String
			JSONObject json = new JSONObject(jsonString);
			
			// For further information about the syntax of this request and JSON-C
			// see the documentation on YouTube http://code.google.com/apis/youtube/2.0/developers_guide_jsonc.html
			
			// Get are search result items
			JSONArray jsonArray = json.getJSONObject("data").getJSONArray("items");
			
			// Loop round our JSON list of videos creating Video objects to use within our app
			setNumberVideo(String.valueOf(jsonArray.length()));
	
		// We don't do any error catching, just nothing will happen if this task falls over
		// an idea would be to reply to the handler with a different message so your Activity can act accordingly
		} catch (ClientProtocolException e) {
			
		} catch (IOException e) {
			
		} catch (JSONException e) {
			
		}
		
	}

	public String getNumberVideo() {
		return numberVideo;
	}

	public void setNumberVideo(String numberVideo) {
		this.numberVideo = numberVideo;
	}


	
}
