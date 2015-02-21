package com.theopentutorials.android.activities;
 
import info.androidhive.slidingmenu.R;

import java.util.ArrayList;
import java.util.List;
import android.app.Fragment;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.theopentutorials.android.adapters.CustomImageListViewAdapter;
import com.theopentutorials.android.beans.RowItem;
 
public class HistoriqueViewActivity extends Fragment implements
        OnItemClickListener {
	
    public static final String[] titles = new String[] { "Festival international de Carthage" };
 
    public static final String[] descriptions = new String[] {
    	"Le Festival international de Carthage (مهرجان قرطاج الدولي) est un festival annuel de musique ayant lieu aux mois de juillet et août, depuis 1964, dans la ville côtière de Carthage (Tunisie)."+
    	"\n\n\n"+"Considéré comme l'un des festivals arabes, africains et mondiaux les plus importants, le Festival international de Carthage est abrité par le théâtre antique de Carthage restauré au début du xxe siècle et doté d'une capacité d'accueil de 7 500 spectateurs. Le festival de Carthage a drainé depuis sa fondation les artistes les plus réputés du monde arabe dont Ali Riahi, Hédi Jouini, Saber Rebaï, Kadhem Saher, Warda ou encore Majida El Roumi. Mais le festival va au-delà de la culture arabo-méditerranéenne pour offrir tous genres de créations artistiques. Ainsi, la scène de Carthage a notamment accueilli Youssou N'Dour mais aussi Dalida, James Brown, Louis Armstrong, Ray Charles, Alpha Blondy, Joe Cocker, Serge Lama, Gérard Lenorman ou Charles Aznavour, ainsi que des pièces de théâtre, des danses folkloriques et des ballets."+
    	"\n\n\n"+"Pour sa 46e édition, dirigée par Boubaker Ben Frej en 2010, le festival a réuni de grands noms de la musique tunisienne, comme Lotfi Bouchnak et Latifa Arfaoui, ainsi que des stars internationales comme Seal et Eros Ramazzotti1."+
    	"\n\n\n"+"Lors des éditions 2010 et 2013, Mourad Sakli en est le président."
             };
 
    public static final Integer[] images = { R.drawable.ic };
 
    ListView listView;
    List<RowItem> rowItems;
    WebView mWebView;
    String SrcPath = "rtsp://v5.cache1.c.youtube.com/CjYLENy73wIaLQnhycnrJQ8qmRMYESARFEIJbXYtZ29vZ2xlSARSBXdhdGNoYPj_hYjnq6uUTQw=/0/0/0/video.3gp";
   
    MediaMetadataRetriever mmr = null;
    
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.main_list, container, false);
        
        
        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < titles.length; i++) {
            RowItem item = new RowItem(images[i], titles[i], descriptions[i]);
            rowItems.add(item);
        }
 
        listView = (ListView) rootView.findViewById(R.id.list);
        CustomImageListViewAdapter adapter = new CustomImageListViewAdapter(getActivity().getApplicationContext(),
                R.layout.historique, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        
       
        
        return rootView;
	}
    
    /** Called when the activity is first created. */
    /*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_list);
 
        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < titles.length; i++) {
            RowItem item = new RowItem(images[i], titles[i], descriptions[i]);
            rowItems.add(item);
        }
 
        listView = (ListView) findViewById(R.id.list);
        CustomListViewAdapter adapter = new CustomListViewAdapter(this,
                R.layout.list_item_image, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }*/
 
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
            long id) {
        Toast toast = Toast.makeText(getActivity().getApplicationContext(),
            "Item " + (position + 1) + ": " + rowItems.get(position),
            Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
    

	
}