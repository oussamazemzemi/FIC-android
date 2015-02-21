package com.theopentutorials.android.activities;
 

import info.androidhive.slidingmenu.R;

import java.util.ArrayList;
import java.util.List;
import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.about.app.ImageDialog;
import com.theopentutorials.android.adapters.CustomListViewAdapter;
import com.theopentutorials.android.beans.RowItem;
 
public class ImageListViewActivity extends Fragment implements
        OnItemClickListener {
 
    public static final String[] titles = new String[] { "Anouar Brahem (Musique) 10-juil","Bollywood Express (Danse) 11-juil", "Musique Soufie : Tunisie,Egypt,Indonésie 12-juil",
    	"Troupe de l'Association de Carthage 14-juil","George Benson (Jazz) 16-juil","Nancy Ajram, Varieté 19-juil", "Yanni 22-juil", "I AM 23-juil",
    	"Mohamed Jebali, Carole Smaha 24-juil","République pour tous de Chokri Bouzayen 25-juil","Les milles et une danses du monde 26-juil",
    	"Chimène Badi, Natasha St Pier 27-juil","Richard III de Jaafar Gasmi (Théâtre) 29-juin","Aladin (Comédie musicale pour enfants) 30-juin",
    	"Marcel Khalifa 31-juin","Youssou N'Dour 1-Août","Nour Chiba, Cheb Mami 2-Août","Ana Moura, Tomatito 3-Août","Hymne à la Tunisie 4-Août","Nawel Skandarani (Danse Comtemporaine) 5-Août",
    	"Saber Rebai 7-Août","Ballet Chinois (The Ancestors of Muqam Art Ensemble) 8-Août","Chirine Abdelwaheb 9-Août","Mounir Troudi, Eric Truffaz 10-Août",
    	"Stromae 11-Août","Al Mansia (Musique Populaire) 13-Août","Chant de l'amour et de la paix de Mohamed Majri 14-Août","Lamine Nahdi (Lila Ala Dalila One Man show) 15-Août","Mozart l'opéra rock (Comédie Musicale) 16-Août"};
 
    public static final String[] descriptions = new String[] {
    	Html.fromHtml("Jeudi 10 Juillet 2014 à 22:00 <p> Prix: 30 DT et 60 DT </p> Anouar Brahem, incontournable oudiste et compositeur tunisien, sera présent pour l'ouverture de cette 50ème édition.").toString(),
    	"Bollywood Express (Danse) 11-juil", "Musique Soufie : Tunisie,Egypt,Indonésie 12-juil",
    	"Troupe de l'Association de Carthage 14-juil",
    	Html.fromHtml("Mercredi 16 Juillet 2014 à 22:00 <p> Prix: 40 DT et 100 DT </p> Avec son clip sorti de la boite à archive, Georges Benson offre toujours ses nuits au public avec Give Me The Night, surement l'une des têtes d'affiches, à ne pas rater.À 71 ans, le roi de la nuit dansera à Carthage jusqu'au bout... comme toujours!").toString(),
    	Html.fromHtml("Samedi 19 Juillet 2014 à 22:00 <p> Prix: 35 DT et 100 DT </p> Nancy Ajram a débuté en participant à des concours pour la chaîne de télévision libanaise arabophone LBC. Après avoir gagné un concours en chantant un morceau d'Oum Kalthoum dans l'émission Nogoum Al-Fan... Elle est devenue l'une des stars de la musique orientale à l'internationale! Des concerts toujours (très) haut en couleurs!").toString(),
    	Html.fromHtml("Mardi 22 Juillet 2014 à 22:00 <p> Prix: 40 DT ET 100 DT </p> Le grec sera l'une des attractions, avec un genre qui est sorti des frontières grecques pour conquérir la planète.En effet, Yanni a reçu plus de 40 disques de platine et d'or et a vendu plus de 25 millions d'albums dans le monde.").toString(),
    	Html.fromHtml("Mercredi 23 Juillet 2014 à 22:00 <p> Prix: 40 DT et 80 DT </p> Avec IAM, le rap français s'est trouvé! Très narratif, aux nombreux clins d’œil cinématographiques, Akhenaton, Shurik’n, Kheops, Freeman ont réussi à transporter le rap français à un niveau rarement atteint depuis. IAM est notamment connu pour avoir fait la BO des films Taxi 1 et 2. Du rap musclé !").toString(),
    	"Mohamed Jebali, Carole Smaha 24-juil","République pour tous de Chokri Bouzayen 25-juil","Les milles et une danses du monde 26-juil",
    	
    	Html.fromHtml("Dimanche 27 Juillet 2014 à 22:00 <p> Prix: 15 DT et 30 DT </p> Pourquoi cette soirée est immanquable? Ce concert est l'un des moins chers du festival et c'est également une occasion (rare) de (re)voir Natasha Saint-Pier sur scène. Souvenez-vous de la Canadienne qui était une star de la variété française au début des années 2000. En 2014, Natasha St Pier anime une émission sur France 3 qui fait 8% d'audience... et fait parti du jury de The Voice Belgique... et sera en concert cet été à Carthage en compagnie de Chimène Badi!").toString(),
    	"Richard III de Jaafar Gasmi (Théâtre) 29-juin","Aladin (Comédie musicale pour enfants) 30-juin",
    	Html.fromHtml("Jeudi 31 Juillet 2014 à 22:00 <p> Prix: 30 DT et 60 DT </p> Le Libanais habitué des scènes tunisiennes possède une composition musicale s'inspirant de grands poètes arabes contemporains.Son univers sonore original le hisse au rang d'ambassadeur de sa culture... à (re)découvrir").toString(),
		Html.fromHtml("Vendredi 01 Août 2014 à 22:00 <p> Prix: 30 DT et 60 DT </p> Né à Dakar en 1959 d’un père ouvrier, c’est à l’âge de 15 ans que Youssou Ndour fait ses premiers pas musicaux. Il est depuis devenu l'une des plus belles voix du continent, doublée d'un artiste qui a su briser les barrières culturelles et économiques du show business international.").toString(),
		"Nour Chiba, Cheb Mami 2-Août",
		Html.fromHtml("Dimanche 03 Août 2014 à 22:00 <p> Prix: 25 DT et 45 DT </p> La portugaise Ana Moura, présente à jazz à Carthage cette année possède un style rythmé qui mélange Fado (musique portugaise et Blues). Et pour rendre un dernier hommage à Paco De Lucia, décédé cette année et présent à Carthage l'an dernier, Tomatito sera présent. L'une des plus grandes légendes du flamenco, avec certainement un clin d'oeil à son idole Paco lors du concert...").toString(),
		"Hymne à la Tunisie 4-Août","Nawel Skandarani (Danse Comtemporaine) 5-Août",
    	"Saber Rebai 7-Août","Ballet Chinois (The Ancestors of Muqam Art Ensemble) 8-Août","Chirine Abdelwaheb 9-Août","Mounir Troudi, Eric Truffaz 10-Août",
    	Html.fromHtml("Lundi 11 Août 2014 à 22:00 <p> Prix: 40 DT et 100 DT </p> Le son de Stromae puise son inspiration dans la new beat, pour offrir un style swing de la technotronique et de la house underground belges du début des années 1990. ").toString(),
    	"Al Mansia (Musique Populaire) 13-Août","Chant de l'amour et de la paix de Mohamed Majri 14-Août","Lamine Nahdi (Lila Ala Dalila One Man show) 15-Août",
    	Html.fromHtml("En cloture: Samedi 16 Août 2014 à 22:00 <p> Prix: 30 DT et 60 DT </p> Mozart l'Opéra Rock Le Concert c'est l'occasion de voir un opéra en Tunisie, dans lequel 6 artistes interprètent les plus grands tubes de l'opéra rock accompagnés par 60 musiciens et choristes, issus de l’Orchestre Symphonique et la Chorale National de Kiev. Un spectacle exclusivement en français!").toString() };
 
    public static final Integer[] images = { R.drawable.anouar,
            R.drawable.bollywood, R.drawable.soufie, R.drawable.ic_home,R.drawable.bensa,
            R.drawable.nancy, R.drawable.yanni, R.drawable.iam,
            R.drawable.carole,
            R.drawable.ic_launcher, R.drawable.ic_communities, R.drawable.natasha,R.drawable.ic_pages,
            R.drawable.ic_whats_hot, R.drawable.marcel, R.drawable.youssou,
            R.drawable.ic,
            R.drawable.ic_launcher, R.drawable.ana, R.drawable.ic_home,R.drawable.ic_pages,
            R.drawable.ic_whats_hot, R.drawable.ic_photos, R.drawable.ic_people,
            R.drawable.stromae,
            R.drawable.ic_whats_hot, R.drawable.ic_photos, R.drawable.ic_people,R.drawable.mozart};
 
    ListView listView;
    List<RowItem> rowItems;
 
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.main_list, container, false);
        
        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < titles.length; i++) {
        	RowItem item = null ;
        	if(descriptions[i].length()>51)
        	{
        		item = new RowItem(images[i], titles[i], descriptions[i].subSequence(0, 50).toString()+"...");
        	}
        	else
        	{
        		item = new RowItem(images[i], titles[i], descriptions[i]);
        	}
            rowItems.add(item);
        }
 
        listView = (ListView) rootView.findViewById(R.id.list);
        CustomListViewAdapter adapter = new CustomListViewAdapter(getActivity().getApplicationContext(),
                R.layout.list_big_image, rowItems);
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
        /*Toast toast = Toast.makeText(getActivity().getApplicationContext(),
            "Item " + (position + 1) + ": " + rowItems.get(position),
            Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
        */
        Dialog d = new Dialog(getActivity(), R.style.About);
        ImageDialog image = new ImageDialog(d.getContext(),rowItems.get(position).getImageId(),descriptions[position]);
    	image.setTitle(rowItems.get(position).getTitle());
		image.show();
    }

}