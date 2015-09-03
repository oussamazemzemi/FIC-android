package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.theopentutorials.android.adapters.CustomImageListViewAdapter;
import com.theopentutorials.android.beans.RowItem;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.content.Context;

public class FindPhotoFragment extends Fragment {
	
	public static ListView listView;
	public static List<RowItem> rowItems;
	
    public static List<String> titles = new ArrayList<String>(); 
    public static List<String> descriptions = new ArrayList<String>();
    public static List<String> images = new ArrayList<String>();
    

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 		
        View rootView = inflater.inflate(R.layout.main_list, container, false);
        listView = (ListView) rootView.findViewById(R.id.list);
		
     		try {
				String result=new HttpAsyncTask().execute("http://scor-emploi.com/rest/json/metallica/get").get();
				resultToList(result);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
     		rowItems = new ArrayList<RowItem>();
     		
     		/*titles.add("aze");
     		descriptions.add("aze");
     		images.add("qsd");*/
     		Log.d("length", String.valueOf(titles.size()));
            for (int i = 0; i < titles.size(); i++) {
        		
                RowItem item = new RowItem(images.get(i), titles.get(i), descriptions.get(i));
                Log.d("images", images.get(i));
                rowItems.add(item);
            }

            CustomImageListViewAdapter adapter = new CustomImageListViewAdapter(getActivity().getApplicationContext(),
                    R.layout.list_item_image, rowItems);
		    
            
            listView.setAdapter(adapter);
            
            titles = new ArrayList<String>();
     		descriptions = new ArrayList<String>();
     		images = new ArrayList<String>();
        return rootView;
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
	
    public boolean isConnected(){
    	ConnectivityManager connMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
    	    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
    	    if (networkInfo != null && networkInfo.isConnected()) 
    	    	return true;
    	    else
    	    	return false;	
    }
    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
              
            return GET(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
        	
        	result="{\"articleList\":"+result+"}";
        	try {
				JSONObject json = new JSONObject(result);
				
				
				JSONArray articles = json.getJSONArray("articleList");
				
				titles=new ArrayList<String>();
				images=new ArrayList<String>();
				descriptions=new ArrayList<String>();
				
				
				for(int i=0;i<articles.length();i++)
				{
					titles.add(articles.getJSONObject(i).getString("video"));
					images.add(articles.getJSONObject(i).getString("image"));
					descriptions.add(articles.getJSONObject(i).getString("description"));
				}
				
				

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       }
    }
	public List<RowItem> getRowItems() {
		return rowItems;
	}
	public void setRowItems(List<RowItem> rowItems) {
		FindPhotoFragment.rowItems = rowItems;
	}
	
	private static void fixClassLoaderIssue()
	{
	    ClassLoader myClassLoader = DefaultHttpClient.class.getClassLoader();
	    Thread.currentThread().setContextClassLoader(myClassLoader);
	}
	
    private void resultToList(String result) {
    	
    	result="{\"articleList\":"+result+"}";
    	try {
			JSONObject json = new JSONObject(result);
			
			
			JSONArray articles = json.getJSONArray("articleList");
			
			titles=new ArrayList<String>();
			images=new ArrayList<String>();
			descriptions=new ArrayList<String>();
			
			
			for(int i=0;i<articles.length();i++)
			{
				titles.add(articles.getJSONObject(i).getString("video"));
				images.add(articles.getJSONObject(i).getString("image"));
				descriptions.add(articles.getJSONObject(i).getString("description"));
			}
			
			

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
}
