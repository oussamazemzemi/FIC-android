package info.androidhive.slidingmenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;


public class RefreshNumber {

	public static String number;
	
	
	public String GetNumber(String type) throws InterruptedException, ExecutionException {
		String result = new HttpAsyncTask().execute("http://scor-emploi.com/rest/json/metallica/"+type).get();
		return number = onPostExecute(result);
	}
	
	public String GET(String url){
		InputStream inputStream = null;
		String result = "";
		try {
			// create HttpClient
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			// make GET request to the given URL
			HttpResponse httpResponse = httpclient.execute(httpGet);
			
			// receive response as inputStream
			inputStream = httpResponse.getEntity().getContent();
			
			// convert inputstream to string
			if(inputStream != null)
				{result = convertInputStreamToString(inputStream);
			Log.d("result", result);}
			else
				result = "Did not work!";
		
		} catch (Exception e) {
			Log.d("InputStream", e.getLocalizedMessage());
		}
		
		return result;
	}
	
  private static String convertInputStreamToString(InputStream inputStream){
    	
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        try {
			while((line = bufferedReader.readLine()) != null)
			    {result += line;}
		
        
        inputStream.close();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return result;
        
    }
  
	  protected String onPostExecute(String result) {
	  	
		String number="0";
	  	result="{\"articleList\":"+result+"}";
	  	try {
				JSONObject json = new JSONObject(result);
				
				
				JSONArray articles = json.getJSONArray("articleList");
				
				
				number=String.valueOf(articles.length());
				
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return number;
	 }
	
	private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
              
            return GET(urls[0]);
        }
      
    }
}
